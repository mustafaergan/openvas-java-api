/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.out.openvasclient.handler;

import java.io.IOException;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.out.openvasclient.model.responses.AuthenticateResponse;

/**
 *
 * @author christoph
 */
public class AuthenticateResponseHandler extends DefaultHandler<AuthenticateResponse>{

    public AuthenticateResponseHandler() {
        super(new AuthenticateResponse(), "authenticate_response");
    }

    @Override
    protected void parseStartElement(XMLStreamReader parser)  throws XMLStreamException, IOException {
        if ("role".equals(parser.getName().toString())){
            response.setRole(parser.getElementText());
        }
        if ("timezone".equals(parser.getName().toString())){
            response.setTimezone(parser.getElementText());
        } 
    }
    
}
