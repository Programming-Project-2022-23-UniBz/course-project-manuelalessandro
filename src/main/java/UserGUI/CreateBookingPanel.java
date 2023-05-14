package UserGUI;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import Objects.Booking;
import Objects.Room;
import Objects.RoomControl;
import Objects.Room.RoomType;

public class CreateBookingPanel extends javax.swing.JPanel {

    public CreateBookingPanel() {
        initComponents();

        jDateOfCheckInChooser.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent e) {
                        refreshInfos();
                    }
                });

        jDateOfCheckOutChooser.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent e) {
                        refreshInfos();
                    }
                });

    }

    public void setAppControlButtons(javax.swing.JFrame frame, int xBorder) {
        appControlButtons.setAppControl(frame, appControlButtons.getX() + xBorder, appControlButtons.getY());
    }

    private double getSelectedRoomPrice() {
        RoomType type = (RoomType) roomTypeComboBox.getSelectedItem().get(0);
        int capacity = (int) roomTypeComboBox.getSelectedItem().get(1);
        int id = RoomControl.getFreeRoomId(type, capacity);
        return RoomControl.getRoom(id).getPrice();
    }

    private void refreshInfos() {
        if (jDateOfCheckInChooser.getDate() == null || jDateOfCheckOutChooser.getDate() == null)
            return;
        int stay = Booking.calculateStay(jDateOfCheckInChooser.getDate(),
                jDateOfCheckOutChooser.getDate());
        double totalCost = Booking.calculateTotalCost(getSelectedRoomPrice(), stay);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bookingPanel = new javax.swing.JPanel();
        applyButton = new javax.swing.JButton();
        roomTypeLabel = new javax.swing.JLabel();
        titleTxt = new javax.swing.JLabel();
        totalCostLabel = new javax.swing.JLabel();
        checkInLabel1 = new javax.swing.JLabel();
        jDateOfCheckInChooser = new com.toedter.calendar.JDateChooser();
        checkOutLabel1 = new javax.swing.JLabel();
        jDateOfCheckOutChooser = new com.toedter.calendar.JDateChooser();
        appControlButtons = new Main.AppControlButtons();
        roomTypeComboBox = new DesignObjects.RoomTypeComboBox();
        totalCostLabel1 = new javax.swing.JLabel();

        bookingPanel.setBackground(new java.awt.Color(255, 255, 255));
        bookingPanel.setMaximumSize(new java.awt.Dimension(3231311, 123131));

        applyButton.setBackground(new java.awt.Color(0, 153, 102));
        applyButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        applyButton.setForeground(new java.awt.Color(255, 255, 255));
        applyButton.setText("Confirm booking");
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
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

        totalCostLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        totalCostLabel1.setForeground(new java.awt.Color(0, 0, 255));
        totalCostLabel1.setText("Total stay: 0 days");

        javax.swing.GroupLayout bookingPanelLayout = new javax.swing.GroupLayout(bookingPanel);
        bookingPanel.setLayout(bookingPanelLayout);
        bookingPanelLayout.setHorizontalGroup(
            bookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookingPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(bookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bookingPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(appControlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bookingPanelLayout.createSequentialGroup()
                        .addGroup(bookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalCostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(applyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titleTxt)
                            .addGroup(bookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(roomTypeComboBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(checkOutLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jDateOfCheckOutChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(checkInLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jDateOfCheckInChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                                    .addComponent(roomTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(totalCostLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 186, Short.MAX_VALUE)))
                .addContainerGap())
        );
        bookingPanelLayout.setVerticalGroup(
            bookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(appControlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(titleTxt)
                .addGap(18, 18, 18)
                .addComponent(roomTypeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roomTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkInLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateOfCheckInChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(checkOutLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateOfCheckOutChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(totalCostLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalCostLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(applyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bookingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bookingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_applyButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_applyButtonActionPerformed

    private void roomTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_roomTypeComboBoxActionPerformed
        refreshInfos();
    }// GEN-LAST:event_roomTypeComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Main.AppControlButtons appControlButtons;
    private javax.swing.JButton applyButton;
    private javax.swing.JPanel bookingPanel;
    private javax.swing.JLabel checkInLabel1;
    private javax.swing.JLabel checkOutLabel1;
    private com.toedter.calendar.JDateChooser jDateOfCheckInChooser;
    private com.toedter.calendar.JDateChooser jDateOfCheckOutChooser;
    private DesignObjects.RoomTypeComboBox roomTypeComboBox;
    private javax.swing.JLabel roomTypeLabel;
    private javax.swing.JLabel titleTxt;
    private javax.swing.JLabel totalCostLabel;
    private javax.swing.JLabel totalCostLabel1;
    // End of variables declaration//GEN-END:variables

}
