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
package com.out.openvasclient.model.responses;

import java.util.ArrayList;
import java.util.List;

import com.out.openvasclient.model.resources.NVT;

/**
 *
 * @author Christoph Bless
 */
public class GetInfoResponse extends Response{
    
    List<NVT> nvts = new ArrayList<NVT>();

    public GetInfoResponse() {
    }

    public List<NVT> getNvts() {
        return nvts;
    }

    public void setNvts(List<NVT> nvts) {
        this.nvts = nvts;
    }

    public boolean add(NVT nvt) {
        return nvts.add(nvt);
    }
    @Override
    public String toString() {
        return "GetInfoResponse{status= "+status+ " statusText=" +statusText+ " nvts=" + nvts + '}';
    }
    
    
}
