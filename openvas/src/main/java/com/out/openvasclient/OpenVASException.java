/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.out.openvasclient;

/**
 *
 * @author Christoph Bless
 */
public class OpenVASException extends Exception {

    public OpenVASException(String string) {
        super(string);
    }

    public OpenVASException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public OpenVASException(Throwable thrwbl) {
        super(thrwbl);
    }

    public OpenVASException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
}
