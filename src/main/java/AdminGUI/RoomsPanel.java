/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package AdminGUI;

import Objects.Room.RoomType;
import Objects.RoomControl;
import Objects.Room;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import Objects.BookingControl;
import org.joda.time.DateTime;

import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author mamu8
 */
public class RoomsPanel extends javax.swing.JPanel {

        /**
         * Creates new form RoomsPanel
         */

        public RoomsPanel() {
                initComponents();
        }

        public void setAppControlButtons(javax.swing.JFrame frame, int xBorder) {
                appControlButtons1.setAppControl(frame, appControlButtons1.getX() + xBorder, appControlButtons1.getY());
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roomsPanel = new javax.swing.JPanel();
        roomNrLabel = new javax.swing.JLabel();
        roomNrTxtField = new javax.swing.JTextField();
        titleTxt = new javax.swing.JLabel();
        roomTypeLabel = new javax.swing.JLabel();
        roomTypeTxtField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomTable = new javax.swing.JTable();
        appControlButtons1 = new DesignObjects.AppControlButtons();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jDateOfCheckInChooser = new com.toedter.calendar.JDateChooser();
        jDateOfCheckOutChooser = new com.toedter.calendar.JDateChooser();
        checkInLabel = new javax.swing.JLabel();
        checkOutLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        roomsPanel.setBackground(new java.awt.Color(255, 255, 255));
        roomsPanel.setPreferredSize(new java.awt.Dimension(738, 546));

        roomNrLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        roomNrLabel.setForeground(new java.awt.Color(0, 0, 255));
        roomNrLabel.setText("Room number");

        roomNrTxtField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        roomNrTxtField.setForeground(new java.awt.Color(0, 153, 153));
        roomNrTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomNrTxtFieldActionPerformed(evt);
            }
        });

        titleTxt.setBackground(new java.awt.Color(255, 255, 255));
        titleTxt.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        titleTxt.setForeground(new java.awt.Color(0, 51, 153));
        titleTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleTxt.setText("SEARCH ROOMS");

        roomTypeLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        roomTypeLabel.setForeground(new java.awt.Color(0, 0, 255));
        roomTypeLabel.setText("Room type");

        roomTypeTxtField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        roomTypeTxtField.setForeground(new java.awt.Color(0, 153, 153));
        roomTypeTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomTypeTxtFieldActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(null);

        roomTable.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        roomTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Room Type", "Capacity", "Price", "Availibility"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        roomTable.setGridColor(new java.awt.Color(255, 255, 255));
        roomTable.setRowHeight(25);
        roomTable.setShowHorizontalLines(true);
        roomTable.setShowVerticalLines(true);
        roomTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(roomTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel1.setText("Search rooms availibilty by entering first the dates and then ROOM NUMBER or ROOM TYPE");

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("\tRoom numbers: \t\tCapacity:\t                Enter one of the following room types: \n\tFrom 100 to 115\t\tSINGLE\t  \t           STANDARD\n\tFrom 116 to 125\t\tDOUBLE\t\t           STANDARD 2\n\tFrom 200 to 215\t\tSINGLE\t\t               DELUXE\n\tFrom 216 to 225\t\tDOUBLE\t\t              DELUXE 2\n\tFrom 300 to 325\t\tSINGLE\t\t                  KING");
        jTextArea1.setBorder(null);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel3.setText("After searching for the room, click on the table's row to proceed with the booking.");

        checkInLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        checkInLabel.setForeground(new java.awt.Color(0, 0, 255));
        checkInLabel.setText("Date of Check-In");

        checkOutLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        checkOutLabel.setForeground(new java.awt.Color(0, 0, 255));
        checkOutLabel.setText("Date of Check-Out");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info.png"))); // NOI18N

        javax.swing.GroupLayout roomsPanelLayout = new javax.swing.GroupLayout(roomsPanel);
        roomsPanel.setLayout(roomsPanelLayout);
        roomsPanelLayout.setHorizontalGroup(
            roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomsPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roomsPanelLayout.createSequentialGroup()
                        .addGroup(roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(roomsPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(titleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(150, 150, 150)
                                .addComponent(appControlButtons1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roomsPanelLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 8, Short.MAX_VALUE)))
                        .addContainerGap(19, Short.MAX_VALUE))
                    .addGroup(roomsPanelLayout.createSequentialGroup()
                        .addGroup(roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(roomsPanelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(roomsPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roomsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roomsPanelLayout.createSequentialGroup()
                        .addComponent(checkInLabel)
                        .addGap(18, 18, 18)
                        .addComponent(jDateOfCheckInChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roomsPanelLayout.createSequentialGroup()
                        .addComponent(checkOutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateOfCheckOutChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(64, 64, 64)
                .addGroup(roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(roomNrLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roomNrTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roomTypeTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roomTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );
        roomsPanelLayout.setVerticalGroup(
            roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roomsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(appControlButtons1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleTxt))
                .addGap(18, 18, 18)
                .addGroup(roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roomsPanelLayout.createSequentialGroup()
                        .addGroup(roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roomsPanelLayout.createSequentialGroup()
                                .addComponent(roomTypeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(roomTypeTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(roomsPanelLayout.createSequentialGroup()
                                .addComponent(roomNrLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(roomNrTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6))
                    .addGroup(roomsPanelLayout.createSequentialGroup()
                        .addGroup(roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jDateOfCheckInChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(checkInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateOfCheckOutChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkOutLabel))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 738, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(roomsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 546, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(roomsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    /*
     * roomNrTxtFieldActionPerformed method is an event handler triggered when the
     * user performs an action on the roomNrTxtField. It is responsible for searching
     * and displaying room information based on the entered room number and dates.
     */
    private void roomNrTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_roomNrTxtFieldActionPerformed
        RoomControl.pullData();
        BookingControl.pullData();

        // Check if any of the required fields are empty
        if (roomNrTxtField.getText().isEmpty()
                || jDateOfCheckInChooser.getDate() == null
                || jDateOfCheckOutChooser.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Please fill in all the required fields.");
            return;
        }

        boolean isCheckInValidated = true;
        boolean isCheckOutValidated = true;
        Date checkInDate = jDateOfCheckInChooser.getDate();
        Date checkOutDate = jDateOfCheckOutChooser.getDate();

        // Validate check-in and check-out dates
        Date currentDate = new Date();

        // Check-in date cannot be earlier than today
        if (checkInDate.before(currentDate) && !isSameDay(checkInDate, currentDate)) {
            JOptionPane.showMessageDialog(this, "Check-in date cannot be earlier than today.",
                    "Invalid Check-in Date",
                    JOptionPane.WARNING_MESSAGE);
            isCheckInValidated = false;
            return;
        }

        // Check-out date must be after the check-in date and not the same day
        if (checkOutDate.before(checkInDate) || isSameDay(checkInDate, checkOutDate)) {
            JOptionPane.showMessageDialog(this, "Check-out date must be after the check-in date and not the same day.",
                    "Invalid Check-out Date", JOptionPane.WARNING_MESSAGE);
            isCheckOutValidated = false;
            return;
        }

        /*
         * Parses the room number from the text field, retrieves the corresponding room
         * using roomControl.getRoomById(roomNr), and updates the roomTable with
         * the room details if a match is found.
         */
        try {
            int roomNr = Integer.parseInt(roomNrTxtField.getText());
            Room roomById = RoomControl.getRoomById(roomNr);

            if (roomById == null) {
                JOptionPane.showMessageDialog(this, "No room found with ID " + roomNr, "Room Not Found",
                        JOptionPane.WARNING_MESSAGE);
                roomNrTxtField.setText("");
                return;
            }

            initRoomTableById(roomById); // Initialize the table for that room
            // clear the textfields
            roomTypeTxtField.setText("");
            roomNrTxtField.setText("");
        } catch (NumberFormatException ex) {
            // If the room number is not a valid integer, a NumberFormatException is caught,
            // and an error message is displayed to the user.
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid room number.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            roomNrTxtField.setText("");
        }
    }// GEN-LAST:event_roomNrTxtFieldActionPerformed

    // Another event handler but this time for the roomTypeTxtField text field
    private void roomTypeTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_roomTypeTxtFieldActionPerformed
        RoomControl.pullData();
        BookingControl.pullData();

        // Check if any of the required fields are empty
        if (roomTypeTxtField.getText().isEmpty()
                || jDateOfCheckInChooser.getDate() == null
                || jDateOfCheckOutChooser.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Please fill in all the required fields.");
            return;
        }

        boolean isCheckInValidated = true;
        boolean isCheckOutValidated = true;
        Date checkInDate = jDateOfCheckInChooser.getDate();
        Date checkOutDate = jDateOfCheckOutChooser.getDate();

        // Validate check-in and check-out dates
        Date currentDate = new Date();

        // Check-in date cannot be earlier than today
        if (checkInDate.before(currentDate) && !isSameDay(checkInDate, currentDate)) {
            JOptionPane.showMessageDialog(this, "Check-in date cannot be earlier than today.",
                    "Invalid Check-in Date",
                    JOptionPane.WARNING_MESSAGE);
            isCheckInValidated = false;
            return;
        }

        // Check-out date must be after the check-in date and not the same day
        if (checkOutDate.before(checkInDate) || isSameDay(checkInDate, checkOutDate)) {
            JOptionPane.showMessageDialog(this, "Check-out date must be after the check-in date and not the same day.",
                    "Invalid Check-out Date", JOptionPane.WARNING_MESSAGE);
            isCheckOutValidated = false;
            return;
        }

        String userInput = roomTypeTxtField.getText().toLowerCase();
        // Regular expression pattern roomTypePattern that represents valid room types
        String roomTypePattern = "(standard|deluxe|king)\\s*(\\d*)";
        /*
         * This regular expression pattern will match any of the following variations:
         *
         * standard
         * deluxe
         * king
         * standard 2
         * deluxe 2
         * king 2
         * where the number after the room type represents the capacity.
         */

        // If the input matches the pattern, extract the room type and capacity
        Pattern pattern = Pattern.compile(roomTypePattern);
        Matcher matcher = pattern.matcher(userInput);

        if (matcher.matches()) {
            String roomTypeString = matcher.group(1);
            String capacityString = matcher.group(2);
            RoomType roomType = null;
            int capacity = -1;

            switch (roomTypeString) {
                case "standard":
                    roomType = RoomType.STANDARD;
                    break;
                case "deluxe":
                    roomType = RoomType.DELUXE;
                    break;
                case "king":
                    roomType = RoomType.KING;
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Invalid room type entered. Please try again.");
                    roomTypeTxtField.setText("");
                    roomNrTxtField.setText("");
                    return; // Exit the method if the room type is not valid
            }

            // If a capacity is specified, parse it as an integer
            if (!capacityString.isEmpty()) {
                capacity = Integer.parseInt(capacityString);
            }

            // Validate the capacity
            if (capacity < 1) {
                capacity = 1;
            }
            if (capacity > 2) {
                capacity = 2;
            }

            // Retrieves a list of rooms that match the specified room type and capacity
            ArrayList<Room> roomsByType = RoomControl.getRoomsByTypeCapacity(roomType, capacity);

            initRoomTableByType(roomsByType);

            roomTypeTxtField.setText("");
            roomNrTxtField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid room type entered. Please try again.");
            roomTypeTxtField.setText("");
            roomNrTxtField.setText("");
        }
    }// GEN-LAST:event_roomTypeTxtFieldActionPerformed

    //Event handler when the user clicks on a row in the roomTable and wants to proceed with the booking of that room
    private void roomTableMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_roomTableMouseClicked
        // Retrieves the index of the selected row
        int selectedRow = roomTable.getSelectedRow();

        // If no row is selected , the method returns and nothing happens
        if (selectedRow == -1) {
            return;
        }
        // Otherwise retrieves the room ID from the selected row
        int roomID = (int) roomTable.getValueAt(selectedRow, 0);

        // Retrieves the value of the "Available" column from the selected row ()check
        // if room available or not
        if (roomTable.getValueAt(selectedRow, 4) == "No") {
            JOptionPane.showMessageDialog(this, "Room " + roomID + " is already booked.");
            return;
        }

        int dialogResult = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to proceed with the booking of room nr. " + roomID + "?",
                "Confirm selected room", JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION) {
            /*
             * Couldn't modify the constructor of the RoomPanel class to pass
             * the instance of AdminFrame, so used
             * SwingUtilities.getWindowAncestor(Component c)
             * method to get the top-level container of the RoomPanel component,
             * which is the AdminFrame in this case.
             */
            // Retrieves the instance of AdminFrame and gets the CardLayout and JPanel from
            // the AdminFrame
            AdminFrame adminFrame = (AdminFrame) SwingUtilities.getWindowAncestor(this);
            CardLayout cardLayout = adminFrame.getCardLayout();
            JPanel cardPanel = adminFrame.getCardPanel();

            Room roomToBook = RoomControl.getRoomById(roomID);
            Date checkIn = jDateOfCheckInChooser.getDate();
            Date checkOut = jDateOfCheckOutChooser.getDate();

            // Create a new instance of the BookingPanel with the roomID and add it to the
            // cardPanel
            BookingsPanel bookingsPanel = new BookingsPanel(roomToBook, checkIn, checkOut);
            cardPanel.add(bookingsPanel, "bookings");
            cardLayout.show(cardPanel, "bookings");
        }
    }// GEN-LAST:event_roomTableMouseClicked

    private void initRoomTableById(Room roomById){
        BookingControl.pullData();
        RoomControl.pullData();

        DateTime dateTimecheckIn = new DateTime(jDateOfCheckInChooser.getDate()).withTime(14, 0, 0, 0);
        DateTime dateTimecheckOut = new DateTime(jDateOfCheckOutChooser.getDate()).withTime(10, 0, 0, 0);

        DefaultTableModel model = (DefaultTableModel) roomTable.getModel();
        model.setRowCount(0); // Clearing any existing rows in the table

        Object[] rowData = new Object[5];
        rowData[0] = roomById.getId();
        rowData[1] = roomById.getType();
        rowData[2] = roomById.getCapacity();
        rowData[3] = roomById.getPrice();

        if (dateTimecheckIn != null && dateTimecheckOut != null) {
            if (roomById.isRoomAvailable(dateTimecheckIn, dateTimecheckOut)) {
                rowData[4] = "Yes";
            } else {
                rowData[4] = "No";
            }

            model.addRow(rowData);
            // Set row color based on availability
            roomTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    String availability = (String) table.getValueAt(row, 4);
                    setBackground(availability.equals("Yes") ? new Color(0, 255, 60) : new Color(255, 102, 102));
                    return this;
                }
            });
        } else {
            rowData[4] = ""; // Empty value if check-in and check-out dates are not selected
            model.addRow(rowData);
        }

        // Make the table content uneditable
        roomTable.setDefaultEditor(Object.class, null);
        roomTable.setModel(model);
        jScrollPane1.setViewportView(roomTable);
    }

    private void initRoomTableByType(ArrayList<Room> roomsByType){
        BookingControl.pullData();
        RoomControl.pullData();

        DefaultTableModel model = (DefaultTableModel) roomTable.getModel();
        model.setRowCount(0); // Clear the existing rows

        DateTime dateTimecheckIn = new DateTime(jDateOfCheckInChooser.getDate()).withTime(14, 0, 0, 0);
        DateTime dateTimecheckOut = new DateTime(jDateOfCheckOutChooser.getDate()).withTime(10, 0, 0, 0);

        // Set the renderer for the whole table outside the loop
        roomTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                boolean isRoomAvailable = table.getValueAt(row, 4).equals("Yes");
                setBackground(isRoomAvailable ? new Color(0, 255, 60) : new Color(255, 102, 102));
                return this;
            }
        });

        for (Room room : roomsByType) {
            Object[] rowData = new Object[5];
            rowData[0] = room.getId();
            rowData[1] = room.getType();
            rowData[2] = room.getCapacity();
            rowData[3] = room.getPrice();

            boolean isRoomAvailable = false;
            if (dateTimecheckIn != null && dateTimecheckOut != null) {
                isRoomAvailable = room.isRoomAvailable(dateTimecheckIn, dateTimecheckOut);
            }

            rowData[4] = isRoomAvailable ? "Yes" : "No";
            model.addRow(rowData);
        }

        // Make the table content uneditable
        roomTable.setDefaultEditor(Object.class, null);
        // Set the updated table model back to the JTable instance
        roomTable.setModel(model);
    }

    private boolean isSameDay(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();

        cal1.setTime(date1);
        cal2.setTime(date2);
        
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
                && cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private DesignObjects.AppControlButtons appControlButtons1;
    private javax.swing.JLabel checkInLabel;
    private javax.swing.JLabel checkOutLabel;
    private com.toedter.calendar.JDateChooser jDateOfCheckInChooser;
    private com.toedter.calendar.JDateChooser jDateOfCheckOutChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel roomNrLabel;
    private javax.swing.JTextField roomNrTxtField;
    private javax.swing.JTable roomTable;
    private javax.swing.JLabel roomTypeLabel;
    private javax.swing.JTextField roomTypeTxtField;
    private javax.swing.JPanel roomsPanel;
    private javax.swing.JLabel titleTxt;
    // End of variables declaration//GEN-END:variables
}
