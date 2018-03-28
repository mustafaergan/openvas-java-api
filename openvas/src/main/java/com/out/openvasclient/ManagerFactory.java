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

/**
 * This class is used to create instances of the Manager classes.
 * 
 * @author Christoph Bless
 */
public class ManagerFactory {
    
    private OMPClient client;
    
    public ManagerFactory(OMPClient client){
        this.client = client;
    }
    
    /**
     * Creates an instance of the ScanManager class.
     * 
     * @return instance of the ScanManager class
     */
    public ScanManager createScanManager(){
        return new ScanManager(client);
    }
    
    /**
     * Creates an instance of the PluginManager class.
     * 
     * @return instance of the PluginManager class
     */
    public PluginManager createPluginManager(){
        return new PluginManager(client);
    }
    
    /**
     * Creates an instance of the ConfigManager class.
     * 
     * @return instance of the ConfigManager class
     */
    public ConfigManager createConfigManager(){
        return new ConfigManager(client);
    }
    
}
