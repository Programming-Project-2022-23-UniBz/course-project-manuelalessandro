
package WelcomeGUI;

import java.awt.Color;

public class ReviewsPanel extends javax.swing.JPanel {

        public ReviewsPanel() {
                initComponents();
        }

        public void setLightTheme(Color[] colors) {
                // Background
                reviewsPanel.setBackground(colors[1]);

                // Foreground
        }

        public void setDarkTheme(Color[] colors) {
                // Background
                reviewsPanel.setBackground(colors[4]);

                // Foreground
        }

        public void setAppControlButtons(javax.swing.JFrame frame, int xBorder) {
                appControlButtons1.setAppControl(frame, appControlButtons1.getX() + xBorder, appControlButtons1.getY());
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                reviewsPanel = new javax.swing.JPanel();
                appControlButtons1 = new Main.AppControlButtons();

                setMaximumSize(new java.awt.Dimension(720, 548));
                setMinimumSize(new java.awt.Dimension(720, 548));

                reviewsPanel.setBackground(new java.awt.Color(145, 146, 129));
                reviewsPanel.setMaximumSize(new java.awt.Dimension(720, 548));
                reviewsPanel.setMinimumSize(new java.awt.Dimension(720, 548));

                javax.swing.GroupLayout reviewsPanelLayout = new javax.swing.GroupLayout(reviewsPanel);
                reviewsPanel.setLayout(reviewsPanelLayout);
                reviewsPanelLayout.setHorizontalGroup(
                                reviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reviewsPanelLayout
                                                                .createSequentialGroup()
                                                                .addContainerGap(647, Short.MAX_VALUE)
                                                                .addComponent(appControlButtons1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap()));
                reviewsPanelLayout.setVerticalGroup(
                                reviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(reviewsPanelLayout.createSequentialGroup()
                                                                .addComponent(appControlButtons1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 528, Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(reviewsPanel, javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addComponent(reviewsPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE)));
        }// </editor-fold>//GEN-END:initComponents

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private Main.AppControlButtons appControlButtons1;
        private javax.swing.JPanel reviewsPanel;
        // End of variables declaration//GEN-END:variables
}
