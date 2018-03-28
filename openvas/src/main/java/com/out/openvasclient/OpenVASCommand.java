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
package com.out.openvasclient;

import javax.xml.bind.JAXBException;

import com.out.openvasclient.handler.ResponseHandler;

/**
 * This interface specifies the commands that must be implemented by every 
 * command class.
 * 
 * @author Christoph Bless
 * @param <T> The type of the ResponseHandler
 */
public interface OpenVASCommand<T extends ResponseHandler> {

        /**
         * Checks if an prior authentication is required.
         * 
         * @return <code>true</code> if a prior authentication is required, 
         * <code>false</code> otherwise
         */
	boolean isAuthenticationRequired();
	
        /**
         * Gets the name of the command.
         * 
         * @return name of the command.
         */
	String getName();
	
        /**
         * Gets the request, that should be send to the server.
         * 
         * @return request that should be send to the server.
         * @throws JAXBException Thrown if the marshalling of the request fails.
         */
	String getRequest() throws JAXBException;
	
        /**
         * Gets the ResponseHandler for this command.
         * 
         * @return ResponseHandler for this command.
         */
	T getResponseHandler();
}
