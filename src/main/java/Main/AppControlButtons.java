
package Main;

import WelcomeGUI.WelcomeFrame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AppControlButtons extends javax.swing.JPanel {
    private ImageIcon closeLight = new ImageIcon("src/main/resources/appControl/close_light.png");
    private ImageIcon closeDark = new ImageIcon("src/main/resources/appControl/close_dark.png");
    private ImageIcon moveLight = new ImageIcon("src/main/resources/appControl/move_light.png");
    private ImageIcon moveDark = new ImageIcon("src/main/resources/appControl/move_dark.png");
    private ImageIcon minimizeLight = new ImageIcon("src/main/resources/appControl/minimize_light.png");
    private ImageIcon minimizeDark = new ImageIcon("src/main/resources/appControl/minimize_dark.png");

    public AppControlButtons() {
        initComponents();
    }

    public void setAppControl(JFrame frame) {

        closeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (frame instanceof WelcomeFrame)
                    System.exit(0);
                else
                    frame.setVisible(false);
            }
        });
        minimizeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setState(JFrame.ICONIFIED);
            }
        });

    }

    public void setLightTheme() {
        closeLabel.setIcon(closeDark);
        moveLabel.setIcon(moveDark);
        minimizeLabel.setIcon(minimizeDark);
    }

    public void setDarkTheme() {
        closeLabel.setIcon(closeLight);
        moveLabel.setIcon(moveLight);
        minimizeLabel.setIcon(minimizeLight);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        closeLabel = new javax.swing.JLabel();
        moveLabel = new javax.swing.JLabel();
        minimizeLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 102, 51));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(83, 20));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        closeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appControl/close_dark.png"))); // NOI18N
        closeLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(closeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, -1));

        moveLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appControl/move_dark.png"))); // NOI18N
        moveLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(moveLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        minimizeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appControl/minimize_dark.png"))); // NOI18N
        minimizeLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(minimizeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 20));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel closeLabel;
    private javax.swing.JLabel minimizeLabel;
    private javax.swing.JLabel moveLabel;
    // End of variables declaration//GEN-END:variables
}
