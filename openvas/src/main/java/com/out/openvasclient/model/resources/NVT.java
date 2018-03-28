/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.out.openvasclient.model.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Christoph Bless
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NVT {
    
    @XmlAttribute
    private String oid;
    
    @XmlElement
    private String name;
    
    @XmlElement
    private String family;
    
    @XmlElement(name="cvss_base")
    private String cvssBase;
    
    @XmlElement
    private String cve;
    
    @XmlElement(name="bugtraq_id")
    private String bugtraqId;
    
    @XmlElement
    private String bid;

    
    @XmlElement
    private String tags;
    
    @XmlElementWrapper(name="cert_refs")
    @XmlElement(name="cert_ref")
    private List<CertRef> certRefs;
    
    @XmlElement
    private String xref;
    
    @XmlElement
    private String summary;

    public NVT() {
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getCvssBase() {
        return cvssBase;
    }

    public void setCvssBase(String cvssBase) {
        this.cvssBase = cvssBase;
    }

    public String getCve() {
        return cve;
    }

    public void setCve(String cve) {
        this.cve = cve;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getXref() {
        return xref;
    }

    public void setXref(String xref) {
        this.xref = xref;
    }

    public String getBugtraqId() {
        return bugtraqId;
    }

    public void setBugtraqId(String bugtraqId) {
        this.bugtraqId = bugtraqId;
    }

    public List<CertRef> getCertRefs() {
        if (certRefs == null){
            certRefs = new ArrayList<CertRef>();
        }
        return certRefs;
    }

    public void setCertRefs(List<CertRef> certRefs) {
        this.certRefs = certRefs;
    }
    
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "NVT{" + "oid=" + oid + ", name=" + name + ", family=" + family + ", cvssBase=" + cvssBase + ", cve=" + cve + ", bugtraqId=" + bugtraqId + ", bid=" + bid + ", tags=" + tags + ", certRefs=" + certRefs + ", xref=" + xref + ", summary=" + summary + '}';
    }
    
    
    
    
}
