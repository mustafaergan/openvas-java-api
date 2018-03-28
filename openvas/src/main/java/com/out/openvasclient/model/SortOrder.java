/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.out.openvasclient.model;

/**
 *
 * @author Christoph Bless
 */
public enum SortOrder {
    
    Ascending("ascending"),
    
    Descending("descending");

    private final String name;
    
    private SortOrder(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
       
}
