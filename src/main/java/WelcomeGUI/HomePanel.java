
package WelcomeGUI;

import java.awt.Color;

public class HomePanel extends javax.swing.JPanel {

        public HomePanel() {
                initComponents();
        }

        public void setLightTheme(Color[] colors) {
                // Background
                homePanel.setBackground(colors[1]);

                // Foreground
                titleLabel1.setForeground(colors[0]);
                titleLabel2.setForeground(colors[0]);
        }

        public void setDarkTheme(Color[] colors) {
                // Background
                homePanel.setBackground(colors[4]);

                // Foreground
                titleLabel1.setForeground(colors[1]);
                titleLabel2.setForeground(colors[1]);
        }

        public void setAppControlButtons(javax.swing.JFrame frame, int xBorder) {
                appControlButtons1.setAppControl(frame, appControlButtons1.getX() + xBorder, appControlButtons1.getY());
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                homePanel = new javax.swing.JPanel();
                homeImageLabel = new javax.swing.JLabel();
                titleLabel2 = new javax.swing.JLabel();
                titleLabel1 = new javax.swing.JLabel();
                appControlButtons1 = new DesignObjects.AppControlButtons();

                setMaximumSize(new java.awt.Dimension(720, 548));
                setMinimumSize(new java.awt.Dimension(720, 548));
                setPreferredSize(new java.awt.Dimension(720, 548));

                homePanel.setBackground(new java.awt.Color(145, 146, 129));

                homeImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exterior1.jpg"))); // NOI18N
                homeImageLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                homeImageLabel.setMaximumSize(new java.awt.Dimension(800, 600));
                homeImageLabel.setMinimumSize(new java.awt.Dimension(800, 600));
                homeImageLabel.setName(""); // NOI18N
                homeImageLabel.setPreferredSize(new java.awt.Dimension(800, 600));

                titleLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
                titleLabel2.setForeground(new java.awt.Color(51, 51, 51));
                titleLabel2.setText("Adler Palace Hotel");

                titleLabel1.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
                titleLabel1.setText("Welcome to");

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
                                                                                                .addComponent(titleLabel2)))
                                                                .addContainerGap(71, Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePanelLayout
                                                                .createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addGroup(homePanelLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                homePanelLayout.createSequentialGroup()
                                                                                                                .addComponent(titleLabel1,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                133,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGap(271, 271,
                                                                                                                                271))
                                                                                .addComponent(appControlButtons1,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                72,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))));
                homePanelLayout.setVerticalGroup(
                                homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePanelLayout
                                                                .createSequentialGroup()
                                                                .addComponent(appControlButtons1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                12, Short.MAX_VALUE)
                                                                .addComponent(titleLabel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                16,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(titleLabel2)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(homeImageLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                400,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(33, 33, 33)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(homePanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(homePanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE));
        }// </editor-fold>//GEN-END:initComponents

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private DesignObjects.AppControlButtons appControlButtons1;
        private javax.swing.JLabel homeImageLabel;
        private javax.swing.JPanel homePanel;
        private javax.swing.JLabel titleLabel1;
        private javax.swing.JLabel titleLabel2;
        // End of variables declaration//GEN-END:variables
}
