package com.mustafaergan.openvas.service;

import java.util.ArrayList;
import java.util.List;

import com.out.api.model.Plugin;
import com.out.api.model.PluginFamily;
import com.out.api.model.Reference;
import com.out.api.model.ReferenceType;
import com.out.api.model.Scan;
import com.out.api.model.ScanDetails;
import com.out.api.model.Vulnerability;
import com.out.openvasclient.model.resources.CertRef;
import com.out.openvasclient.model.resources.NVT;
import com.out.openvasclient.model.resources.NvtFamily;
import com.out.openvasclient.model.resources.Target;
import com.out.openvasclient.model.resources.results.Result;
import com.out.openvasclient.model.resources.tasks.Task;

/**
 * Created by mustafaergan
 */
public class Api {
    
    public static final int NONE_EXISTING_ID = -1;
    
    public static Scan toScan(Task task){
        Scan s = new Scan();
        s.setId(task.getId());
        s.setName(task.getName());
        s.setStatus(task.getStatus());
        return s;
    }
    
    public static ScanDetails toScanDetails(Task task){
        ScanDetails s = new ScanDetails();
        s.setId(task.getId());
        s.setName(task.getName());
        s.setStatus(task.getStatus());
        s.setTargets(task.getTarget().getName());
        return s;
    }
    
    public static ScanDetails toScanDetails(Task task, Target target){
        ScanDetails s = new ScanDetails();
        s.setId(task.getId());
        s.setName(task.getName());
        s.setStatus(task.getStatus());
        s.setTargets(target.getHosts());
        return s;
    }
    
    public static Reference refFromBID(String bid){
        Reference ref = new Reference();
        ref.setType(ReferenceType.BID);
        ref.setReference(bid);
        return ref;
    }
    
    public static Reference refFromBuqtraq(String bid){
        Reference ref = new Reference();
        ref.setType(ReferenceType.BUGTRAQ);
        ref.setReference(bid);
        return ref;
    }
    
    public static Reference refFromCVE(String cve){
        Reference ref = new Reference();
        ref.setType(ReferenceType.CVE);
        ref.setReference(cve);
        return ref;
    }
    
    public static Reference refFromXREF(String xref){
        Reference ref = new Reference();
        ref.setType(ReferenceType.XREF);
        ref.setReference(xref);
        return ref;
    }
    
    public static Reference refFromCert(CertRef certRef){
        Reference ref = new Reference();
        ref.setType(ReferenceType.CERT);
        ref.setReference(certRef.toString());
        return ref;
    }

    public static Vulnerability toVuln(Result result){
        Vulnerability vuln = new Vulnerability();
        vuln.setId(result.getId());
        vuln.setName(result.getName());
        vuln.setSeverity(result.getSeverity());
        vuln.setPluginId(result.getNvt().getOid());
        vuln.setIp(result.getHost());
        return vuln;
    }
    
    public static List<Reference> toReferences(NVT nvt){
        List<Reference> refs = new ArrayList<Reference>();
        String cve = nvt.getCve();
        String bugtraq = nvt.getBugtraqId();
        String xref = nvt.getXref();
        String bid = nvt.getBid();
        if (bid != null && !"NOBID".equals(bid)){
            refs.add(refFromBID(bid));
        }
        if (cve != null && !"NOCVE".equals(cve)){
            refs.add(refFromCVE(cve));
        }
        if (bugtraq != null){
            refs.add(refFromBuqtraq(bugtraq));
        }
        if (xref != null && !"NOXREF".equals(xref)){
            refs.add(refFromXREF(xref));
        }
        for (CertRef ref : nvt.getCertRefs()){
            refs.add(refFromCert(ref));
            
        }
        return refs;
    }
    

    public static Plugin toPlugin(NVT nvt){
        System.out.println(nvt);
        Plugin plugin = new Plugin();
        plugin.setId(nvt.getOid());
        plugin.setName(nvt.getName());
        plugin.setFamily(nvt.getFamily());
        plugin.setCvss(nvt.getCvssBase());
        plugin.setReferences(toReferences(nvt));
        plugin.setDescription(nvt.getSummary());
        return plugin;
    }
    
    public static PluginFamily toPluginFamily(NvtFamily f){
        PluginFamily family = new PluginFamily();
        family.setId(String.valueOf(NONE_EXISTING_ID));
        family.setName(f.getName());
        family.setPluginCount(f.getNvtCount());
        return family;
    }
}
