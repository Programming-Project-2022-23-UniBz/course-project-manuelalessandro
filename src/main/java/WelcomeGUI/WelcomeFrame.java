
package WelcomeGUI;

import Main.ColorSetting;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import Main.ColorSetting;
import SteelCheckBox.ColorDef;

public class WelcomeFrame extends javax.swing.JFrame {

        // Settings
        private int width = 1100;
        private int height = 650;
        private boolean resize = false; // Resizable? default:false
        private String logoPath = "src/main/resources/logo.png";

        // Instance variables (custom)
        private ImageIcon homeIcon;
        private CardLayout cardLayout;
        private Color[] lightColors;
        private Color[] darkColors;

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
                setTitle("Hotel Management");
                setResizable(resize); // prevent from resize
                // setUndecorated(true); //disable app borders
                setVisible(true); // make frame visible

                // Set logo as icon
                ImageIcon logo = new ImageIcon(logoPath); // set path in settings
                setIconImage(logo.getImage());

                // Buttons settings
                cardLayout = (CardLayout) cardPanel.getLayout();
                homeButton.addActionListener(this::buttonCardAction);
                accomodationButton.addActionListener(this::buttonCardAction);
                reviewsButton.addActionListener(this::buttonCardAction);
                servicesButton.addActionListener(this::buttonCardAction);
                galleryButton.addActionListener(this::buttonCardAction);
        }

        public void setLightTheme() {
                lightColors = ColorSetting.getWelcomeColors("Light");

                // borderPanel background
                borderPanel.setBackground(lightColors[4]);
                infoPanel.setBackground(lightColors[4]);
                homeButton.setBackground(lightColors[4]);
                accomodationButton.setBackground(lightColors[4]);
                reviewsButton.setBackground(lightColors[4]);
                galleryButton.setBackground(lightColors[4]);
                servicesButton.setBackground(lightColors[4]);
                themeCheckBox.setBackground(lightColors[4]);

                // cardPanel background
                homePanel.setBackground(lightColors[3]);
                accomodationPanel.setBackground(lightColors[3]);
                reviewsPanel.setBackground(lightColors[3]);
                servicesPanel.setBackground(lightColors[3]);
                galleryPanel.setBackground(lightColors[3]);

                // borderPanel forderground
                borderPanel.setForeground(lightColors[0]);
                infoPanel.setForeground(lightColors[0]);
                homeButton.setForeground(lightColors[0]);
                accomodationButton.setForeground(lightColors[0]);
                reviewsButton.setForeground(lightColors[0]);
                galleryButton.setForeground(lightColors[0]);
                servicesButton.setForeground(lightColors[0]);
                themeCheckBox.setForeground(lightColors[0]);
                infoLabel1.setForeground(lightColors[0]);
                infoLabel2.setForeground(lightColors[0]);
                infoLabel3.setForeground(lightColors[0]);
        }

        public void setDarkTheme() {
                darkColors = ColorSetting.getWelcomeColors("Dark");

                // borderPanel background
                borderPanel.setBackground(darkColors[1]);
                infoPanel.setBackground(darkColors[1]);
                homeButton.setBackground(darkColors[1]);
                accomodationButton.setBackground(darkColors[1]);
                reviewsButton.setBackground(darkColors[1]);
                galleryButton.setBackground(darkColors[1]);
                servicesButton.setBackground(darkColors[1]);
                themeCheckBox.setBackground(darkColors[1]);

                // cardPanel background
                homePanel.setBackground(darkColors[2]);
                accomodationPanel.setBackground(darkColors[2]);
                reviewsPanel.setBackground(darkColors[2]);
                servicesPanel.setBackground(darkColors[2]);
                galleryPanel.setBackground(darkColors[2]);

                // borderPanel forderground
                borderPanel.setForeground(darkColors[0]);
                infoPanel.setForeground(darkColors[0]);
                homeButton.setForeground(darkColors[0]);
                accomodationButton.setForeground(darkColors[0]);
                reviewsButton.setForeground(darkColors[0]);
                galleryButton.setForeground(darkColors[0]);
                servicesButton.setForeground(darkColors[0]);
                themeCheckBox.setForeground(darkColors[0]);
                infoLabel1.setForeground(darkColors[0]);
                infoLabel2.setForeground(darkColors[0]);
                infoLabel3.setForeground(darkColors[0]);
        }

        private void buttonCardAction(ActionEvent e) {
                if (e.getSource() == homeButton)
                        cardLayout.show(cardPanel, "home");
                else if (e.getSource() == accomodationButton)
                        cardLayout.show(cardPanel, "accomodations");
                else if (e.getSource() == reviewsButton)
                        cardLayout.show(cardPanel, "reviews");
                else if (e.getSource() == servicesButton)
                        cardLayout.show(cardPanel, "services");
                else if (e.getSource() == galleryButton)
                        cardLayout.show(cardPanel, "gallery");
        }

        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                borderPanel = new javax.swing.JPanel();
                homeButton = new javax.swing.JButton();
                accomodationButton = new javax.swing.JButton();
                reviewsButton = new javax.swing.JButton();
                servicesButton = new javax.swing.JButton();
                galleryButton = new javax.swing.JButton();
                infoPanel = new javax.swing.JPanel();
                infoLabel1 = new javax.swing.JLabel();
                infoLabel2 = new javax.swing.JLabel();
                infoLabel3 = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                jButton1 = new javax.swing.JButton();
                themeCheckBox = new SteelCheckBox.SteelCheckBox();
                cardPanel = new javax.swing.JPanel();
                homePanel = new javax.swing.JPanel();
                homeImageLabel = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                accomodationPanel = new javax.swing.JPanel();
                jPanel1 = new javax.swing.JPanel();
                reviewsPanel = new javax.swing.JPanel();
                servicesPanel = new javax.swing.JPanel();
                galleryPanel = new javax.swing.JPanel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setResizable(false);

                borderPanel.setBackground(new java.awt.Color(153, 153, 0));
                borderPanel.setMaximumSize(new java.awt.Dimension(129, 421));
                borderPanel.setMinimumSize(new java.awt.Dimension(129, 421));

                homeButton.setBackground(new java.awt.Color(153, 153, 0));
                homeButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                homeButton.setText("Home");
                homeButton.setBorder(null);
                homeButton.setFocusPainted(false);
                homeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                homeButton.setMaximumSize(new java.awt.Dimension(50, 20));
                homeButton.setMinimumSize(new java.awt.Dimension(50, 20));

                accomodationButton.setBackground(new java.awt.Color(153, 153, 0));
                accomodationButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                accomodationButton.setText("Accomodation");
                accomodationButton.setBorder(null);
                accomodationButton.setFocusPainted(false);
                accomodationButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

                reviewsButton.setBackground(new java.awt.Color(153, 153, 0));
                reviewsButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                reviewsButton.setText("Reviews");
                reviewsButton.setBorder(null);
                reviewsButton.setFocusPainted(false);
                reviewsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                reviewsButton.setMaximumSize(new java.awt.Dimension(50, 20));
                reviewsButton.setMinimumSize(new java.awt.Dimension(50, 20));

                servicesButton.setBackground(new java.awt.Color(153, 153, 0));
                servicesButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                servicesButton.setText("Services");
                servicesButton.setBorder(null);
                servicesButton.setFocusPainted(false);
                servicesButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                servicesButton.setMaximumSize(new java.awt.Dimension(50, 20));
                servicesButton.setMinimumSize(new java.awt.Dimension(50, 20));

                galleryButton.setBackground(new java.awt.Color(153, 153, 0));
                galleryButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                galleryButton.setText("Gallery");
                galleryButton.setBorder(null);
                galleryButton.setFocusPainted(false);
                galleryButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                galleryButton.setMaximumSize(new java.awt.Dimension(50, 20));
                galleryButton.setMinimumSize(new java.awt.Dimension(50, 20));

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

                jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo_small.png"))); // NOI18N

                jButton1.setBackground(new java.awt.Color(145, 146, 129));
                jButton1.setForeground(new java.awt.Color(102, 102, 102));
                jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login_icon.png"))); // NOI18N
                jButton1.setText("Account");
                jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
                jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                jButton1.setFocusPainted(false);
                jButton1.setMargin(new java.awt.Insets(3, 2, 3, 2));
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton1ActionPerformed(evt);
                        }
                });

                themeCheckBox.setLabel("DARK");
                themeCheckBox.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                themeCheckBoxActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout borderPanelLayout = new javax.swing.GroupLayout(borderPanel);
                borderPanel.setLayout(borderPanelLayout);
                borderPanelLayout.setHorizontalGroup(
                                borderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(borderPanelLayout.createSequentialGroup()
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(borderPanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                borderPanelLayout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGroup(borderPanelLayout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(galleryButton,
                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
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
                                                                                                                                                .addComponent(accomodationButton,
                                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                .addComponent(reviewsButton,
                                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                .addComponent(servicesButton,
                                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                90,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                                borderPanelLayout
                                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                                                .addGroup(borderPanelLayout
                                                                                                                                                                                                .createSequentialGroup()
                                                                                                                                                                                                .addGap(6, 6, 6)
                                                                                                                                                                                                .addComponent(themeCheckBox,
                                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                                72,
                                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                                                                .addComponent(jButton1,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                81,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                                                                .addGap(19, 19, 19))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                borderPanelLayout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(jLabel5)
                                                                                                                .addGap(37, 37, 37)))));
                borderPanelLayout.setVerticalGroup(
                                borderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(borderPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jButton1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                28,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(themeCheckBox,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                26,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jLabel5)
                                                                .addGap(30, 30, 30)
                                                                .addComponent(homeButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(accomodationButton)
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
                                                                .addGap(74, 74, 74)
                                                                .addComponent(infoPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(16, 16, 16)));

                cardPanel.setLayout(new java.awt.CardLayout());

                homePanel.setBackground(new java.awt.Color(145, 146, 129));

                homeImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exterior1.jpg"))); // NOI18N
                homeImageLabel.setMaximumSize(new java.awt.Dimension(800, 600));
                homeImageLabel.setMinimumSize(new java.awt.Dimension(800, 600));
                homeImageLabel.setName(""); // NOI18N
                homeImageLabel.setPreferredSize(new java.awt.Dimension(800, 600));

                jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
                jLabel4.setForeground(new java.awt.Color(51, 51, 51));
                jLabel4.setText("Adler Palace Hotel");

                javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
                homePanel.setLayout(homePanelLayout);
                homePanelLayout.setHorizontalGroup(
                                homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(homePanelLayout.createSequentialGroup()
                                                                .addGroup(homePanelLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(homePanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(81, 81, 81)
                                                                                                .addComponent(homeImageLabel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                544,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(homePanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(209, 209, 209)
                                                                                                .addComponent(jLabel4)))
                                                                .addContainerGap(94, Short.MAX_VALUE)));
                homePanelLayout.setVerticalGroup(
                                homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePanelLayout
                                                                .createSequentialGroup()
                                                                .addContainerGap(49, Short.MAX_VALUE)
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(homeImageLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                379,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(47, 47, 47)));

                cardPanel.add(homePanel, "home");

                accomodationPanel.setBackground(new java.awt.Color(145, 146, 129));

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 680, Short.MAX_VALUE));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 38, Short.MAX_VALUE));

                javax.swing.GroupLayout accomodationPanelLayout = new javax.swing.GroupLayout(accomodationPanel);
                accomodationPanel.setLayout(accomodationPanelLayout);
                accomodationPanelLayout.setHorizontalGroup(
                                accomodationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                accomodationPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addContainerGap(22, Short.MAX_VALUE)
                                                                                .addComponent(jPanel1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(17, 17, 17)));
                accomodationPanelLayout.setVerticalGroup(
                                accomodationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(accomodationPanelLayout.createSequentialGroup()
                                                                .addGap(37, 37, 37)
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(455, Short.MAX_VALUE)));

                cardPanel.add(accomodationPanel, "accomodations");

                reviewsPanel.setBackground(new java.awt.Color(145, 146, 129));

                javax.swing.GroupLayout reviewsPanelLayout = new javax.swing.GroupLayout(reviewsPanel);
                reviewsPanel.setLayout(reviewsPanelLayout);
                reviewsPanelLayout.setHorizontalGroup(
                                reviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 0, Short.MAX_VALUE));
                reviewsPanelLayout.setVerticalGroup(
                                reviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 0, Short.MAX_VALUE));

                cardPanel.add(reviewsPanel, "reviews");

                servicesPanel.setBackground(new java.awt.Color(145, 146, 129));

                javax.swing.GroupLayout servicesPanelLayout = new javax.swing.GroupLayout(servicesPanel);
                servicesPanel.setLayout(servicesPanelLayout);
                servicesPanelLayout.setHorizontalGroup(
                                servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 0, Short.MAX_VALUE));
                servicesPanelLayout.setVerticalGroup(
                                servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 0, Short.MAX_VALUE));

                cardPanel.add(servicesPanel, "services");

                galleryPanel.setBackground(new java.awt.Color(145, 146, 129));

                javax.swing.GroupLayout galleryPanelLayout = new javax.swing.GroupLayout(galleryPanel);
                galleryPanel.setLayout(galleryPanelLayout);
                galleryPanelLayout.setHorizontalGroup(
                                galleryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 0, Short.MAX_VALUE));
                galleryPanelLayout.setVerticalGroup(
                                galleryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 0, Short.MAX_VALUE));

                cardPanel.add(galleryPanel, "gallery");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addComponent(borderPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(cardPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                719,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cardPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(borderPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                borderPanel.getAccessibleContext().setAccessibleName("");

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void themeCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_themeCheckBoxActionPerformed
                // TODO add your handling code here:
                if (themeCheckBox.isSelected())
                        setDarkTheme();
                else
                        setLightTheme();
        }// GEN-LAST:event_themeCheckBoxActionPerformed

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_jButton1ActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton accomodationButton;
        private javax.swing.JPanel accomodationPanel;
        private javax.swing.JPanel borderPanel;
        private javax.swing.JPanel cardPanel;
        private javax.swing.JButton galleryButton;
        private javax.swing.JPanel galleryPanel;
        private javax.swing.JButton homeButton;
        private javax.swing.JLabel homeImageLabel;
        private javax.swing.JPanel homePanel;
        private javax.swing.JLabel infoLabel1;
        private javax.swing.JLabel infoLabel2;
        private javax.swing.JLabel infoLabel3;
        private javax.swing.JPanel infoPanel;
        private javax.swing.JButton jButton1;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JButton reviewsButton;
        private javax.swing.JPanel reviewsPanel;
        private javax.swing.JButton servicesButton;
        private javax.swing.JPanel servicesPanel;
        private SteelCheckBox.SteelCheckBox themeCheckBox;
        // End of variables declaration//GEN-END:variables
}
