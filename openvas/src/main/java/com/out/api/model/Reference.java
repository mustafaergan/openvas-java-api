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
 * This class contains information about a reference. 
 * 
 * @author Christoph Bless
 */
public class Reference {
    
    private ReferenceType type;
    
    private String reference;

    public Reference() {
    }

    /**
     * Gets the type of the reference.
     * 
     * @return Type of the reference.
     */
    public ReferenceType getType() {
        return type;
    }

    /**
     * Sets the type of the reference.
     * @param type Type of the reference.
     */
    public void setType(ReferenceType type) {
        this.type = type;
    }

    /**
     * Gets the reference of the reference.
     * @return The reference of the reference.
     */
    public String getReference() {
        return reference;
    }

    /**
     * Sets the reference of the reference.
     * @param reference Reference of the reference.
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "Reference{" + "type=" + type + ", reference=" + reference + '}';
    }
    
    
    
}
