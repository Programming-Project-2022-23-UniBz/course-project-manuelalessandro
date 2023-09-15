/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserGUI;

import java.util.Date;

import javax.swing.JOptionPane;

import Objects.User;
import Objects.User.GenderType;

/**
 * This class represents a panel for managing user account information in a GUI
 * application.
 * 
 * @Author: ManuelVillotti
 */
public class UserAccountPanel extends javax.swing.JPanel {

        private User user;

        /**
         * Creates new form UserAccountPanel
         */
        public UserAccountPanel() {
                initComponents();
        }

        /**
         * Sets the current user for the user account panel.
         * 
         * @param user The user to set.
         */
        public void setUser(User user) {
                this.user = user;
        }

        /**
         * Sets the app control buttons for the panel.
         * 
         * @param frame   The JFrame containing the app controls.
         * @param xBorder The x-coordinate border for the app controls.
         */
        public void setAppControlButtons(javax.swing.JFrame frame, int xBorder) {
                appControlButtons.setAppControl(frame, appControlButtons.getX() + xBorder, appControlButtons.getY());
        }

        /**
         * Refreshes the displayed user information on the panel.
         * If the user is not identified, it displays an error message.
         */
        public void refreshInfos() {
                if (user != null) {
                        errorLabel.setText("");
                        nameField.setText(user.getName());
                        surnameField.setText(user.getSurname());
                        usernameField.setText(user.getUsername());
                        birthField.setDate(user.getDateOfBirth());
                        emailField.setText(user.getEmail());
                        passField1.setText("");
                        passField2.setText("");
                        GenderType gender = user.getGender();
                        if (gender != null) {
                                if (gender.equals(GenderType.MAN))
                                        genderComboBox.setSelectedItem("Man");
                                else if (gender.equals(GenderType.WOMAN))
                                        genderComboBox.setSelectedItem("Woman");
                                else
                                        genderComboBox.setSelectedItem("Other");
                        }
                } else {
                        errorLabel.setText("Your account was not identified, please restart the application");
                        System.out.println("-- User is null");
                }
        }

