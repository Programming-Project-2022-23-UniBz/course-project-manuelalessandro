
package WelcomeGUI;

import Main.LoginFrame;
import DesignObjects.ColorSetting;
import DesignObjects.SteelCheckBox.ColorDef;

import java.awt.CardLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

/**
 * WelcomeFrame represents the main GUI frame for the welcome interface.
 * 
 * @Author ManuelVillotti
 */
public class WelcomeFrame extends javax.swing.JFrame {

        private boolean resize = false; // Resizable? default:false
        private String logoPath = "src/main/resources/logo_light.png";

        // Instance variables (custom)
        private ImageIcon homeIcon;
        private CardLayout cardLayout;
        private Color[] lightColors;
        private Color[] darkColors;

        /**
         * Constructs a new WelcomeFrame.
         */
        public WelcomeFrame() {

                // Instantiates design components
                initComponents();

                // Instance variables setup
                homeIcon = new ImageIcon("/exterior1.jpg"); // load the image to a imageIcon
                Image image = homeIcon.getImage(); // transform it
                Image newimg = image.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH); // scale it the smooth
                                                                                               // way
                homeIcon = new ImageIcon(newimg); // transform it back

                // Light dark theme
                themeCheckBox.setSelectedColor(ColorDef.BLACK);
                setLightTheme();

                // Frame
                setTitle("Adler Palace");
                setResizable(resize); // prevent from resize
                setLocationRelativeTo(null);// center position of JFrame
                // setVisible(true); // set frame visible in Main.java

                // Set logo as icon
                ImageIcon logo = new ImageIcon(logoPath); // set path in settings
                setIconImage(logo.getImage());

                // Buttons settings
                cardLayout = (CardLayout) cardPanel.getLayout();
                homeButton.addActionListener(this::buttonCardAction);
                reviewsButton.addActionListener(this::buttonCardAction);
                servicesButton.addActionListener(this::buttonCardAction);
                galleryButton.addActionListener(this::buttonCardAction);

