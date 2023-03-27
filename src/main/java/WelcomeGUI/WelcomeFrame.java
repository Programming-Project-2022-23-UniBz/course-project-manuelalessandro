
package WelcomeGUI;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class WelcomeFrame extends javax.swing.JFrame {
    
    // Settings
    private int width = 1100;
    private int height = 650;
    private boolean resize = false; // Resizable?
    private String logoPath = "src/main/resources/logo.png";
    
    // Instance variables (custom)
    ImageIcon homeIcon;

    public WelcomeFrame() {
        //Instance variables setup
        homeIcon = new ImageIcon("/exterior1.jpg"); // load the image to a imageIcon
        Image image = homeIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(400, 400,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        homeIcon = new ImageIcon(newimg);  // transform it back

        
        
        initComponents();
        
        //Frame
        setTitle("Hotel Management");
        setResizable(resize); // prevent from resize
        //setUndecorated(true); //disable app borders
        setVisible(true); // make frame visible
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // stop application when closed

        // Set logo as icon
        ImageIcon logo = new ImageIcon(logoPath); // set path in settings
        setIconImage(logo.getImage());
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        borderPanel = new javax.swing.JPanel();
        homeButton = new javax.swing.JButton();
        accomodationButton = new javax.swing.JButton();
        reviewsButton = new javax.swing.JButton();
        servicesButton = new javax.swing.JButton();
        galleryButton = new javax.swing.JButton();
        infoPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cardPanel = new javax.swing.JPanel();
        homePanel = new javax.swing.JPanel();
        homeImageLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        accomodationPanel = new javax.swing.JPanel();
        reviewsPanel = new javax.swing.JPanel();
        servicesPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        borderPanel.setBackground(new java.awt.Color(153, 153, 0));

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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Adler Palace");
        infoPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 15, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Milan - Italy");
        infoPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("info@adlerpalace.it");
        infoPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 45, -1, -1));

        javax.swing.GroupLayout borderPanelLayout = new javax.swing.GroupLayout(borderPanel);
        borderPanel.setLayout(borderPanelLayout);
        borderPanelLayout.setHorizontalGroup(
            borderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
            .addGroup(borderPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(borderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(galleryButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(borderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(homeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(accomodationButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(reviewsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(servicesButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        borderPanelLayout.setVerticalGroup(
            borderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(borderPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(accomodationButton)
                .addGap(18, 18, 18)
                .addComponent(reviewsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(servicesButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(galleryButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

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
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(homeImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jLabel4)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePanelLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(homeImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        cardPanel.add(homePanel, "card2");

        javax.swing.GroupLayout accomodationPanelLayout = new javax.swing.GroupLayout(accomodationPanel);
        accomodationPanel.setLayout(accomodationPanelLayout);
        accomodationPanelLayout.setHorizontalGroup(
            accomodationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        accomodationPanelLayout.setVerticalGroup(
            accomodationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );

        cardPanel.add(accomodationPanel, "card3");

        javax.swing.GroupLayout reviewsPanelLayout = new javax.swing.GroupLayout(reviewsPanel);
        reviewsPanel.setLayout(reviewsPanelLayout);
        reviewsPanelLayout.setHorizontalGroup(
            reviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        reviewsPanelLayout.setVerticalGroup(
            reviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );

        cardPanel.add(reviewsPanel, "card4");

        javax.swing.GroupLayout servicesPanelLayout = new javax.swing.GroupLayout(servicesPanel);
        servicesPanel.setLayout(servicesPanelLayout);
        servicesPanelLayout.setHorizontalGroup(
            servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        servicesPanelLayout.setVerticalGroup(
            servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );

        cardPanel.add(servicesPanel, "card5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(borderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(borderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        borderPanel.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accomodationButton;
    private javax.swing.JPanel accomodationPanel;
    private javax.swing.JPanel borderPanel;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JButton galleryButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel homeImageLabel;
    private javax.swing.JPanel homePanel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton reviewsButton;
    private javax.swing.JPanel reviewsPanel;
    private javax.swing.JButton servicesButton;
    private javax.swing.JPanel servicesPanel;
    // End of variables declaration//GEN-END:variables
}
