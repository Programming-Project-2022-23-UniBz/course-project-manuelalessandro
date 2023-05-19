package UserGUI;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.joda.time.DateTime;

import Objects.Booking;
import Objects.BookingControl;
import Objects.Room;
import Objects.RoomControl;
import Objects.User;
import Objects.Room.RoomType;

public class CreateBookingPanel extends javax.swing.JPanel {
        private User user;
        private UserFrame frame;

        public CreateBookingPanel() {
                initComponents();

                errorLabel.setText("");

                checkInBox.getDateEditor().addPropertyChangeListener(
                                new PropertyChangeListener() {
                                        @Override
                                        public void propertyChange(PropertyChangeEvent e) {
                                                refreshInfos();
                                        }
                                });

                checkOutBox.getDateEditor().addPropertyChangeListener(
                                new PropertyChangeListener() {
                                        @Override
                                        public void propertyChange(PropertyChangeEvent e) {
                                                refreshInfos();
                                        }
                                });

        }

        public void setAppControlButtons(javax.swing.JFrame frame, int xBorder) {
                this.frame = (UserFrame) frame;
                appControlButtons.setAppControl(frame, appControlButtons.getX() + xBorder, appControlButtons.getY());
        }

        // Checks which room is selected and returns the price for one day
        private double getSelectedRoomPrice(DateTime checkIn, DateTime checkOut) throws Exception {
                RoomType type = (RoomType) roomTypeComboBox.getSelectedItem().get(0);
                int capacity = (int) roomTypeComboBox.getSelectedItem().get(1);
                int id = RoomControl.getFreeRoomId(type, capacity, checkIn, checkOut);
                return RoomControl.getRoom(id).getPrice();

        }

        // Refreshes the total stay and total cost on the panel once some info changes
        private void refreshInfos() {
                if (checkInBox.getDate() == null || checkOutBox.getDate() == null)
                        return;

                DateTime checkIn = new DateTime(checkInBox.getDate());
                DateTime checkOut = new DateTime(checkOutBox.getDate());

                int stay = Booking.calculateStay(checkIn.toDate(), checkOut.toDate());
                double totalCost;
                try {
                        totalCost = Booking.calculateTotalCost(getSelectedRoomPrice(checkIn, checkOut), stay);
                        totalStayLabel.setText("Total stay:" + stay + " nights");
                        totalCostLabel.setText("Total cost:" + totalCost + "€");
                } catch (Exception e) {
                        e.printStackTrace();
                        errorLabel.setText(e.getMessage());
                        totalStayLabel.setText("Total stay: / days");
                        totalCostLabel.setText("Total cost: 0€");
                }
        }

        private void confirmBooking() {
                Date checkIn = checkInBox.getDate();
                Date checkOut = checkOutBox.getDate();
                if (checkIn != null && checkOut != null) {
                        RoomType roomType = (RoomType) roomTypeComboBox.getSelectedItem().get(0);
                        int capacity = (int) roomTypeComboBox.getSelectedItem().get(1);

                        try {
                                int roomId = RoomControl.getFreeRoomId(roomType, capacity, new DateTime(checkIn),
                                                new DateTime(checkOut));
                                Room room = RoomControl.getRoom(roomId);

                                BookingControl.createBooking(user, room, checkIn, checkOut);

                                JOptionPane.showMessageDialog(this,
                                                "The booking was created successfully!", "",
                                                JOptionPane.WARNING_MESSAGE);
                        } catch (Exception e) {
                                errorLabel.setText("Unfortunately, no room is avaiable for the selected dates.");
                                return;
                        }

                        if (frame != null)
                                frame.buttonCardAction("booking");
                }
        }

        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                bookingPanel = new javax.swing.JPanel();
                confrimButton = new javax.swing.JButton();
                roomTypeLabel = new javax.swing.JLabel();
                titleTxt = new javax.swing.JLabel();
                totalCostLabel = new javax.swing.JLabel();
                checkInLabel1 = new javax.swing.JLabel();
                checkInBox = new com.toedter.calendar.JDateChooser();
                checkOutLabel1 = new javax.swing.JLabel();
                checkOutBox = new com.toedter.calendar.JDateChooser();
                appControlButtons = new DesignObjects.AppControlButtons();
                roomTypeComboBox = new DesignObjects.RoomTypeComboBox();
                totalStayLabel = new javax.swing.JLabel();
                errorLabel = new javax.swing.JLabel();

