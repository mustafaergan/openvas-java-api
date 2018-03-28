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
package com.out.openvasclient.handler;

import java.io.IOException;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.out.openvasclient.model.resources.NVT;
import com.out.openvasclient.model.responses.GetInfoResponse;

/**
 *
 * @author Christoph Bless
 */
public class GetInfoResponseHandler extends DefaultHandler<GetInfoResponse>{

    
    public GetInfoResponseHandler() {
        super(new GetInfoResponse(), "get_info_response");
    }

    
    @Override
    protected void parseStartElement(XMLStreamReader parser) throws XMLStreamException, IOException {
        if ("nvt".equals(parser.getName().toString())){
            NVT nvt = mapper.readValue(parser, NVT.class);
            response.add(nvt);
        }
    }
    
}
