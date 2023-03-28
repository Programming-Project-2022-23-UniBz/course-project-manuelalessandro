
package WelcomeGUI;

import java.awt.CardLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class WelcomeFrame extends javax.swing.JFrame {
    
    // Settings
    private int width = 1100;
    private int height = 650;
    private boolean resize = false; // Resizable? default:false
    private String logoPath = "src/main/resources/logo.png";
    
    // Instance variables (custom)
    private ImageIcon homeIcon;
    private CardLayout cardLayout;

    public WelcomeFrame() {
        //Instance variables setup
        homeIcon = new ImageIcon("/exterior1.jpg"); // load the image to a imageIcon
        Image image = homeIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(400, 400,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        homeIcon = new ImageIcon(newimg);  // transform it back

        //Instantiates design components
        initComponents();
        
        //Frame
        setTitle("Hotel Management");
        setResizable(resize); // prevent from resize
        //setUndecorated(true); //disable app borders
        setVisible(true); // make frame visible

        // Set logo as icon
        ImageIcon logo = new ImageIcon(logoPath); // set path in settings
        setIconImage(logo.getImage());
        
        //Buttons settings
        cardLayout = (CardLayout) cardPanel.getLayout();
        homeButton.addActionListener(this::buttonCardAction);
        accomodationButton.addActionListener(this::buttonCardAction);
        reviewsButton.addActionListener(this::buttonCardAction);
        servicesButton.addActionListener(this::buttonCardAction);
        galleryButton.addActionListener(this::buttonCardAction);
    }
    
    private void buttonCardAction(ActionEvent e){
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
        jLabel5 = new javax.swing.JLabel();
        cardPanel = new javax.swing.JPanel();
        homePanel = new javax.swing.JPanel();
        homeImageLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        accomodationPanel = new javax.swing.JPanel();
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

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo_small.png"))); // NOI18N

        javax.swing.GroupLayout borderPanelLayout = new javax.swing.GroupLayout(borderPanel);
        borderPanel.setLayout(borderPanelLayout);
        borderPanelLayout.setHorizontalGroup(
            borderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, borderPanelLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(borderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, borderPanelLayout.createSequentialGroup()
                        .addGroup(borderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(galleryButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(borderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(homeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(accomodationButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(reviewsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(servicesButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, borderPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(37, 37, 37))))
        );
        borderPanelLayout.setVerticalGroup(
            borderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(borderPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(homeImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        cardPanel.add(homePanel, "home");

        javax.swing.GroupLayout accomodationPanelLayout = new javax.swing.GroupLayout(accomodationPanel);
        accomodationPanel.setLayout(accomodationPanelLayout);
        accomodationPanelLayout.setHorizontalGroup(
            accomodationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        accomodationPanelLayout.setVerticalGroup(
            accomodationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        cardPanel.add(accomodationPanel, "accomodations");

        javax.swing.GroupLayout reviewsPanelLayout = new javax.swing.GroupLayout(reviewsPanel);
        reviewsPanel.setLayout(reviewsPanelLayout);
        reviewsPanelLayout.setHorizontalGroup(
            reviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        reviewsPanelLayout.setVerticalGroup(
            reviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        cardPanel.add(reviewsPanel, "reviews");

        javax.swing.GroupLayout servicesPanelLayout = new javax.swing.GroupLayout(servicesPanel);
        servicesPanel.setLayout(servicesPanelLayout);
        servicesPanelLayout.setHorizontalGroup(
            servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        servicesPanelLayout.setVerticalGroup(
            servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        cardPanel.add(servicesPanel, "services");

        javax.swing.GroupLayout galleryPanelLayout = new javax.swing.GroupLayout(galleryPanel);
        galleryPanel.setLayout(galleryPanelLayout);
        galleryPanelLayout.setHorizontalGroup(
            galleryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        galleryPanelLayout.setVerticalGroup(
            galleryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        cardPanel.add(galleryPanel, "gallery");

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
            .addGroup(layout.createSequentialGroup()
                .addComponent(cardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(borderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private javax.swing.JPanel galleryPanel;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel homeImageLabel;
    private javax.swing.JPanel homePanel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton reviewsButton;
    private javax.swing.JPanel reviewsPanel;
    private javax.swing.JButton servicesButton;
    private javax.swing.JPanel servicesPanel;
    // End of variables declaration//GEN-END:variables
}