                // App control settings
                homePanel.setAppControlButtons(this, borderPanel.getWidth());
                galleryPanel.setAppControlButtons(this, borderPanel.getWidth());
                reviewsPanel.setAppControlButtons(this, borderPanel.getWidth());
                servicesPanel.setAppControlButtons(this, borderPanel.getWidth());
        }

        /**
         * Sets the light theme for the WelcomeFrame.
         */
        public void setLightTheme() {
                lightColors = ColorSetting.getWelcomeColors("Light");

                // borderPanel background
                borderPanel.setBackground(lightColors[4]);
                infoPanel.setBackground(lightColors[4]);
                homeButton.setBackground(lightColors[4]);
                reviewsButton.setBackground(lightColors[4]);
                galleryButton.setBackground(lightColors[4]);
                servicesButton.setBackground(lightColors[4]);
                themeCheckBox.setBackground(lightColors[4]);
                accountButton.setBackground(lightColors[1]); // same colors as cardPanel

                // cardPanel background
                homePanel.setLightTheme(lightColors);
                reviewsPanel.setLightTheme(lightColors);
                servicesPanel.setLightTheme(lightColors);
                galleryPanel.setLightTheme(lightColors);

                // borderPanel Foreground
                borderPanel.setForeground(lightColors[0]);
                infoPanel.setForeground(lightColors[0]);
                homeButton.setForeground(lightColors[0]);
                reviewsButton.setForeground(lightColors[0]);
                galleryButton.setForeground(lightColors[0]);
                servicesButton.setForeground(lightColors[0]);
                themeCheckBox.setForeground(lightColors[0]);
                infoLabel1.setForeground(lightColors[0]);
                infoLabel2.setForeground(lightColors[0]);
                infoLabel3.setForeground(lightColors[0]);
                accountButton.setForeground(lightColors[0]);
        }

        /**
         * Sets the dark theme for the WelcomeFrame.
         */
        public void setDarkTheme() {
                darkColors = ColorSetting.getWelcomeColors("Dark");

                // borderPanel background
                borderPanel.setBackground(darkColors[1]);
                infoPanel.setBackground(darkColors[1]);
                homeButton.setBackground(darkColors[1]);
                reviewsButton.setBackground(darkColors[1]);
                galleryButton.setBackground(darkColors[1]);
                servicesButton.setBackground(darkColors[1]);
                themeCheckBox.setBackground(darkColors[1]);
                accountButton.setBackground(darkColors[4]); // same colors as cardPanel

                // cardPanel background
                homePanel.setDarkTheme(darkColors);
                reviewsPanel.setDarkTheme(darkColors);
                servicesPanel.setDarkTheme(darkColors);
                galleryPanel.setDarkTheme(darkColors);

                // borderPanel Foreground
                borderPanel.setForeground(darkColors[4]);
                infoPanel.setForeground(darkColors[4]);
                homeButton.setForeground(darkColors[4]);
                reviewsButton.setForeground(darkColors[4]);
                galleryButton.setForeground(darkColors[4]);
                servicesButton.setForeground(darkColors[4]);
                themeCheckBox.setForeground(darkColors[4]);
                infoLabel1.setForeground(darkColors[4]);
                infoLabel2.setForeground(darkColors[4]);
                infoLabel3.setForeground(darkColors[4]);
                accountButton.setForeground(darkColors[1]);
        }

        /**
         * Handles button click events and switches the displayed card (panel).
         * 
         * @param e The ActionEvent triggering this action.
         */
        private void buttonCardAction(ActionEvent e) {
                if (e.getSource() == homeButton)
                        cardLayout.show(cardPanel, "home");
                else if (e.getSource() == reviewsButton)
                        cardLayout.show(cardPanel, "reviews");
                else if (e.getSource() == servicesButton)
                        cardLayout.show(cardPanel, "services");
                else if (e.getSource() == galleryButton)
                        cardLayout.show(cardPanel, "gallery1");
        }

        /**
         * Handles the action when the accountButton is clicked.
         * Instantiates and displays the admin login panel.
         * 
         * @param event The ActionEvent triggering this action.
         */
        private void accountButtonActionPerformed(java.awt.event.ActionEvent event) {
                LoginFrame login = new LoginFrame();
                login.setVisible(true);
        }

        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                cardPanel = new javax.swing.JPanel();
                homePanel = new WelcomeGUI.HomePanel();
                reviewsPanel = new WelcomeGUI.ReviewsPanel();
                servicesPanel = new WelcomeGUI.ServicesPanel();
                galleryPanel = new WelcomeGUI.GalleryPanel();
                borderPanel = new javax.swing.JPanel();
                homeButton = new javax.swing.JButton();
                reviewsButton = new javax.swing.JButton();
                servicesButton = new javax.swing.JButton();
                galleryButton = new javax.swing.JButton();
                infoPanel = new javax.swing.JPanel();
                infoLabel1 = new javax.swing.JLabel();
                infoLabel2 = new javax.swing.JLabel();
                infoLabel3 = new javax.swing.JLabel();
                hotelLogo = new javax.swing.JLabel();
                accountButton = new javax.swing.JButton();
                themeCheckBox = new DesignObjects.SteelCheckBox.SteelCheckBox();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setUndecorated(true);
                setResizable(false);

                jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
                jPanel1.setPreferredSize(new java.awt.Dimension(833, 548));

                cardPanel.setLayout(new java.awt.CardLayout());
                cardPanel.add(homePanel, "home");
                cardPanel.add(reviewsPanel, "reviews");
                cardPanel.add(servicesPanel, "services");
                cardPanel.add(galleryPanel, "gallery1");

                borderPanel.setBackground(new java.awt.Color(153, 153, 0));
                borderPanel.setMaximumSize(new java.awt.Dimension(129, 421));
                borderPanel.setMinimumSize(new java.awt.Dimension(129, 421));

                homeButton.setBackground(new java.awt.Color(153, 153, 0));
                homeButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                homeButton.setText("Home");
                homeButton.setBorder(null);
                homeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                homeButton.setFocusPainted(false);
                homeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                homeButton.setMaximumSize(new java.awt.Dimension(50, 20));
                homeButton.setMinimumSize(new java.awt.Dimension(50, 20));

                reviewsButton.setBackground(new java.awt.Color(153, 153, 0));
                reviewsButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                reviewsButton.setText("Reviews");
                reviewsButton.setBorder(null);
                reviewsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                reviewsButton.setFocusPainted(false);
                reviewsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                reviewsButton.setMaximumSize(new java.awt.Dimension(50, 20));
                reviewsButton.setMinimumSize(new java.awt.Dimension(50, 20));

                servicesButton.setBackground(new java.awt.Color(153, 153, 0));
                servicesButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                servicesButton.setText("Services");
                servicesButton.setBorder(null);
                servicesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                servicesButton.setFocusPainted(false);
                servicesButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                servicesButton.setMaximumSize(new java.awt.Dimension(50, 20));
                servicesButton.setMinimumSize(new java.awt.Dimension(50, 20));
                servicesButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                servicesButtonActionPerformed(evt);
                        }
                });

                galleryButton.setBackground(new java.awt.Color(153, 153, 0));
                galleryButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                galleryButton.setText("Gallery");
                galleryButton.setBorder(null);
                galleryButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                galleryButton.setFocusPainted(false);
                galleryButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                galleryButton.setMaximumSize(new java.awt.Dimension(50, 20));
                galleryButton.setMinimumSize(new java.awt.Dimension(50, 20));
                galleryButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                galleryButtonActionPerformed(evt);
                        }
                });

                infoPanel.setBackground(new java.awt.Color(153, 153, 0));
                infoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                infoLabel1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
                infoLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                infoLabel1.setText("Adler Palace");
                infoPanel.add(infoLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 15, -1, -1));

                infoLabel2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
                infoLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                infoLabel2.setText("Milan - Italy");
                infoPanel.add(infoLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 28, -1, -1));

                infoLabel3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
                infoLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                infoLabel3.setText("info@adlerpalace.it");
                infoPanel.add(infoLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 100, -1));

                hotelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo_small_dark.png"))); // NOI18N

                accountButton.setBackground(new java.awt.Color(145, 146, 129));
                accountButton.setForeground(new java.awt.Color(102, 102, 102));
                accountButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login_icon.png"))); // NOI18N
                accountButton.setText("Account");
                accountButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
                accountButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                accountButton.setFocusPainted(false);
                accountButton.setMargin(new java.awt.Insets(3, 2, 3, 2));
                accountButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                accountButtonActionPerformed(evt);
                        }
                });

                themeCheckBox.setText("DARK");
                themeCheckBox.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                themeCheckBoxActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout borderPanelLayout = new javax.swing.GroupLayout(borderPanel);
                borderPanel.setLayout(borderPanelLayout);
                borderPanelLayout.setHorizontalGroup(
                                borderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 129,
                                                                Short.MAX_VALUE)
                                                .addGroup(borderPanelLayout.createSequentialGroup()
                                                                .addGap(35, 35, 35)
                                                                .addComponent(hotelLogo)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addGroup(borderPanelLayout.createSequentialGroup()
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(borderPanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(accountButton,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(borderPanelLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                false)
                                                                                                .addComponent(homeButton,
                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(reviewsButton,
                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                90,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                borderPanelLayout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(themeCheckBox,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                72,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(9, 9, 9))))
                                                                .addContainerGap(32, Short.MAX_VALUE))
                                                .addGroup(borderPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(servicesButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                90,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addGroup(borderPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(galleryButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                90,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                borderPanelLayout.setVerticalGroup(
                                borderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(borderPanelLayout.createSequentialGroup()
                                                                .addGap(12, 12, 12)
                                                                .addComponent(accountButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                28,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(themeCheckBox,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                26,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                86,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(hotelLogo)
                                                                .addGap(39, 39, 39)
                                                                .addComponent(homeButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(reviewsButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(servicesButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(galleryButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                92,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(infoPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(16, 16, 16)));

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(borderPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 702, Short.MAX_VALUE))
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                jPanel1Layout.createSequentialGroup()
                                                                                                .addGap(0, 115, Short.MAX_VALUE)
                                                                                                .addComponent(cardPanel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                718,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(borderPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(cardPanel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                548, Short.MAX_VALUE)));

                borderPanel.getAccessibleContext().setAccessibleName("");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 550,
                                                                Short.MAX_VALUE));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void servicesButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_servicesButtonActionPerformed
        }// GEN-LAST:event_servicesButtonActionPerformed
         // -----------------------------------Gallery panel
         // implemantation-------------------------------------------------------------------

        private void galleryButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_galleryButtonActionPerformed

        }// GEN-LAST:event_galleryButtonActionPerformed

        private void themeCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_themeCheckBoxActionPerformed
                if (themeCheckBox.isSelected())
                        setDarkTheme();
                else
                        setLightTheme();
        }// GEN-LAST:event_themeCheckBoxActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton accountButton;
        private javax.swing.JPanel borderPanel;
        private javax.swing.JPanel cardPanel;
        private javax.swing.JButton galleryButton;
        private WelcomeGUI.GalleryPanel galleryPanel;
        private javax.swing.JButton homeButton;
        private WelcomeGUI.HomePanel homePanel;
        private javax.swing.JLabel hotelLogo;
        private javax.swing.JLabel infoLabel1;
        private javax.swing.JLabel infoLabel2;
        private javax.swing.JLabel infoLabel3;
        private javax.swing.JPanel infoPanel;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JButton reviewsButton;
        private WelcomeGUI.ReviewsPanel reviewsPanel;
        private javax.swing.JButton servicesButton;
        private WelcomeGUI.ServicesPanel servicesPanel;
        private DesignObjects.SteelCheckBox.SteelCheckBox themeCheckBox;
        // End of variables declaration//GEN-END:variables
}
