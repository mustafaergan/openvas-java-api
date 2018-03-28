/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.out.openvasclient.handler;

import java.io.IOException;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.out.openvasclient.model.responses.ResumeTaskResponse;

/**
 *
 * @author christoph
 */
public class ResumeTaskResponseHandler extends DefaultHandler<ResumeTaskResponse>{

    public ResumeTaskResponseHandler() {
        super(new ResumeTaskResponse(), "resume_task_response");
    }

    @Override
    protected void parseStartElement(XMLStreamReader parser)  throws XMLStreamException, IOException  {
        if ("report_id".equals(parser.getName().toString())){
            response.setReportId(parser.getElementText());
        }
    }  
}
