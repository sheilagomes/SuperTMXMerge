/*
 * Copyright (C) 2013 Aaron Madlon-Kay <aaron@madlon-kay.com>.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package org.madlonkay.supertmxmerge.gui;

import javax.swing.border.Border;

import org.jdesktop.beansbinding.Converter;

/**
 *
 * @author Aaron Madlon-Kay <aaron@madlon-kay.com>
 */
public class BorderConverter extends Converter<Boolean, Border> {
    
    private final Border selectedBorder;
    private final Border defaultBorder;

    /**
     * Empty constructor to make NetBeans' design view happy.
     * Do not use.
     */
    public BorderConverter() {
        this.selectedBorder = null;
        this.defaultBorder = null;
    }
    
    public BorderConverter(Border selectedBorder, Border defaultBorder) {
        this.selectedBorder = selectedBorder;
        this.defaultBorder = defaultBorder;
    }
            
    @Override
    public Border convertForward(Boolean value) {
        return value ? selectedBorder : defaultBorder;
    }

    @Override
    public Boolean convertReverse(Border value) {
        return value == selectedBorder;
    }
    
}
