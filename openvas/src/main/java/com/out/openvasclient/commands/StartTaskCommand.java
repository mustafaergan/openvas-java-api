/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.out.openvasclient.commands;

import javax.xml.bind.JAXBException;

import com.out.openvasclient.DefaultCommand;
import com.out.openvasclient.handler.StartTaskResponseHandler;
import com.out.openvasclient.model.requests.StartTaskRequest;
import com.out.openvasclient.util.JAXBUtil;

/**
 *
 * @author christoph
 */
public class StartTaskCommand extends DefaultCommand<StartTaskResponseHandler> {

    private StartTaskRequest request = new StartTaskRequest();

    public StartTaskCommand() {
        super("start_task", true, new StartTaskResponseHandler());
    }
    
    public void setTaskId(String id){
        request.setTaskId(id);
    }

    @Override
    public String getRequest() throws JAXBException {
        return JAXBUtil.marshall(request, StartTaskRequest.class);
    }

}
