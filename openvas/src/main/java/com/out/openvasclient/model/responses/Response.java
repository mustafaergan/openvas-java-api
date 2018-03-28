package com.out.openvasclient.model.responses;

public class Response {

    /**
     * @see http://docs.greenbone.net/GSM-Manual/gos-3.1/de/omp.html
     * 2xx: successfull
     * 200 = OK
     * 201 = Resource created
     * 202 = Request submitted
     * 
     * 4xx: Client error
     * 400 = Synthax Error
     * 401 = authentication required
     * 403 = Forbidden
     * 404 = Resource not found
     * 409 = resource busy
     * 
     * 5xx: Server error
     * 500 = Internal Error
     * 503 = Service temporarily down / serive unavailable
     * 
     * 
     */
    protected Integer status;
    protected String statusText;


    public Integer getStatus() {
            return status;
    }
    public void setStatus(Integer status) {
            this.status = status;
    }
    public String getStatusText() {
            return statusText;
    }
    public void setStatusText(String statusText) {
            this.statusText = statusText;
    }
    
}
