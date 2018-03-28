/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.out.openvasclient.model;

/**
 *
 * @author christoph
 */
public enum TaskStatus {

    Delete("Delete Requested"),
    Done("Done"),
    New("New"),
    Requested("Requested"),
    Running("Running"),
    StopRequested("Stop Requested"),
    Stopped("Stopped"),
    InternalError("InternalError");
    
    private final String status;

    private TaskStatus(String status) {
        this.status = status;
    }
    
    public String getStatus(){
        return status;
    }
}
