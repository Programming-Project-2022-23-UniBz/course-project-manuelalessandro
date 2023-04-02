
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
import Admin.Login;

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
        homePanel.setLightTheme(lightColors);
        accomodationPanel.setLightTheme(lightColors);
        reviewsPanel.setLightTheme(lightColors);
        servicesPanel.setLightTheme(lightColors);
        galleryPanel.setLightTheme(lightColors);

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
        homePanel.setDarkTheme(darkColors);
        accomodationPanel.setDarkTheme(darkColors);
        reviewsPanel.setDarkTheme(darkColors);
        servicesPanel.setDarkTheme(darkColors);
        galleryPanel.setDarkTheme(darkColors);

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
            cardLayout.show(cardPanel, "gallery1");
    }

    // Here the admin login panel is intantiated
    private void accountButtonActionPerformed(java.awt.event.ActionEvent event) {

        Login login = new Login();
        login.setVisible(true);
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
        homePanel = new WelcomeGUI.HomePanel();
        accomodationPanel = new WelcomeGUI.AccomodationPanel();
        reviewsPanel = new WelcomeGUI.ReviewsPanel();
        servicesPanel = new WelcomeGUI.ServicesPanel();
        galleryPanel = new WelcomeGUI.GalleryPanel();

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
            .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(borderPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(borderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, borderPanelLayout.createSequentialGroup()
                        .addGroup(borderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(galleryButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(borderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(homeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(accomodationButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(reviewsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(servicesButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, borderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(borderPanelLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(themeCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(accountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, borderPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(37, 37, 37))))
        );
        borderPanelLayout.setVerticalGroup(
            borderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(borderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(accountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(themeCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(30, 30, 30)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(accomodationButton)
                .addGap(18, 18, 18)
                .addComponent(reviewsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(servicesButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(galleryButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        cardPanel.setLayout(new java.awt.CardLayout());
        cardPanel.add(homePanel, "home");
        cardPanel.add(accomodationPanel, "accomodations");
        cardPanel.add(reviewsPanel, "reviews");
        cardPanel.add(servicesPanel, "services");
        cardPanel.add(galleryPanel, "gallery1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(borderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(borderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        borderPanel.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
     // -----------------------------------Gallery panel
     // implemantation-------------------------------------------------------------------

    private void galleryButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_galleryButtonActionPerformed

    }// GEN-LAST:event_galleryButtonActionPerformed

    private void themeCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_themeCheckBoxActionPerformed
        // TODO add your handling code here:
        if (themeCheckBox.isSelected())
            setDarkTheme();
        else
            setLightTheme();
    }// GEN-LAST:event_themeCheckBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accomodationButton;
    private WelcomeGUI.AccomodationPanel accomodationPanel;
    private javax.swing.JButton accountButton;
    private javax.swing.JPanel borderPanel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JButton galleryButton;
    private WelcomeGUI.GalleryPanel galleryPanel;
    private javax.swing.JButton homeButton;
    private WelcomeGUI.HomePanel homePanel;
    private javax.swing.JLabel infoLabel1;
    private javax.swing.JLabel infoLabel2;
    private javax.swing.JLabel infoLabel3;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton reviewsButton;
    private WelcomeGUI.ReviewsPanel reviewsPanel;
    private javax.swing.JButton servicesButton;
    private WelcomeGUI.ServicesPanel servicesPanel;
    private SteelCheckBox.SteelCheckBox themeCheckBox;
    // End of variables declaration//GEN-END:variables
}
