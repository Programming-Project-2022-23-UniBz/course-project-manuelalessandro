package WelcomeGUI;

import java.awt.Color;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class GalleryPanel extends javax.swing.JPanel {

    // Instance variables (custom)
    private javax.swing.ButtonGroup buttonGroup;
    private final String[] imgNames = new String[] { "/gallery/1.jpg", "/gallery/2.jpg", "/gallery/3.jpg",
            "/gallery/4.jpg", "/gallery/5.jpg", "/gallery/6.jpg",
            "/gallery/7.jpg", "/gallery/8.jpg", "/gallery/9.jpg", "/gallery/10.jpg" };
    private byte inc = 0;

    public GalleryPanel() {
        initComponents();

        setImage(imgNames[0]);

        // to gruop all the radio buttons relative to the images
        buttonGroup = new javax.swing.ButtonGroup();
        buttonGroup.add(radioImage1);
        buttonGroup.add(radioImage2);
        buttonGroup.add(radioImage3);
        buttonGroup.add(radioImage4);
        buttonGroup.add(radioImage5);
        buttonGroup.add(radioImage6);
        buttonGroup.add(radioImage7);
        buttonGroup.add(radioImage8);
        buttonGroup.add(radioImage9);
        buttonGroup.add(radioImage10);
    }

    public void setLightTheme(Color[] colors) {
        galleryPanel.setBackground(colors[3]);
    }

    public void setDarkTheme(Color[] colors) {
        galleryPanel.setBackground(colors[2]);
    }

    public Main.AppControlButtons getAppControlButtons() {
        return appControlButtons1;
    }

    private void setImage(String url) {
        if (url.equals(imgNames[0])) {
            radioImage1.setSelected(true);
            galleryTxtLable.setText("Reception area");
        } else if (url.equals(imgNames[1])) {
            radioImage2.setSelected(true);
            galleryTxtLable.setText("Restaurant and bar services");
        } else if (url.equals(imgNames[2])) {
            radioImage3.setSelected(true);
            galleryTxtLable.setText("Single room deluxe");
        } else if (url.equals(imgNames[3])) {
            radioImage4.setSelected(true);
            galleryTxtLable.setText("Double room deluxe");
        } else if (url.equals(imgNames[4])) {
            radioImage5.setSelected(true);
            galleryTxtLable.setText("Double room standard");
        } else if (url.equals(imgNames[5])) {
            radioImage6.setSelected(true);
            galleryTxtLable.setText("Kids area");
        } else if (url.equals(imgNames[6])) {
            radioImage7.setSelected(true);
            galleryTxtLable.setText("Sauna - Wellness & Spa");
        } else if (url.equals(imgNames[7])) {
            radioImage8.setSelected(true);
            galleryTxtLable.setText("Swimming pool");
        } else if (url.equals(imgNames[8])) {
            radioImage9.setSelected(true);
            galleryTxtLable.setText("Dining hall");
        } else if (url.equals(imgNames[9])) {
            radioImage10.setSelected(true);
            galleryTxtLable.setText("Breakfast area");
        }

        ImageIcon icon = new ImageIcon(this.getClass().getResource(url));
        icon.setImage(icon.getImage().getScaledInstance(600, 600, Image.SCALE_SMOOTH));
        imgLable.setIcon(icon);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        galleryPanel = new javax.swing.JPanel();
        imgLable = new javax.swing.JLabel();
        btnLeft = new javax.swing.JButton();
        btnRight = new javax.swing.JButton();
        radioImage1 = new javax.swing.JRadioButton();
        radioImage2 = new javax.swing.JRadioButton();
        radioImage3 = new javax.swing.JRadioButton();
        radioImage4 = new javax.swing.JRadioButton();
        radioImage5 = new javax.swing.JRadioButton();
        galleryTxtLable = new javax.swing.JLabel();
        radioImage6 = new javax.swing.JRadioButton();
        radioImage7 = new javax.swing.JRadioButton();
        radioImage8 = new javax.swing.JRadioButton();
        radioImage9 = new javax.swing.JRadioButton();
        radioImage10 = new javax.swing.JRadioButton();
        appControlButtons1 = new Main.AppControlButtons();

        setMaximumSize(new java.awt.Dimension(720, 548));
        setMinimumSize(new java.awt.Dimension(720, 548));

        galleryPanel.setBackground(new java.awt.Color(145, 146, 129));
        galleryPanel.setMaximumSize(new java.awt.Dimension(720, 548));
        galleryPanel.setMinimumSize(new java.awt.Dimension(720, 548));

        imgLable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnLeft.setFont(new java.awt.Font("Wide Latin", 1, 36)); // NOI18N
        btnLeft.setText("<");
        btnLeft.setBorderPainted(false);
        btnLeft.setContentAreaFilled(false);
        btnLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeftActionPerformed(evt);
            }
        });

        btnRight.setFont(new java.awt.Font("Wide Latin", 1, 36)); // NOI18N
        btnRight.setText(">");
        btnRight.setBorderPainted(false);
        btnRight.setContentAreaFilled(false);
        btnRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRightActionPerformed(evt);
            }
        });

        radioImage1.setContentAreaFilled(false);
        radioImage1.setFocusPainted(false);
        radioImage1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioImage1ActionPerformed(evt);
            }
        });

        radioImage2.setContentAreaFilled(false);
        radioImage2.setFocusPainted(false);
        radioImage2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioImage2ActionPerformed(evt);
            }
        });

        radioImage3.setContentAreaFilled(false);
        radioImage3.setFocusPainted(false);
        radioImage3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioImage3ActionPerformed(evt);
            }
        });

        radioImage4.setContentAreaFilled(false);
        radioImage4.setFocusPainted(false);
        radioImage4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioImage4ActionPerformed(evt);
            }
        });

        radioImage5.setContentAreaFilled(false);
        radioImage5.setFocusPainted(false);
        radioImage5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioImage5ActionPerformed(evt);
            }
        });

        galleryTxtLable.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        galleryTxtLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        radioImage6.setContentAreaFilled(false);
        radioImage6.setFocusPainted(false);
        radioImage6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioImage6ActionPerformed(evt);
            }
        });

        radioImage7.setContentAreaFilled(false);
        radioImage7.setFocusPainted(false);
        radioImage7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioImage7ActionPerformed(evt);
            }
        });

        radioImage8.setContentAreaFilled(false);
        radioImage8.setFocusPainted(false);
        radioImage8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioImage8ActionPerformed(evt);
            }
        });

        radioImage9.setContentAreaFilled(false);
        radioImage9.setFocusPainted(false);
        radioImage9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioImage9ActionPerformed(evt);
            }
        });

        radioImage10.setContentAreaFilled(false);
        radioImage10.setFocusPainted(false);
        radioImage10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioImage10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout galleryPanelLayout = new javax.swing.GroupLayout(galleryPanel);
        galleryPanel.setLayout(galleryPanelLayout);
        galleryPanelLayout.setHorizontalGroup(
            galleryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(galleryPanelLayout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(radioImage1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioImage2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioImage3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioImage4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioImage5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioImage6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioImage7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioImage8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioImage9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioImage10)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, galleryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(galleryTxtLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(galleryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imgLable, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRight, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, galleryPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(appControlButtons1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        galleryPanelLayout.setVerticalGroup(
            galleryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(galleryPanelLayout.createSequentialGroup()
                .addComponent(appControlButtons1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(galleryTxtLable, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(galleryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(galleryPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(galleryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(imgLable, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, galleryPanelLayout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(btnLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(galleryPanelLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(btnRight, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(galleryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioImage1)
                    .addComponent(radioImage2)
                    .addComponent(radioImage3)
                    .addComponent(radioImage4)
                    .addComponent(radioImage5)
                    .addComponent(radioImage6)
                    .addComponent(radioImage7)
                    .addComponent(radioImage10)
                    .addComponent(radioImage8)
                    .addComponent(radioImage9))
                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(galleryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(galleryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLeftActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLeftActionPerformed
        inc--;
        if (inc < 0)
            inc = 9;
        setImage(imgNames[inc]);
    }// GEN-LAST:event_btnLeftActionPerformed

    private void btnRightActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRightActionPerformed
        inc++;
        if (inc > 9)
            inc = 0;
        setImage(imgNames[inc]);
    }// GEN-LAST:event_btnRightActionPerformed

    private void radioImage1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radioImage1ActionPerformed
        setImage(imgNames[0]);
        inc = 0;
    }// GEN-LAST:event_radioImage1ActionPerformed

    private void radioImage2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radioImage2ActionPerformed
        setImage(imgNames[1]);
        inc = 1;
    }// GEN-LAST:event_radioImage2ActionPerformed

    private void radioImage3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radioImage3ActionPerformed
        setImage(imgNames[2]);
        inc = 2;
    }// GEN-LAST:event_radioImage3ActionPerformed

    private void radioImage4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radioImage4ActionPerformed
        setImage(imgNames[3]);
        inc = 3;
    }// GEN-LAST:event_radioImage4ActionPerformed

    private void radioImage5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radioImage5ActionPerformed
        setImage(imgNames[4]);
        inc = 4;
    }// GEN-LAST:event_radioImage5ActionPerformed

    private void radioImage6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radioImage6ActionPerformed
        setImage(imgNames[5]);
        inc = 5;
    }// GEN-LAST:event_radioImage6ActionPerformed

    private void radioImage7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radioImage7ActionPerformed
        setImage(imgNames[6]);
        inc = 6;
    }// GEN-LAST:event_radioImage7ActionPerformed

    private void radioImage8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radioImage8ActionPerformed
        setImage(imgNames[7]);
        inc = 7;
    }// GEN-LAST:event_radioImage8ActionPerformed

    private void radioImage9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radioImage9ActionPerformed
        setImage(imgNames[8]);
        inc = 8;
    }// GEN-LAST:event_radioImage9ActionPerformed

    private void radioImage10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radioImage10ActionPerformed
        setImage(imgNames[9]);
        inc = 9;
    }// GEN-LAST:event_radioImage10ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Main.AppControlButtons appControlButtons1;
    private javax.swing.JButton btnLeft;
    private javax.swing.JButton btnRight;
    private javax.swing.JPanel galleryPanel;
    private javax.swing.JLabel galleryTxtLable;
    private javax.swing.JLabel imgLable;
    private javax.swing.JRadioButton radioImage1;
    private javax.swing.JRadioButton radioImage10;
    private javax.swing.JRadioButton radioImage2;
    private javax.swing.JRadioButton radioImage3;
    private javax.swing.JRadioButton radioImage4;
    private javax.swing.JRadioButton radioImage5;
    private javax.swing.JRadioButton radioImage6;
    private javax.swing.JRadioButton radioImage7;
    private javax.swing.JRadioButton radioImage8;
    private javax.swing.JRadioButton radioImage9;
    // End of variables declaration//GEN-END:variables
}
