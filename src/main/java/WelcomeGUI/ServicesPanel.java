
package WelcomeGUI;

import java.awt.Color;

public class ServicesPanel extends javax.swing.JPanel {

    public ServicesPanel() {
        initComponents();
    }

    public void setLightTheme(Color[] colors) {
        // Background
        servicesPanel.setBackground(colors[1]);
        panelGlowingGradient1.setBackground(colors[4]);
        panelGlowingGradient2.setBackground(colors[4]);
        panelGlowingGradient3.setBackground(colors[4]);
        panelGlowingGradient4.setBackground(colors[4]);
        panelGlowingGradient5.setBackground(colors[4]);
        panelGlowingGradient6.setBackground(colors[4]);
        panelGlowingGradient1.setBackgroundLight(colors[4]);
        panelGlowingGradient2.setBackgroundLight(colors[4]);
        panelGlowingGradient3.setBackgroundLight(colors[4]);
        panelGlowingGradient4.setBackgroundLight(colors[4]);
        panelGlowingGradient5.setBackgroundLight(colors[4]);
        panelGlowingGradient6.setBackgroundLight(colors[4]);

        // Gradient Colors
        panelGlowingGradient1.setGradientColor1(colors[3]);
        panelGlowingGradient2.setGradientColor1(colors[3]);
        panelGlowingGradient3.setGradientColor1(colors[3]);
        panelGlowingGradient4.setGradientColor1(colors[3]);
        panelGlowingGradient5.setGradientColor1(colors[3]);
        panelGlowingGradient6.setGradientColor1(colors[3]);
        panelGlowingGradient1.setGradientColor2(colors[2]);
        panelGlowingGradient2.setGradientColor2(colors[2]);
        panelGlowingGradient3.setGradientColor2(colors[2]);
        panelGlowingGradient4.setGradientColor2(colors[2]);
        panelGlowingGradient5.setGradientColor2(colors[2]);
        panelGlowingGradient6.setGradientColor2(colors[2]);

        // Foreground
        jLabel4.setForeground(colors[1]);
        jLabel6.setForeground(colors[1]);
        jLabel9.setForeground(colors[1]);
        jLabel10.setForeground(colors[1]);
        jLabel17.setForeground(colors[1]);
        jLabel18.setForeground(colors[1]);
        jLabel13.setForeground(colors[1]);
        jLabel14.setForeground(colors[1]);
        jLabel21.setForeground(colors[1]);
        jLabel22.setForeground(colors[1]);
        jLabel25.setForeground(colors[1]);
        jLabel26.setForeground(colors[1]);

    }

    public void setDarkTheme(Color[] colors) {
        // Background
        servicesPanel.setBackground(colors[4]);
        panelGlowingGradient1.setBackground(colors[1]);
        panelGlowingGradient2.setBackground(colors[1]);
        panelGlowingGradient3.setBackground(colors[1]);
        panelGlowingGradient4.setBackground(colors[1]);
        panelGlowingGradient5.setBackground(colors[1]);
        panelGlowingGradient6.setBackground(colors[1]);
        panelGlowingGradient1.setBackgroundLight(colors[1]);
        panelGlowingGradient2.setBackgroundLight(colors[1]);
        panelGlowingGradient3.setBackgroundLight(colors[1]);
        panelGlowingGradient4.setBackgroundLight(colors[1]);
        panelGlowingGradient5.setBackgroundLight(colors[1]);
        panelGlowingGradient6.setBackgroundLight(colors[1]);

        // Gradient Colors
        panelGlowingGradient1.setGradientColor1(colors[3]);
        panelGlowingGradient2.setGradientColor1(colors[3]);
        panelGlowingGradient3.setGradientColor1(colors[3]);
        panelGlowingGradient4.setGradientColor1(colors[3]);
        panelGlowingGradient5.setGradientColor1(colors[3]);
        panelGlowingGradient6.setGradientColor1(colors[3]);
        panelGlowingGradient1.setGradientColor2(colors[2]);
        panelGlowingGradient2.setGradientColor2(colors[2]);
        panelGlowingGradient3.setGradientColor2(colors[2]);
        panelGlowingGradient4.setGradientColor2(colors[2]);
        panelGlowingGradient5.setGradientColor2(colors[2]);
        panelGlowingGradient6.setGradientColor2(colors[2]);

        // Foreground
        jLabel4.setForeground(colors[4]);
        jLabel6.setForeground(colors[4]);
        jLabel9.setForeground(colors[4]);
        jLabel10.setForeground(colors[4]);
        jLabel17.setForeground(colors[4]);
        jLabel18.setForeground(colors[4]);
        jLabel13.setForeground(colors[4]);
        jLabel14.setForeground(colors[4]);
        jLabel21.setForeground(colors[4]);
        jLabel22.setForeground(colors[4]);
        jLabel25.setForeground(colors[4]);
        jLabel26.setForeground(colors[4]);
    }