        /**
         * Applies changes made to user account information.
         * Validates the input fields and updates user information accordingly.
         */
        private void applyChanges() {
                try {
                        String name = nameField.getText();
                        System.out.println("\n\n name: " + name);
                        String surname = surnameField.getText();
                        String username = usernameField.getText();
                        Date birth = birthField.getDate();
                        String email = emailField.getText();
                        String pass1 = new String(passField1.getPassword());
                        String pass2 = new String(passField2.getPassword());
                        GenderType gender;

                        if (genderComboBox.getSelectedItem().equals("Man"))
                                gender = GenderType.MAN;
                        else if (genderComboBox.getSelectedItem().equals("Woman"))
                                gender = GenderType.WOMAN;
                        else
                                gender = GenderType.OTHER;

                        if (!User.nameValid(name, surname))
                                throw new Exception("Name or surname is invalid!");
                        else if (!user.getUsername().equals(username) && !User.usernameValid(username))
                                throw new Exception("Username is invalid!");
                        else if (!user.getEmail().equals(email)) {
                                if (!User.emailValid(email))
                                        throw new Exception("Email is invalid!");
                        } else if (pass1 != null && pass1.length() > 5 && !User.passwordValid(pass1, pass2)) {
                                // Show password requirements
                                JOptionPane.showMessageDialog(this,
                                                User.getPasswordRequirements(),
                                                "Password requirements",
                                                JOptionPane.WARNING_MESSAGE);

                                throw new Exception("Password is invalid!");
                        } else if (!User.birthDateValid(birth))
                                throw new Exception("Birthdate is invalid!");
                        else {
                                user.setName(name);
                                user.setSurname(surname);
                                user.setUsername(username);
                                user.setDateOfBirth(birth);
                                user.setGender(gender);
                                user.setEmail(email);
                                if (pass1 != null) // if pass1 is null than don't change
                                        user.setPassword(pass1);

                                user.pushChanges(); // used to push changes in json

                                JOptionPane.showMessageDialog(this,
                                                "You account was edited successfully", "",
                                                JOptionPane.WARNING_MESSAGE);

                        }
                } catch (Exception e) {
                        errorLabel.setText("Error: " + e.getMessage());
                        e.printStackTrace();
                }
                refreshInfos();
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                accountPanel = new javax.swing.JPanel();
                applyChangesButton = new javax.swing.JButton();
                genderLabel = new javax.swing.JLabel();
                discardChangesButton = new javax.swing.JButton();
                titleTxt = new javax.swing.JLabel();
                genderComboBox = new javax.swing.JComboBox<>();
                passLabel2 = new javax.swing.JLabel();
                checkInLabel = new javax.swing.JLabel();
                birthField = new com.toedter.calendar.JDateChooser();
                appControlButtons = new DesignObjects.AppControlButtons();
                nameLabel = new javax.swing.JLabel();
                nameField = new javax.swing.JTextField();
                emailLabel = new javax.swing.JLabel();
                emailField = new javax.swing.JTextField();
                passLabel1 = new javax.swing.JLabel();
                surnameLabel = new javax.swing.JLabel();
                surnameField = new javax.swing.JTextField();
                passField2 = new javax.swing.JPasswordField();
                passField1 = new javax.swing.JPasswordField();
                errorLabel = new javax.swing.JLabel();
                usernameLabel = new javax.swing.JLabel();
                usernameField = new javax.swing.JTextField();

                setMaximumSize(new java.awt.Dimension(3231311, 123131));

                accountPanel.setBackground(new java.awt.Color(255, 255, 255));
                accountPanel.setMaximumSize(new java.awt.Dimension(3231311, 123131));
                accountPanel.setMinimumSize(new java.awt.Dimension(0, 0));

                applyChangesButton.setBackground(new java.awt.Color(0, 153, 102));
                applyChangesButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                applyChangesButton.setForeground(new java.awt.Color(255, 255, 255));
                applyChangesButton.setText("Apply changes");
                applyChangesButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                applyChangesButtonActionPerformed(evt);
                        }
                });

                genderLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
                genderLabel.setForeground(new java.awt.Color(0, 0, 255));
                genderLabel.setText("Gender");

                discardChangesButton.setBackground(new java.awt.Color(255, 102, 51));
                discardChangesButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                discardChangesButton.setForeground(new java.awt.Color(255, 255, 255));
                discardChangesButton.setText("Discard changes");
                discardChangesButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                discardChangesButtonActionPerformed(evt);
                        }
                });

                titleTxt.setBackground(new java.awt.Color(255, 255, 255));
                titleTxt.setFont(new java.awt.Font("Yu Gothic UI", 1, 25)); // NOI18N
                titleTxt.setForeground(new java.awt.Color(102, 153, 255));
                titleTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                titleTxt.setText("Account information");

                genderComboBox.setModel(
                                new javax.swing.DefaultComboBoxModel<>(new String[] { "Man", "Woman", "Other" }));
                genderComboBox.setSelectedItem("Other");
                genderComboBox.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                genderComboBoxActionPerformed(evt);
                        }
                });

                passLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
                passLabel2.setForeground(new java.awt.Color(0, 0, 255));
                passLabel2.setText("Confirm password");

                checkInLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
                checkInLabel.setForeground(new java.awt.Color(0, 0, 255));
                checkInLabel.setText("Date of birth");

                nameLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
                nameLabel.setForeground(new java.awt.Color(0, 0, 255));
                nameLabel.setText("Name");

                nameField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
                nameField.setForeground(new java.awt.Color(0, 0, 0));
                nameField.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                nameFieldActionPerformed(evt);
                        }
                });

                emailLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
                emailLabel.setForeground(new java.awt.Color(0, 0, 255));
                emailLabel.setText("Email");

                emailField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
                emailField.setForeground(new java.awt.Color(0, 0, 0));
                emailField.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                emailFieldActionPerformed(evt);
                        }
                });

                passLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
                passLabel1.setForeground(new java.awt.Color(0, 0, 255));
                passLabel1.setText("New password");

                surnameLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
                surnameLabel.setForeground(new java.awt.Color(0, 0, 255));
                surnameLabel.setText("Surname");

                surnameField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
                surnameField.setForeground(new java.awt.Color(0, 0, 0));
                surnameField.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                surnameFieldActionPerformed(evt);
                        }
                });

                passField2.setText("test");

                passField1.setText("test");

                errorLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
                errorLabel.setForeground(new java.awt.Color(255, 51, 51));
                errorLabel.setText("Error Message");

                usernameLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
                usernameLabel.setForeground(new java.awt.Color(0, 0, 255));
                usernameLabel.setText("Username");

                usernameField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
                usernameField.setForeground(new java.awt.Color(0, 0, 0));
                usernameField.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                usernameFieldActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout accountPanelLayout = new javax.swing.GroupLayout(accountPanel);
                accountPanel.setLayout(accountPanelLayout);
                accountPanelLayout.setHorizontalGroup(
                                accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(accountPanelLayout.createSequentialGroup()
                                                                .addGap(38, 38, 38)
                                                                .addGroup(accountPanelLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(accountPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(titleTxt)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(appControlButtons,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                74,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                accountPanelLayout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGroup(accountPanelLayout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addGroup(accountPanelLayout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addGroup(accountPanelLayout
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                                .addGroup(accountPanelLayout
                                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                                                                accountPanelLayout
                                                                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                                                                                                .addComponent(birthField,
                                                                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                                                                                accountPanelLayout
                                                                                                                                                                                                                                                .createSequentialGroup()
                                                                                                                                                                                                                                                .addComponent(checkInLabel,
                                                                                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                                                                                101,
                                                                                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                                                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                                                                                                                                                .addComponent(discardChangesButton,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                172,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                                                .addComponent(surnameField,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                169,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                .addComponent(surnameLabel,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                91,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                .addComponent(nameField,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                169,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                .addComponent(nameLabel,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                91,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                                .addGap(40, 40, 40))
                                                                                                                                .addGroup(accountPanelLayout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addGroup(accountPanelLayout
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                                .addComponent(usernameField,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                169,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                .addComponent(usernameLabel,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                91,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                                .addPreferredGap(
                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                Short.MAX_VALUE)))
                                                                                                                .addGroup(accountPanelLayout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                false)
                                                                                                                                .addComponent(genderLabel,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                79,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(emailLabel,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                91,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(passLabel1,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                91,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(applyChangesButton,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addComponent(genderComboBox,
                                                                                                                                                0,
                                                                                                                                                169,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addComponent(emailField)
                                                                                                                                .addComponent(passField2)
                                                                                                                                .addComponent(passField1)
                                                                                                                                .addComponent(passLabel2))
                                                                                                                .addGap(25, 25, 25)))
                                                                .addContainerGap())
                                                .addGroup(accountPanelLayout.createSequentialGroup()
                                                                .addGap(27, 27, 27)
                                                                .addComponent(errorLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                401,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(22, Short.MAX_VALUE)));
                accountPanelLayout.setVerticalGroup(
                                accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(accountPanelLayout.createSequentialGroup()
                                                                .addGroup(accountPanelLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(accountPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addContainerGap()
                                                                                                .addComponent(appControlButtons,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(accountPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(19, 19, 19)
                                                                                                .addComponent(titleTxt)))
                                                                .addGap(12, 12, 12)
                                                                .addGroup(accountPanelLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(accountPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(nameLabel)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(nameField,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(accountPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(genderLabel)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(genderComboBox,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(6, 6, 6)
                                                                .addGroup(accountPanelLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addGroup(accountPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(surnameLabel)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(surnameField,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(usernameLabel)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(usernameField,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(checkInLabel)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(birthField,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                22,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(accountPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(emailLabel)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(emailField,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(passLabel1)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(passField1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(passLabel2)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(passField2,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(accountPanelLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(applyChangesButton,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                36,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(discardChangesButton,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                36,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(errorLabel)
                                                                .addContainerGap(25, Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(accountPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(accountPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        }// </editor-fold>//GEN-END:initComponents

        private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_usernameFieldActionPerformed
        }// GEN-LAST:event_usernameFieldActionPerformed

        private void applyChangesButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_applyChangesButtonActionPerformed
                int dialogResult = JOptionPane.showOptionDialog(this,
                                "Are you sure you want to edit your infos?", "Confirmation", JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE, null,
                                new Object[] { "No", "Yes" }, "No");
                if (dialogResult == 1)
                        applyChanges();
        }// GEN-LAST:event_applyChangesButtonActionPerformed

        private void discardChangesButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_discardChangesButtonActionPerformed
                refreshInfos();
        }// GEN-LAST:event_discardChangesButtonActionPerformed

        private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_nameFieldActionPerformed
        }// GEN-LAST:event_nameFieldActionPerformed

        private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_emailFieldActionPerformed
        }// GEN-LAST:event_emailFieldActionPerformed

        private void genderComboBoxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_genderComboBoxActionPerformed
        }// GEN-LAST:event_genderComboBoxActionPerformed

        private void surnameFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_surnameFieldActionPerformed
        }// GEN-LAST:event_surnameFieldActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JPanel accountPanel;
        private DesignObjects.AppControlButtons appControlButtons;
        private javax.swing.JButton applyChangesButton;
        private com.toedter.calendar.JDateChooser birthField;
        private javax.swing.JLabel checkInLabel;
        private javax.swing.JButton discardChangesButton;
        private javax.swing.JTextField emailField;
        private javax.swing.JLabel emailLabel;
        private javax.swing.JLabel errorLabel;
        private javax.swing.JComboBox<String> genderComboBox;
        private javax.swing.JLabel genderLabel;
        private javax.swing.JTextField nameField;
        private javax.swing.JLabel nameLabel;
        private javax.swing.JPasswordField passField1;
        private javax.swing.JPasswordField passField2;
        private javax.swing.JLabel passLabel1;
        private javax.swing.JLabel passLabel2;
        private javax.swing.JTextField surnameField;
        private javax.swing.JLabel surnameLabel;
        private javax.swing.JLabel titleTxt;
        private javax.swing.JTextField usernameField;
        private javax.swing.JLabel usernameLabel;
        // End of variables declaration//GEN-END:variables
}
