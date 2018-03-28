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

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import com.out.openvasclient.util.SSLClient;
import com.out.openvasclient.util.SSLFactory;

/**
 * This class can be used to create an instance of the OMPClient class.
 * 
 * @author Christoph Bless
 */
public class ClientBuilder {

    private String host;
    private Integer port;
    private boolean trustAll;

    public ClientBuilder(String host, Integer port) {
        this(host, port, false);
    }

    public ClientBuilder(String host, Integer port, boolean trustAll) {
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

    /**
     * Creates an instance of the OMPClient class.
     * 
     * @return Instance of the OMPClient class.
     * @throws IOException
     * @throws KeyManagementException
     * @throws NoSuchAlgorithmException 
     */
    public OMPClient build() throws IOException, KeyManagementException,
            NoSuchAlgorithmException {
        SSLFactory factory = new SSLFactory(trustAll);
        SSLClient sslClient = factory.createClient(host, port);
        OMPClient ompClient = new OMPClient(sslClient);
        return ompClient;
    }

}
