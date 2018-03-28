/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.out.openvasclient.model.resources.results;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.out.openvasclient.model.resources.NVT;
import com.out.openvasclient.model.resources.tasks.Task;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Christoph Bless
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    
    @XmlAttribute
    private String id;
    
    @XmlElement
    private String name;
    
    
    @XmlElement
    private String comment;
    
    @XmlElement(name="creation_time")
    private String creationTime;
    
    @XmlElement(name="modification_time")
    private String modificationTime;
    
    // TODO user_tags
    
    /**
     * The report the result belongs to (only when details were requested)
     */
    @XmlElementWrapper(name="report")
    @XmlElement(name="id")
    private String reportId;
    
    @XmlElement
    private Task task;
    
    @XmlElement
    private String host;
    
    @XmlElement
    private String port;
    
    @XmlElement
    private NVT nvt;
    
    @XmlElement(name="scan_nvt_version")
    private String scanNVTVersion;
    
    @XmlElement
    private String threat;
    
    @XmlElement
    private String severity;
    
    @XmlElement
    private String description;

    public Result() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(String modificationTime) {
        this.modificationTime = modificationTime;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public NVT getNvt() {
        return nvt;
    }

    public void setNvt(NVT nvt) {
        this.nvt = nvt;
    }

    public String getScanNVTVersion() {
        return scanNVTVersion;
    }

    public void setScanNVTVersion(String scanNVTVersion) {
        this.scanNVTVersion = scanNVTVersion;
    }

    public String getThreat() {
        return threat;
    }

    public void setThreat(String threat) {
        this.threat = threat;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Result{" + "id=" + id + ", name=" + name + ", comment=" + comment + ", creationTime=" + creationTime + ", modificationTime=" + modificationTime + ", reportId=" + reportId + ", task=" + task + ", host=" + host + ", port=" + port + ", nvt=" + nvt + ", scanNVTVersion=" + scanNVTVersion + ", threat=" + threat + ", severity=" + severity + ", description=" + description + '}';
    }
  
    
    
}
