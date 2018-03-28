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
 * This is an abstract class which implents all interfaces provided by this API.
 * 
 * @author Christoph Bless
 */
abstract public class AbstractClient implements SessionClient, ScanClient, 
        PluginClient, ReportClient {
    
    protected String host;
    protected Integer port;
    protected boolean trustAll;

    public AbstractClient(String host, boolean trustAll) {
        this.host = host;
        this.trustAll = trustAll;
    }
    
    public AbstractClient(String host, Integer port, boolean trustAll){
        this.host = host;
        this.port = port;
        this.trustAll = trustAll;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public boolean isTrustAll() {
        return trustAll;
    }

    public void setTrustAll(boolean trustAll) {
        this.trustAll = trustAll;
    }
    
    
}
