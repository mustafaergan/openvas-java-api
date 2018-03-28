/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.out.openvasclient.commands;

import javax.xml.bind.JAXBException;

import com.out.openvasclient.DefaultCommand;
import com.out.openvasclient.handler.GetTasksResponseHandler;
import com.out.openvasclient.model.requests.GetTasksRequest;
import com.out.openvasclient.util.JAXBUtil;

/**
 *
 * @author christoph
 */
public class GetTasksCommand extends DefaultCommand<GetTasksResponseHandler>{

    private GetTasksRequest request = new GetTasksRequest();

    public GetTasksCommand() {
        super("get_tasks", true, new GetTasksResponseHandler());
    }
    
    
    public void setUUID(String uuid){
        request.setTaskId(uuid);
    }
    public void setDetails(boolean details){
        request.setDetails(details);
    }
    

    @Override
    public String getRequest() throws JAXBException {
        return JAXBUtil.marshall(request, GetTasksRequest.class);
    }

}
