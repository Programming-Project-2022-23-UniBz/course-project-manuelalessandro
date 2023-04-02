
package WelcomeGUI;

import Main.Main;
import Main.ColorSetting;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Color;
import SteelCheckBox.ColorDef;

public class WelcomeFrame extends javax.swing.JFrame {

        // Settings
        private int width = 1100;
        private int height = 650;
        private boolean resize = false; // Resizable? default:false
        private String logoPath = "src/main/resources/logo.png";

        // For gallery section
        private final String[] imgNames = new String[] { "/1.jpg", "/2.jpg", "/3.jpg", "/4.jpg", "/5.jpg", "/6.jpg",
                        "/7.jpg", "/8.jpg", "/9.jpg", "/10.jpg" };
        private byte inc = 0;

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
                accountButton.setBackground(lightColors[3]); // same colors as cardPanel

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
                accountButton.setForeground(lightColors[0]);
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
                accountButton.setBackground(darkColors[2]); // same colors as cardPanel

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
                accountButton.setForeground(darkColors[0]);
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

        private void accountButtonActionPerformed(java.awt.event.ActionEvent event) {
                Login log = new Login();
                log.setVisible(true);

        }

        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                buttonGroup1 = new javax.swing.ButtonGroup();
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
                accountButton = new javax.swing.JButton();
                themeCheckBox = new SteelCheckBox.SteelCheckBox();
                cardPanel = new javax.swing.JPanel();
                homePanel = new javax.swing.JPanel();
                homeImageLabel = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                jLabel1 = new javax.swing.JLabel();
                accomodationPanel = new javax.swing.JPanel();
                jPanel1 = new javax.swing.JPanel();
                reviewsPanel = new javax.swing.JPanel();
                servicesPanel = new javax.swing.JPanel();
                galleryPanel = new javax.swing.JPanel();
                imgLable = new javax.swing.JLabel();
                btnLeft = new javax.swing.JButton();
                btnRight = new javax.swing.JButton();
                radioImage1 = new javax.swing.JRadioButton();
                radioImage2 = new javax.swing.JRadioButton();
                radioImage3 = new javax.swing.JRadioButton();
                radioImage4 = new javax.swing.JRadioButton();
                radioImage5 = new javax.swing.JRadioButton();
                galleryTxtLable = new javax.swing.JLabel();
                radioImage6 = new javax.swing.JRadioButton();
                radioImage7 = new javax.swing.JRadioButton();
                radioImage8 = new javax.swing.JRadioButton();
                radioImage9 = new javax.swing.JRadioButton();
                radioImage10 = new javax.swing.JRadioButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setResizable(false);

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

                accomodationButton.setBackground(new java.awt.Color(153, 153, 0));
                accomodationButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                accomodationButton.setText("Accomodation");
                accomodationButton.setBorder(null);
                accomodationButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                accomodationButton.setFocusPainted(false);
                accomodationButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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

                jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo_small.png"))); // NOI18N

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
                                                                                                                                                                                .addComponent(accountButton,
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
                                                                .addComponent(accountButton,
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
                homeImageLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                homeImageLabel.setMaximumSize(new java.awt.Dimension(800, 600));
                homeImageLabel.setMinimumSize(new java.awt.Dimension(800, 600));
                homeImageLabel.setName(""); // NOI18N
                homeImageLabel.setPreferredSize(new java.awt.Dimension(800, 600));

                jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
                jLabel4.setForeground(new java.awt.Color(51, 51, 51));
                jLabel4.setText("Adler Palace Hotel");

                jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
                jLabel1.setText("Welcome to");

                javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
                homePanel.setLayout(homePanelLayout);
                homePanelLayout.setHorizontalGroup(
                                homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(homePanelLayout.createSequentialGroup()
                                                                .addGroup(homePanelLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(homePanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(62, 62, 62)
                                                                                                .addComponent(homeImageLabel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                587,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(homePanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(209, 209, 209)
                                                                                                .addComponent(jLabel4)))
                                                                .addContainerGap(70, Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePanelLayout
                                                                .createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(jLabel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                133,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(277, 277, 277)));
                homePanelLayout.setVerticalGroup(
                                homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePanelLayout
                                                                .createSequentialGroup()
                                                                .addContainerGap(30, Short.MAX_VALUE)
                                                                .addComponent(jLabel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                16,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(homeImageLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                400,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(33, 33, 33)));

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
                                                                .addContainerGap(465, Short.MAX_VALUE)));

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

                imgLable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

                btnLeft.setFont(new java.awt.Font("Wide Latin", 1, 36)); // NOI18N
                btnLeft.setText("<");
                btnLeft.setBorderPainted(false);
                btnLeft.setContentAreaFilled(false);
                btnLeft.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnLeftActionPerformed(evt);
                        }
                });

                btnRight.setFont(new java.awt.Font("Wide Latin", 1, 36)); // NOI18N
                btnRight.setText(">");
                btnRight.setBorderPainted(false);
                btnRight.setContentAreaFilled(false);
                btnRight.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnRightActionPerformed(evt);
                        }
                });

                radioImage1.setContentAreaFilled(false);
                radioImage1.setFocusPainted(false);
                radioImage1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                radioImage1ActionPerformed(evt);
                        }
                });

                radioImage2.setContentAreaFilled(false);
                radioImage2.setFocusPainted(false);
                radioImage2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                radioImage2ActionPerformed(evt);
                        }
                });

                radioImage3.setContentAreaFilled(false);
                radioImage3.setFocusPainted(false);
                radioImage3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                radioImage3ActionPerformed(evt);
                        }
                });

                radioImage4.setContentAreaFilled(false);
                radioImage4.setFocusPainted(false);
                radioImage4.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                radioImage4ActionPerformed(evt);
                        }
                });

                radioImage5.setContentAreaFilled(false);
                radioImage5.setFocusPainted(false);
                radioImage5.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                radioImage5ActionPerformed(evt);
                        }
                });

                galleryTxtLable.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
                galleryTxtLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

                radioImage6.setContentAreaFilled(false);
                radioImage6.setFocusPainted(false);
                radioImage6.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                radioImage6ActionPerformed(evt);
                        }
                });

                radioImage7.setContentAreaFilled(false);
                radioImage7.setFocusPainted(false);
                radioImage7.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                radioImage7ActionPerformed(evt);
                        }
                });

                radioImage8.setContentAreaFilled(false);
                radioImage8.setFocusPainted(false);
                radioImage8.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                radioImage8ActionPerformed(evt);
                        }
                });

                radioImage9.setContentAreaFilled(false);
                radioImage9.setFocusPainted(false);
                radioImage9.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                radioImage9ActionPerformed(evt);
                        }
                });

                radioImage10.setContentAreaFilled(false);
                radioImage10.setFocusPainted(false);
                radioImage10.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                radioImage10ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout galleryPanelLayout = new javax.swing.GroupLayout(galleryPanel);
                galleryPanel.setLayout(galleryPanelLayout);
                galleryPanelLayout.setHorizontalGroup(
                                galleryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(galleryPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(btnLeft,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                60,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(imgLable,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                543,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                32,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(btnRight,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                60,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap())
                                                .addGroup(galleryPanelLayout.createSequentialGroup()
                                                                .addGap(248, 248, 248)
                                                                .addComponent(radioImage1)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(radioImage2)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(radioImage3)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(radioImage4)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(radioImage5)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(radioImage6)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(radioImage7)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(radioImage8)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(radioImage9)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(radioImage10)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, galleryPanelLayout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(galleryTxtLable,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                galleryPanelLayout.setVerticalGroup(
                                galleryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(galleryPanelLayout.createSequentialGroup()
                                                                .addGap(59, 59, 59)
                                                                .addComponent(galleryTxtLable,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                37,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(galleryPanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(galleryPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                21,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addGroup(galleryPanelLayout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                .addComponent(imgLable,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                321,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                galleryPanelLayout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addGap(100, 100,
                                                                                                                                                                100)
                                                                                                                                                .addComponent(btnLeft,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                107,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                .addGap(18, 18, 18))
                                                                                .addGroup(galleryPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(121, 121, 121)
                                                                                                .addComponent(btnRight,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                109,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)))
                                                                .addGroup(galleryPanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(radioImage1)
                                                                                .addComponent(radioImage2)
                                                                                .addComponent(radioImage3)
                                                                                .addComponent(radioImage4)
                                                                                .addComponent(radioImage5)
                                                                                .addComponent(radioImage6)
                                                                                .addComponent(radioImage7)
                                                                                .addComponent(radioImage10)
                                                                                .addComponent(radioImage8)
                                                                                .addComponent(radioImage9))
                                                                .addGap(64, 64, 64)));

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
         // -----------------------------------Gallery panel
         // implemantation-------------------------------------------------------------------

        private void galleryButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_galleryButtonActionPerformed

                setImage(imgNames[0]);

                // to gruop all the radio buttons relative to the images
                buttonGroup1.add(radioImage1);
                buttonGroup1.add(radioImage2);
                buttonGroup1.add(radioImage3);
                buttonGroup1.add(radioImage4);
                buttonGroup1.add(radioImage5);
                buttonGroup1.add(radioImage6);
                buttonGroup1.add(radioImage7);
                buttonGroup1.add(radioImage8);
                buttonGroup1.add(radioImage9);
                buttonGroup1.add(radioImage10);

        }// GEN-LAST:event_galleryButtonActionPerformed

        private void setImage(String url) {
                if (url.equals(imgNames[0])) {
                        radioImage1.setSelected(true);
                        galleryTxtLable.setText("Reception area");
                } else if (url.equals(imgNames[1])) {
                        radioImage2.setSelected(true);
                        galleryTxtLable.setText("Restaurant and bar services");
                } else if (url.equals(imgNames[2])) {
                        radioImage3.setSelected(true);
                        galleryTxtLable.setText("Single room deluxe");
                } else if (url.equals(imgNames[3])) {
                        radioImage4.setSelected(true);
                        galleryTxtLable.setText("Double room deluxe");
                } else if (url.equals(imgNames[4])) {
                        radioImage5.setSelected(true);
                        galleryTxtLable.setText("Double room standard");
                } else if (url.equals(imgNames[5])) {
                        radioImage6.setSelected(true);
                        galleryTxtLable.setText("Kids area");
                } else if (url.equals(imgNames[6])) {
                        radioImage7.setSelected(true);
                        galleryTxtLable.setText("Sauna - Wellness & Spa");
                } else if (url.equals(imgNames[7])) {
                        radioImage8.setSelected(true);
                        galleryTxtLable.setText("Swimming pool");
                } else if (url.equals(imgNames[8])) {
                        radioImage9.setSelected(true);
                        galleryTxtLable.setText("Dining hall");
                } else if (url.equals(imgNames[9])) {
                        radioImage10.setSelected(true);
                        galleryTxtLable.setText("Breakfast area");
                }

                ImageIcon icon = new ImageIcon(this.getClass().getResource(url));
                icon.setImage(icon.getImage().getScaledInstance(600, 600, Image.SCALE_SMOOTH));
                imgLable.setIcon(icon);
        }

        private void btnLeftActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLeftActionPerformed
                inc--;
                if (inc < 0)
                        inc = 10;
                setImage(imgNames[inc]);
        }// GEN-LAST:event_btnLeftActionPerformed

        private void btnRightActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRightActionPerformed
                inc++;
                if (inc > 10)
                        inc = 0;
                setImage(imgNames[inc]);
        }// GEN-LAST:event_btnRightActionPerformed

        private void radioImage1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radioImage1ActionPerformed
                setImage(imgNames[0]);
        }// GEN-LAST:event_radioImage1ActionPerformed

        private void radioImage2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radioImage2ActionPerformed
                setImage(imgNames[1]);
        }// GEN-LAST:event_radioImage2ActionPerformed

        private void radioImage3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radioImage3ActionPerformed
                setImage(imgNames[2]);
        }// GEN-LAST:event_radioImage3ActionPerformed

        private void radioImage4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radioImage4ActionPerformed
                setImage(imgNames[3]);
        }// GEN-LAST:event_radioImage4ActionPerformed

        private void radioImage5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radioImage5ActionPerformed
                setImage(imgNames[4]);
        }// GEN-LAST:event_radioImage5ActionPerformed

        private void radioImage6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radioImage6ActionPerformed
                setImage(imgNames[5]);
        }// GEN-LAST:event_radioImage6ActionPerformed

        private void radioImage7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radioImage7ActionPerformed
                setImage(imgNames[6]);
        }// GEN-LAST:event_radioImage7ActionPerformed

        private void radioImage8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radioImage8ActionPerformed
                setImage(imgNames[7]);
        }// GEN-LAST:event_radioImage8ActionPerformed

        private void radioImage9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radioImage9ActionPerformed
                setImage(imgNames[8]);
        }// GEN-LAST:event_radioImage9ActionPerformed

        private void radioImage10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radioImage10ActionPerformed
                setImage(imgNames[9]);
        }// GEN-LAST:event_radioImage10ActionPerformed
         // -----------------------------------Gallery panel
         // implemantation-------------------------------------------------------------------

        private void themeCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_themeCheckBoxActionPerformed
                // TODO add your handling code here:
                if (themeCheckBox.isSelected())
                        setDarkTheme();
                else
                        setLightTheme();
        }// GEN-LAST:event_themeCheckBoxActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton accomodationButton;
        private javax.swing.JPanel accomodationPanel;
        private javax.swing.JButton accountButton;
        private javax.swing.JPanel borderPanel;
        private javax.swing.JButton btnLeft;
        private javax.swing.JButton btnRight;
        private javax.swing.ButtonGroup buttonGroup1;
        private javax.swing.JPanel cardPanel;
        private javax.swing.JButton galleryButton;
        private javax.swing.JPanel galleryPanel;
        private javax.swing.JLabel galleryTxtLable;
        private javax.swing.JButton homeButton;
        private javax.swing.JLabel homeImageLabel;
        private javax.swing.JPanel homePanel;
        private javax.swing.JLabel imgLable;
        private javax.swing.JLabel infoLabel1;
        private javax.swing.JLabel infoLabel2;
        private javax.swing.JLabel infoLabel3;
        private javax.swing.JPanel infoPanel;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JRadioButton radioImage1;
        private javax.swing.JRadioButton radioImage10;
        private javax.swing.JRadioButton radioImage2;
        private javax.swing.JRadioButton radioImage3;
        private javax.swing.JRadioButton radioImage4;
        private javax.swing.JRadioButton radioImage5;
        private javax.swing.JRadioButton radioImage6;
        private javax.swing.JRadioButton radioImage7;
        private javax.swing.JRadioButton radioImage8;
        private javax.swing.JRadioButton radioImage9;
        private javax.swing.JButton reviewsButton;
        private javax.swing.JPanel reviewsPanel;
        private javax.swing.JButton servicesButton;
        private javax.swing.JPanel servicesPanel;
        private SteelCheckBox.SteelCheckBox themeCheckBox;
        // End of variables declaration//GEN-END:variables
}
