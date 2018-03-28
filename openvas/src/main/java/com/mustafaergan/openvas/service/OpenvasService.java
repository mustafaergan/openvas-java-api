package com.mustafaergan.openvas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.out.api.ClientException;
import com.out.api.NotFoundException;
import com.out.api.model.Scan;
import com.out.api.model.ScanDetails;
import com.out.api.model.Vulnerability;

/**
 * Created by mustafaergan
 */
@Service
public class OpenvasService {

	String host = "", username = "", password = "";
	int port;
	Client client = null;

	public OpenvasService() throws ClientException {
		client = new Client(host, port, true);
		client.login(username, password);
	}

	public List<Scan> scanList() throws ClientException {
		return client.getScans();
	}

	public String launchScan(String scanId) throws ClientException {
		return client.launch(scanId);
	}

	public ScanDetails scanDetails(String scanId) throws NotFoundException, ClientException {
		return client.getScanDetails(scanId);
	}

	public List<Vulnerability> getVulnerability(String assetId) throws ClientException {
		return client.getResults(assetId);
	}

}
