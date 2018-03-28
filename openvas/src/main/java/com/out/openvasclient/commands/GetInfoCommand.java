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
import com.out.openvasclient.handler.GetInfoResponseHandler;
import com.out.openvasclient.model.requests.GetInfoRequest;
import com.out.openvasclient.util.JAXBUtil;

/**
 *
 * @author Christoph Bless
 */
public class GetInfoCommand extends DefaultCommand<GetInfoResponseHandler>{

    private GetInfoRequest request = new GetInfoRequest();
    
    public GetInfoCommand() {
        super("get_info", true, new GetInfoResponseHandler());
    }

    public void setType(String type) {
        request.setType(type);
    }

    public void setName(String name) {
        request.setName(name);
    }

    public void setInfoId(String infoId) {
        request.setInfoId(infoId);
    }

    
    @Override
    public String getRequest() throws JAXBException {
        return JAXBUtil.marshall(request, GetInfoRequest.class);
    }
    
    
}
