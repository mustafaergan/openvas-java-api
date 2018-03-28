package com.out.openvasclient.util;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class SSLFactory {
	
	private SSLSocketFactory factory = null;
	
	 // Create a trust manager that does not validate certificate chains
    private static TrustManager[] trustAllCerts = new TrustManager[]{
        new X509TrustManager() {
        	@Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }

        	@Override
			public void checkClientTrusted(
					java.security.cert.X509Certificate[] arg0, String arg1)
					throws CertificateException {
				
			}

        	@Override
			public void checkServerTrusted(
					java.security.cert.X509Certificate[] arg0, String arg1)
					throws CertificateException {
				
			}
        }};

    // Ignore differences between given hostname and certificate hostname
    private static final HostnameVerifier hv = new HostnameVerifier() {
    	@Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };
    
    public SSLFactory(boolean trustAll) throws KeyManagementException, NoSuchAlgorithmException {
    	if (trustAll){
    		SSLContext context = SSLContext.getInstance("TLS");
        	context.init(null, trustAllCerts, new SecureRandom());
        	factory = context.getSocketFactory();
    	}else{
    		factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
    	}
	}
        
    public SSLSocket createSocket(String host, int port) throws IOException {
    	return (SSLSocket) factory.createSocket(host,port);    	
    }
    
    public SSLClient createClient(String host, int port) throws IOException {
        return new SSLClient(createSocket(host, port));
    }
}
