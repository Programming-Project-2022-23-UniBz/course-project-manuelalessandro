
package WelcomeGUI;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class appControlButtons extends javax.swing.JPanel {
    private ImageIcon closeLight = new ImageIcon("src/main/resources/appControl/close_light.png");
    private ImageIcon closeDark = new ImageIcon("src/main/resources/appControl/close_dark.png");
    private ImageIcon minimizeLight = new ImageIcon("src/main/resources/appControl/minimize_light.png");
    private ImageIcon minimizeDark = new ImageIcon("src/main/resources/appControl/minimize_dark.png");

    public appControlButtons() {
        initComponents();
    }

    public void setLightTheme() {
        closeLabel.setIcon(closeDark);
        minimizeLabel.setIcon(minimizeDark);
    }

    public void setDarkTheme() {
        closeLabel.setIcon(closeLight);
        minimizeLabel.setIcon(minimizeLight);
    }

    public JLabel getCloseLabel() {
        return closeLabel;
    }

    public JLabel getMinimizeLabel() {
        return minimizeLabel;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        closeLabel = new javax.swing.JLabel();
        minimizeLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 102, 51));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(57, 32));

        closeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appControl/close_dark.png"))); // NOI18N
        closeLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        minimizeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appControl/minimize_dark.png"))); // NOI18N
        minimizeLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(minimizeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(closeLabel)
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(minimizeLabel)
                                        .addComponent(closeLabel))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel closeLabel;
    private javax.swing.JLabel minimizeLabel;
    // End of variables declaration//GEN-END:variables
}
