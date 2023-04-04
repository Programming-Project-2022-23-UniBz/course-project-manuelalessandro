/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Admin;

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        editRoomBtn = new javax.swing.JButton();
        addRoomBtn = new javax.swing.JButton();
        roomNrLabel = new javax.swing.JLabel();
        roomNrTxtField = new javax.swing.JTextField();
        deleteRoomBtn = new javax.swing.JButton();
        titleTxt = new javax.swing.JLabel();
        roomTypeComboBox = new javax.swing.JComboBox<>();
        roomPriceLabel = new javax.swing.JLabel();
        roomTypeLabel = new javax.swing.JLabel();
        roomStatusLabel = new javax.swing.JLabel();
        roomStatusComboBox = new javax.swing.JComboBox<>();
        roomPriceTxtField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomTable = new javax.swing.JTable();

        editRoomBtn.setBackground(new java.awt.Color(255, 153, 0));
        editRoomBtn.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        editRoomBtn.setForeground(new java.awt.Color(255, 255, 255));
        editRoomBtn.setText("Edit existing room");
        editRoomBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRoomBtnActionPerformed(evt);
            }
        });

        addRoomBtn.setBackground(new java.awt.Color(0, 204, 0));
        addRoomBtn.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        addRoomBtn.setForeground(new java.awt.Color(255, 255, 255));
        addRoomBtn.setText("Add new room");
        addRoomBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRoomBtnActionPerformed(evt);
            }
        });

        roomNrLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        roomNrLabel.setForeground(new java.awt.Color(102, 153, 255));
        roomNrLabel.setText("Room number");

        roomNrTxtField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        roomNrTxtField.setForeground(new java.awt.Color(0, 153, 153));
        roomNrTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomNrTxtFieldActionPerformed(evt);
            }
        });

        deleteRoomBtn.setBackground(new java.awt.Color(255, 102, 51));
        deleteRoomBtn.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        deleteRoomBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteRoomBtn.setText("Delete room");
        deleteRoomBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRoomBtnActionPerformed(evt);
            }
        });

        titleTxt.setBackground(new java.awt.Color(255, 255, 255));
        titleTxt.setFont(new java.awt.Font("Yu Gothic UI", 1, 25)); // NOI18N
        titleTxt.setForeground(new java.awt.Color(102, 153, 255));
        titleTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleTxt.setText("Manage Rooms");

        roomTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single room deluxe", "Double room deluxe", "Double room Standard", "King suite" }));

        roomPriceLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        roomPriceLabel.setForeground(new java.awt.Color(102, 153, 255));
        roomPriceLabel.setText("Room price (€)");

        roomTypeLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        roomTypeLabel.setForeground(new java.awt.Color(102, 153, 255));
        roomTypeLabel.setText("Room type");

        roomStatusLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        roomStatusLabel.setForeground(new java.awt.Color(102, 153, 255));
        roomStatusLabel.setText("Room status");

        roomStatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vacant", "Booked" }));

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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Number", "Type", "Status", "Price"
            }
        ));
        roomTable.setGridColor(new java.awt.Color(51, 153, 255));
        roomTable.setRowHeight(25);
        roomTable.setShowHorizontalLines(true);
        roomTable.setShowVerticalLines(true);
        jScrollPane1.setViewportView(roomTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 726, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(roomTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(roomNrLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(roomStatusComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(roomPriceTxtField)
                                .addComponent(addRoomBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(editRoomBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                .addComponent(deleteRoomBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(roomNrTxtField)
                                .addComponent(roomTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(roomStatusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(roomPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(26, 26, 26)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(238, 238, 238)
                            .addComponent(titleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(titleTxt)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(roomNrLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(roomNrTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(roomTypeLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(roomTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(roomStatusLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(roomStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(roomPriceLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(roomPriceTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(addRoomBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(editRoomBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(deleteRoomBtn)))
                    .addContainerGap(19, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 726, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editRoomBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editRoomBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editRoomBtnActionPerformed

    private void addRoomBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRoomBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addRoomBtnActionPerformed

    private void roomNrTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomNrTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomNrTxtFieldActionPerformed

    private void deleteRoomBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRoomBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteRoomBtnActionPerformed

    private void roomPriceTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomPriceTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomPriceTxtFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRoomBtn;
    private javax.swing.JButton deleteRoomBtn;
    private javax.swing.JButton editRoomBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel roomNrLabel;
    private javax.swing.JTextField roomNrTxtField;
    private javax.swing.JLabel roomPriceLabel;
    private javax.swing.JTextField roomPriceTxtField;
    private javax.swing.JComboBox<String> roomStatusComboBox;
    private javax.swing.JLabel roomStatusLabel;
    private javax.swing.JTable roomTable;
    private javax.swing.JComboBox<String> roomTypeComboBox;
    private javax.swing.JLabel roomTypeLabel;
    private javax.swing.JLabel titleTxt;
    // End of variables declaration//GEN-END:variables
}