                bookingPanel.setBackground(new java.awt.Color(255, 255, 255));
                bookingPanel.setMaximumSize(new java.awt.Dimension(3231311, 123131));

                confrimButton.setBackground(new java.awt.Color(0, 153, 102));
                confrimButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                confrimButton.setForeground(new java.awt.Color(255, 255, 255));
                confrimButton.setText("Confirm booking");
                confrimButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                confirmButtonActionPerformed(evt);
                        }
                });

                roomTypeLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
                roomTypeLabel.setForeground(new java.awt.Color(0, 0, 255));
                roomTypeLabel.setText("Room Type");

                titleTxt.setBackground(new java.awt.Color(255, 255, 255));
                titleTxt.setFont(new java.awt.Font("Yu Gothic UI", 1, 25)); // NOI18N
                titleTxt.setForeground(new java.awt.Color(102, 153, 255));
                titleTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                titleTxt.setText("Book your room!");

                totalCostLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
                totalCostLabel.setForeground(new java.awt.Color(0, 0, 255));
                totalCostLabel.setText("Total Cost: 0€");

                checkInLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
                checkInLabel1.setForeground(new java.awt.Color(0, 0, 255));
                checkInLabel1.setText("Date of Check-In");

                checkOutLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
                checkOutLabel1.setForeground(new java.awt.Color(0, 0, 255));
                checkOutLabel1.setText("Date of Check-Out");

                totalStayLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
                totalStayLabel.setForeground(new java.awt.Color(0, 0, 255));
                totalStayLabel.setText("Total stay: 0 days");

                errorLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
                errorLabel.setForeground(new java.awt.Color(255, 51, 51));
                errorLabel.setText("Error Message");

                javax.swing.GroupLayout bookingPanelLayout = new javax.swing.GroupLayout(bookingPanel);
                bookingPanel.setLayout(bookingPanelLayout);
                bookingPanelLayout.setHorizontalGroup(
                                bookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(bookingPanelLayout.createSequentialGroup()
                                                                .addGap(38, 38, 38)
                                                                .addGroup(bookingPanelLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(bookingPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                                .addComponent(appControlButtons,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                74,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(bookingPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(bookingPanelLayout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(confrimButton,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                172,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(titleTxt)
                                                                                                                .addGroup(bookingPanelLayout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                false)
                                                                                                                                .addComponent(roomTypeComboBox,
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                172,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                bookingPanelLayout
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
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
                                                                                                                                                                                                                172,
                                                                                                                                                                                                                Short.MAX_VALUE))
                                                                                                                                                                .addComponent(roomTypeLabel,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                79,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                                .addComponent(errorLabel,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                348,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(totalCostLabel,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                119,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(totalStayLabel,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                128,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(0, 33, Short.MAX_VALUE)))
                                                                .addContainerGap()));
                bookingPanelLayout.setVerticalGroup(
                                bookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(bookingPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(appControlButtons,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(2, 2, 2)
                                                                .addComponent(titleTxt)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(roomTypeLabel)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(roomTypeComboBox,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(checkInLabel1)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(checkInBox,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                22,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(12, 12, 12)
                                                                .addComponent(checkOutLabel1)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(checkOutBox,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(totalStayLabel)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(totalCostLabel)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(confrimButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                23,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(errorLabel)
                                                                .addContainerGap()));

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

        private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_applyButtonActionPerformed
                confirmBooking();
        }// GEN-LAST:event_applyButtonActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private DesignObjects.AppControlButtons appControlButtons;
        private javax.swing.JPanel bookingPanel;
        private com.toedter.calendar.JDateChooser checkInBox;
        private javax.swing.JLabel checkInLabel1;
        private com.toedter.calendar.JDateChooser checkOutBox;
        private javax.swing.JLabel checkOutLabel1;
        private javax.swing.JButton confrimButton;
        private javax.swing.JLabel errorLabel;
        private DesignObjects.RoomTypeComboBox roomTypeComboBox;
        private javax.swing.JLabel roomTypeLabel;
        private javax.swing.JLabel titleTxt;
        private javax.swing.JLabel totalCostLabel;
        private javax.swing.JLabel totalStayLabel;
        // End of variables declaration//GEN-END:variables

}