    public void setAppControlButtons(javax.swing.JFrame frame, int xBorder) {
        appControlButtons1.setAppControl(frame, appControlButtons1.getX() + xBorder, appControlButtons1.getY());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        servicesPanel = new javax.swing.JPanel();
        appControlButtons1 = new Main.AppControlButtons();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelGlowingGradient3 = new pggb.PanelGlowingGradient();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelGlowingGradient1 = new pggb.PanelGlowingGradient();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        panelGlowingGradient2 = new pggb.PanelGlowingGradient();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        panelGlowingGradient5 = new pggb.PanelGlowingGradient();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        panelGlowingGradient6 = new pggb.PanelGlowingGradient();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        panelGlowingGradient4 = new pggb.PanelGlowingGradient();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(720, 548));
        setMinimumSize(new java.awt.Dimension(720, 548));
        setPreferredSize(new java.awt.Dimension(720, 548));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        servicesPanel.setBackground(new java.awt.Color(145, 146, 129));
        servicesPanel.setMaximumSize(new java.awt.Dimension(720, 548));
        servicesPanel.setMinimumSize(new java.awt.Dimension(720, 548));

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 2, 12)); // NOI18N
        jLabel1.setText("Exceptional service - endless possibilities  ");

        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 0, 20)); // NOI18N
        jLabel2.setText("Services and Facilities ");

        panelGlowingGradient3.setBackground(new java.awt.Color(0, 153, 255));
        panelGlowingGradient3.setBackgroundLight(new java.awt.Color(51, 153, 255));

        jLabel3.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Pet friendly");
        panelGlowingGradient3.add(jLabel3);
        jLabel3.setBounds(20, 40, 180, 30);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pet_icon.png"))); // NOI18N
        panelGlowingGradient3.add(jLabel5);
        jLabel5.setBounds(80, 70, 50, 70);

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel4.setText("our hotel.");
        panelGlowingGradient3.add(jLabel4);
        jLabel4.setBounds(40, 170, 120, 20);

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel6.setText("We allow everyone at ");
        panelGlowingGradient3.add(jLabel6);
        jLabel6.setBounds(40, 150, 160, 20);

        panelGlowingGradient1.setBackground(new java.awt.Color(0, 153, 255));
        panelGlowingGradient1.setBackgroundLight(new java.awt.Color(51, 153, 255));

        jLabel7.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Room service");
        panelGlowingGradient1.add(jLabel7);
        jLabel7.setBounds(20, 30, 180, 30);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/room_service.png"))); // NOI18N
        panelGlowingGradient1.add(jLabel8);
        jLabel8.setBounds(70, 70, 70, 70);

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel9.setText("food drink to their rooms.");
        panelGlowingGradient1.add(jLabel9);
        jLabel9.setBounds(30, 170, 170, 20);

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel10.setText("Allows guests to order ");
        panelGlowingGradient1.add(jLabel10);
        jLabel10.setBounds(40, 150, 150, 20);

        panelGlowingGradient2.setBackground(new java.awt.Color(0, 153, 255));
        panelGlowingGradient2.setBackgroundLight(new java.awt.Color(51, 153, 255));

        jLabel15.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Car rental services ");
        panelGlowingGradient2.add(jLabel15);
        jLabel15.setBounds(30, 30, 180, 30);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/car_rent.png"))); // NOI18N
        panelGlowingGradient2.add(jLabel16);
        jLabel16.setBounds(90, 70, 70, 70);

        jLabel17.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel17.setText("assosciated rental agency");
        panelGlowingGradient2.add(jLabel17);
        jLabel17.setBounds(40, 170, 170, 20);

        jLabel18.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel18.setText("Hire a car through our");
        panelGlowingGradient2.add(jLabel18);
        jLabel18.setBounds(50, 150, 160, 20);

        panelGlowingGradient5.setBackground(new java.awt.Color(0, 153, 255));
        panelGlowingGradient5.setBackgroundLight(new java.awt.Color(51, 153, 255));

        jLabel11.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Kids Activities");
        panelGlowingGradient5.add(jLabel11);
        jLabel11.setBounds(20, 30, 180, 30);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kids.png"))); // NOI18N
        panelGlowingGradient5.add(jLabel12);
        jLabel12.setBounds(80, 70, 70, 70);

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Kids pool and slide");
        panelGlowingGradient5.add(jLabel13);
        jLabel13.setBounds(50, 170, 120, 20);

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Go-carting");
        panelGlowingGradient5.add(jLabel14);
        jLabel14.setBounds(30, 150, 160, 20);

        panelGlowingGradient6.setBackground(new java.awt.Color(0, 153, 255));
        panelGlowingGradient6.setBackgroundLight(new java.awt.Color(51, 153, 255));

        jLabel19.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Reward Program");
        panelGlowingGradient6.add(jLabel19);
        jLabel19.setBounds(20, 30, 180, 30);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reward.png"))); // NOI18N
        panelGlowingGradient6.add(jLabel20);
        jLabel20.setBounds(80, 60, 70, 80);

        jLabel21.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel21.setText("member NOW!");
        panelGlowingGradient6.add(jLabel21);
        jLabel21.setBounds(60, 170, 120, 20);

        jLabel22.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel22.setText("Become a Leaders Club");
        panelGlowingGradient6.add(jLabel22);
        jLabel22.setBounds(40, 150, 160, 20);

        panelGlowingGradient4.setBackground(new java.awt.Color(0, 153, 255));
        panelGlowingGradient4.setBackgroundLight(new java.awt.Color(51, 153, 255));

        jLabel23.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Milano Tour");
        panelGlowingGradient4.add(jLabel23);
        jLabel23.setBounds(20, 30, 180, 30);

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milan.png"))); // NOI18N
        panelGlowingGradient4.add(jLabel24);
        jLabel24.setBounds(90, 70, 70, 70);

        jLabel25.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel25.setText("with our city Tour package");
        panelGlowingGradient4.add(jLabel25);
        jLabel25.setBounds(30, 170, 180, 20);

        jLabel26.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel26.setText("Enjoy beautiful Milano");
        panelGlowingGradient4.add(jLabel26);
        jLabel26.setBounds(40, 150, 160, 20);

        javax.swing.GroupLayout servicesPanelLayout = new javax.swing.GroupLayout(servicesPanel);
        servicesPanel.setLayout(servicesPanelLayout);
        servicesPanelLayout.setHorizontalGroup(
                servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(servicesPanelLayout.createSequentialGroup()
                                .addGap(215, 215, 215)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, servicesPanelLayout
                                .createSequentialGroup()
                                .addContainerGap(12, Short.MAX_VALUE)
                                .addGroup(servicesPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, servicesPanelLayout
                                                .createSequentialGroup()
                                                .addGroup(servicesPanelLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(panelGlowingGradient4,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 224,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(panelGlowingGradient1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 232,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(servicesPanelLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(servicesPanelLayout.createSequentialGroup()
                                                                .addComponent(panelGlowingGradient6,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 218,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(panelGlowingGradient5,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 218,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(servicesPanelLayout.createSequentialGroup()
                                                                .addComponent(panelGlowingGradient3,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 218,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(panelGlowingGradient2,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 236,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(24, 24, 24))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                servicesPanelLayout.createSequentialGroup()
                                                        .addComponent(jLabel2)
                                                        .addGap(253, 253, 253))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                servicesPanelLayout.createSequentialGroup()
                                                        .addComponent(appControlButtons1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 71,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(41, 41, 41)))));
        servicesPanelLayout.setVerticalGroup(
                servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(servicesPanelLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(appControlButtons1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addGroup(servicesPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(servicesPanelLayout.createSequentialGroup()
                                                .addGap(41, 41, 41)
                                                .addGroup(servicesPanelLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(panelGlowingGradient1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 224,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(panelGlowingGradient2,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 224,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(189, 189, 189)
                                                .addGroup(servicesPanelLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(panelGlowingGradient5,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 224,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(panelGlowingGradient4,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 224,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(servicesPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        225, Short.MAX_VALUE)
                                                .addComponent(panelGlowingGradient3,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 224,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(185, 185, 185)
                                                .addComponent(panelGlowingGradient6,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 224,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(81, 81, 81)))));

        jScrollPane1.setViewportView(servicesPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, 947, Short.MAX_VALUE));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Main.AppControlButtons appControlButtons1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private pggb.PanelGlowingGradient panelGlowingGradient1;
    private pggb.PanelGlowingGradient panelGlowingGradient2;
    private pggb.PanelGlowingGradient panelGlowingGradient3;
    private pggb.PanelGlowingGradient panelGlowingGradient4;
    private pggb.PanelGlowingGradient panelGlowingGradient5;
    private pggb.PanelGlowingGradient panelGlowingGradient6;
    private javax.swing.JPanel servicesPanel;
    // End of variables declaration//GEN-END:variables
}
