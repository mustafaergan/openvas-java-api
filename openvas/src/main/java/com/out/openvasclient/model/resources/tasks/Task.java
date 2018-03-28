/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.out.openvasclient.model.resources.tasks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author christoph
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Task {
    
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
   
    @XmlElement
    //@XmlJavaTypeAdapter(BooleanStringAdapter.class)
    private Integer writeable;
    
    @XmlElement
  //  @XmlJavaTypeAdapter(BooleanStringAdapter.class)
    private Integer inUse;
    
    // user_tags
    // owner 
    
    @XmlElement
 //   @XmlJavaTypeAdapter(BooleanStringAdapter.class)
    private Integer alterable;
    
    @XmlElement
    private Config config;
    
    @XmlElement
    private Target target;
    
    @XmlElement
    private Scanner scanner;
    
    @XmlElement
    private String status;
    

    public Task() {
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

    
    public Integer getWriteable() {
        return writeable;
    }

    public void setWriteable(Integer writeable) {
        this.writeable = writeable;
    }

    public Integer getInUse() {
        return inUse;
    }

    public void setInUse(Integer inUse) {
        this.inUse = inUse;
    }

    public Integer getAlterable() {
        return alterable;
    }

    public void setAlterable(Integer alterable) {
        this.alterable = alterable;
    }

    
    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", name=" + name + ", comment=" + comment + ", creationTime=" + creationTime + ", modificationTime=" + modificationTime + ", config=" + config + ", target=" + target + ", scanner=" + scanner + ", status=" + status + '}';
    }

   
    
    
}
