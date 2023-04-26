/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserGUI;

/**
 *
 * @author mamu8
 */
public class UserAccountPanel extends javax.swing.JPanel {

    /**
     * Creates new form UserAccountPanel
     */
    public UserAccountPanel() {
        initComponents();
    }

    public void setAppControlButtons(javax.swing.JFrame frame, int xBorder) {
        appControlButtons.setAppControl(frame, appControlButtons.getX() + xBorder, appControlButtons.getY());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        accountPanel = new javax.swing.JPanel();
        applyChangesButton = new javax.swing.JButton();
        genderLabel = new javax.swing.JLabel();
        discardChangesButton = new javax.swing.JButton();
        titleTxt = new javax.swing.JLabel();
        genderComboBox = new javax.swing.JComboBox<>();
        passLabel2 = new javax.swing.JLabel();
        checkInLabel = new javax.swing.JLabel();
        jDateOfCheckInChooser = new com.toedter.calendar.JDateChooser();
        checkOutLabel = new javax.swing.JLabel();
        jDateOfCheckOutChooser = new com.toedter.calendar.JDateChooser();
        appControlButtons = new Main.AppControlButtons();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        passLabel1 = new javax.swing.JLabel();
        surnameLabel = new javax.swing.JLabel();
        surnameField = new javax.swing.JTextField();
        passField2 = new javax.swing.JPasswordField();
        passField1 = new javax.swing.JPasswordField();

        accountPanel.setBackground(new java.awt.Color(255, 255, 255));

        applyChangesButton.setBackground(new java.awt.Color(0, 153, 102));
        applyChangesButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        applyChangesButton.setForeground(new java.awt.Color(255, 255, 255));
        applyChangesButton.setText("Apply changes");
        applyChangesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyChangesButtonActionPerformed(evt);
            }
        });

        genderLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        genderLabel.setForeground(new java.awt.Color(0, 0, 255));
        genderLabel.setText("Gender");

        discardChangesButton.setBackground(new java.awt.Color(255, 102, 51));
        discardChangesButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        discardChangesButton.setForeground(new java.awt.Color(255, 255, 255));
        discardChangesButton.setText("Discard changes");
        discardChangesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardChangesButtonActionPerformed(evt);
            }
        });

        titleTxt.setBackground(new java.awt.Color(255, 255, 255));
        titleTxt.setFont(new java.awt.Font("Yu Gothic UI", 1, 25)); // NOI18N
        titleTxt.setForeground(new java.awt.Color(102, 153, 255));
        titleTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleTxt.setText("Account information");

        genderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "Single room deluxe", "Double room deluxe", "Double room Standard", "King suite" }));
        genderComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderComboBoxActionPerformed(evt);
            }
        });

        passLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        passLabel2.setForeground(new java.awt.Color(0, 0, 255));
        passLabel2.setText("Confirm password");

        checkInLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        checkInLabel.setForeground(new java.awt.Color(0, 0, 255));
        checkInLabel.setText("Date of birth");

        checkOutLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        checkOutLabel.setForeground(new java.awt.Color(0, 0, 255));
        checkOutLabel.setText("Date of Check-Out");

        nameLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(0, 0, 255));
        nameLabel.setText("Name");

        nameField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        nameField.setForeground(new java.awt.Color(0, 153, 153));
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        emailLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(0, 0, 255));
        emailLabel.setText("Email");

        emailField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        emailField.setForeground(new java.awt.Color(0, 153, 153));
        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });

        passLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        passLabel1.setForeground(new java.awt.Color(0, 0, 255));
        passLabel1.setText("New password");

        surnameLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        surnameLabel.setForeground(new java.awt.Color(0, 0, 255));
        surnameLabel.setText("Surname");

        surnameField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        surnameField.setForeground(new java.awt.Color(0, 153, 153));
        surnameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surnameFieldActionPerformed(evt);
            }
        });

        passField2.setText("test");

        passField1.setText("test");

        javax.swing.GroupLayout accountPanelLayout = new javax.swing.GroupLayout(accountPanel);
        accountPanel.setLayout(accountPanelLayout);
        accountPanelLayout.setHorizontalGroup(
                accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(accountPanelLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(accountPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(accountPanelLayout.createSequentialGroup()
                                                .addComponent(titleTxt)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(appControlButtons, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(accountPanelLayout.createSequentialGroup()
                                                .addGroup(accountPanelLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(accountPanelLayout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                        accountPanelLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jDateOfCheckOutChooser,
                                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE)
                                                                                .addComponent(jDateOfCheckInChooser,
                                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE)
                                                                                .addGroup(
                                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                                        accountPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(
                                                                                                        accountPanelLayout
                                                                                                                .createParallelGroup(
                                                                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                .addComponent(
                                                                                                                        checkOutLabel,
                                                                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                        116,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(
                                                                                                                        checkInLabel,
                                                                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                        101,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(0, 0,
                                                                                                        Short.MAX_VALUE)))
                                                                .addComponent(discardChangesButton,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 172,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(surnameField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 169,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(surnameLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 91,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(40, 40, 40)
                                                .addGroup(accountPanelLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(genderLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 79,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(emailLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 91,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(passLabel1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 91,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(applyChangesButton,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(genderComboBox, 0, 169, Short.MAX_VALUE)
                                                        .addComponent(emailField)
                                                        .addComponent(passField2)
                                                        .addComponent(passField1)
                                                        .addComponent(passLabel2))
                                                .addGap(25, 25, 25)))
                                .addContainerGap()));
        accountPanelLayout.setVerticalGroup(
                accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(accountPanelLayout.createSequentialGroup()
                                .addGroup(accountPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(accountPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(appControlButtons, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(accountPanelLayout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(titleTxt)))
                                .addGap(12, 12, 12)
                                .addGroup(accountPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(accountPanelLayout.createSequentialGroup()
                                                .addComponent(nameLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(accountPanelLayout.createSequentialGroup()
                                                .addComponent(genderLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(6, 6, 6)
                                .addGroup(accountPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(accountPanelLayout.createSequentialGroup()
                                                .addComponent(surnameLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(checkInLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jDateOfCheckInChooser,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 22,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(checkOutLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jDateOfCheckOutChooser,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(accountPanelLayout.createSequentialGroup()
                                                .addComponent(emailLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(passLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(passField1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(passLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(passField2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(accountPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(applyChangesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(discardChangesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(39, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(accountPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(accountPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)));
    }// </editor-fold>//GEN-END:initComponents

    private void applyChangesButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_applyChangesButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_applyChangesButtonActionPerformed

    private void discardChangesButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_discardChangesButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_discardChangesButtonActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_nameFieldActionPerformed

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_emailFieldActionPerformed

    private void genderComboBoxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_genderComboBoxActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_genderComboBoxActionPerformed

    private void surnameFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_surnameFieldActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_surnameFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accountPanel;
    private Main.AppControlButtons appControlButtons;
    private javax.swing.JButton applyChangesButton;
    private javax.swing.JLabel checkInLabel;
    private javax.swing.JLabel checkOutLabel;
    private javax.swing.JButton discardChangesButton;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JComboBox<String> genderComboBox;
    private javax.swing.JLabel genderLabel;
    private com.toedter.calendar.JDateChooser jDateOfCheckInChooser;
    private com.toedter.calendar.JDateChooser jDateOfCheckOutChooser;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPasswordField passField1;
    private javax.swing.JPasswordField passField2;
    private javax.swing.JLabel passLabel1;
    private javax.swing.JLabel passLabel2;
    private javax.swing.JTextField surnameField;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JLabel titleTxt;
    // End of variables declaration//GEN-END:variables
}