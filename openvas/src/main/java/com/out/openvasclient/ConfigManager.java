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

import com.out.openvasclient.commands.GetTargetsCommand;
import com.out.openvasclient.model.resources.Target;

/**
 * This class provides methods for getting information about a target.
 * 
 * @author Christoph Bless
 */
public class ConfigManager {
    
    private OMPClient client;

    public ConfigManager(OMPClient client) {
        this.client = client;
    }

    /**
     * Gets information about all targets.
     * 
     * @return List of targets
     * 
     * @throws OpenVASException The OpenVASException is thrown if there occurs 
     * any error during this request.
     */
    public List<Target> getTargets() throws OpenVASException {
        GetTargetsCommand cmd = new GetTargetsCommand();
        client.execute(cmd);
        return cmd.getResponseHandler().getResponse().getTargets();
    }
    
    /**
     * Gets information about the given target.
     * 
     * @return Information about the given target
     * 
     * @throws OpenVASException The OpenVASException is thrown if there occurs 
     * any error during this request.
     */
    public List<Target> getTargets(String uuid) throws OpenVASException {
        GetTargetsCommand cmd = new GetTargetsCommand();
        cmd.setTargetId(uuid);
        client.execute(cmd);
        return cmd.getResponseHandler().getResponse().getTargets();
    }
}
