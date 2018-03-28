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

import com.out.openvasclient.model.resources.results.Result;
import com.out.openvasclient.model.responses.GetResultsResponse;

/**
 *
 * @author Christoph Bless
 */
public class GetResultsResponseHandler extends DefaultHandler<GetResultsResponse>{

    
    public GetResultsResponseHandler() {
        super(new GetResultsResponse(), "get_results_response");
    }

    @Override
    protected void parseStartElement(XMLStreamReader parser) throws XMLStreamException, IOException {
        if ("result".equals(parser.getName().toString())){
            Result result = mapper.readValue(parser, Result.class);
            response.addResult(result);
        }
    }
    
    
}
