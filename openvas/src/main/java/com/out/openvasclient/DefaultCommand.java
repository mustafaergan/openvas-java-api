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

import com.out.openvasclient.handler.ResponseHandler;

/**
 * This class is used as base class for all Command classes. It implements a 
 * default behavior for the methods isAuthenticated, getName and 
 * getResponseHandler. 
 * 
 * @author Christoph Bless
 */
public abstract class DefaultCommand<T extends ResponseHandler> implements OpenVASCommand<T>{
    
    protected final String name;
    protected final T handler;
    protected final boolean authenticationRequired;

    public DefaultCommand(String name, boolean authenticationRequired, T handler) {
        this.name = name;
        this.authenticationRequired = authenticationRequired;
        this.handler = handler;
    }

    /**
     * Checks wether the user is authenticated or not.
     * 
     * @return <code>true</code> if the user is authenticated, 
     * <code>false</code> otherwise
     */
    @Override
    public boolean isAuthenticationRequired() {
        return authenticationRequired;
    }

    /**
     * Gets the name of the command.
     * 
     * @return name of the command
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Gets the ResponseHandler for this command.
     * 
     * @return T ResponseHandler for this command
     */
    @Override
    public T getResponseHandler() {
        return handler;
    }
    
    
    
}
