/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package AdminGUI;

/**
 *
 * @author kumar
 */
public class BookingsPanel extends javax.swing.JPanel {

    /**
     * Creates new form Bookings
     */
    public BookingsPanel() {
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        roomsPanel = new javax.swing.JPanel();
        editRoomBtn = new javax.swing.JButton();
        addRoomBtn = new javax.swing.JButton();
        roomNrLabel = new javax.swing.JLabel();
        roomNrTxtField = new javax.swing.JTextField();
        deleteRoomBtn = new javax.swing.JButton();
        titleTxt = new javax.swing.JLabel();
        roomTypeComboBox = new javax.swing.JComboBox<>();
        roomPriceLabel = new javax.swing.JLabel();
        roomTypeLabel = new javax.swing.JLabel();
        roomPriceTxtField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomTable = new javax.swing.JTable();
        checkInLabel = new javax.swing.JLabel();
        jDateOfCheckInChooser = new com.toedter.calendar.JDateChooser();
        checkOutLabel = new javax.swing.JLabel();
        jDateOfCheckOutChooser = new com.toedter.calendar.JDateChooser();
        appControlButtons1 = new Main.AppControlButtons();

        jLabel1.setText("jLabel1");

        roomsPanel.setBackground(new java.awt.Color(255, 255, 255));
        roomsPanel.setPreferredSize(new java.awt.Dimension(738, 546));

        editRoomBtn.setBackground(new java.awt.Color(255, 153, 0));
        editRoomBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editRoomBtn.setForeground(new java.awt.Color(255, 255, 255));
        editRoomBtn.setText("Edit");
        editRoomBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRoomBtnActionPerformed(evt);
            }
        });

        addRoomBtn.setBackground(new java.awt.Color(0, 153, 102));
        addRoomBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addRoomBtn.setForeground(new java.awt.Color(255, 255, 255));
        addRoomBtn.setText("Add new room");
        addRoomBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRoomBtnActionPerformed(evt);
            }
        });

        roomNrLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        roomNrLabel.setForeground(new java.awt.Color(0, 0, 255));
        roomNrLabel.setText("Room Type");

        roomNrTxtField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        roomNrTxtField.setForeground(new java.awt.Color(0, 153, 153));
        roomNrTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomNrTxtFieldActionPerformed(evt);
            }
        });

        deleteRoomBtn.setBackground(new java.awt.Color(255, 102, 51));
        deleteRoomBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deleteRoomBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteRoomBtn.setText("Delete");
        deleteRoomBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRoomBtnActionPerformed(evt);
            }
        });

        titleTxt.setBackground(new java.awt.Color(255, 255, 255));
        titleTxt.setFont(new java.awt.Font("Yu Gothic UI", 1, 25)); // NOI18N
        titleTxt.setForeground(new java.awt.Color(102, 153, 255));
        titleTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleTxt.setText("Manage Bookings");

        roomTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single room deluxe", "Double room deluxe", "Double room Standard", "King suite" }));
        roomTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomTypeComboBoxActionPerformed(evt);
            }
        });

        roomPriceLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        roomPriceLabel.setForeground(new java.awt.Color(0, 0, 255));
        roomPriceLabel.setText("Total Cost (€)");

        roomTypeLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        roomTypeLabel.setForeground(new java.awt.Color(0, 0, 255));
        roomTypeLabel.setText("Customer ");

        roomPriceTxtField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        roomPriceTxtField.setForeground(new java.awt.Color(0, 153, 153));
        roomPriceTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomPriceTxtFieldActionPerformed(evt);
            }
        });

        roomTable.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        roomTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Customer", "Room", "Check-In", "Check-Out", "Total Cost"
            }
        ));
        roomTable.setGridColor(new java.awt.Color(51, 153, 255));
        roomTable.setRowHeight(25);
        roomTable.setShowGrid(true);
        jScrollPane1.setViewportView(roomTable);

        checkInLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        checkInLabel.setForeground(new java.awt.Color(0, 0, 255));
        checkInLabel.setText("Date of Check-In");

        checkOutLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        checkOutLabel.setForeground(new java.awt.Color(0, 0, 255));
        checkOutLabel.setText("Date of Check-Out");

        javax.swing.GroupLayout roomsPanelLayout = new javax.swing.GroupLayout(roomsPanel);
        roomsPanel.setLayout(roomsPanelLayout);
        roomsPanelLayout.setHorizontalGroup(
            roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomsPanelLayout.createSequentialGroup()
                .addGroup(roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roomsPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(titleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(152, 152, 152)
                        .addComponent(appControlButtons1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roomsPanelLayout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addGroup(roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkOutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateOfCheckOutChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateOfCheckInChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roomsPanelLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roomsPanelLayout.createSequentialGroup()
                        .addGroup(roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(roomTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roomNrTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roomNrLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roomTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(321, 321, 321)
                        .addGroup(roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(roomPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addRoomBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(roomsPanelLayout.createSequentialGroup()
                                .addComponent(deleteRoomBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editRoomBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(roomPriceTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34))
        );
        roomsPanelLayout.setVerticalGroup(
            roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(appControlButtons1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleTxt))
                .addGap(25, 25, 25)
                .addGroup(roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(roomsPanelLayout.createSequentialGroup()
                            .addComponent(roomPriceLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(roomPriceTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(addRoomBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(deleteRoomBtn)
                                .addComponent(editRoomBtn)))
                        .addGroup(roomsPanelLayout.createSequentialGroup()
                            .addComponent(checkInLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jDateOfCheckInChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(checkOutLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jDateOfCheckOutChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(roomsPanelLayout.createSequentialGroup()
                        .addComponent(roomTypeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roomNrTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(roomNrLabel)
                        .addGap(5, 5, 5)
                        .addComponent(roomTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
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

    private void editRoomBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_editRoomBtnActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_editRoomBtnActionPerformed

    private void addRoomBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addRoomBtnActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_addRoomBtnActionPerformed

    private void roomNrTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_roomNrTxtFieldActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_roomNrTxtFieldActionPerformed

    private void deleteRoomBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_deleteRoomBtnActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_deleteRoomBtnActionPerformed

    private void roomTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_roomTypeComboBoxActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_roomTypeComboBoxActionPerformed

    private void roomPriceTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_roomPriceTxtFieldActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_roomPriceTxtFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRoomBtn;
    private Main.AppControlButtons appControlButtons1;
    private javax.swing.JLabel checkInLabel;
    private javax.swing.JLabel checkOutLabel;
    private javax.swing.JButton deleteRoomBtn;
    private javax.swing.JButton editRoomBtn;
    private com.toedter.calendar.JDateChooser jDateOfCheckInChooser;
    private com.toedter.calendar.JDateChooser jDateOfCheckOutChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel roomNrLabel;
    private javax.swing.JTextField roomNrTxtField;
    private javax.swing.JLabel roomPriceLabel;
    private javax.swing.JTextField roomPriceTxtField;
    private javax.swing.JTable roomTable;
    private javax.swing.JComboBox<String> roomTypeComboBox;
    private javax.swing.JLabel roomTypeLabel;
    private javax.swing.JPanel roomsPanel;
    private javax.swing.JLabel titleTxt;
    // End of variables declaration//GEN-END:variables
}
