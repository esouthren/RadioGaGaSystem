/*
 * Author : Eilidh Southren - 1513195
 *
 * This creates a GUI window to Add or Change a Timeslot
 *
 */
package radioshowGUI;

import javax.swing.JOptionPane;
import radioshowModel.Advert;
import radioshowModel.Content;
import radioshowModel.Music;
import radioshowModel.Schedule;
import radioshowModel.Show;
import radioshowModel.Talk;
import radioshowModel.TimeSlot;

public class EditTimeslot extends javax.swing.JDialog {

    private Schedule schedule;
    private Show show;
    private TimeSlot timeslot;
    
    // Constructor for edit Timeslot - passing values of selected Timeslot
    public EditTimeslot(java.awt.Frame parent, boolean modal, Schedule schedule, Show show, TimeSlot timeslot) {
        super(parent, modal);    
        this.schedule = schedule;
        this.show = show;
        this.timeslot = timeslot;
        initComponents();

        // Initialise text if a timeslot is to be edited
        comboBoxTimeslotType.setSelectedItem(timeslot);
        comboBoxShowList.setSelectedItem(show);
        
        // Change GUI to suit type of Content being created
        // Set text fields to selected Timeslot if it's being edited
        if (timeslot instanceof Content) {
            setForContent();
            textFieldDescription.setText(((Content)timeslot).getDescription());
            if (((Content)timeslot).isInternallyProduced()) {
                primeButtonYes.setSelected(true);
            } else { primeButtonNo.setSelected(true); }
        }
        if (timeslot instanceof Advert ) {
            setForAdvert();
            if (((Advert)timeslot).isPrimetime()) {
                primeButtonYes.setSelected(true);
               } else { primeButtonNo.setSelected(true); }
        }
        if (timeslot instanceof Talk) {
            setForTalk();
            textFieldDescription.setText(((Talk)timeslot).getGuest());
            if (((Talk)timeslot).isInternallyProduced()) {
                primeButtonYes.setSelected(true);
            } else { primeButtonNo.setSelected(true); }            
        }
        if (timeslot instanceof Music) {
            setForMusic();
            textFieldDescription.setText(((Music)timeslot).getArtist());
            textFieldSongTitle.setText(((Music)timeslot).getSongTitle());
        }
    }
    // Methods to change GUI when Timeslot type is changed
    private void setForAdvert() {
    comboBoxTimeslotType.setSelectedItem("Advert");
    jLabelDescription.setText("Client");
    labelBoolean.setText("Prime");
    labelBoolean.setVisible(true);
    primeButtonYes.setVisible(true);
    primeButtonNo.setVisible(true);
    jLabelSongTitle.setVisible(false);
    textFieldSongTitle.setVisible(false);          
    }
    
    private void setForTalk() {
    comboBoxTimeslotType.setSelectedItem("Talk");
    jLabelDescription.setText("Guest");
    textFieldDescription.setVisible(true);
    labelBoolean.setVisible(false);
    primeButtonYes.setVisible(false);
    primeButtonNo.setVisible(false);
    labelBoolean.setText("Internally Produced:");
    labelBoolean.setVisible(false);
    jLabelSongTitle.setVisible(false);
    textFieldSongTitle.setVisible(false);
    jLabelSongTitle.setVisible(false);
    }
    
    private void setForMusic() {
        comboBoxTimeslotType.setSelectedItem("Music");
        jLabelDescription.setText("Artist");
        labelBoolean.setVisible(false);
        primeButtonYes.setVisible(false);
        primeButtonNo.setVisible(false);
        jLabelSongTitle.setVisible(true);
        textFieldSongTitle.setVisible(true);
    }
    
    private void setForContent() {
        comboBoxTimeslotType.setSelectedItem("Content");
        jLabelDescription.setText("Description");
        jLabelSongTitle.setVisible(false);
        textFieldSongTitle.setVisible(false);
        primeButtonYes.setVisible(true);
        primeButtonNo.setVisible(true);
        labelBoolean.setVisible(true);
        labelBoolean.setText("Internally Produced"); 
    }
    
