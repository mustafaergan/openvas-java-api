/*
 * Copyright (C) 2015 Christoph Bless
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.out.api.model;

/**
 * This class provides some basic information about a scan or task.
 * 
 * @author Christoph Bless
 */
public class Scan {
    
    /** The unique id of the scan. */
    protected String id;
    
    /** The name of the scan */
    protected String name;
    
    /** The status to the scan. */
    protected String status;

    public Scan() {
    }

    /**
     * Gets the id of the scan
     * @return The id of the scan
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id of the scan
     * @param id The id of the scan
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the name of the scan
     * @return The name of the scan
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the scan
     * @param name The name of the scan
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the status of the scan
     * @return The status of the scan
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the scan
     * @param status The status of the scan
     */
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Scan{" + "id=" + id + ", name=" + name + ", status=" + status + '}';
    }
    
    
}
