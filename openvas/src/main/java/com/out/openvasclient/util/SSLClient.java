package com.out.openvasclient.util;

import java.io.IOException;
import java.io.OutputStream;

import javax.net.ssl.SSLSocket;

import com.out.openvasclient.OpenVASException;
import com.out.openvasclient.handler.ResponseHandler;


public class SSLClient {

	private String host;
	private int port;
	private SSLSocket sock;
	
        public SSLClient(SSLSocket socket){
            this.sock = socket;
        }
        
	
	public void send(String data) throws IOException{
		String msg = data + "\n";
                //System.out.println("DEBUG send: "+ msg);
		OutputStream out = sock.getOutputStream();
		out.write(msg.getBytes("UTF-8"));
		out.flush();		
	}
		
        public void recv(ResponseHandler handler) throws IOException, OpenVASException {
            NotCloseableInputStream in = new NotCloseableInputStream(
                    sock.getInputStream());
            handler.parse(in);
        }
        
        
	public void close() throws IOException{
		sock.close();
	}
	
}
