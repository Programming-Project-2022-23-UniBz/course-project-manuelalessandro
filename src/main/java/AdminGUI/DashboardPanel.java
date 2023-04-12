/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package AdminGUI;

/**
 *
 * @author kumar
 */
public class DashboardPanel extends javax.swing.JPanel {

    /**
     * Creates new form Dashboard
     */
    public DashboardPanel() {
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

        roomsPanel = new javax.swing.JPanel();
        titleTxt = new javax.swing.JLabel();
        panelGlowingGradient1 = new pggb.PanelGlowingGradient();
        jLabel1 = new javax.swing.JLabel();
        customersButton = new javax.swing.JButton();
        panelGlowingGradient2 = new pggb.PanelGlowingGradient();
        jLabel2 = new javax.swing.JLabel();
        bookingsButton = new javax.swing.JButton();
        panelGlowingGradient3 = new pggb.PanelGlowingGradient();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        chartsButton = new javax.swing.JButton();
        panelGlowingGradient4 = new pggb.PanelGlowingGradient();
        jLabel4 = new javax.swing.JLabel();
        roomsButton = new javax.swing.JButton();
        appControlButtons1 = new Main.AppControlButtons();

        setPreferredSize(new java.awt.Dimension(744, 546));

        roomsPanel.setBackground(new java.awt.Color(255, 255, 255));
        roomsPanel.setPreferredSize(new java.awt.Dimension(738, 546));

        titleTxt.setBackground(new java.awt.Color(255, 255, 255));
        titleTxt.setFont(new java.awt.Font("Yu Gothic UI", 1, 25)); // NOI18N
        titleTxt.setForeground(new java.awt.Color(102, 153, 255));
        titleTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleTxt.setText("Dashboard");

        panelGlowingGradient1.setForeground(new java.awt.Color(153, 0, 0));
        panelGlowingGradient1.setBackgroundLight(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 0, 20)); // NOI18N
        jLabel1.setText("Customers");
        panelGlowingGradient1.add(jLabel1);
        jLabel1.setBounds(90, 40, 150, 25);

        customersButton.setBackground(new java.awt.Color(255, 204, 204));
        customersButton.setForeground(new java.awt.Color(153, 0, 153));
        customersButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/customer.png"))); // NOI18N
        customersButton.setText("Customers");
        customersButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        customersButton.setBorderPainted(false);
        customersButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        customersButton.setFocusPainted(false);
        customersButton.setMargin(new java.awt.Insets(3, 2, 3, 2));
        customersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customersButtonActionPerformed(evt);
            }
        });
        panelGlowingGradient1.add(customersButton);
        customersButton.setBounds(90, 80, 120, 32);

        panelGlowingGradient2.setForeground(new java.awt.Color(153, 0, 0));
        panelGlowingGradient2.setBackgroundLight(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 0, 20)); // NOI18N
        jLabel2.setText("Bookings");
        panelGlowingGradient2.add(jLabel2);
        jLabel2.setBounds(90, 40, 140, 25);

        bookingsButton.setBackground(new java.awt.Color(255, 204, 204));
        bookingsButton.setForeground(new java.awt.Color(153, 0, 153));
        bookingsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appointment.png"))); // NOI18N
        bookingsButton.setText("Bookings");
        bookingsButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        bookingsButton.setBorderPainted(false);
        bookingsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bookingsButton.setFocusPainted(false);
        bookingsButton.setMargin(new java.awt.Insets(3, 2, 3, 2));
        bookingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingsButtonActionPerformed(evt);
            }
        });
        panelGlowingGradient2.add(bookingsButton);
        bookingsButton.setBounds(80, 80, 120, 34);

        panelGlowingGradient3.setForeground(new java.awt.Color(153, 0, 0));
        panelGlowingGradient3.setBackgroundLight(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Perpetua Titling MT", 1, 20)); // NOI18N
        panelGlowingGradient3.add(jLabel3);
        jLabel3.setBounds(80, 30, 150, 0);

        jLabel5.setFont(new java.awt.Font("Perpetua Titling MT", 0, 20)); // NOI18N
        jLabel5.setText("Income charts");
        panelGlowingGradient3.add(jLabel5);
        jLabel5.setBounds(60, 40, 190, 25);

        chartsButton.setBackground(new java.awt.Color(255, 204, 204));
        chartsButton.setForeground(new java.awt.Color(153, 0, 153));
        chartsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/profit.png"))); // NOI18N
        chartsButton.setText("Chart");
        chartsButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        chartsButton.setBorderPainted(false);
        chartsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chartsButton.setFocusPainted(false);
        chartsButton.setMargin(new java.awt.Insets(3, 2, 3, 2));
        chartsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chartsButtonActionPerformed(evt);
            }
        });
        panelGlowingGradient3.add(chartsButton);
        chartsButton.setBounds(90, 80, 120, 30);

        panelGlowingGradient4.setForeground(new java.awt.Color(153, 0, 0));
        panelGlowingGradient4.setBackgroundLight(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Perpetua Titling MT", 0, 20)); // NOI18N
        jLabel4.setText("Rooms");
        panelGlowingGradient4.add(jLabel4);
        jLabel4.setBounds(100, 40, 100, 25);

        roomsButton.setBackground(new java.awt.Color(255, 204, 204));
        roomsButton.setForeground(new java.awt.Color(153, 0, 153));
        roomsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bed.png"))); // NOI18N
        roomsButton.setText("Check Rooms");
        roomsButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        roomsButton.setBorderPainted(false);
        roomsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        roomsButton.setFocusPainted(false);
        roomsButton.setMargin(new java.awt.Insets(3, 2, 3, 2));
        roomsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomsButtonActionPerformed(evt);
            }
        });
        panelGlowingGradient4.add(roomsButton);
        roomsButton.setBounds(80, 80, 120, 32);

        javax.swing.GroupLayout roomsPanelLayout = new javax.swing.GroupLayout(roomsPanel);
        roomsPanel.setLayout(roomsPanelLayout);
        roomsPanelLayout.setHorizontalGroup(
            roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomsPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelGlowingGradient2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelGlowingGradient4, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelGlowingGradient3, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelGlowingGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65))
            .addGroup(roomsPanelLayout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(titleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(appControlButtons1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roomsPanelLayout.setVerticalGroup(
            roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roomsPanelLayout.createSequentialGroup()
                .addGroup(roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roomsPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(titleTxt))
                    .addGroup(roomsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(appControlButtons1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelGlowingGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelGlowingGradient4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(roomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelGlowingGradient2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelGlowingGradient3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roomsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(roomsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void roomsButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_roomsButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_roomsButtonActionPerformed

    private void customersButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_customersButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_customersButtonActionPerformed

    private void bookingsButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bookingsButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_bookingsButtonActionPerformed

    private void chartsButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_chartsButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_chartsButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Main.AppControlButtons appControlButtons1;
    private javax.swing.JButton bookingsButton;
    private javax.swing.JButton chartsButton;
    private javax.swing.JButton customersButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private pggb.PanelGlowingGradient panelGlowingGradient1;
    private pggb.PanelGlowingGradient panelGlowingGradient2;
    private pggb.PanelGlowingGradient panelGlowingGradient3;
    private pggb.PanelGlowingGradient panelGlowingGradient4;
    private javax.swing.JButton roomsButton;
    private javax.swing.JPanel roomsPanel;
    private javax.swing.JLabel titleTxt;
    // End of variables declaration//GEN-END:variables
}