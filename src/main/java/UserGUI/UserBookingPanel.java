/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserGUI;

import java.util.Date;

import javax.swing.JOptionPane;

import org.joda.time.DateTime;

import Objects.Booking;
import Objects.GeneralController;
import Objects.Room;
import Objects.Room.RoomType;
import Objects.User;

/**
 *
 * @author mamu8
 */
public class UserBookingPanel extends javax.swing.JPanel {

        private User user;
        private Booking booking;
        private UserFrame frame;

        /**
         * Creates new form UserBookingPanel
         */
        public UserBookingPanel() {
                initComponents();
        }

        public void setUser(User user) {
                this.user = user;
                booking = GeneralController.findBooking(user);
        }

        public void setAppControlButtons(javax.swing.JFrame frame, int xBorder) {
                this.frame = (UserFrame) frame;
                appControlButtons.setAppControl(frame, appControlButtons.getX() + xBorder, appControlButtons.getY());
        }

        public void refreshInfos() {
                errorLabel.setText("");
                if (booking != null) {
                        Room room = booking.getRoom();

                        roomField.setText("N:" + room.getId() + " - " + room.getType() + " for "
                                        + room.getCapacity());
                        checkInField.setText(booking.getCheckInDate().toString("dd/MM/yyyy") + "");
                        checkOutField.setText(booking.getCheckOutDate().toString("dd/MM/yyyy") + "");
                        totalCostField.setText(booking.getTotalCost() + "");
                } else {
                        errorLabel.setText("Your booking was not identified, please restart the application");
                        System.out.println("-- Booking is null");
                }
        }

        public void applyChanges() {
                Date checkIn = checkInBox.getDate();
                Date checkOut = checkOutBox.getDate();
                if (user == null) {
                        errorLabel.setText("Your account was not identified, please restart the application");
                        System.out.println("-- User is null");
                }

                if (booking == null) {
                        errorLabel.setText("Your booking was not identified, please restart the application");
                        System.out.println("-- Booking is null");
                }

                if (checkIn != null && checkOut != null) {
                        RoomType roomType = (RoomType) roomTypeComboBox.getSelectedItem().get(0);
                        int capacity = (int) roomTypeComboBox.getSelectedItem().get(1);

                        try {
                                // find free room
                                Room room = GeneralController.getFreeRoom(roomType, capacity,
                                                new DateTime(checkIn),
                                                new DateTime(checkOut));

                                // ask for confirmation
                                int stay = Booking.calculateStay(checkIn, checkOut);
                                double cost = Booking.calculateTotalCost(room.getPrice(), stay);
                                int input = JOptionPane.showConfirmDialog(null,
                                                "Total Stay: " + stay + "\nTotal cost: "
                                                                + cost
                                                                + "\nDo you want to confirm the changes?"); // 0=yes,
                                                                                                            // 1=no,
                                                                                                            // 2=cancel

                                // apply changes
                                if (input == 0) {
                                        booking.setRoom(room);
                                        booking.setCheckInDate(new DateTime(checkIn));
                                        booking.setCheckOutDate(new DateTime(checkOut));

                                        JOptionPane.showMessageDialog(this,
                                                        "The booking was edited successfully!", "",
                                                        JOptionPane.WARNING_MESSAGE);
                                }

                        } catch (Exception e) {
                                errorLabel.setText(
                                                "Unfortunately, no room is avaiable for the selected dates.");
                                return;
                        }

                        refreshInfos();

                } else {
                        errorLabel.setText("You have to select valid dates!");
                }
        }

