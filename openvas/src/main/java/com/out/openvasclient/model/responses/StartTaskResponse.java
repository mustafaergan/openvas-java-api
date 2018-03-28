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
public class StartTaskResponse extends Response {
    
    private String reportId;

    public StartTaskResponse() {
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    @Override
    public String toString() {
        return "StartTaskResponse{status="+ status + " statusText="+statusText 
                + " reportId=" + reportId + '}';
    }
  
    
}
