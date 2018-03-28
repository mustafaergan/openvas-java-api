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
 * @author christoph
 */
@XmlRootElement(name="resume_task")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResumeTaskRequest {
    
    @XmlAttribute(name="task_id")
    private String taskId;

    public ResumeTaskRequest() {
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return "ResumeTaskRequest{" + "taskId=" + taskId + '}';
    }

    
   
}
