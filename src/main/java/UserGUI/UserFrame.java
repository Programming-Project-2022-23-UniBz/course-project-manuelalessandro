
package UserGUI;

import AdminGUI.*;
import Objects.User;

import java.awt.CardLayout;
import java.awt.event.*;

public class UserFrame extends javax.swing.JFrame {

    private CardLayout cardLayout;
    private User user;

    public UserFrame(User user) {
        this.user = user;
        initComponents();

        // Buttons settings
        cardLayout = (CardLayout) cardPanel.getLayout();
        dashLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                buttonCardAction(e);
            }
        });
        bookingLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                buttonCardAction(e);
            }
        });
        accountLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                buttonCardAction(e);
            }
        });

        // App control settings
        userBookingPanel.setAppControlButtons(this, sideMenu.getWidth());
        userAccountPanel.setAppControlButtons(this, sideMenu.getWidth());
        userDashboardPanel.setAppControlButtons(this, sideMenu.getWidth());
    }

    private void buttonCardAction(MouseEvent e) {
        if (e.getSource() == dashLabel)
            cardLayout.show(cardPanel, "dashboard");
        else if (e.getSource() == bookingLabel)
            cardLayout.show(cardPanel, "booking");
        else if (e.getSource() == accountLabel)
            cardLayout.show(cardPanel, "account");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cardPanel = new javax.swing.JPanel();
        userDashboardPanel = new UserGUI.UserDashboardPanel();
        userBookingPanel = new UserGUI.UserBookingPanel();
        userAccountPanel = new UserGUI.UserAccountPanel();
        sideMenu = new javax.swing.JPanel();
        dashLabel = new javax.swing.JLabel();
        bookingLabel = new javax.swing.JLabel();
        accountLabel = new javax.swing.JLabel();
        logOutBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(617, 352));
        setMinimumSize(new java.awt.Dimension(617, 352));
        setUndecorated(true);

        cardPanel.setMaximumSize(new java.awt.Dimension(3231311, 123131));
        cardPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        cardPanel.setLayout(new java.awt.CardLayout());
        cardPanel.add(userDashboardPanel, "dashboard");
        cardPanel.add(userBookingPanel, "booking");
        cardPanel.add(userAccountPanel, "account");

        sideMenu.setBackground(new java.awt.Color(51, 153, 255));
        sideMenu.setMaximumSize(new java.awt.Dimension(167, 352));
        sideMenu.setMinimumSize(new java.awt.Dimension(167, 352));
        sideMenu.setPreferredSize(new java.awt.Dimension(167, 352));

        dashLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        dashLabel.setForeground(new java.awt.Color(255, 255, 255));
        dashLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dashLabel.setText("Dashboard");

        bookingLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        bookingLabel.setForeground(new java.awt.Color(255, 255, 255));
        bookingLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bookingLabel.setText("Booking");

        accountLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        accountLabel.setForeground(new java.awt.Color(255, 255, 255));
        accountLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        accountLabel.setText("Account");

        logOutBtn.setBackground(new java.awt.Color(0, 204, 255));
        logOutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logOutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login_icon.png"))); // NOI18N
        logOutBtn.setText("Log Out");
        logOutBtn.setBorder(null);
        logOutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logOutBtn.setFocusPainted(false);
        logOutBtn.setMargin(new java.awt.Insets(3, 2, 3, 2));
        logOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutBtnActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(0, 0, 153));

        jLabel10.setFont(new java.awt.Font("Brush Script MT", 0, 28)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 153));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Adler Palace");

        jLabel11.setFont(new java.awt.Font("Brush Script MT", 0, 28)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 153));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Hotel");

        javax.swing.GroupLayout sideMenuLayout = new javax.swing.GroupLayout(sideMenu);
        sideMenu.setLayout(sideMenuLayout);
        sideMenuLayout.setHorizontalGroup(
            sideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(sideMenuLayout.createSequentialGroup()
                .addGroup(sideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sideMenuLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sideMenuLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(sideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bookingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dashLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(accountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        sideMenuLayout.setVerticalGroup(
            sideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideMenuLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(dashLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bookingLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(accountLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sideMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sideMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
            .addComponent(cardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_logOutBtnActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_logOutBtnActionPerformed

    private void logOutBtnActionPerformed() {// GEN-FIRST:event_logOutBtnActionPerformed
        this.dispose();
    }// GEN-LAST:event_logOutBtnActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserFrame(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountLabel;
    private javax.swing.JLabel bookingLabel;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JLabel dashLabel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JPanel sideMenu;
    private UserGUI.UserAccountPanel userAccountPanel;
    private UserGUI.UserBookingPanel userBookingPanel;
    private UserGUI.UserDashboardPanel userDashboardPanel;
    // End of variables declaration//GEN-END:variables
}
