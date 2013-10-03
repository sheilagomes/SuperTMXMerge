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
package org.madlonkay.supertmxmerge;

import gen.core.tmx14.Tuv;
import java.beans.*;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.bind.UnmarshalException;
import org.madlonkay.supertmxmerge.data.DiffInfo;
import org.madlonkay.supertmxmerge.data.DiffSet;
import org.madlonkay.supertmxmerge.data.Key;
import org.madlonkay.supertmxmerge.data.TmxFile;
import org.madlonkay.supertmxmerge.gui.DiffWindow;
import org.madlonkay.supertmxmerge.util.DiffUtil;
import org.madlonkay.supertmxmerge.util.FileUtil;
import org.madlonkay.supertmxmerge.util.GuiUtil;
import org.madlonkay.supertmxmerge.util.LocString;
import org.madlonkay.supertmxmerge.util.TuvUtil;

/**
 *
 * @author Aaron Madlon-Kay <aaron@madlon-kay.com>
 */
public class DiffController implements Serializable, IController {
    
    public static final String PROP_FILE1 = "file1";
    public static final String PROP_FILE2 = "file2";
    public static final String PROP_TMX1 = "tmx1";
    public static final String PROP_TMX2 = "tmx2";
    public static final String PROP_CHANGECOUNT = "changeCount";

    private File file1;
    private File file2;
    private TmxFile tmx1;
    private TmxFile tmx2;
    
    private List<DiffInfo> diffInfos;
    
    private PropertyChangeSupport propertySupport;
    
    public DiffController() {
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
    
    public File getFile1() {
        return file1;
    }

    public void setFile1(File file1) {
        File oldFile1 = this.file1;
        this.file1 = file1;
        propertySupport.firePropertyChange(PROP_FILE1, oldFile1, file1);
        propertySupport.firePropertyChange(PROP_INPUTISVALID, null, null);
    }
    
    public File getFile2() {
        return file2;
    }

    public void setFile2(File file2) {
        File oldFile2 = this.file2;
        this.file2 = file2;
        propertySupport.firePropertyChange(PROP_FILE2, oldFile2, file2);
        propertySupport.firePropertyChange(PROP_INPUTISVALID, null, null);
    }
    
    public TmxFile getTmx1() {
        return tmx1;
    }
    
    public void setTmx1(TmxFile tmx1) {
        TmxFile oldTmx1 = this.tmx1;
        this.tmx1 = tmx1;
        propertySupport.firePropertyChange(PROP_TMX1, oldTmx1, tmx1);
    }
    
    public TmxFile getTmx2() {
        return tmx2;
    }
    
    public void setTmx2(TmxFile tmx2) {
        TmxFile oldTmx2 = this.tmx2;
        this.tmx2 = tmx2;
        propertySupport.firePropertyChange(PROP_TMX2, oldTmx2, tmx2);
    }
    
    @Override
    public void go(boolean block) {
        try {
            setTmx1(new TmxFile(getFile1()));
            setTmx2(new TmxFile(getFile2()));
        } catch (UnmarshalException ex) {
            Logger.getLogger(MergeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        generateDiffData();
        
        if (diffInfos.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                        LocString.get("identical_files_message"),
                        LocString.get("diff_window_title"),
                        JOptionPane.INFORMATION_MESSAGE);
        } else {
            DiffWindow window = new DiffWindow(this);
            GuiUtil.displayWindow(window);
            if (block) {
                GuiUtil.blockOnWindow(window);
            }
        }
    }

    @Override
    public boolean getInputIsValid() {
        return FileUtil.validateFile(getFile1()) 
                && FileUtil.validateFile(getFile2()) && !getFile1().equals(getFile2());
    }
    
    public List<DiffInfo> getDiffInfos() {
        if (diffInfos == null) {
            generateDiffData();
        }
        return diffInfos;
    }
    
    private void generateDiffData() {
        
        diffInfos = new ArrayList<DiffInfo>();
        
        DiffSet set = DiffUtil.generateDiffSet(getTmx1(), getTmx2());
        
        for (Key key : set.deleted) {
            Tuv tuv = getTmx1().getTuvMap().get(key);
            diffInfos.add(new DiffInfo(key, getTmx1().getSourceLanguage(),
                    TuvUtil.getLanguage(tuv), TuvUtil.getContent(tuv), null));
        }
        for (Key key : set.added) {
            Tuv tuv = getTmx2().getTuvMap().get(key);
            diffInfos.add(new DiffInfo(key, getTmx2().getSourceLanguage(),
                    TuvUtil.getLanguage(tuv), null, TuvUtil.getContent(tuv)));
        }
        for (Key key : set.modified) {
            Tuv tuv1 = getTmx1().getTuvMap().get(key);
            Tuv tuv2 = getTmx2().getTuvMap().get(key);
            diffInfos.add(new DiffInfo(key, getTmx1().getSourceLanguage(),
                    TuvUtil.getLanguage(tuv1), TuvUtil.getContent(tuv1), TuvUtil.getContent(tuv2)));
        }
        propertySupport.firePropertyChange(PROP_CHANGECOUNT, null, null);
    }

    /**
     * @return the changeCount
     */
    public int getChangeCount() {
        return diffInfos.size();
    }
}
