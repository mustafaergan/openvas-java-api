/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.out.openvasclient.model.resources.tasks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author christoph
 */
@XmlRootElement(name="result_count")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown=true)
public class TaskResultCount {
    
    @XmlElement
    private Integer debug;
    
    @XmlElement
    private Integer hole;
    
    @XmlElement
    private Integer info;
    
    @XmlElement
    private Integer log;
    
    @XmlElement
    private Integer warnings;

    public TaskResultCount() {
    }

    public Integer getDebug() {
        return debug;
    }

    public void setDebug(Integer debug) {
        this.debug = debug;
    }

    public Integer getHole() {
        return hole;
    }

    public void setHole(Integer hole) {
        this.hole = hole;
    }

    public Integer getInfo() {
        return info;
    }

    public void setInfo(Integer info) {
        this.info = info;
    }

    public Integer getLog() {
        return log;
    }

    public void setLog(Integer log) {
        this.log = log;
    }

    public Integer getWarnings() {
        return warnings;
    }

    public void setWarnings(Integer warnings) {
        this.warnings = warnings;
    }

    

    @Override
    public String toString() {
        return "ResultCount{" + "debug=" + debug + ", hole=" + hole + ", info=" + info + ", log=" + log + ", warnings=" + warnings + '}';
    }
    
    
    
}
