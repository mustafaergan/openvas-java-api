/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.out.openvasclient.model.responses;

/**
 *
 * @author christoph
 */
public class StopTaskResponse extends Response {

    public StopTaskResponse() {
    }

    @Override
    public String toString() {
        return "StopTaskResponse{status= " +status + " statusText="+ statusText +'}';
    }
    
    
}
