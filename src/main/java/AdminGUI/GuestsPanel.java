package AdminGUI;

public class GuestsPanel extends javax.swing.JPanel {

    /**
     * Creates new form GuestsPanel
     */
    public GuestsPanel() {
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

        guestsPanel = new javax.swing.JPanel();
        surnameLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        titleTxt = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        genderComboBox = new javax.swing.JComboBox<>();
        dobLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomTable = new javax.swing.JTable();
        addGuestBtn = new javax.swing.JButton();
        editGuestBtn = new javax.swing.JButton();
        deleteGuestBtn = new javax.swing.JButton();
        surnameTxtField = new javax.swing.JTextField();
        phnNrLabel = new javax.swing.JLabel();
        phoneNrTxtField = new javax.swing.JTextField();
        nameTxtField = new javax.swing.JTextField();
        jDateOfBirthChooser = new com.toedter.calendar.JDateChooser();

        setPreferredSize(new java.awt.Dimension(744, 546));

        guestsPanel.setBackground(new java.awt.Color(255, 255, 255));
        guestsPanel.setPreferredSize(new java.awt.Dimension(744, 546));

        surnameLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        surnameLabel.setForeground(new java.awt.Color(102, 153, 255));
        surnameLabel.setText("Surname");

        nameLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(102, 153, 255));
        nameLabel.setText("Name");

        titleTxt.setBackground(new java.awt.Color(255, 255, 255));
        titleTxt.setFont(new java.awt.Font("Yu Gothic UI", 1, 25)); // NOI18N
        titleTxt.setForeground(new java.awt.Color(102, 153, 255));
        titleTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleTxt.setText("Manage Guests");

        genderLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        genderLabel.setForeground(new java.awt.Color(102, 153, 255));
        genderLabel.setText("Gender");

        genderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));

        dobLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        dobLabel.setForeground(new java.awt.Color(102, 153, 255));
        dobLabel.setText("Date of Birth");

        roomTable.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        roomTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Surname", "Name", "Gender", "Date of Birth", "Phone number"
            }
        ));
        roomTable.setGridColor(new java.awt.Color(51, 153, 255));
        roomTable.setRowHeight(25);
        roomTable.setShowHorizontalLines(true);
        roomTable.setShowVerticalLines(true);
        jScrollPane1.setViewportView(roomTable);

        addGuestBtn.setBackground(new java.awt.Color(0, 204, 0));
        addGuestBtn.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        addGuestBtn.setForeground(new java.awt.Color(255, 255, 255));
        addGuestBtn.setText("Add new guest");
        addGuestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGuestBtnActionPerformed(evt);
            }
        });

        editGuestBtn.setBackground(new java.awt.Color(255, 153, 0));
        editGuestBtn.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        editGuestBtn.setForeground(new java.awt.Color(255, 255, 255));
        editGuestBtn.setText("Edit guest");
        editGuestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editGuestBtnActionPerformed(evt);
            }
        });

        deleteGuestBtn.setBackground(new java.awt.Color(255, 102, 51));
        deleteGuestBtn.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        deleteGuestBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteGuestBtn.setText("Remove guest");
        deleteGuestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteGuestBtnActionPerformed(evt);
            }
        });

        surnameTxtField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        surnameTxtField.setForeground(new java.awt.Color(0, 153, 153));
        surnameTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surnameTxtFieldActionPerformed(evt);
            }
        });

        phnNrLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        phnNrLabel.setForeground(new java.awt.Color(102, 153, 255));
        phnNrLabel.setText("Phone number");

        phoneNrTxtField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        phoneNrTxtField.setForeground(new java.awt.Color(0, 153, 153));
        phoneNrTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNrTxtFieldActionPerformed(evt);
            }
        });

        nameTxtField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        nameTxtField.setForeground(new java.awt.Color(0, 153, 153));
        nameTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTxtFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout guestsPanelLayout = new javax.swing.GroupLayout(guestsPanel);
        guestsPanel.setLayout(guestsPanelLayout);
        guestsPanelLayout.setHorizontalGroup(
            guestsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(guestsPanelLayout.createSequentialGroup()
                .addGroup(guestsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(guestsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(guestsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(guestsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(phnNrLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dobLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(phoneNrTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jDateOfBirthChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(surnameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(surnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(addGuestBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(editGuestBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(deleteGuestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(guestsPanelLayout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(titleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        guestsPanelLayout.setVerticalGroup(
            guestsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(guestsPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(titleTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(guestsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(guestsPanelLayout.createSequentialGroup()
                        .addComponent(surnameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(surnameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(genderLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phnNrLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phoneNrTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(dobLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateOfBirthChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(addGuestBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editGuestBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteGuestBtn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 773, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(guestsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(guestsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nameTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTxtFieldActionPerformed

    private void phoneNrTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNrTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNrTxtFieldActionPerformed

    private void surnameTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surnameTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_surnameTxtFieldActionPerformed

    private void deleteGuestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteGuestBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteGuestBtnActionPerformed

    private void editGuestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editGuestBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editGuestBtnActionPerformed

    private void addGuestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addGuestBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addGuestBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addGuestBtn;
    private javax.swing.JButton deleteGuestBtn;
    private javax.swing.JLabel dobLabel;
    private javax.swing.JButton editGuestBtn;
    private javax.swing.JComboBox<String> genderComboBox;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JPanel guestsPanel;
    private com.toedter.calendar.JDateChooser jDateOfBirthChooser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTxtField;
    private javax.swing.JLabel phnNrLabel;
    private javax.swing.JTextField phoneNrTxtField;
    private javax.swing.JTable roomTable;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JTextField surnameTxtField;
    private javax.swing.JLabel titleTxt;
    // End of variables declaration//GEN-END:variables
}
