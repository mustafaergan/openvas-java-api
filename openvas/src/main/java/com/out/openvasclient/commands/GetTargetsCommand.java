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
import com.out.openvasclient.handler.GetTargetsResponseHandler;
import com.out.openvasclient.model.requests.GetTargetsRequest;
import com.out.openvasclient.util.JAXBUtil;

/**
 *
 * @author Christoph Bless
 */
public class GetTargetsCommand extends DefaultCommand<GetTargetsResponseHandler>{
    
    private GetTargetsRequest request = new GetTargetsRequest();

    public GetTargetsCommand() {
        super("get_targets", true, new GetTargetsResponseHandler());
    }


    public String getTargetId() {
        return request.getTargetId();
    }

    public void setTargetId(String targetId) {
        request.setTargetId(targetId);
    }

    public String getFilter() {
        return request.getFilter();
    }

    public void setFilter(String filter) {
        request.setFilter(filter);
    }

    public String getFiltId() {
        return request.getFiltId();
    }

    public void setFiltId(String filtId) {
        request.setFiltId(filtId);
    }

    public Boolean getTrash() {
        return request.getTrash();
    }

    public void setTrash(Boolean trash) {
        request.setTrash(trash);
    }

    public Boolean getTasks() {
        return request.getTasks();
    }

    public void setTasks(Boolean tasks) {
        request.setTasks(tasks);
    }

    @Override
    public String getRequest() throws JAXBException {
        return JAXBUtil.marshall(request, GetTargetsRequest.class);
    }
    
    
}
