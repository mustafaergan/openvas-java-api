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

import com.out.api.model.Plugin;
import com.out.api.model.PluginFamily;

/**
 * This interface defines all plugin related methods that must be implemented 
 * by the client.
 * 
 * @author Christoph Bless
 */
public interface PluginClient {
    
    
    /**
     * Returns a list of plugin families.
     * 
     * @return list of plugin families
     * @throws ClientException This Exception is thrown if any error occurs.
     */
    List<PluginFamily> listFamilies() throws ClientException;
    
    /**
     * Returns the details for the given plugin.
     * 
     * @param id Id of the plugin to get
     * @return Plugin details.
     * @throws NotFoundException Throws a NotFoundException if there is no 
     *  plugin with the given id.
     * @throws ClientException  Throws a ClientException if any other error 
     *  occurs.
     */
    Plugin getPlugin(String id) throws NotFoundException, ClientException;
    
}
