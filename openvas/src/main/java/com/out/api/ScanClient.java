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

import com.out.api.model.Scan;
import com.out.api.model.ScanDetails;

/**
 * This interface specifies the methods that must be implemented by a Client to 
 * provide basic scan features, such as start or stop a single scan or to get 
 * a list of available scans.
 * 
 * @author Christoph Bless
 */
public interface ScanClient {
    
    
    /**
     * Get a list of available scans.
     * 
     * @return A list of available scans
     * @throws ClientException Throws a ClientException if any error occures.
     */
    List<Scan> getScans() throws ClientException;
   
    
    /**
     * Get the scan with the specified id. 
     * 
     * @param id Id of the Scan to get.
     * @return  Scan with the specified id.
     * @throws NotFoundException Throws a NotFoundException if there is no scan 
     *  with the specified id.
     * @throws ClientException Throws a ClientException if any other error 
     * occures.
     */
    Scan getScan(String id) throws NotFoundException, ClientException;
    
        
    /**
     * Get the scan details for the scan with the specified id. 
     * 
     * @param id Id of the scan to get.
     * @return  Scan with the specified id.
     * @throws NotFoundException Throws a NotFoundException if there is no scan 
     *  with the specified id.
     * @throws ClientException Throws a ClientException if any other error 
     * occures.
     */
    ScanDetails getScanDetails(String id) throws ClientException, 
            NotFoundException;
    
    /**
     * Get the current status of the scan with the specified id.
     * 
     * @param id Id of the scan to get
     * @return The status of the scan. 
     * @throws NotFoundException Throws a NotFoundException if there is no scan 
     *  with the specified id.
     * @throws ClientException Throws a ClientException if any other error 
     * occures.
     */
    String getScanStatus(String id) throws ClientException, NotFoundException;
    
    
    /**
     * This method is used to start a single scan. It returns an id that can be 
     * used to request the report.
     * 
     * @param id Id of the scan that should be started.
     * @return Report id.
     * @throws ClientException Throws a ClientException if any error occures.
     */
    String launch(String id) throws ClientException;
    
    
    /**
     * This method is used to pause a single scan. 
     * 
     * @param id Id of the scan that should be paused.
     * @throws ClientException Throws a ClientException if any error occures.
     */
    void pause(String id) throws ClientException;
    
    
    /**
     * This method is used to resume a paused scan. It returns an id that can be 
     * used to request the report.
     * 
     * @param id Id of the scan that should be resumed.
     * @return Report id.
     * @throws ClientException Throws a ClientException if any error occures.
     */
    String resume(String id) throws ClientException;
    
    
    /**
     * This method is used to stop a single scan. 
     * 
     * @param id Id of the scan that should be stopped.
     * @throws ClientException Throws a ClientException if any error occures.
     */
    void stop(String id) throws ClientException;
    
    
}
