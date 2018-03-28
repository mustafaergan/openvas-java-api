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
package com.out.openvasclient.model.requests;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.out.openvasclient.util.BooleanStringAdapter;

/**
 *
 * @author Christoph Bless
 */
@XmlRootElement(name="get_configs")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetConfigsRequest {
    
    @XmlAttribute(name="config_id")
    private String configID;
    
    @XmlAttribute
    private String filter;
    
    @XmlAttribute(name="filt_id")
    private String filtID;
    
    @XmlAttribute
    @XmlJavaTypeAdapter(BooleanStringAdapter.class)
    private Boolean trash = false;
    
    @XmlAttribute
    @XmlJavaTypeAdapter(BooleanStringAdapter.class)
    private Boolean details = false;
    
    @XmlAttribute
    @XmlJavaTypeAdapter(BooleanStringAdapter.class)
    private Boolean families = false;
    
    @XmlAttribute
    @XmlJavaTypeAdapter(BooleanStringAdapter.class)
    private Boolean preferences = false;
    
    @XmlAttribute
    @XmlJavaTypeAdapter(BooleanStringAdapter.class)
    private Boolean tasks = false;

    public GetConfigsRequest() {
    }

    public String getConfigID() {
        return configID;
    }

    public void setConfigID(String configID) {
        this.configID = configID;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getFiltID() {
        return filtID;
    }

    public void setFiltID(String filtID) {
        this.filtID = filtID;
    }

    public Boolean getTrash() {
        return trash;
    }

    public void setTrash(Boolean trash) {
        this.trash = trash;
    }

    public Boolean getDetails() {
        return details;
    }

    public void setDetails(Boolean details) {
        this.details = details;
    }

    public Boolean getFamilies() {
        return families;
    }

    public void setFamilies(Boolean families) {
        this.families = families;
    }

    public Boolean getPreferences() {
        return preferences;
    }

    public void setPreferences(Boolean preferences) {
        this.preferences = preferences;
    }

    public Boolean getTasks() {
        return tasks;
    }

    public void setTasks(Boolean tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "GetConfigRequest{" + "configID=" + configID + ", filter=" + filter + ", filtID=" + filtID + ", trash=" + trash + ", details=" + details + ", families=" + families + ", preferences=" + preferences + ", tasks=" + tasks + '}';
    }
    
    
}
