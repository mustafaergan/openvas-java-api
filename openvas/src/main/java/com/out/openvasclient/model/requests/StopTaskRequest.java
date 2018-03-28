/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.out.openvasclient.model.requests;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Christoph Bless
 */
@XmlRootElement(name="stop_task")
@XmlAccessorType(XmlAccessType.FIELD)
public class StopTaskRequest {

    @XmlAttribute(name="task_id")
    private String taskId;

    public StopTaskRequest() {
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return "StopTaskRequest{" + "taskId=" + taskId + '}';
    }
    
    
}
