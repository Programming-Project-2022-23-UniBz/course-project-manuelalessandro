
package AdminGUI;

import LoginGUI.Login;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminFrame extends javax.swing.JFrame {

    private CardLayout cardLayout;

    public AdminFrame() {
        initComponents();
        setLocationRelativeTo(null);// center position of JFrame
        setResizable(false);
        // Buttons settings
        cardLayout = (CardLayout) cardPanel.getLayout();
        initMouseActionListener();

        // App control settings
        roomsPanel.setAppControlButtons(this, sideMenu.getWidth());
        guestsPanel.setAppControlButtons(this, sideMenu.getWidth());
        dashboardPanel.setAppControlButtons(this, sideMenu.getWidth());
        bookingsPanel.setAppControlButtons(this, sideMenu.getWidth());
    }

    // Set the card switch for cards
    private void initMouseActionListener() {
        dashButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(cardPanel, "dash");
            }
        });
        roomsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(cardPanel, "rooms");
            }
        });
        guestsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(cardPanel, "guests");
            }
        });
        bookingsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(cardPanel, "bookings");
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sideMenu = new javax.swing.JPanel();
        dashButton = new javax.swing.JLabel();
        roomsButton = new javax.swing.JLabel();
        guestsButton = new javax.swing.JLabel();
        bookingsButton = new javax.swing.JLabel();
        logOutBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cardPanel = new javax.swing.JPanel();
        dashboardPanel = new AdminGUI.DashboardPanel();
        roomsPanel = new AdminGUI.RoomsPanel();
        guestsPanel = new AdminGUI.GuestsPanel();
        bookingsPanel = new AdminGUI.BookingsPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(902, 546));

        sideMenu.setBackground(new java.awt.Color(51, 153, 255));
        sideMenu.setMaximumSize(new java.awt.Dimension(164, 546));
        sideMenu.setMinimumSize(new java.awt.Dimension(164, 546));
        sideMenu.setPreferredSize(new java.awt.Dimension(164, 546));

        dashButton.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        dashButton.setForeground(new java.awt.Color(255, 255, 255));
        dashButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dashButton.setText("Dashboard");
        dashButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        roomsButton.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        roomsButton.setForeground(new java.awt.Color(255, 255, 255));
        roomsButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        roomsButton.setText("Rooms");
        roomsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        guestsButton.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        guestsButton.setForeground(new java.awt.Color(255, 255, 255));
        guestsButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        guestsButton.setText("Guests");
        guestsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        bookingsButton.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        bookingsButton.setForeground(new java.awt.Color(255, 255, 255));
        bookingsButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bookingsButton.setText("Bookings");
        bookingsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo_small_dark.png"))); // NOI18N

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
                        .addGap(27, 27, 27)
                        .addGroup(sideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(sideMenuLayout.createSequentialGroup()
                                .addGroup(sideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(guestsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(roomsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bookingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dashButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(logOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2))))
                    .addGroup(sideMenuLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel5)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        sideMenuLayout.setVerticalGroup(
            sideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideMenuLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel5)
                .addGap(43, 43, 43)
                .addComponent(dashButton)
                .addGap(18, 18, 18)
                .addComponent(roomsButton)
                .addGap(18, 18, 18)
                .addComponent(guestsButton)
                .addGap(18, 18, 18)
                .addComponent(bookingsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        cardPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        cardPanel.setPreferredSize(new java.awt.Dimension(738, 546));
        cardPanel.setLayout(new java.awt.CardLayout());

        dashboardPanel.setMaximumSize(new java.awt.Dimension(44444444, 33313));
        dashboardPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        dashboardPanel.setPreferredSize(new java.awt.Dimension(738, 546));
        cardPanel.add(dashboardPanel, "dash");

        roomsPanel.setPreferredSize(new java.awt.Dimension(738, 546));
        cardPanel.add(roomsPanel, "rooms");

        guestsPanel.setMinimumSize(new java.awt.Dimension(744, 546));
        guestsPanel.setPreferredSize(new java.awt.Dimension(738, 546));
        cardPanel.add(guestsPanel, "guests");

        bookingsPanel.setPreferredSize(new java.awt.Dimension(738, 546));
        cardPanel.add(bookingsPanel, "bookings");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sideMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sideMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_logOutBtnActionPerformed
        new Login().setVisible(true);
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
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bookingsButton;
    private AdminGUI.BookingsPanel bookingsPanel;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JLabel dashButton;
    private AdminGUI.DashboardPanel dashboardPanel;
    private javax.swing.JLabel guestsButton;
    private AdminGUI.GuestsPanel guestsPanel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JLabel roomsButton;
    private AdminGUI.RoomsPanel roomsPanel;
    private javax.swing.JPanel sideMenu;
    // End of variables declaration//GEN-END:variables
}
