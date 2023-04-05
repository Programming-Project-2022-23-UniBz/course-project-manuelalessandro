
package WelcomeGUI;

import java.awt.Color;

public class AccomodationPanel extends javax.swing.JPanel {

    public AccomodationPanel() {
        initComponents();
    }

    public void setLightTheme(Color[] colors) {
        accomodationPanel.setBackground(colors[3]);
    }

    public void setDarkTheme(Color[] colors) {
        accomodationPanel.setBackground(colors[2]);
    }

    public Main.AppControlButtons getAppControlButtons() {
        return appControlButtons1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        accomodationPanel = new javax.swing.JPanel();
        appControlButtons1 = new Main.AppControlButtons();

        setMaximumSize(new java.awt.Dimension(720, 548));
        setMinimumSize(new java.awt.Dimension(720, 548));
        setPreferredSize(new java.awt.Dimension(720, 548));

        accomodationPanel.setBackground(new java.awt.Color(145, 146, 129));
        accomodationPanel.setMaximumSize(new java.awt.Dimension(720, 548));
        accomodationPanel.setMinimumSize(new java.awt.Dimension(720, 548));

        javax.swing.GroupLayout accomodationPanelLayout = new javax.swing.GroupLayout(accomodationPanel);
        accomodationPanel.setLayout(accomodationPanelLayout);
        accomodationPanelLayout.setHorizontalGroup(
            accomodationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, accomodationPanelLayout.createSequentialGroup()
                .addContainerGap(646, Short.MAX_VALUE)
                .addComponent(appControlButtons1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        accomodationPanelLayout.setVerticalGroup(
            accomodationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accomodationPanelLayout.createSequentialGroup()
                .addComponent(appControlButtons1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 528, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(accomodationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(accomodationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accomodationPanel;
    private Main.AppControlButtons appControlButtons1;
    // End of variables declaration//GEN-END:variables
}
