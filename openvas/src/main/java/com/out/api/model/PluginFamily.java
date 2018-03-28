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
 * This class contains information about a PluginFamily.
 * 
 * @author Christoph Bless
 */
public class PluginFamily {
    
    private String id;
    
    private String name;

    private int pluginCount;
    
    public PluginFamily() {
    }

    /**
     * Gets the id of the PluginFamily.
     * 
     * @return id of the PluginFamily
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id of the PluginFamily
     * 
     * @param id The id of the PluginFamily
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the name of the PluginFamily
     * @return The name of the PluginFamily
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the PluginFamily
     * @param name The name of the PluginFamily
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the number of plugins in this PluginFamily.
     * 
     * @return number of plugins in this PluginFamily
     */
    public int getPluginCount() {
        return pluginCount;
    }

    /**
     * Sets the number of plugins in this PluginFamily.
     * 
     * @param pluginCount The number of plugins in this PluginFamily
     */
    public void setPluginCount(int pluginCount) {
        this.pluginCount = pluginCount;
    }

    @Override
    public String toString() {
        return "PluginFamily{" + "id=" + id + ", name=" + name + ", pluginCount=" + pluginCount + '}';
    }

    
}
