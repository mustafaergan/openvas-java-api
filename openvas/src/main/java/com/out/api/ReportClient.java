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

import java.util.List;
import java.util.Map;

import com.out.api.model.Vulnerability;

/**
 * This interface defines all report related methods that must be implemented 
 * by the client.
 * 
 * @author Christoph Bless
 */
public interface ReportClient {
    
    /**
     * Returns a list of vulnerabilities found in the given scan.
     * 
     * @param id The id of the scan.
     * @return List of vulnerabilities. 
     * @throws ClientException Throws a ClientException if any error occurs.
     */
    List<Vulnerability> getResults(String id) throws ClientException;
    
    /**
     * Returns a map with vulnerabilities found in the given scan. This map 
     * contains the hosts (IPs) as key. Each host entry contains a list of 
     * vulnerabilities found for this host.
     * 
     * @param id The id of the scan.
     * @return A map with vulnerabilities.
     * @throws ClientException Throws a ClientException if any error occurs.
     */
    Map<String, List<Vulnerability>> getResultsByHost(String id) throws ClientException;
}
