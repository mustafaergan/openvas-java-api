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
package com.out.openvasclient.model.resources;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Christoph Bless
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NvtFamily {
    
    @XmlElement
    private String name;
    
    @XmlElement(name="max_nvt_count")
    private int nvtCount;

    public NvtFamily() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNvtCount() {
        return nvtCount;
    }

    public void setNvtCount(int nvtCount) {
        this.nvtCount = nvtCount;
    }

    @Override
    public String toString() {
        return "NvtFamily{" + "name=" + name + ", nvtCount=" + nvtCount + '}';
    }
    
    
}
