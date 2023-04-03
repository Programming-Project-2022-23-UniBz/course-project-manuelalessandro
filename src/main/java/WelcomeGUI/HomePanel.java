
package WelcomeGUI;

import java.awt.Color;
import javax.swing.JFrame;

public class HomePanel extends javax.swing.JPanel {

    public HomePanel() {
        initComponents();
    }
    
    public void setAppControl(JFrame frame){
        appControlButtons1.setAppControl(frame);
    }

    public void setLightTheme(Color[] colors) {
        homePanel.setBackground(colors[3]);
    }

    public void setDarkTheme(Color[] colors) {
        homePanel.setBackground(colors[2]);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        homePanel = new javax.swing.JPanel();
        homeImageLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        appControlButtons1 = new Main.AppControlButtons();

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
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(homePanelLayout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(homeImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(homePanelLayout.createSequentialGroup()
                                .addGap(209, 209, 209)
                                .addComponent(jLabel4)))
                        .addGap(0, 64, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(208, 208, 208)
                        .addComponent(appControlButtons1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePanelLayout.createSequentialGroup()
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addContainerGap(30, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(appControlButtons1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(homeImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 719, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(homePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(homePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Main.AppControlButtons appControlButtons1;
    private javax.swing.JLabel homeImageLabel;
    private javax.swing.JPanel homePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
