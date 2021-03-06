/*
 * @author Eilidh Southren - 1513195
 *
 * This creates the main GUI window of the Radio Scheduling Program
 *
 */
package radioshowGUI;

import radioshowModel.Advert;
import radioshowModel.Content;
import radioshowModel.Music;
import radioshowModel.Schedule;
import radioshowModel.Show;
import radioshowModel.Talk;
import radioshowModel.TimeSlot;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileFilter;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;

public class MainGui extends javax.swing.JFrame {

    private static Schedule schedule;
    // Start GUI
    public MainGui(Schedule s) {
        this.schedule = s;
        initComponents(); 
        timeslotList.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jFileChooser1 = new javax.swing.JFileChooser();
        jScrollPane4 = new javax.swing.JScrollPane();
        timeslotList = new javax.swing.JList<>();
        buttonAddTimeslot = new javax.swing.JButton();
        buttonEditTimeslot = new javax.swing.JButton();
        labelExtraInformation = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        String str = "Select a Show to view Information";
        infoTextBox = new javax.swing.JTextArea(str);
        comboBoxSort = new javax.swing.JComboBox<>();
        labelSortBy = new javax.swing.JLabel();
        buttonAddChangePresenter = new javax.swing.JButton();
        labelTimeslotInfo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        timeslotInfo = new javax.swing.JTextArea();
        labelTitle = new javax.swing.JLabel();
        Show[] showList = schedule.getShows();
        comboBoxSelectShow = new javax.swing.JComboBox(showList);
        labelSelectShow = new javax.swing.JLabel();
        buttonViewAllShows = new javax.swing.JButton();
        labelShowInformation = new javax.swing.JLabel();
        buttonDeleteTimeslot = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuItemOpen = new javax.swing.JMenuItem();
        menuItemSave = new javax.swing.JMenuItem();
        menuItemExit = new javax.swing.JMenuItem();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jFileChooser1.setVisible(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DefaultListModel model = new DefaultListModel();
        model.addElement("Select a Show to Display TimeSlots");
        timeslotList.setModel(model);
        Show s = (Show)comboBoxSelectShow.getSelectedItem();
        updateTimeslotList(s);
        timeslotList.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                timeslotListAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        timeslotList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                timeslotListMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(timeslotList);

        buttonAddTimeslot.setText("Add Timeslot");
        buttonAddTimeslot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddTimeslotActionPerformed(evt);
            }
        });

        buttonEditTimeslot.setText("Edit Timeslot");
        buttonEditTimeslot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditTimeslotActionPerformed(evt);
            }
        });

        labelExtraInformation.setText("Extra Information");

        updateInfoBox(s);
        infoTextBox.setColumns(20);
        infoTextBox.setRows(5);
        jScrollPane3.setViewportView(infoTextBox);

        comboBoxSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Runtime - Ascending" , "Runtime - Descending", "Item Order - Ascending", "Item Order - Descending" }));
        comboBoxSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSortActionPerformed(evt);
            }
        });

        labelSortBy.setText("Sort By:");

        buttonAddChangePresenter.setText("Add/Change Presenter");
        buttonAddChangePresenter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddChangePresenterActionPerformed(evt);
            }
        });

        labelTimeslotInfo.setText("Timeslot Information");

        timeslotInfo.setColumns(20);
        timeslotInfo.setRows(5);
        timeslotInfo.setText("Select a Show to view Timeslot ");
        jScrollPane1.setViewportView(timeslotInfo);

        labelTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelTitle.setText("Radio Ga-Ga Scheduling System");

        comboBoxSelectShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSelectShowActionPerformed(evt);
            }
        });

        labelSelectShow.setText("Select Show:");

        buttonViewAllShows.setText("View All Shows");
        buttonViewAllShows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonViewAllShowsActionPerformed(evt);
            }
        });

        labelShowInformation.setText("Show Information");

        buttonDeleteTimeslot.setText("Delete Timeslot");
        buttonDeleteTimeslot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteTimeslotActionPerformed(evt);
            }
        });

        menuFile.setText("File");
        menuFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFileActionPerformed(evt);
            }
        });

        menuItemOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuItemOpen.setText("Open File");
        menuItemOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemOpenActionPerformed(evt);
            }
        });
        menuFile.add(menuItemOpen);

        menuItemSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuItemSave.setText("Save to File");
        menuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSaveActionPerformed(evt);
            }
        });
        menuFile.add(menuItemSave);

        menuItemExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        menuItemExit.setText("Exit");
        menuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExitActionPerformed(evt);
            }
        });
        menuFile.add(menuItemExit);

        jMenuBar1.add(menuFile);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(labelSelectShow))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(labelSortBy, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboBoxSelectShow, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboBoxSort, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(buttonAddChangePresenter, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                    .addComponent(buttonViewAllShows, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelShowInformation))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTimeslotInfo)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                                .addComponent(labelExtraInformation)
                                .addComponent(jScrollPane3)
                                .addComponent(buttonAddTimeslot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonEditTimeslot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonDeleteTimeslot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(labelTitle)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(labelSelectShow))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxSelectShow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonViewAllShows))))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(labelSortBy))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboBoxSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonAddChangePresenter)))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelShowInformation)
                    .addComponent(labelTimeslotInfo))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(buttonAddTimeslot)
                        .addGap(6, 6, 6)
                        .addComponent(buttonEditTimeslot)
                        .addGap(6, 6, 6)
                        .addComponent(buttonDeleteTimeslot)
                        .addGap(42, 42, 42)
                        .addComponent(labelExtraInformation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Update the main Timeslot list window
    public void updateTimeslotList(Show thisShow) {
        timeslotList.setSelectedIndex(0);
        // Retrieve ArrayList of timeslots from selected show and change to Array
        ArrayList<TimeSlot> ts = thisShow.getItems();
        TimeSlot[] slotList = ts.toArray(new TimeSlot[ts.size()]);
        // Update list with timeslots
        DefaultListModel model = (DefaultListModel)timeslotList.getModel();
        model.removeAllElements();
        for (TimeSlot t : slotList) {
            model.addElement(t);
        }
    }
    // Update single Timeslot Info window
    private void updateTimeSlotInfo(Show thisShow) {
        int index = (int)timeslotList.getSelectedIndex();
        String str = "Select a timeslot to view information";
        try {
        TimeSlot t = thisShow.getTimeSlot(index);
            str = ("Type: \t" + t.getClass().getSimpleName() +"\n\n");
            str += ("Order: \t[" + t.getRunningOrder()+ "]\n");
            str +=  ("Runtime (s): \t" + t.getRuntime()+"\n\n");
            
            if (t instanceof Advert) {
                str += ("Client: \t" + ((Advert) t).getClient()+ "\n");
                str += ("PrimeTime: \t" + ((Advert) t).isPrimetime() + "\n\n");
            }
            if (t instanceof Content) {
                str += ("Description: \t" + ((Content) t).getDescription() + "\n");
                str += ("Internal: \t" + ((Content) t).isInternallyProduced() + "\n\n");
            
                if (t instanceof Talk) {
                    str += ("Guest: \t" + ((Talk) t).getGuest());
                }
            
                if (t instanceof Music) {
                    str += ("Artist: \t" + ((Music) t).getArtist() + "\n");
                    str += ("Title: \t" + ((Music) t).getSongTitle() );
                }
            }
        } catch (ArrayIndexOutOfBoundsException e ) {
            // Only update list if there are timeslots in the list (i.e. if a single-list timeslot is deleted, do nothing)
        }
        timeslotInfo.setText(str);
    }
    
    // Update the 'extra information' textbox with show info
    private void updateInfoBox(Show thisShow) {
    
        String str = thisShow.getName() + "\n\n";
        str += "Presenter: " + thisShow.getPresenter() + "\n";
        str += "Time Remaining: " + thisShow.getTimeRemaining()/60 + ":" + thisShow.getTimeRemaining()%60;
        infoTextBox.setText(str);
    }
    
    // Actions when show selection changes
    private void comboBoxSelectShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSelectShowActionPerformed
        
        Show currentShow = (Show)comboBoxSelectShow.getSelectedItem();
        updateTimeslotList(currentShow);
        updateTimeSlotInfo(currentShow);
        updateInfoBox(currentShow);
        timeslotList.setSelectedIndex(0);
    }//GEN-LAST:event_comboBoxSelectShowActionPerformed

        // Open a .txt File
    private void menuItemOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemOpenActionPerformed
        jFileChooser1.setVisible(true);
        FileFilter filter = new FileNameExtensionFilter("txt File","txt");
        jFileChooser1.setFileFilter(filter);
         // get filepath
        Show thisShow = (Show)comboBoxSelectShow.getSelectedItem();
        if (this.jFileChooser1.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
            thisShow.readFromFile(this.jFileChooser1.getSelectedFile());
            // Update Informmation in GUI screen
            updateTimeslotList(thisShow);
            updateInfoBox(thisShow);
            } catch (InputMismatchException e) {
                JOptionPane.showMessageDialog(this, "Error: Selected file does not match required format.");
            }
        }
    }//GEN-LAST:event_menuItemOpenActionPerformed

    private void menuFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuFileActionPerformed

    private void buttonAddTimeslotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddTimeslotActionPerformed
         // Create default timeslot to populate the 'new timeslot' GUI
         Advert defaultNewTimeslot = new Advert(0,0, "", true);
         Show thisShow = (Show)comboBoxSelectShow.getSelectedItem();
           EditTimeslot edAv = new EditTimeslot(this, true, schedule, thisShow, defaultNewTimeslot);
           edAv.pack();
           edAv.setVisible(true);
           updateTimeslotList(thisShow);
           updateTimeSlotInfo(thisShow);
    }//GEN-LAST:event_buttonAddTimeslotActionPerformed

    private void comboBoxSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSortActionPerformed
        // Sort timeslot list based on seletion
        // 0 : Sort by runtime, ascending
        // 1 : Sort by runtime, descending
        // 2 : Sort by order list, ascending
        // 3 : sort by order list, descending
        Show thisShow = (Show)comboBoxSelectShow.getSelectedItem();
        int sortCombo = comboBoxSort.getSelectedIndex();
        
        switch (sortCombo) {
            case 0 :    thisShow.sortItemsByRuntime();
                        Collections.reverse(thisShow.getItems());
                        updateTimeslotList(thisShow);
                        break;
            case 1 :    thisShow.sortItemsByRuntime();
                        updateTimeslotList(thisShow);
                        break;
            case 2 :    thisShow.sortItemsByOrder();
                        
                        updateTimeslotList(thisShow);
                        break;
            case 3 :    thisShow.sortItemsByOrder();
                        Collections.reverse(thisShow.getItems());
                        updateTimeslotList(thisShow);
                        break;
        }
    }//GEN-LAST:event_comboBoxSortActionPerformed

    private void timeslotListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timeslotListMouseClicked
        // show information about selected Timeslot
        updateTimeSlotInfo((Show)comboBoxSelectShow.getSelectedItem());        
    }//GEN-LAST:event_timeslotListMouseClicked

    private void buttonEditTimeslotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditTimeslotActionPerformed
        Show thisShow = (Show)comboBoxSelectShow.getSelectedItem();
        // open add/edit GUI, if a timeslot has been selected
        try {
            int index = (int)timeslotList.getSelectedIndex();
            TimeSlot t = thisShow.getTimeSlot(index);
            System.out.println("Packing edit timeslot window");
            EditTimeslot edAv = new EditTimeslot(this, true, schedule, thisShow, t);
            edAv.pack();
            edAv.setVisible(true);  
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Error: Select a Timeslot to edit first");
        }
        finally {
            updateTimeslotList(thisShow);
            updateTimeSlotInfo(thisShow);
        }
    }//GEN-LAST:event_buttonEditTimeslotActionPerformed

    private void buttonViewAllShowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonViewAllShowsActionPerformed
        // display information about all shows
        DefaultListModel model = new DefaultListModel();
        
        for (Show s : schedule.getShows()) {
            model.addElement(s.getName());
            model.addElement("Time Remaining in Schedule: " + s.getTimeRemaining()/60 + ":" + s.getTimeRemaining()%60);
            model.addElement("Presenter: " + s.getPresenter().getFullName());
            model.addElement("******");
        }
        timeslotList.setModel(model);
        timeslotInfo.setText("Select a Show to View Timeslot");
    }//GEN-LAST:event_buttonViewAllShowsActionPerformed

    private void menuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSaveActionPerformed
        // Open filechooser dialog with '.txt' filter applied
        jFileChooser1.setSelectedFile(new File("show_name"));
        jFileChooser1.setFileFilter(new FileNameExtensionFilter("txt file","txt"));
        jFileChooser1.setVisible(true);        
        Show thisShow = (Show)comboBoxSelectShow.getSelectedItem();
        if (this.jFileChooser1.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            String withExtension = jFileChooser1.getSelectedFile().getAbsolutePath() + ".txt";
            File f = new File(withExtension);
            thisShow.saveToFile(f);
        }
    }//GEN-LAST:event_menuItemSaveActionPerformed

    // Quit show, with confirmation popup
    private void menuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExitActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Do you want to exit?") == JOptionPane.YES_NO_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_menuItemExitActionPerformed

    private void buttonAddChangePresenterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddChangePresenterActionPerformed
        Show thisShow = (Show)comboBoxSelectShow.getSelectedItem();
  
        AddPresenter test = new AddPresenter(this, true, schedule, thisShow);
        test.pack();
        test.setVisible(true);
               
        updateTimeslotList(thisShow);  
        updateInfoBox(thisShow);
    }//GEN-LAST:event_buttonAddChangePresenterActionPerformed

    private void timeslotListAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_timeslotListAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_timeslotListAncestorAdded

    private void buttonDeleteTimeslotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteTimeslotActionPerformed
       // Delete timeslot, if one is selected
        Show thisShow = (Show)comboBoxSelectShow.getSelectedItem();
        if (timeslotList.getModel().getSize() == 0) {
            JOptionPane.showMessageDialog(this, "Error: Select a Timeslot to delete it");
        }
        else {
            if (JOptionPane.showConfirmDialog(null, "Do you really want to delete this Timeslot?") == JOptionPane.YES_NO_OPTION){
            int index = (int)timeslotList.getSelectedIndex();
            TimeSlot t = thisShow.getTimeSlot(index);
            thisShow.removeTimeSlot(t);
            }
            updateTimeslotList(thisShow);
            updateTimeSlotInfo(thisShow);
            updateInfoBox(thisShow);
        }
            
    }//GEN-LAST:event_buttonDeleteTimeslotActionPerformed
    
    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddChangePresenter;
    private javax.swing.JButton buttonAddTimeslot;
    private javax.swing.JButton buttonDeleteTimeslot;
    private javax.swing.JButton buttonEditTimeslot;
    private javax.swing.JButton buttonViewAllShows;
    private javax.swing.JComboBox<String> comboBoxSelectShow;
    private javax.swing.JComboBox<String> comboBoxSort;
    private javax.swing.JTextArea infoTextBox;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel labelExtraInformation;
    private javax.swing.JLabel labelSelectShow;
    private javax.swing.JLabel labelShowInformation;
    private javax.swing.JLabel labelSortBy;
    private javax.swing.JLabel labelTimeslotInfo;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JMenuItem menuItemOpen;
    private javax.swing.JMenuItem menuItemSave;
    private javax.swing.JTextArea timeslotInfo;
    private javax.swing.JList<String> timeslotList;
    // End of variables declaration//GEN-END:variables
}