    private void setFormat(String timeslotType) {
        textFieldRunOrder.setText(String.valueOf(timeslot.getRunningOrder()));
        textFieldRunningTime.setText(String.valueOf(timeslot.getRuntime()));
        String initSelection = timeslotType;
        switch (initSelection) {
            case "Advert": setForAdvert();
                textFieldDescription.setText(((Advert)timeslot).getClient());
                break;
            case "Talk": setForTalk();
                textFieldDescription.setText(((Talk)timeslot).getGuest());
                break;
            case "Music": setForMusic();  
                textFieldDescription.setText(((Music)timeslot).getArtist());
                break;
            case "Content" : setForContent();
                textFieldDescription.setText(((Content)timeslot).getDescription());
                break;
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        buttonGroup9 = new javax.swing.ButtonGroup();
        primeCheckButtons = new javax.swing.ButtonGroup();
        jCheckBox1 = new javax.swing.JCheckBox();
        buttonOK = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        labelRunOrder = new javax.swing.JLabel();
        labelRunTime = new javax.swing.JLabel();
        jLabelDescription = new javax.swing.JLabel();
        labelBoolean = new javax.swing.JLabel();
        textFieldRunOrder = new javax.swing.JTextField();
        textFieldRunningTime = new javax.swing.JTextField();
        textFieldDescription = new javax.swing.JTextField();
        primeButtonYes = new javax.swing.JRadioButton();
        primeButtonNo = new javax.swing.JRadioButton();
        labelContentType = new javax.swing.JLabel();
        comboBoxTimeslotType = new javax.swing.JComboBox<>();
        jLabelSongTitle = new javax.swing.JLabel();
        textFieldSongTitle = new javax.swing.JTextField();
        label1 = new javax.swing.JLabel();
        Show[] showList = schedule.getShows();
        comboBoxShowList = new javax.swing.JComboBox(showList);

        primeCheckButtons.add(primeButtonYes);
        primeCheckButtons.add(primeButtonNo);

        jCheckBox1.setText("jCheckBox1");

        setTitle("Add or Edit Timeslot");

        buttonOK.setText("OK");
        buttonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOKActionPerformed(evt);
            }
        });

        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        labelRunOrder.setText("Run Order");

        labelRunTime.setText("Run Time (seconds) ");

        jLabelDescription.setText("Client");

        labelBoolean.setText("Primetime");

        textFieldRunOrder.setText("" + timeslot.getRunningOrder()
        );
        textFieldRunOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldRunOrderActionPerformed(evt);
            }
        });

        textFieldRunningTime.setText("" + timeslot.getRuntime());

        textFieldDescription.setText("");

        primeButtonYes.setText("Yes");
        primeButtonYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                primeButtonYesActionPerformed(evt);
            }
        });

        primeButtonNo.setText("No");
        primeButtonNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                primeButtonNoActionPerformed(evt);
            }
        });

        labelContentType.setText("Content Type");

        comboBoxTimeslotType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Advert", "Music", "Content", "Talk" }));
        comboBoxTimeslotType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTimeslotTypeActionPerformed(evt);
            }
        });

        jLabelSongTitle.setText("Song Title");

        textFieldSongTitle.setText("song_title");

        label1.setText("Show");

        comboBoxShowList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxShowListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonOK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancel)
                        .addGap(0, 256, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelRunOrder)
                            .addComponent(labelRunTime)
                            .addComponent(jLabelDescription)
                            .addComponent(jLabelSongTitle)
                            .addComponent(labelBoolean)
                            .addComponent(labelContentType)
                            .addComponent(label1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(primeButtonYes)
                                .addGap(18, 18, 18)
                                .addComponent(primeButtonNo))
                            .addComponent(textFieldRunOrder, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldRunningTime, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldDescription, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldSongTitle, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxTimeslotType, 0, 228, Short.MAX_VALUE)
                            .addComponent(comboBoxShowList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label1)
                    .addComponent(comboBoxShowList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelContentType)
                    .addComponent(comboBoxTimeslotType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRunOrder)
                    .addComponent(textFieldRunOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRunTime)
                    .addComponent(textFieldRunningTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDescription)
                    .addComponent(textFieldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSongTitle)
                    .addComponent(textFieldSongTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBoolean)
                    .addComponent(primeButtonYes)
                    .addComponent(primeButtonNo))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonOK)
                    .addComponent(buttonCancel))
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        // Close window if 'cancel' is picked
        this.setVisible(false);
    }//GEN-LAST:event_buttonCancelActionPerformed
    
    // Create or Edit Timeslot when 'OK' is clicked
    private void buttonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOKActionPerformed
        int order = Integer.parseInt(textFieldRunOrder.getText());
        int time = Integer.parseInt(textFieldRunningTime.getText());
        if (textFieldRunningTime.getText().equals("") || textFieldRunOrder.getText().equals("") || textFieldDescription.getText().equals("") || textFieldSongTitle.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Error: Fields must have values");
        }
        else if ((time < 0) || (order < 0)) {
                JOptionPane.showMessageDialog(this, "Error: Run Time and Run Order Must be a positive integer");
            }
        
        else {
            try {
                // Initialise variables that are common to all Timeslot types
                String selection = (String)comboBoxTimeslotType.getSelectedItem();
                
                boolean state = true;
                if (primeButtonNo.isSelected()) { state = false; }

                // Delete selected timeslot and create new
                show.removeTimeSlot(timeslot);

                show = (Show)comboBoxShowList.getSelectedItem();
                switch (selection) {
                    case "Advert" :
                        show.addTimeSlot(new Advert(order, time, textFieldDescription.getText(), state ));                    
                        break;
                    case "Content" :
                        show.addTimeSlot(new Content(order, time, textFieldDescription.getText(), false));
                        break;
                    case "Music" :
                        show.addTimeSlot(new Music(order, time, textFieldDescription.getText(), textFieldSongTitle.getText()));
                        break;
                    case "Talk" :
                        show.addTimeSlot(new Talk(order, time, textFieldDescription.getText()));
                        break;
                }
                // Close window
                this.setVisible(false);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error: Run Order and Run Time must be integer values");   
            }
        }
    }//GEN-LAST:event_buttonOKActionPerformed

    private void primeButtonYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_primeButtonYesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_primeButtonYesActionPerformed

    private void primeButtonNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_primeButtonNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_primeButtonNoActionPerformed

    private void textFieldRunOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldRunOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldRunOrderActionPerformed

    private void comboBoxTimeslotTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTimeslotTypeActionPerformed
        String selection = (String)comboBoxTimeslotType.getSelectedItem();
        switch (selection) {
            case "Talk" : setForTalk();
            break;
            case "Content" : setForContent();
            break;
            case "Music" : setForMusic();
            break;
            case "Advert" : setForAdvert();
            break;                   
        }       
    }//GEN-LAST:event_comboBoxTimeslotTypeActionPerformed

    private void comboBoxShowListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxShowListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxShowListActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    private javax.swing.JButton buttonOK;
    private javax.swing.JComboBox<String> comboBoxShowList;
    private javax.swing.JComboBox<String> comboBoxTimeslotType;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabelDescription;
    private javax.swing.JLabel jLabelSongTitle;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel labelBoolean;
    private javax.swing.JLabel labelContentType;
    private javax.swing.JLabel labelRunOrder;
    private javax.swing.JLabel labelRunTime;
    private javax.swing.JRadioButton primeButtonNo;
    private javax.swing.JRadioButton primeButtonYes;
    private javax.swing.ButtonGroup primeCheckButtons;
    private javax.swing.JTextField textFieldDescription;
    private javax.swing.JTextField textFieldRunOrder;
    private javax.swing.JTextField textFieldRunningTime;
    private javax.swing.JTextField textFieldSongTitle;
    // End of variables declaration//GEN-END:variables

}
