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
package com.out.openvasclient.commands;

import javax.xml.bind.JAXBException;

import com.out.openvasclient.DefaultCommand;
import com.out.openvasclient.handler.GetResultsResponseHandler;
import com.out.openvasclient.model.requests.GetResultsRequest;
import com.out.openvasclient.util.JAXBUtil;

/**
 *
 * @author Christoph Bless
 */
public class GetResultsCommand extends DefaultCommand<GetResultsResponseHandler>{

    private GetResultsRequest request = new GetResultsRequest();

    public GetResultsCommand() {
        super("get_results", true, new GetResultsResponseHandler());
    }

    public String getResultID() {
        return request.getResultID();
    }

    public void setResultID(String resultID) {
        request.setResultID(resultID);
    }

    public String getFilter() {
        return request.getFilter();
    }

    public void setFilter(String filter) {
        request.setFilter(filter);
    }

    public String getFilterId() {
        return request.getFilterId();
    }

    public void setFilterId(String filterId) {
        request.setFilterId(filterId);
    }

    public String getTaskId() {
        return request.getTaskId();
    }

    public void setTaskId(String taskId) {
        request.setTaskId(taskId);
    }

    
    public boolean isNotes() {
        return request.isNotes();
    }

    public void setNotes(boolean notes) {
        request.setNotes(notes);
    }

    public boolean isNoteDetails() {
        return request.isNoteDetails();
    }

    public void setNoteDetails(boolean noteDetails) {
        request.setNoteDetails(noteDetails);
    }

    public boolean isOverrides() {
        return request.isOverrides();
    }

    public void setOverrides(boolean overrides) {
        request.setOverrides(overrides);
    }

    public boolean isOverrideDetails() {
        return request.isOverrideDetails();
    }

    public void setOverrideDetails(boolean overrideDetails) {
        request.setOverrideDetails(overrideDetails);
    }

    public boolean isApplyOverrides() {
        return request.isApplyOverrides();
    }

    public void setApplyOverrides(boolean applyOverrides) {
        request.setApplyOverrides(applyOverrides);
    }

    public boolean isDetails() {
        return request.isDetails();
    }

    public void setDetails(boolean details) {
        request.setDetails(details);
    }
    
    
    @Override
    public String getRequest() throws JAXBException {
        return JAXBUtil.marshall(request, GetResultsRequest.class);
    }

    
}
