/*
 * Copyright (C) 2013 Aaron Madlon-Kay <aaron@madlon-kay.com>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package org.madlonkay.supertmxmerge.data;

import bmsi.util.Diff;
import org.madlonkay.supertmxmerge.util.DiffUtil;

/**
 *
 * @author Aaron Madlon-Kay <aaron@madlon-kay.com>
 */
public class DiffInfo {
    
    public final Key key;
    public final String sourceLanguage;
    
    public final String targetLanguage;
    public final String tuv1Text;
    public final String tuv2Text;
    
    public final Diff.change diff;
    
    public DiffInfo(Key key, String sourceLanguage,
            String targetLanguage, String tuv1Text, String tuv2Text) {
        this.key = key;
        this.sourceLanguage = sourceLanguage;
        this.targetLanguage = targetLanguage;
        this.tuv1Text = tuv1Text;
        this.tuv2Text = tuv2Text;
        this.diff = DiffUtil.getCharacterDiff(tuv1Text, tuv2Text);
    }
}
