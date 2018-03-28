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

import java.util.List;

import com.out.openvasclient.commands.GetInfoCommand;
import com.out.openvasclient.commands.GetNvtFamiliesCommand;
import com.out.openvasclient.model.InfoTypes;
import com.out.openvasclient.model.resources.NVT;
import com.out.openvasclient.model.resources.NvtFamily;

/**
 * This class provides the methods that are used to request information about 
 * plugins (NVT's) and plugin-families.
 * 
 * @author Christoph Bless
 */
public class PluginManager {
    
    private final OMPClient client;

    public PluginManager(OMPClient client) {
        this.client = client;
    }
    
    
    /**
     * Gets information about the given plugin (NVT).
     * 
     * @param oid The id of the plugin.
     * @return Information about the given plugin
     * @throws OpenVASException Throws an OpenVASException if any error occurs
     */
    public List<NVT> getNVT(String oid) throws OpenVASException {
        GetInfoCommand cmd = new GetInfoCommand();
        cmd.setType(InfoTypes.NVT.name());
        cmd.setInfoId(oid);
        client.execute(cmd);
        return cmd.getResponseHandler().getResponse().getNvts();
    }
    
    /**
     * Gets a list of available plugin-families.
     * 
     * @return list of available plugin-families
     * @throws OpenVASException Throws an OpenVASException if any error occurs
     */
    public List<NvtFamily> getFamilies() throws OpenVASException {
        GetNvtFamiliesCommand cmd = new GetNvtFamiliesCommand();
        client.execute(cmd);
        return cmd.getResponseHandler().getResponse().getFamilies();
    }
}
