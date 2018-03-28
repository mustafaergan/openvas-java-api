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

import com.out.openvasclient.model.resources.Target;

/**
 *
 * @author Christoph Bless
 */
public class GetTargetsResponse extends Response {

    List<Target> targets = new ArrayList<Target>();
    
    public GetTargetsResponse() {
    }

    public List<Target> getTargets() {
        return targets;
    }

    public void setTargets(List<Target> targets) {
        this.targets = targets;
    }

    public boolean add(Target e) {
        return targets.add(e);
    }

    @Override
    public String toString() {
        return "GetTargetsResponse{" + "targets=" + targets + '}';
    }
    
    
}
