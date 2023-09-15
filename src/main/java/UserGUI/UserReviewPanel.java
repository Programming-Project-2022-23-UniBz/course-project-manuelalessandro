/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserGUI;

import Objects.User;

import javax.swing.JOptionPane;

/**
 *
 * @author mamu8
 */
public class UserReviewPanel extends javax.swing.JPanel {

        private User user;
        private UserFrame frame;

        /**
         * Creates new form UserReviewPanel
         */
        public UserReviewPanel() {
                initComponents();
        }

        /**
         * The function sets the position of the app control buttons on a JFrame.
         * 
         * @param frame   The "frame" parameter is a reference to a JFrame object. It is
         *                casted to a
         *                UserFrame object in the code.
         * @param xBorder The xBorder parameter is an integer value that represents the
         *                amount by which
         *                the x-coordinate of the appControlButtons should be adjusted.
         */
        public void setAppControlButtons(javax.swing.JFrame frame, int xBorder) {
                this.frame = (UserFrame) frame;
                appControlButtons.setAppControl(frame, appControlButtons.getX() + xBorder, appControlButtons.getY());
        }

        public void refreshInfos() {
                this.errorLabel.setText("");
                String review = "";
                int rating = 0;
                if (this.user.hasReview()) {
                        this.confirmButton.setText("Update");
                        review = user.getReview();
                        rating = user.getRating();
                        this.ratingComboBox.setSelectedItem(rating);
                        this.textField.setText(review);
                } else {
                        this.confirmButton.setText("Confirm");
                        this.ratingComboBox.setSelectedIndex(0);
                        this.textField.setText("");
                }

                // refresh also infos on the WelcomeFrame
                try {
                        frame.refreshWelcomeReviews();
                } catch (Exception e) {
                        System.out.println("Refresh of welcome review frame failed: " + e.getMessage());
                }
        }

        public void setUser(User user) {
                this.user = user;
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                reviewPanel = new javax.swing.JPanel();
                confirmButton = new javax.swing.JButton();
                ratingLabel = new javax.swing.JLabel();
                deleteButton = new javax.swing.JButton();
                titleLabel = new javax.swing.JLabel();
                appControlButtons = new DesignObjects.AppControlButtons();
                textLabel = new javax.swing.JLabel();
                textField = new javax.swing.JTextField();
                errorLabel = new javax.swing.JLabel();
                ratingComboBox = new javax.swing.JComboBox<>();

                setPreferredSize(new java.awt.Dimension(459, 361));

                reviewPanel.setBackground(new java.awt.Color(255, 255, 255));
                reviewPanel.setMaximumSize(new java.awt.Dimension(3231311, 123131));
                reviewPanel.setPreferredSize(new java.awt.Dimension(459, 361));

                confirmButton.setBackground(new java.awt.Color(0, 153, 102));
                confirmButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                confirmButton.setForeground(new java.awt.Color(255, 255, 255));
                confirmButton.setText("Confirm");
                confirmButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                confirmButtonActionPerformed(evt);
                        }
                });

                ratingLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
                ratingLabel.setForeground(new java.awt.Color(0, 0, 255));
                ratingLabel.setText("Rating:");

                deleteButton.setBackground(new java.awt.Color(255, 102, 51));
                deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                deleteButton.setForeground(new java.awt.Color(255, 255, 255));
                deleteButton.setText("Delete");
                deleteButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                deleteButtonActionPerformed(evt);
                        }
                });

                titleLabel.setBackground(new java.awt.Color(255, 255, 255));
                titleLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 25)); // NOI18N
                titleLabel.setForeground(new java.awt.Color(102, 153, 255));
                titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                titleLabel.setText("Write a review");

                textLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
                textLabel.setForeground(new java.awt.Color(0, 0, 255));
                textLabel.setText("Text:");

                textField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
                textField.setForeground(new java.awt.Color(0, 0, 0));
                textField.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                textFieldActionPerformed(evt);
                        }
                });

                errorLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
                errorLabel.setForeground(new java.awt.Color(255, 51, 51));
                errorLabel.setText("Error Message");

                ratingComboBox.setModel(
                                new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
                ratingComboBox.setSelectedIndex(4);

                javax.swing.GroupLayout reviewPanelLayout = new javax.swing.GroupLayout(reviewPanel);
                reviewPanel.setLayout(reviewPanelLayout);
                reviewPanelLayout.setHorizontalGroup(
                                reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(reviewPanelLayout.createSequentialGroup()
                                                                .addGap(38, 38, 38)
                                                                .addGroup(reviewPanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(reviewPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(titleLabel)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(appControlButtons,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                74,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(reviewPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(reviewPanelLayout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                false)
                                                                                                                .addGroup(reviewPanelLayout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(deleteButton,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                172,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addComponent(confirmButton,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                172,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addGroup(reviewPanelLayout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(textField,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                371,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(textLabel,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                91,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGroup(reviewPanelLayout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addComponent(ratingLabel,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                79,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addPreferredGap(
                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                .addComponent(ratingComboBox,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                .addComponent(errorLabel,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                348,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                .addGap(0, 44, Short.MAX_VALUE)))
                                                                .addContainerGap()));
                reviewPanelLayout.setVerticalGroup(
                                reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(reviewPanelLayout.createSequentialGroup()
                                                                .addGroup(reviewPanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(reviewPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addContainerGap()
                                                                                                .addComponent(appControlButtons,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(reviewPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(19, 19, 19)
                                                                                                .addComponent(titleLabel)))
                                                                .addGap(29, 29, 29)
                                                                .addGroup(
                                                                                reviewPanelLayout.createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(ratingLabel)
                                                                                                .addComponent(ratingComboBox,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(textLabel)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(textField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                112,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(reviewPanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(confirmButton,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                23,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(deleteButton))
                                                                .addGap(35, 35, 35)
                                                                .addComponent(errorLabel)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(reviewPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(reviewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 362,
                                                                Short.MAX_VALUE));
        }// </editor-fold>//GEN-END:initComponents

        private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_confirmButtonActionPerformed
                String buttonText = confirmButton.getText();

                if ("Confirm".equals(buttonText)) {
                        int rating = this.ratingComboBox.getSelectedIndex() + 1;
                        String review = this.textField.getText();
                        this.user.addReview(review, rating);
                        JOptionPane.showMessageDialog(null, "Review added correctly", "Success",
                                        JOptionPane.INFORMATION_MESSAGE);
                } else if ("Update".equals(buttonText)) {
                        user.removeReview(user.getReview());
                        int rating = this.ratingComboBox.getSelectedIndex() + 1;
                        String review = this.textField.getText();
                        user.addReview(review, rating);
                }
                refreshInfos();
        }// GEN-LAST:event_confirmButtonActionPerformed

        private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_deleteButtonActionPerformed
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this review?",
                                "Delete Review", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                        user.removeReview(user.getReview());
                        this.errorLabel.setText("Review Removed");
                        refreshInfos();
                } else {
                        return;
                }
        }

        private void textFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_textFieldActionPerformed
        }// GEN-LAST:event_textFieldActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private DesignObjects.AppControlButtons appControlButtons;
        private javax.swing.JButton confirmButton;
        private javax.swing.JButton deleteButton;
        private javax.swing.JLabel errorLabel;
        private javax.swing.JComboBox<String> ratingComboBox;
        private javax.swing.JLabel ratingLabel;
        private javax.swing.JPanel reviewPanel;
        private javax.swing.JTextField textField;
        private javax.swing.JLabel textLabel;
        private javax.swing.JLabel titleLabel;
        // End of variables declaration//GEN-END:variables
}
