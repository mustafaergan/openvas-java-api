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

import com.out.openvasclient.model.resources.NvtFamily;
import com.out.openvasclient.model.responses.GetNvtFamiliesResponse;

/**
 *
 * @author Christoph Bless
 */
public class GetNvtFamiliesHandler extends DefaultHandler<GetNvtFamiliesResponse>{

    private NvtFamily tempFamily; 
    
    public GetNvtFamiliesHandler() {
        super(new GetNvtFamiliesResponse(), "get_nvt_families_response");
    }

    @Override
    protected void parseStartElement(XMLStreamReader parser) throws XMLStreamException, IOException {
        if ("family".equals(parser.getName().toString())){
           tempFamily = new NvtFamily();
        } else if ("name".equals(parser.getName().toString())){
            if (tempFamily != null){
                tempFamily.setName(parser.getElementText());
            }
        } else if ("max_nvt_count".equals(parser.getName().toString())){
            if (tempFamily != null){
                tempFamily.setNvtCount(Integer.parseInt(parser.getElementText()));
            }
        }
    }

    @Override
    protected void parseEndElement(XMLStreamReader parser) {
        if ("family".equals(parser.getName().toString())){
            response.add(tempFamily);
            tempFamily = null;
        }
    }
    
    
    
}
