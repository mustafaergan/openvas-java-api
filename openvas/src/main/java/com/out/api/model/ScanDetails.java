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
 * This class provides detailed information about a scan or task.
 * 
 * @author Christoph Bless
 */
public class ScanDetails extends Scan{

    /** The specified target(s) of the scan. This contains either a single IP or
     * target name or a comma separated list of IP's.*/
    private String targets;

    public ScanDetails() {
        super();
    }

    /** Gets the target(s) of the scan.
     * 
     * @return Target(s) of of the scan
     */
    public String getTargets() {
        return targets;
    }

    /** Sets the target(s) of the scan.
     * 
     * @param targets Target(s) of of the scan
     */
    public void setTargets(String targets) {
        this.targets = targets;
    }

    @Override
    public String toString() {
        return "ScanDetails{id="+id+", name="+name + ", status="+status + ", targets=" + targets + '}';
    }
  
    
}
