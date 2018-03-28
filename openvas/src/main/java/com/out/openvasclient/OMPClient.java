/*
 * Copyright (C) 2015 Christoph Bless
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */package com.out.openvasclient;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.out.openvasclient.commands.AuthenticateCommand;
import com.out.openvasclient.model.responses.AuthenticateResponse;
import com.out.openvasclient.util.SSLClient;

 /**
  * This class is used for the command execution. 
  * 
  * @author Christoph Bless
  */
public class OMPClient {

	private String username;
	private String password;
	private SSLClient client;
	
	private boolean authenticated;
	
	
        public OMPClient(SSLClient client){
            this.client = client;
        }
    
        /**
         * Sets the username that is used for the authentication.
         * 
         * @param username the username used for the authentication
         */
	public void setUsername(String username) {
            this.username = username;
	}
	
        /**
         * Gets the username that is used for the authentication.
         * 
         * @return the username used for the authentication
         */
	public String getUsername() {
            return username;
	}
	
        /**
         * Sets the password that is used for the authentication.
         * 
         * @param password the password used for the authentication
         */
	public void setPassword(String password) {
            this.password = password;
	}

	
        /**
         * Authenticate with the OpenVAS server. To execute this method the 
         * username and password must be set. 
         * 
         * @throws LoginException The LoginException is thrown if the 
         * authentication was not successful.         * 
         * @throws OpenVASException The OpenVASException is thrown if any other 
         * error occurs.
         *  
         */
	public void authenticate() throws OpenVASException, LoginException{
            AuthenticateCommand cmd = new AuthenticateCommand();
            cmd.setUsername(username);
            cmd.setPassword(password);
            execute(cmd);
            AuthenticateResponse resp = (AuthenticateResponse) cmd.getResponseHandler().getResponse();
            if (resp.getStatus() == 200){
                authenticated = true;
            } else {
                throw new LoginException(resp.getStatusText());
            }
	}
	
        
        /**
         * Authenticate with the OpenVAS server. 
         * 
         * 
         * @param username The username used for the authentication
         * @param password The password used for the authentication
         * @throws LoginException The LoginException is thrown if the 
         * authentication was not successful.         * 
         * @throws OpenVASException The OpenVASException is thrown if any other 
         * error occurs.
         *  
         */
	public void authenticate(String username, String password) 
                throws OpenVASException , LoginException{
            setUsername(username);
            setPassword(password);
            authenticate();
	}
		
        /**
         * Checks wether the user is authenticated or not.
         * 
         * @return <code>true</code> is the user is authenticated, 
         * <code>false</code> otherwise
         */
        public boolean isAuthenticated(){
            return authenticated;
        }
	
        /**
         * Executes the given command. The first command that should be executed
         * is the command authenticate (see method authenticate). 
         * 
         * @param cmd The command to execute.
         * @throws OpenVASException The OpenVASException is thrown if any error 
         * occurs
         */
	public void execute(OpenVASCommand cmd) 
                throws OpenVASException 
        {
            try{
                if (cmd.isAuthenticationRequired() && !isAuthenticated()){
                    authenticate();
                }
                client.send(cmd.getRequest());
                client.recv(cmd.getResponseHandler());                    
            } catch (IOException ex){
                throw new OpenVASException(ex);
            } catch (JAXBException ex ){
                throw new OpenVASException(ex);
            }
		
	}
        
        
        /**
         * Executes the given command and checks if the execution of the command
         * was successful.
         * 
         * @param cmd The command to execute.
         * @throws StatusException The StatusExceptin is thrown if the execution
         * of the command return with a return code greater or equal 400
         * @throws OpenVASException The OpenVASException is thrown if any other 
         * error occurs
         */
        public void executeWithStatusCheck(OpenVASCommand cmd) 
                throws OpenVASException, StatusException
        {
            execute(cmd);
            // http://docs.greenbone.net/GSM-Manual/gos-3.1/de/omp.html
            if (cmd.getResponseHandler().getStatus() >= 400){
                throw new StatusException(cmd.getResponseHandler().getStatus(), 
                        cmd.getResponseHandler().getStatusText());
            }
	}
	
        /**
         * Closes the socket.
         * 
         * @throws IOException 
         */
	public void close() throws IOException{
            client.close();
	}
		
}
