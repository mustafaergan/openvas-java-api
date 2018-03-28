/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.out.openvasclient.handler;

import java.io.IOException;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.out.openvasclient.model.responses.StopTaskResponse;

/**
 *
 * @author christoph
 */
public class StopTaskResponseHandler extends DefaultHandler<StopTaskResponse>{

    public StopTaskResponseHandler() {
        super(new StopTaskResponse(), "stop_task_response");
    }

    @Override
    protected void parseStartElement(XMLStreamReader parser)  throws XMLStreamException, IOException  {
        
    }
    
}
