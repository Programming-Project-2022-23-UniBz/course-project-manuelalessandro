
package UserGUI;

import Objects.Booking;
import Objects.GeneralController;
import Objects.User;

import java.awt.CardLayout;
import java.awt.event.*;

/**
 * UserFrame class represents the main GUI frame for the user interface.
 * It allows users to navigate between different panels (Dashboard, Booking,
 * Account).
 * 
 * @Author ManuelVillotti
 */
public class UserFrame extends javax.swing.JFrame {

    private CardLayout cardLayout;
    private User user;

    /**
     * Enumeration defining the available cards (panels) in the UserFrame.
     */
    public enum Card {
        DASH, BOOKING, ACCOUNT, REVIEW
    };

    /**
     * Constructs a new UserFrame for a given user.
     * 
     * @param user The User object representing the logged-in user.
     */
    public UserFrame(User user) {
        System.out.println("Login as " + user.getFullName());
        this.user = user;
        initComponents();
        setLocationRelativeTo(null);// center position of JFrame
        setResizable(false);

        // Buttons settings
        cardLayout = (CardLayout) cardPanel.getLayout();
        dashLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                buttonCardAction(Card.DASH);
            }
        });
        bookingLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                buttonCardAction(Card.BOOKING);
            }
        });
        accountLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                buttonCardAction(Card.ACCOUNT);
            }
        });

        reviewLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                buttonCardAction(Card.REVIEW);
            }
        });

        // App control settings
        userBookingPanel.setAppControlButtons(this, sideMenu.getWidth());
        userAccountPanel.setAppControlButtons(this, sideMenu.getWidth());
        userDashboardPanel.setAppControlButtons(this, sideMenu.getWidth());
        createBookingPanel.setAppControlButtons(this, sideMenu.getWidth());
        userReviewPanel.setAppControlButtons(this, sideMenu.getWidth());

        // set user in panels
        createBookingPanel.setUser(user);
        userBookingPanel.setUser(user);
        userAccountPanel.setUser(user);
        userReviewPanel.setUser(user);

        // refresh user infos
        userBookingPanel.refreshInfos();
        userAccountPanel.refreshInfos();
        userReviewPanel.refreshInfos();
    }

    /**
     * Handles the action when a card (panel) is clicked.
     * 
     * @param card The card to be displayed.
     */
    void buttonCardAction(Card card) {
        Booking booking = GeneralController.findBooking(user.getId());
        if (card.equals(Card.BOOKING) && booking == null) {
            cardLayout.show(cardPanel, "create");
            return;
        } else if (card.equals(Card.BOOKING))
            cardLayout.show(cardPanel, "booking");
        else if (card.equals(Card.ACCOUNT))
            cardLayout.show(cardPanel, "account");
        else if (card.equals(Card.REVIEW))
            cardLayout.show(cardPanel, "review");
        else
            cardLayout.show(cardPanel, "dash");

        userBookingPanel.refreshInfos();
        userAccountPanel.refreshInfos();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
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
        createBookingPanel = new UserGUI.CreateBookingPanel();
        userReviewPanel = new UserGUI.UserReviewPanel();
        sideMenu = new javax.swing.JPanel();
        dashLabel = new javax.swing.JLabel();
        bookingLabel = new javax.swing.JLabel();
        accountLabel = new javax.swing.JLabel();
        logOutBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        reviewLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(617, 352));
        setMinimumSize(new java.awt.Dimension(617, 352));
        setUndecorated(true);

        cardPanel.setMaximumSize(new java.awt.Dimension(3231311, 123131));
        cardPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        cardPanel.setLayout(new java.awt.CardLayout());
        cardPanel.add(userDashboardPanel, "dash");
        cardPanel.add(userBookingPanel, "booking");
        cardPanel.add(userAccountPanel, "account");
        cardPanel.add(createBookingPanel, "create");
        cardPanel.add(userReviewPanel, "review");

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

        reviewLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        reviewLabel.setForeground(new java.awt.Color(255, 255, 255));
        reviewLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        reviewLabel.setText("Review");

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
                            .addComponent(logOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reviewLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reviewLabel)
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
            .addComponent(sideMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
            .addComponent(cardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Handles the action when the log out button is clicked.
     * 
     * @param evt The ActionEvent triggering this action.
     */
    private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_logOutBtnActionPerformed
        this.dispose(); // closes the frame
    }// GEN-LAST:event_logOutBtnActionPerformed

    /**
     * Main method to start the UserFrame GUI.
     * Only used during developement to easy testing.
     */
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

        User user = GeneralController.searchUser("guest@email.com");
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserFrame(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountLabel;
    private javax.swing.JLabel bookingLabel;
    private javax.swing.JPanel cardPanel;
    private UserGUI.CreateBookingPanel createBookingPanel;
    private javax.swing.JLabel dashLabel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JLabel reviewLabel;
    private javax.swing.JPanel sideMenu;
    private UserGUI.UserAccountPanel userAccountPanel;
    private UserGUI.UserBookingPanel userBookingPanel;
    private UserGUI.UserDashboardPanel userDashboardPanel;
    private UserGUI.UserReviewPanel userReviewPanel;
    // End of variables declaration//GEN-END:variables
}
