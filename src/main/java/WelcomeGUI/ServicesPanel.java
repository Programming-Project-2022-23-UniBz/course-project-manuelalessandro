
package WelcomeGUI;

import java.awt.Color;

public class ServicesPanel extends javax.swing.JPanel {

    public ServicesPanel() {
        initComponents();
    }

    public void setLightTheme(Color[] colors) {
        servicesPanel.setBackground(colors[3]);
    }

    public void setDarkTheme(Color[] colors) {
        servicesPanel.setBackground(colors[2]);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        servicesPanel = new javax.swing.JPanel();
        appControlButtons1 = new Main.AppControlButtons();

        setMaximumSize(new java.awt.Dimension(720, 548));
        setMinimumSize(new java.awt.Dimension(720, 548));
        setPreferredSize(new java.awt.Dimension(720, 548));

        servicesPanel.setBackground(new java.awt.Color(145, 146, 129));
        servicesPanel.setMaximumSize(new java.awt.Dimension(720, 548));
        servicesPanel.setMinimumSize(new java.awt.Dimension(720, 548));

        javax.swing.GroupLayout servicesPanelLayout = new javax.swing.GroupLayout(servicesPanel);
        servicesPanel.setLayout(servicesPanelLayout);
        servicesPanelLayout.setHorizontalGroup(
            servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, servicesPanelLayout.createSequentialGroup()
                .addContainerGap(647, Short.MAX_VALUE)
                .addComponent(appControlButtons1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        servicesPanelLayout.setVerticalGroup(
            servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(servicesPanelLayout.createSequentialGroup()
                .addComponent(appControlButtons1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 528, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(servicesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(servicesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Main.AppControlButtons appControlButtons1;
    private javax.swing.JPanel servicesPanel;
    // End of variables declaration//GEN-END:variables
}
