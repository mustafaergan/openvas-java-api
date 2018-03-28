package com.mustafaergan.openvas.service;


import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.out.api.AbstractClient;
import com.out.api.ClientException;
import com.out.api.NotFoundException;
import com.out.api.SessionException;
import com.out.api.model.Plugin;
import com.out.api.model.PluginFamily;
import com.out.api.model.Scan;
import com.out.api.model.ScanDetails;
import com.out.api.model.Vulnerability;
import com.out.openvasclient.ClientBuilder;
import com.out.openvasclient.ConfigManager;
import com.out.openvasclient.LoginException;
import com.out.openvasclient.ManagerFactory;
import com.out.openvasclient.OMPClient;
import com.out.openvasclient.OpenVASException;
import com.out.openvasclient.PluginManager;
import com.out.openvasclient.ScanManager;
import com.out.openvasclient.model.resources.NVT;
import com.out.openvasclient.model.resources.NvtFamily;
import com.out.openvasclient.model.resources.Target;
import com.out.openvasclient.model.resources.results.Result;
import com.out.openvasclient.model.resources.tasks.Task;
import com.out.openvasclient.model.responses.GetTasksResponse;
import com.out.openvasclient.model.responses.ResumeTaskResponse;
import com.out.openvasclient.model.responses.StartTaskResponse;

/**
 * Created by mustafaergan
 */
public class Client extends AbstractClient {

    private OMPClient client;
    private ScanManager scanManager;
    private PluginManager pluginManager;
    private ConfigManager configManager;
    
    public Client(String host, int port, boolean trustAll) throws ClientException {
        super(host, port, trustAll);
        ClientBuilder builder = new ClientBuilder(host, port, trustAll);
        try {
            client = builder.build();
        } catch (IOException ex) {
            throw new ClientException(ex);
        } catch (KeyManagementException ex) {
            throw new ClientException(ex);
        } catch (NoSuchAlgorithmException ex) {
            throw new ClientException(ex);
        }
        ManagerFactory factory = new ManagerFactory(client);
        scanManager = factory.createScanManager();
        pluginManager = factory.createPluginManager();
        configManager = factory.createConfigManager();
    }

    
    @Override
    public void login(String username, String password) throws SessionException, ClientException {
        client.setUsername(username);
        client.setPassword(password);
        try {
            client.authenticate();
        } catch(LoginException ex ) {
            throw new SessionException(ex);
        }catch (OpenVASException ex) {
            throw new ClientException(ex);
        }
    }

    @Override
    public void logout() throws SessionException, ClientException {
        // Since OpenVAS doesn't support a Logout this method won't do anything.
    }

    @Override
    public boolean isAuthenticated() {
        return client.isAuthenticated();
    }

    @Override
    public List<Scan> getScans() throws ClientException {
        List<Scan> results = new ArrayList<Scan>();
        try {
            GetTasksResponse response = scanManager.getTasks();
            for (Task t : response.getTasks()){
                results.add(Api.toScan(t));
            }
            return results;
        } catch (OpenVASException ex) {
            throw new ClientException(ex);
        }        
    }

    @Override
    public Scan getScan(String id) throws NotFoundException, ClientException {
        try {
            GetTasksResponse response = scanManager.getTasks();
            if (response.getTasks().isEmpty()){
                throw new NotFoundException("Scan with id: " + id + " not found!");
            }
            return Api.toScan(response.getTasks().get(0));
        } catch (OpenVASException ex) {
            throw new ClientException(ex);
        }  
    }

    public List<ScanDetails> getScanDetails() throws ClientException {
        List<ScanDetails> results = new ArrayList<ScanDetails>();
        try {
            GetTasksResponse response = scanManager.getTasks();
            for (Task t : response.getTasks()){
                List<Target> targets = configManager.getTargets(t.getTarget().getId());
                if (targets.isEmpty()){
                    results.add(Api.toScanDetails(t));
                } else {
                    results.add(Api.toScanDetails(t, targets.get(0)));
                }
            }
            return results;
        } catch (OpenVASException ex) {
            throw new ClientException(ex);
        }
    }

    @Override
    public ScanDetails getScanDetails(String id) throws ClientException, NotFoundException {
        try {
            GetTasksResponse response = scanManager.getTasks();
            if (response.getTasks().isEmpty()){
                throw new NotFoundException("Scan with id: " + id + " not found!");
            }
            return Api.toScanDetails(response.getTasks().get(0));
        } catch (OpenVASException ex) {
            throw new ClientException(ex);
        }  
    }

    @Override
    public String launch(String id) throws ClientException {
        try {
            StartTaskResponse response = scanManager.startTask(id);
            return response.getReportId();
        } catch (OpenVASException ex) {
            throw new ClientException(ex);
        }
    }

    @Override
    public void pause(String id) throws ClientException {
        try {
            scanManager.stopTask(id);
        } catch (OpenVASException ex) {
            throw new ClientException(ex);
        }
    }

    @Override
    public String resume(String id) throws ClientException {
        try{
            ResumeTaskResponse response = scanManager.resumeTask(id);
            return response.getReportId();
        } catch (OpenVASException ex){
            throw new ClientException(ex);
        }
    }

    @Override
    public void stop(String id) throws ClientException {
        try {
            scanManager.stopTask(id);
        } catch (OpenVASException ex) {
            throw new ClientException(ex);
        }
    }

    @Override
    public List<Vulnerability> getResults(String id) throws ClientException {
        try {
            List<Vulnerability> vulns = new ArrayList<Vulnerability>();
            List<Result> results = scanManager.getResults(id);
            for (Result r : results){
                vulns.add(Api.toVuln(r));
            }
            return vulns;
        } catch (OpenVASException ex) {
            throw new ClientException(ex);
        }
    }
    
    @Override
    public Map<String, List<Vulnerability>> getResultsByHost(String id)
            throws ClientException {
        try {
            Map<String, List<Vulnerability>> results = new HashMap<String , List<Vulnerability>>();
            List<Result> response = scanManager.getResults(id);
            for (Result r : response){
                List<Vulnerability> vulns;
                if (results.containsKey(r.getHost())){
                    vulns = results.get(r.getHost());
                } else {
                    vulns = new ArrayList<Vulnerability>();
                    
                }
                vulns.add(Api.toVuln(r));
                results.put(r.getHost(), vulns);
            }
            return results;
        } catch (OpenVASException ex){
            throw new ClientException(ex);
        }
    }

    @Override
    public String getScanStatus(String id) throws ClientException, NotFoundException {
        Scan scan = getScan(id);
        return scan.getStatus();
    }

    @Override
    public List<PluginFamily> listFamilies() throws ClientException {
        try{
            List<NvtFamily> nvtFamilies = pluginManager.getFamilies();
            List<PluginFamily> results = new ArrayList<PluginFamily>();
            for(NvtFamily f : nvtFamilies){
                results.add(Api.toPluginFamily(f));
            }
            return results;
        } catch (OpenVASException ex){
            throw new ClientException(ex);
        }
    }

    @Override
    public Plugin getPlugin(String id) throws NotFoundException, ClientException {
        try {
            List<NVT> nvts = pluginManager.getNVT(id);
            if (nvts.size() > 0){
                return Api.toPlugin(nvts.get(0));
            }
            throw new NotFoundException("plugin not found!");
        } catch (OpenVASException ex) {
            throw new ClientException(ex);
        }
    }

}