        public void deleteBooking() {
                try {
                        GeneralController.removeBookingById(booking.getId());

                        JOptionPane.showMessageDialog(this,
                                        "The booking was deleted!", "",
                                        JOptionPane.WARNING_MESSAGE);
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(this,
                                        "An error was detected by deleting the booking. Please restart the application.",
                                        "",
                                        JOptionPane.WARNING_MESSAGE);
                }

                if (frame != null)
                        frame.buttonCardAction(UserFrame.Card.BOOKING);
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                bookingPanel = new javax.swing.JPanel();
                applyButton = new javax.swing.JButton();
                roomTypeLabel = new javax.swing.JLabel();
                deleteButton = new javax.swing.JButton();
                titleTxt = new javax.swing.JLabel();
                totalCostLabel = new javax.swing.JLabel();
                totalCostField = new javax.swing.JTextField();
                checkInLabel1 = new javax.swing.JLabel();
                checkInBox = new com.toedter.calendar.JDateChooser();
                checkOutLabel1 = new javax.swing.JLabel();
                checkOutBox = new com.toedter.calendar.JDateChooser();
                appControlButtons = new DesignObjects.AppControlButtons();
                roomLabel = new javax.swing.JLabel();
                roomField = new javax.swing.JTextField();
                checkInLabel2 = new javax.swing.JLabel();
                checkInField = new javax.swing.JTextField();
                editBookingLabel = new javax.swing.JLabel();
                checkOutLabel2 = new javax.swing.JLabel();
                checkOutField = new javax.swing.JTextField();
                bookingInfoLabel = new javax.swing.JLabel();
                errorLabel = new javax.swing.JLabel();
                roomTypeComboBox = new DesignObjects.RoomTypeComboBox();

                setMaximumSize(new java.awt.Dimension(3231311, 123131));

                bookingPanel.setBackground(new java.awt.Color(255, 255, 255));
                bookingPanel.setMaximumSize(new java.awt.Dimension(3231311, 123131));
                bookingPanel.setMinimumSize(new java.awt.Dimension(0, 0));

                applyButton.setBackground(new java.awt.Color(0, 153, 102));
                applyButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                applyButton.setForeground(new java.awt.Color(255, 255, 255));
                applyButton.setText("Apply changes");
                applyButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                applyButtonActionPerformed(evt);
                        }
                });

                roomTypeLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
                roomTypeLabel.setForeground(new java.awt.Color(0, 0, 255));
                roomTypeLabel.setText("Room Type");

                deleteButton.setBackground(new java.awt.Color(255, 102, 51));
                deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                deleteButton.setForeground(new java.awt.Color(255, 255, 255));
                deleteButton.setText("Delete booking");
                deleteButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                deleteButtonActionPerformed(evt);
                        }
                });

                titleTxt.setBackground(new java.awt.Color(255, 255, 255));
                titleTxt.setFont(new java.awt.Font("Yu Gothic UI", 1, 25)); // NOI18N
                titleTxt.setForeground(new java.awt.Color(102, 153, 255));
                titleTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                titleTxt.setText("Manage Your Booking");

                totalCostLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
                totalCostLabel.setForeground(new java.awt.Color(0, 0, 255));
                totalCostLabel.setText("Total Cost (€)");

                totalCostField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
                totalCostField.setForeground(new java.awt.Color(0, 0, 0));
                totalCostField.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                totalCostFieldActionPerformed(evt);
                        }
                });

                checkInLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
                checkInLabel1.setForeground(new java.awt.Color(0, 0, 255));
                checkInLabel1.setText("Date of Check-In");

                checkOutLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
                checkOutLabel1.setForeground(new java.awt.Color(0, 0, 255));
                checkOutLabel1.setText("Date of Check-Out");

                roomLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
                roomLabel.setForeground(new java.awt.Color(0, 0, 255));
                roomLabel.setText("Room");

                roomField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
                roomField.setForeground(new java.awt.Color(0, 0, 0));
                roomField.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                roomFieldActionPerformed(evt);
                        }
                });

                checkInLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
                checkInLabel2.setForeground(new java.awt.Color(0, 0, 255));
                checkInLabel2.setText("Date of Check-In");

                checkInField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
                checkInField.setForeground(new java.awt.Color(0, 0, 0));
                checkInField.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                checkInFieldActionPerformed(evt);
                        }
                });

                editBookingLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
                editBookingLabel.setForeground(new java.awt.Color(204, 0, 51));
                editBookingLabel.setText("Edit booking:");

                checkOutLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
                checkOutLabel2.setForeground(new java.awt.Color(0, 0, 255));
                checkOutLabel2.setText("Date of Check-Out");

                checkOutField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
                checkOutField.setForeground(new java.awt.Color(0, 0, 0));
                checkOutField.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                checkOutFieldActionPerformed(evt);
                        }
                });

                bookingInfoLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
                bookingInfoLabel.setForeground(new java.awt.Color(204, 0, 51));
                bookingInfoLabel.setText("Your booking:");

                errorLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
                errorLabel.setForeground(new java.awt.Color(255, 51, 51));
                errorLabel.setText("Error Message");

                javax.swing.GroupLayout bookingPanelLayout = new javax.swing.GroupLayout(bookingPanel);
                bookingPanel.setLayout(bookingPanelLayout);
                bookingPanelLayout.setHorizontalGroup(
                                bookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(bookingPanelLayout.createSequentialGroup()
                                                                .addGap(38, 38, 38)
                                                                .addGroup(bookingPanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(bookingPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(titleTxt)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(appControlButtons,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                74,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(bookingPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(bookingPanelLayout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(errorLabel,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                348,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGroup(bookingPanelLayout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addGroup(bookingPanelLayout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                false)
                                                                                                                                                .addGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                                bookingPanelLayout
                                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                                                                false)
                                                                                                                                                                                .addComponent(checkOutLabel1,
                                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                116,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                                .addComponent(checkOutBox,
                                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                                .addComponent(checkInLabel1,
                                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                101,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                                .addComponent(checkInBox,
                                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                                .addComponent(applyButton,
                                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                172,
                                                                                                                                                                                                Short.MAX_VALUE))
                                                                                                                                                .addComponent(deleteButton,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                .addComponent(roomTypeComboBox,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                .addGroup(bookingPanelLayout
                                                                                                                                                                .createSequentialGroup()
                                                                                                                                                                .addGroup(bookingPanelLayout
                                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                                                .addComponent(editBookingLabel,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                119,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                                .addComponent(roomTypeLabel,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                79,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                                                .addGap(53, 53, 53)))
                                                                                                                                .addGap(40, 40, 40)
                                                                                                                                .addGroup(bookingPanelLayout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(bookingInfoLabel,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                119,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(roomField,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                169,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(roomLabel,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                91,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(totalCostField,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                169,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(totalCostLabel,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                91,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(checkInField,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                169,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(checkInLabel2,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                91,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(checkOutField,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                169,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(checkOutLabel2))))
                                                                                                .addGap(0, 34, Short.MAX_VALUE)))
                                                                .addContainerGap()));
                bookingPanelLayout.setVerticalGroup(
                                bookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(bookingPanelLayout.createSequentialGroup()
                                                                .addGroup(bookingPanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(bookingPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addContainerGap()
                                                                                                .addComponent(appControlButtons,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(bookingPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(19, 19, 19)
                                                                                                .addComponent(titleTxt)))
                                                                .addGap(31, 31, 31)
                                                                .addGroup(bookingPanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(bookingPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(editBookingLabel)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(roomTypeLabel)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(roomTypeComboBox,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(checkInLabel1)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(checkInBox,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                22,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(checkOutLabel1)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(checkOutBox,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addComponent(applyButton,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                23,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(deleteButton))
                                                                                .addGroup(bookingPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(bookingInfoLabel)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(roomLabel)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(roomField,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(checkInLabel2)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(checkInField,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(checkOutLabel2)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(checkOutField,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(totalCostLabel)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(totalCostField,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(errorLabel)
                                                                .addContainerGap(16, Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(bookingPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(bookingPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        }// </editor-fold>//GEN-END:initComponents

        private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_applyButtonActionPerformed
                applyChanges();
        }// GEN-LAST:event_applyButtonActionPerformed

        private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_deleteButtonActionPerformed
                deleteBooking();
        }// GEN-LAST:event_deleteButtonActionPerformed

        private void roomTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_roomTypeComboBoxActionPerformed
        }// GEN-LAST:event_roomTypeComboBoxActionPerformed

        private void totalCostFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_totalCostFieldActionPerformed
        }// GEN-LAST:event_totalCostFieldActionPerformed

        private void roomFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_roomFieldActionPerformed
        }// GEN-LAST:event_roomFieldActionPerformed

        private void checkInFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_checkInFieldActionPerformed
        }// GEN-LAST:event_checkInFieldActionPerformed

        private void checkOutFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_checkOutFieldActionPerformed
        }// GEN-LAST:event_checkOutFieldActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private DesignObjects.AppControlButtons appControlButtons;
        private javax.swing.JButton applyButton;
        private javax.swing.JLabel bookingInfoLabel;
        private javax.swing.JPanel bookingPanel;
        private com.toedter.calendar.JDateChooser checkInBox;
        private javax.swing.JTextField checkInField;
        private javax.swing.JLabel checkInLabel1;
        private javax.swing.JLabel checkInLabel2;
        private com.toedter.calendar.JDateChooser checkOutBox;
        private javax.swing.JTextField checkOutField;
        private javax.swing.JLabel checkOutLabel1;
        private javax.swing.JLabel checkOutLabel2;
        private javax.swing.JButton deleteButton;
        private javax.swing.JLabel editBookingLabel;
        private javax.swing.JLabel errorLabel;
        private javax.swing.JTextField roomField;
        private javax.swing.JLabel roomLabel;
        private DesignObjects.RoomTypeComboBox roomTypeComboBox;
        private javax.swing.JLabel roomTypeLabel;
        private javax.swing.JLabel titleTxt;
        private javax.swing.JTextField totalCostField;
        private javax.swing.JLabel totalCostLabel;
        // End of variables declaration//GEN-END:variables
}
