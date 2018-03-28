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
@XmlRootElement(name="get_targets")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetTargetsRequest {
    
    @XmlAttribute(name="target_id")
    private String targetId;
    
    @XmlAttribute
    private String filter;
    
    @XmlAttribute(name="filt_id")
    private String filtId;
    
    @XmlAttribute
    @XmlJavaTypeAdapter(BooleanStringAdapter.class)
    private Boolean trash = false;
    
    @XmlAttribute
    @XmlJavaTypeAdapter(BooleanStringAdapter.class)
    private Boolean tasks = false;

    public GetTargetsRequest() {
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getFiltId() {
        return filtId;
    }

    public void setFiltId(String filtId) {
        this.filtId = filtId;
    }

    public Boolean getTrash() {
        return trash;
    }

    public void setTrash(Boolean trash) {
        this.trash = trash;
    }

    public Boolean getTasks() {
        return tasks;
    }

    public void setTasks(Boolean tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "GetTargetsRequest{" + "targetId=" + targetId + ", filter=" + filter + ", filtId=" + filtId + ", trash=" + trash + ", tasks=" + tasks + '}';
    }
    
    
}
