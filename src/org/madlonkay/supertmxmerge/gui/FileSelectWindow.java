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

import java.awt.Component;
import java.io.File;
import java.util.Enumeration;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.TransferHandler;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.madlonkay.supertmxmerge.util.GuiUtil;
import org.madlonkay.supertmxmerge.util.LocString;

/**
 *
 * @author Aaron Madlon-Kay <aaron@madlon-kay.com>
 */
public class FileSelectWindow extends javax.swing.JFrame implements IDropCallback {
    
    private final static Logger LOGGER = Logger.getLogger(FileSelectWindow.class.getName());
    
    private final static FileNameExtensionFilter FILTER_TMX = 
            new FileNameExtensionFilter(LocString.get("tmx_file_type_label"), "tmx");
    
    /**
     * Creates new form FileSelectWindow
     */
    public FileSelectWindow() {
        initComponents();
        TransferHandler th = new FileDropHandler(this);
        file1Field.setTransferHandler(th);
        file2Field.setTransferHandler(th);
        leftFileField.setTransferHandler(th);
        rightFileField.setTransferHandler(th);
        baseFileField.setTransferHandler(th);
        combineList.setTransferHandler(th);
        
        if (GuiUtil.isOSX()) {
            setJMenuBar(new MenuBar());
        }
    }
    
