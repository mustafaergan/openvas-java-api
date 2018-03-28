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
package com.out.openvasclient.model.responses;

import java.util.ArrayList;
import java.util.List;

import com.out.openvasclient.model.resources.config.Config;

/**
 *
 * @author Christoph Bless
 */
public class GetConfigsResponse extends Response {
    
    
    private List<Config> configList = new ArrayList<Config>();

    public GetConfigsResponse() {
    }

    public boolean add(Config e) {
        return configList.add(e);
    }

    public Config get(int i) {
        return configList.get(i);
    }
    
    

    public List<Config> getConfigList() {
        return configList;
    }

    public void setConfigList(List<Config> configList) {
        this.configList = configList;
    }

    @Override
    public String toString() {
        return "GetConfigsResponse{" + "configList=" + configList + '}';
    }

    
    
}
