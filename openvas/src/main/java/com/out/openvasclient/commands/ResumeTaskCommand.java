/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.out.openvasclient.commands;

import javax.xml.bind.JAXBException;

import com.out.openvasclient.DefaultCommand;
import com.out.openvasclient.handler.ResumeTaskResponseHandler;
import com.out.openvasclient.model.requests.ResumeTaskRequest;
import com.out.openvasclient.util.JAXBUtil;

/**
 *
 * @author Christoph Bless
 */
public class ResumeTaskCommand extends DefaultCommand<ResumeTaskResponseHandler> {

    private ResumeTaskRequest request = new ResumeTaskRequest();

    public ResumeTaskCommand() {
        super("resume_task", true, new ResumeTaskResponseHandler());
    }
    
    
    public void setTaskId(String id){
        request.setTaskId(id);
    }
    

    @Override
    public String getRequest() throws JAXBException {
        return JAXBUtil.marshall(request, ResumeTaskRequest.class);
    }

}
