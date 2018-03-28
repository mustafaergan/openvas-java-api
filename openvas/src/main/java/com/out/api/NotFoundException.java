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
package com.out.api;

/**
 * This Exception should be thrown if the server couldn't found the requested 
 * resource.
 * 
 * @author Christoph Bless
 */
public class NotFoundException extends ClientException {

    public NotFoundException(String string) {
        super(string);
    }

    public NotFoundException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public NotFoundException(Throwable thrwbl) {
        super(thrwbl);
    }

    public NotFoundException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
}