    @Override
    public void droppedToTarget(Component component) {
        if (component == combineList) {
            DefaultListModel model = (DefaultListModel) combineList.getModel();
            combineIOController.setFiles((Enumeration<File>)model.elements());
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        singleFileChooser = new javax.swing.JFileChooser();
        fileStringConverter = new org.madlonkay.supertmxmerge.gui.FileStringConverter();
        diffIOController = new org.madlonkay.supertmxmerge.DiffIOController();
        mergeIOController = new org.madlonkay.supertmxmerge.MergeIOController();
        combineIOController = new org.madlonkay.supertmxmerge.CombineIOController();
        multiFileChooser = new javax.swing.JFileChooser();
        diffMergeTabbedPane = new javax.swing.JTabbedPane();
        diffPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        file1Button = new javax.swing.JButton();
        file2Button = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        file1Field = new javax.swing.JTextField();
        file2Field = new javax.swing.JTextField();
        diffButtonPanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        diffOkButton = new javax.swing.JButton();
        diffCancelButton = new javax.swing.JButton();
        mergePanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        baseFileButton = new javax.swing.JButton();
        leftFileButton = new javax.swing.JButton();
        rightFileButton = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        baseFileField = new javax.swing.JTextField();
        leftFileField = new javax.swing.JTextField();
        rightFileField = new javax.swing.JTextField();
        mergeButtonPanel = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        mergeOkButton = new javax.swing.JButton();
        mergeCancelButton = new javax.swing.JButton();
        combinePanel = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        addRemoveButtonPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        combineList = new javax.swing.JList();
        combineButtonPanel = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        combineOkButton = new javax.swing.JButton();
        combineCancelButton = new javax.swing.JButton();

        singleFileChooser.setFileFilter(FILTER_TMX);

        multiFileChooser.setFileFilter(FILTER_TMX);
        multiFileChooser.setMultiSelectionEnabled(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(LocString.get("file_select_window_title")); // NOI18N
        setLocationByPlatform(true);
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        diffPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        diffPanel.setLayout(new javax.swing.BoxLayout(diffPanel, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel1.setLayout(new java.awt.BorderLayout(0, 2));

        jPanel3.setLayout(new java.awt.GridLayout(0, 1));

        file1Button.setText(LocString.get("select_button_file1")); // NOI18N
        file1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                file1ButtonActionPerformed(evt);
            }
        });
        jPanel3.add(file1Button);

        file2Button.setText(LocString.get("select_button_file2")); // NOI18N
        file2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                file2ButtonActionPerformed(evt);
            }
        });
        jPanel3.add(file2Button);

        jPanel1.add(jPanel3, java.awt.BorderLayout.WEST);

        jPanel4.setLayout(new java.awt.GridLayout(0, 1, 0, 1));

        file1Field.setColumns(45);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, diffIOController, org.jdesktop.beansbinding.ELProperty.create("${file1}"), file1Field, org.jdesktop.beansbinding.BeanProperty.create("text"), "diffFile1");
        binding.setConverter(fileStringConverter);
        bindingGroup.addBinding(binding);

        jPanel4.add(file1Field);

        file2Field.setColumns(45);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, diffIOController, org.jdesktop.beansbinding.ELProperty.create("${file2}"), file2Field, org.jdesktop.beansbinding.BeanProperty.create("text"), "diffFile2");
        binding.setConverter(fileStringConverter);
        bindingGroup.addBinding(binding);

        jPanel4.add(file2Field);

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel1);

        diffPanel.add(jPanel2);

        diffButtonPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        diffButtonPanel.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        diffOkButton.setText(LocString.get("ok_button")); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, diffIOController, org.jdesktop.beansbinding.ELProperty.create("${inputIsValid}"), diffOkButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"), "diffOkButton");
        bindingGroup.addBinding(binding);

        diffOkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diffOkButtonActionPerformed(evt);
            }
        });
        jPanel5.add(diffOkButton);

        diffCancelButton.setText(LocString.get("cancel_button")); // NOI18N
        diffCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jPanel5.add(diffCancelButton);

        diffButtonPanel.add(jPanel5, java.awt.BorderLayout.EAST);

        diffPanel.add(diffButtonPanel);

        diffMergeTabbedPane.addTab(LocString.get("file_select_diff_tab"), diffPanel); // NOI18N

        mergePanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        mergePanel.setLayout(new javax.swing.BoxLayout(mergePanel, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel7.setLayout(new java.awt.GridLayout(0, 1));

        baseFileButton.setText(LocString.get("select_button_base_file")); // NOI18N
        baseFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baseFileButtonActionPerformed(evt);
            }
        });
        jPanel7.add(baseFileButton);

        leftFileButton.setText(LocString.get("select_button_left_file")); // NOI18N
        leftFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftFileButtonActionPerformed(evt);
            }
        });
        jPanel7.add(leftFileButton);

        rightFileButton.setText(LocString.get("select_button_right_file")); // NOI18N
        rightFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightFileButtonActionPerformed(evt);
            }
        });
        jPanel7.add(rightFileButton);

        jPanel6.add(jPanel7, java.awt.BorderLayout.WEST);

        jPanel8.setLayout(new java.awt.GridLayout(0, 1, 0, 1));

        baseFileField.setColumns(20);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, mergeIOController, org.jdesktop.beansbinding.ELProperty.create("${baseFile}"), baseFileField, org.jdesktop.beansbinding.BeanProperty.create("text"), "mergeBaseFile");
        binding.setConverter(fileStringConverter);
        bindingGroup.addBinding(binding);

        jPanel8.add(baseFileField);

        leftFileField.setColumns(20);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, mergeIOController, org.jdesktop.beansbinding.ELProperty.create("${file1}"), leftFileField, org.jdesktop.beansbinding.BeanProperty.create("text"), "mergeFile1");
        binding.setConverter(fileStringConverter);
        bindingGroup.addBinding(binding);

        jPanel8.add(leftFileField);

        rightFileField.setColumns(20);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, mergeIOController, org.jdesktop.beansbinding.ELProperty.create("${file2}"), rightFileField, org.jdesktop.beansbinding.BeanProperty.create("text"), "mergeFile2");
        binding.setConverter(fileStringConverter);
        bindingGroup.addBinding(binding);

        jPanel8.add(rightFileField);

        jPanel6.add(jPanel8, java.awt.BorderLayout.CENTER);

        mergePanel.add(jPanel6);

        mergeButtonPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        mergeButtonPanel.setLayout(new java.awt.BorderLayout());

        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.LINE_AXIS));

        mergeOkButton.setText(LocString.get("ok_button")); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, mergeIOController, org.jdesktop.beansbinding.ELProperty.create("${inputIsValid}"), mergeOkButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        mergeOkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mergeOkButtonActionPerformed(evt);
            }
        });
        jPanel10.add(mergeOkButton);

        mergeCancelButton.setText(LocString.get("cancel_button")); // NOI18N
        mergeCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jPanel10.add(mergeCancelButton);

        mergeButtonPanel.add(jPanel10, java.awt.BorderLayout.EAST);

        mergePanel.add(mergeButtonPanel);

        diffMergeTabbedPane.addTab(LocString.get("file_select_merge_tab"), mergePanel); // NOI18N

        combinePanel.setLayout(new javax.swing.BoxLayout(combinePanel, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 0, 0, 4));
        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));

        addRemoveButtonPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        addRemoveButtonPanel.setLayout(new javax.swing.BoxLayout(addRemoveButtonPanel, javax.swing.BoxLayout.PAGE_AXIS));

        addButton.setText(LocString.get("add_button")); // NOI18N
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        addRemoveButtonPanel.add(addButton);

        removeButton.setText(LocString.get("remove_button")); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, combineList, org.jdesktop.beansbinding.ELProperty.create("${not empty selectedElements}"), removeButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"), "listHasSelection");
        bindingGroup.addBinding(binding);

        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });
        addRemoveButtonPanel.add(removeButton);

        jPanel9.add(addRemoveButtonPanel);

        combineList.setModel(new DefaultListModel());
        combineList.setVisibleRowCount(4);
        jScrollPane1.setViewportView(combineList);

        jPanel9.add(jScrollPane1);

        combinePanel.add(jPanel9);

        combineButtonPanel.setLayout(new java.awt.BorderLayout());

        jPanel13.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        jPanel13.setLayout(new javax.swing.BoxLayout(jPanel13, javax.swing.BoxLayout.LINE_AXIS));

        combineOkButton.setText(LocString.get("ok_button")); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, combineIOController, org.jdesktop.beansbinding.ELProperty.create("${inputIsValid}"), combineOkButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        combineOkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combineOkButtonActionPerformed(evt);
            }
        });
        jPanel13.add(combineOkButton);

        combineCancelButton.setText(LocString.get("cancel_button")); // NOI18N
        combineCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jPanel13.add(combineCancelButton);

        combineButtonPanel.add(jPanel13, java.awt.BorderLayout.EAST);

        combinePanel.add(combineButtonPanel);

        diffMergeTabbedPane.addTab(LocString.get("combine_button"), combinePanel); // NOI18N

        getContentPane().add(diffMergeTabbedPane);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void file1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_file1ButtonActionPerformed
        if (singleFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            diffIOController.setFile1(singleFileChooser.getSelectedFile());
        }
    }//GEN-LAST:event_file1ButtonActionPerformed

    private void file2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_file2ButtonActionPerformed
        if (singleFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            diffIOController.setFile2(singleFileChooser.getSelectedFile());
        }
    }//GEN-LAST:event_file2ButtonActionPerformed

    private void baseFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baseFileButtonActionPerformed
        if (singleFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            mergeIOController.setBaseFile(singleFileChooser.getSelectedFile());
        }
    }//GEN-LAST:event_baseFileButtonActionPerformed

    private void leftFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftFileButtonActionPerformed
        if (singleFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            mergeIOController.setFile1(singleFileChooser.getSelectedFile());
        }
    }//GEN-LAST:event_leftFileButtonActionPerformed

    private void rightFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightFileButtonActionPerformed
        if (singleFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            mergeIOController.setFile2(singleFileChooser.getSelectedFile());
        }
    }//GEN-LAST:event_rightFileButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void diffOkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diffOkButtonActionPerformed
        dispose();
        GuiUtil.safelyRunBlockingRoutine(new Runnable() {
            @Override
            public void run() {
                diffIOController.go();
            }
        });
    }//GEN-LAST:event_diffOkButtonActionPerformed

    private void mergeOkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mergeOkButtonActionPerformed
        dispose();
        GuiUtil.safelyRunBlockingRoutine(new Runnable() {
            @Override
            public void run() {
                mergeIOController.go();
            }
        });
    }//GEN-LAST:event_mergeOkButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        DefaultListModel model = (DefaultListModel) combineList.getModel();
        if (multiFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            for (File file : multiFileChooser.getSelectedFiles()) {
                if (!model.contains(file)) {
                    model.addElement(file);
                }
            }
        }
        combineIOController.setFiles((Enumeration<File>)model.elements());
    }//GEN-LAST:event_addButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        DefaultListModel model = (DefaultListModel) combineList.getModel();
        Object[] toRemove = combineList.getSelectedValues();
        if (toRemove.length == 0) {
            return;
        }
        for (Object o : toRemove) {
            model.removeElement(o);
        }
        combineIOController.setFiles((Enumeration<File>)model.elements());
    }//GEN-LAST:event_removeButtonActionPerformed

    private void combineOkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combineOkButtonActionPerformed
        dispose();
        GuiUtil.safelyRunBlockingRoutine(new Runnable() {
            @Override
            public void run() {
                combineIOController.go();
            }
        });
    }//GEN-LAST:event_combineOkButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JPanel addRemoveButtonPanel;
    private javax.swing.JButton baseFileButton;
    private javax.swing.JTextField baseFileField;
    private javax.swing.JPanel combineButtonPanel;
    private javax.swing.JButton combineCancelButton;
    private org.madlonkay.supertmxmerge.CombineIOController combineIOController;
    private javax.swing.JList combineList;
    private javax.swing.JButton combineOkButton;
    private javax.swing.JPanel combinePanel;
    private javax.swing.JPanel diffButtonPanel;
    private javax.swing.JButton diffCancelButton;
    private org.madlonkay.supertmxmerge.DiffIOController diffIOController;
    private javax.swing.JTabbedPane diffMergeTabbedPane;
    private javax.swing.JButton diffOkButton;
    private javax.swing.JPanel diffPanel;
    private javax.swing.JButton file1Button;
    private javax.swing.JTextField file1Field;
    private javax.swing.JButton file2Button;
    private javax.swing.JTextField file2Field;
    private org.madlonkay.supertmxmerge.gui.FileStringConverter fileStringConverter;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton leftFileButton;
    private javax.swing.JTextField leftFileField;
    private javax.swing.JPanel mergeButtonPanel;
    private javax.swing.JButton mergeCancelButton;
    private org.madlonkay.supertmxmerge.MergeIOController mergeIOController;
    private javax.swing.JButton mergeOkButton;
    private javax.swing.JPanel mergePanel;
    private javax.swing.JFileChooser multiFileChooser;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton rightFileButton;
    private javax.swing.JTextField rightFileField;
    private javax.swing.JFileChooser singleFileChooser;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
