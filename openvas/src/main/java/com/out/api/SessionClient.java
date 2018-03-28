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
 */
package com.out.api;

/**
 * This interface specifies the methods that a client must implement to provide 
 * basic authentication features.
 * 
 * @author Christoph Bless
 */
public interface SessionClient {
    
    
    /**
     * This Method is used to authenticate. It throws a SessionException if the 
     * login was not successful. 
     * 
     * @param username The username for the person who is attempting to log in.
     * @param password The password for the person who is attempting to log in.
     * @throws SessionException Thwrows a SessionExceoption if the login was not 
     * successful.
     * @throws ClientException Throws a ClientException if any other error 
     * occures.
     */
    void login (String username, String password) throws SessionException, 
            ClientException;
    
    /**
     * This method is used to log the authenticated used out. It throws a 
     * SessionException if no session exists.
     * @throws SessionException Throws a SessionException if no session exists.
     * @throws ClientException  Throws a ClientException if any other error occurs.
     */
    void logout () throws SessionException, ClientException;
    
    
    /**
     * This method is used to check if a user has been authenticated. It returns 
     * true if the user has been authenticated, false otherwise.
     * 
     * @return true if the user has been authenticated, false otherwise. 
     */
    boolean isAuthenticated();
    
}
