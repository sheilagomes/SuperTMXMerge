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
package org.madlonkay.supertmxmerge.gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JRadioButton;
import org.madlonkay.supertmxmerge.MergeController;
import org.madlonkay.supertmxmerge.data.MergeInfo;
import org.madlonkay.supertmxmerge.util.LocString;

    /**
 *
 * @author Aaron Madlon-Kay <aaron@madlon-kay.com>
 */
public class MergeWindow extends javax.swing.JFrame {

    private List<JRadioButton> leftRadioButtons = new ArrayList<JRadioButton>();
    private List<JRadioButton> rightRadioButtons = new ArrayList<JRadioButton>();
    private List<JRadioButton> centerRadioButtons = new ArrayList<JRadioButton>();
    
    /**
     * Creates new form MergeWindow
     */
    public MergeWindow(MergeController controller) {
        this.controller = controller;
        initComponents();
        
        for (MergeInfo info : controller.getMergeInfos()) {
            addMergeInfo(info);
        }
    }
    
    private void addMergeInfo(MergeInfo info) {
        MergeCell cell = new MergeCell(info);
        leftRadioButtons.add(cell.getLeftButton());
        rightRadioButtons.add(cell.getRightButton());
        centerRadioButtons.add(cell.getCenterButton());
        mergeInfoPanel.add(cell);
    }
    
    private MergeController getController() {
        return controller;
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

        controller = getController();
        unitCountConverter1 = new org.madlonkay.supertmxmerge.gui.UnitCountConverter();
        jPanel2 = new javax.swing.JPanel();
        leftFilename = new javax.swing.JLabel();
        centerFilename = new javax.swing.JLabel();
        rightFilename = new javax.swing.JLabel();
        leftTextUnits = new javax.swing.JLabel();
        centerTextUnits = new javax.swing.JLabel();
        rightTextUnits = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mergeInfoPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(LocString.get("merge_window_title")); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        jPanel2.setLayout(new java.awt.GridLayout(3, 3));

        leftFilename.setText("leftFilename");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, controller, org.jdesktop.beansbinding.ELProperty.create("${leftTmx.fileName}"), leftFilename, org.jdesktop.beansbinding.BeanProperty.create("text"), "leftFileName");
        bindingGroup.addBinding(binding);

        jPanel2.add(leftFilename);

        centerFilename.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        centerFilename.setText("centerFilename");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, controller, org.jdesktop.beansbinding.ELProperty.create("${baseTmx.fileName}"), centerFilename, org.jdesktop.beansbinding.BeanProperty.create("text"), "baseFileName");
        bindingGroup.addBinding(binding);

        jPanel2.add(centerFilename);

        rightFilename.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rightFilename.setText("rightFilename");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, controller, org.jdesktop.beansbinding.ELProperty.create("${rightTmx.fileName}"), rightFilename, org.jdesktop.beansbinding.BeanProperty.create("text"), "rightFileName");
        bindingGroup.addBinding(binding);

        jPanel2.add(rightFilename);

        leftTextUnits.setText("leftTextUnits");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, controller, org.jdesktop.beansbinding.ELProperty.create("${leftTmx.size}"), leftTextUnits, org.jdesktop.beansbinding.BeanProperty.create("text"), "leftFileUnitCount");
        binding.setConverter(unitCountConverter1);
        bindingGroup.addBinding(binding);

        jPanel2.add(leftTextUnits);

        centerTextUnits.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        centerTextUnits.setText("centerTextUnits");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, controller, org.jdesktop.beansbinding.ELProperty.create("${baseTmx.size}"), centerTextUnits, org.jdesktop.beansbinding.BeanProperty.create("text"), "baseFileUnitCount");
        binding.setConverter(unitCountConverter1);
        bindingGroup.addBinding(binding);

        jPanel2.add(centerTextUnits);

        rightTextUnits.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rightTextUnits.setText("rightTextUnits");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, controller, org.jdesktop.beansbinding.ELProperty.create("${rightTmx.size}"), rightTextUnits, org.jdesktop.beansbinding.BeanProperty.create("text"), "rightFileUnitCount");
        binding.setConverter(unitCountConverter1);
        bindingGroup.addBinding(binding);

        jPanel2.add(rightTextUnits);

        jButton1.setText(LocString.get("choose_all_left")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useAllLeft(evt);
            }
        });
        jPanel2.add(jButton1);

        jButton2.setText(LocString.get("choose_all_center")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useAllBase(evt);
            }
        });
        jPanel2.add(jButton2);

        jButton3.setText(LocString.get("choose_all_right")); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useAllRight(evt);
            }
        });
        jPanel2.add(jButton3);

        getContentPane().add(jPanel2, java.awt.BorderLayout.NORTH);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        mergeInfoPanel.setLayout(new javax.swing.BoxLayout(mergeInfoPanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(mergeInfoPanel);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        jPanel1.add(okButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jPanel1.add(cancelButton);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void useAllLeft(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useAllLeft
        for (JRadioButton b : leftRadioButtons) {
            b.setSelected(true);
        }
    }//GEN-LAST:event_useAllLeft

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_okButtonActionPerformed

    private void useAllBase(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useAllBase
        for (JRadioButton b : centerRadioButtons) {
            b.setSelected(true);
        }
    }//GEN-LAST:event_useAllBase

    private void useAllRight(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useAllRight
        for (JRadioButton b : rightRadioButtons) {
            b.setSelected(true);
        }
    }//GEN-LAST:event_useAllRight

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel centerFilename;
    private javax.swing.JLabel centerTextUnits;
    private org.madlonkay.supertmxmerge.MergeController controller;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel leftFilename;
    private javax.swing.JLabel leftTextUnits;
    private javax.swing.JPanel mergeInfoPanel;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel rightFilename;
    private javax.swing.JLabel rightTextUnits;
    private org.madlonkay.supertmxmerge.gui.UnitCountConverter unitCountConverter1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
