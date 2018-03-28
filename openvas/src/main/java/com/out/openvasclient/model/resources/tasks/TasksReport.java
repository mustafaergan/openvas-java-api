/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.out.openvasclient.model.resources.tasks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author christoph
 */
@XmlRootElement(name="report")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown=true)
public class TasksReport {
    
    @XmlAttribute
    private String id;
    
    @XmlElement
    private String timestamp;
    
    @XmlElement(name="result_count")
    private TaskResultCount resultCount;
    
    private String serverity;

    public TasksReport() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public TaskResultCount getResultCount() {
        return resultCount;
    }

    public void setResultCount(TaskResultCount resultCount) {
        this.resultCount = resultCount;
    }

    public String getServerity() {
        return serverity;
    }

    public void setServerity(String serverity) {
        this.serverity = serverity;
    }

    @Override
    public String toString() {
        return "Report{" + "id=" + id + ", timestamp=" + timestamp + ", resultCount=" + resultCount + ", serverity=" + serverity + '}';
    }
    
    
}
