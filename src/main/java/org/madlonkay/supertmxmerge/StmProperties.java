/*
 * Copyright (C) 2014 Aaron Madlon-Kay <aaron@madlon-kay.com>.
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

package org.madlonkay.supertmxmerge;

import java.awt.Window;
import java.util.ResourceBundle;

import org.madlonkay.supertmxmerge.data.Report;
import org.madlonkay.supertmxmerge.data.ResolutionStrategy;

/**
 *
 * @author Aaron Madlon-Kay <aaron@madlon-kay.com>
 */
public class StmProperties {
    
    private ResourceBundle resource = null;
    private Window parentWindow = null;
    private int listViewThreshold = 5;
    private ResolutionStrategy resolutionStrategy = null;
    private Report report = null;

    public StmProperties() {
    }
    
    public StmProperties setLanguageResource(ResourceBundle resource) {
        this.resource = resource;
        return this;
    }
    
    public ResourceBundle getLanguageResource() {
        return resource;
    }
    
    public StmProperties setParentWindow(Window window) {
        this.parentWindow = window;
        return this;
    }
    
    public Window getParentWindow() {
        return parentWindow;
    }
    
    public StmProperties setListViewThreshold(int threshold) {
        if (threshold < 0) {
            throw new IllegalArgumentException("The list view threshold must be at least 0.");
        }
        this.listViewThreshold = threshold;
        return this;
    }
    
    public int getListViewThreshold() {
        return listViewThreshold;
    }

    public ResolutionStrategy getResolutionStrategy() {
        return this.resolutionStrategy;
    }
    
    public StmProperties setResolutionStrategy(ResolutionStrategy resolutionStrategy) {
        this.resolutionStrategy = resolutionStrategy;
        return this;
    }
    
    public Report getReport() {
        return report;
    }
    
    StmProperties setReport(Report report) {
        this.report = report;
        return this;
    }
}
