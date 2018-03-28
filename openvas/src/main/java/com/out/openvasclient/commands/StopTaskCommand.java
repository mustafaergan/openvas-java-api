/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.out.openvasclient.commands;

import javax.xml.bind.JAXBException;

import com.out.openvasclient.DefaultCommand;
import com.out.openvasclient.handler.StopTaskResponseHandler;
import com.out.openvasclient.model.requests.StopTaskRequest;
import com.out.openvasclient.util.JAXBUtil;

/**
 *
 * @author christoph
 */
public class StopTaskCommand extends DefaultCommand<StopTaskResponseHandler> {

    private StopTaskRequest request = new StopTaskRequest();

    public StopTaskCommand() {
        super("stop_task", true, new StopTaskResponseHandler());
    }

    public void setTaskId(String id) {
        request.setTaskId(id);
    }

    @Override
    public String getRequest() throws JAXBException {
        return JAXBUtil.marshall(request, StopTaskRequest.class);
    }

}
