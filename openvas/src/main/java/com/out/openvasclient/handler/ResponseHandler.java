/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.out.openvasclient.handler;

import java.io.InputStream;

import com.out.openvasclient.OpenVASException;
import com.out.openvasclient.model.responses.Response;

/**
 *
 * @author christoph
*/ 
public interface ResponseHandler<T extends Response> {

    String getStatusText();
    
    int getStatus();
    
    T getResponse();
    
    void parse(InputStream in) throws OpenVASException;
    
}
