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
@XmlRootElement(name="get_results")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetResultsRequest {
    
    @XmlAttribute(name="result_id")
    private String resultID;
    
    @XmlAttribute
    private String filter;
        
    @XmlAttribute(name="filt_id")
    private String filterId;
    
    @XmlAttribute(name="task_id")
    private String taskId;
    
    @XmlAttribute
    @XmlJavaTypeAdapter(BooleanStringAdapter.class)
    private Boolean notes = false;
    
    @XmlAttribute(name="note_details")
    @XmlJavaTypeAdapter(BooleanStringAdapter.class)
    private Boolean noteDetails = false;
    
    @XmlAttribute
    @XmlJavaTypeAdapter(BooleanStringAdapter.class)
    private Boolean overrides = false;
    
    @XmlAttribute(name="override_details")
    @XmlJavaTypeAdapter(BooleanStringAdapter.class)
    private Boolean overrideDetails = false;
    
    @XmlAttribute(name="apply_overrides")
    @XmlJavaTypeAdapter(BooleanStringAdapter.class)
    private Boolean applyOverrides = false;
    
    @XmlAttribute
    @XmlJavaTypeAdapter(BooleanStringAdapter.class)
    private Boolean details = false;

    public GetResultsRequest() {
    }

    public String getResultID() {
        return resultID;
    }

    public void setResultID(String resultID) {
        this.resultID = resultID;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getFilterId() {
        return filterId;
    }

    public void setFilterId(String filterId) {
        this.filterId = filterId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    
    public boolean isNotes() {
        return notes;
    }

    public void setNotes(boolean notes) {
        this.notes = notes;
    }

    public boolean isNoteDetails() {
        return noteDetails;
    }

    public void setNoteDetails(boolean noteDetails) {
        this.noteDetails = noteDetails;
    }

    public boolean isOverrides() {
        return overrides;
    }

    public void setOverrides(boolean overrides) {
        this.overrides = overrides;
    }

    public boolean isOverrideDetails() {
        return overrideDetails;
    }

    public void setOverrideDetails(boolean overrideDetails) {
        this.overrideDetails = overrideDetails;
    }

    public boolean isApplyOverrides() {
        return applyOverrides;
    }

    public void setApplyOverrides(boolean applyOverrides) {
        this.applyOverrides = applyOverrides;
    }

    public boolean isDetails() {
        return details;
    }

    public void setDetails(boolean details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "GetResultsRequest{" + "resultID=" + resultID + ", filter=" + filter + ", filterId=" + filterId + ", taskId=" + taskId + ", notes=" + notes + ", noteDetails=" + noteDetails + ", overrides=" + overrides + ", overrideDetails=" + overrideDetails + ", applyOverrides=" + applyOverrides + ", details=" + details + '}';
    }

    
    
}
