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

import java.util.List;

/**
 * This class contains information about a plugin. 
 * 
 * @author Christoph Bless
 */
public class Plugin {
    
    private String id;
    
    private String name;
    
    private String family;
    
    private String cvss;
    
    private String description;

    private List<Reference> references;
        
    
    public Plugin() {
    }
    
    /**
     * Gets the description of the plugin.
     * 
     * @return The description of the plugin
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the plugin.
     * 
     * @param description The description of the plugin
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    
    /**
     * Gets the id of the plugin.
     * 
     * @return The id of the plugin
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id of the plugin.
     * 
     * @param id The id of the plugin
     */
    public void setId(String id) {
        this.id = id;
    }

    
    /**
     * Gets the name of the plugin.
     * 
     * @return The name of the plugin
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the plugin.
     * 
     * @param name The name of the plugin
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the family of the plugin.
     * 
     * @return The family of the plugin
     */
    public String getFamily() {
        return family;
    }

    /**
     * Sets the family of the plugin.
     * 
     * @param family The family of the plugin
     */
    public void setFamily(String family) {
        this.family = family;
    }

    /**
     * Gets the CVSS value of the plugin.
     * 
     * @return  The CVSS value of the plugin
     */
    public String getCvss() {
        return cvss;
    }

    /**
     * Sets the CVSS value of the plugin.
     * 
     * @param cvss The CVSS value of the plugin
     */
    public void setCvss(String cvss) {
        this.cvss = cvss;
    }

    /**
     * Gets a list of references.
     * 
     * @return  A list of references.
     */
    public List<Reference> getReferences() {
        return references;
    }

    /**
     * Sets a list of references.
     * 
     * @param references A list of references.
     */
    public void setReferences(List<Reference> references) {
        this.references = references;
    }

    @Override
    public String toString() {
        return "Plugin{" + "id=" + id + ", name=" + name + ", family=" + family + ", cvss=" + cvss + ", description=" + description + ", references=" + references + '}';
    }

    
}
