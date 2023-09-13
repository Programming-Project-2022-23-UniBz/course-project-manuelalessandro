/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import Objects.GeneralController;
import Objects.User;
import Objects.User.GenderType;
import UserGUI.UserFrame;

import java.awt.CardLayout;
import java.util.Date;

import javax.swing.JOptionPane;

import AdminGUI.AdminFrame;

/**
 *
 * @author mamu8
 */
public class LoginFrame extends javax.swing.JFrame {

        private CardLayout cardLayout;

        public enum Card {
                LOGIN, REGISTER
        };

        /**
         * Creates new form LoginTEST
         */
        public LoginFrame() {
                initComponents();
                setLocationRelativeTo(null);// center position of JFrame
                setResizable(false);

                cardLayout = (CardLayout) cardPanel.getLayout();
                buttonCardAction(Card.LOGIN);

                appControlButtons1.setAppControl(this, appControlButtons1.getX(), appControlButtons1.getY());
                appControlButtons2.setAppControl(this, appControlButtons2.getX(), appControlButtons2.getY());

                registerErrorLabel.setText("");
                loginErrorLabel.setText("");

        }

        public boolean loginUser(String username, String password) {
                // String username = loginUsernameField.getText();
                // String password = new String(loginPassField.getPassword());

                try {
                        // searching for user that logged in
                        User user = GeneralController.searchUser(username, password);
                        String userRole = user.getRole();

                        if (userRole.equals("admin")) {
                                AdminFrame frame = new AdminFrame();
                                frame.setVisible(true);
                        } else {
                                UserFrame frame = new UserFrame(user);
                                frame.setVisible(true);
                        }
                        this.dispose();
                        return true;
                } catch (Exception exception) {
                        loginErrorLabel.setText("Error: invalid username or password");
                        exception.printStackTrace();
                        return false;
                }
        }

        public boolean registerUser(String name, String surname, String username, Date birth, String email,
                        String pass1,
                        String pass2) {
                try {
                        /*
                         * String name = nameField.getText();
                         * String surname = surnameField.getText();
                         * String username = usernameField.getText();
                         * Date birth = birthField.getDate();
                         * String email = emailField.getText();
                         * String pass1 = new String(passField1.getPassword());
                         * String pass2 = new String(passField2.getPassword());
                         */
                        GenderType gender;

                        if (genderComboBox.getSelectedItem().equals("Man"))
                                gender = GenderType.MAN;
                        else if (genderComboBox.getSelectedItem().equals("Woman"))
                                gender = GenderType.WOMAN;
                        else
                                gender = GenderType.OTHER;

                        if (!User.nameValid(name, surname))
                                throw new Exception("Name or surname is invalid! (First letter has to be capital)");
                        else if (!User.usernameValid(username))
                                throw new Exception("Username already in use!");
                        else if (!User.emailValid(email))
                                throw new Exception("Email is invalid!");
                        else if (pass1 != null && !User.passwordValid(pass1, pass2)) {

                                // Show password requirements
                                JOptionPane.showMessageDialog(this,
                                                User.getPasswordRequirements(),
                                                "Password requirements",
                                                JOptionPane.WARNING_MESSAGE);

                                throw new Exception("Password is invalid!");
                        } else if (!User.birthDateValid(birth))
                                throw new Exception("Birthdate is invalid!");
                        else {

                                User user = new User(name, surname, username, birth, gender, email, pass1, "user");

                                GeneralController.addUser(user);

                                this.dispose(); // to close this Frame
                                return true; // user registered successfully
                        }
                } catch (Exception e) {
                        registerErrorLabel.setText("Error: " + e.getMessage());
                        e.printStackTrace();
                        return false; // user registration failed
                }
        }

        private void buttonCardAction(Card card) {
                if (card.equals(Card.REGISTER))
                        cardLayout.show(cardPanel, "register");
                else
                        cardLayout.show(cardPanel, "login");
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

                cardPanel = new javax.swing.JPanel();
                registerPanel = new javax.swing.JPanel();
                nameLabel = new javax.swing.JLabel();
                genderLabel = new javax.swing.JLabel();
                genderComboBox = new javax.swing.JComboBox<>();
                surnameLabel = new javax.swing.JLabel();
                surnameField = new javax.swing.JTextField();
                emailLabel = new javax.swing.JLabel();
                emailField = new javax.swing.JTextField();
                passLabel1 = new javax.swing.JLabel();
                passField1 = new javax.swing.JPasswordField();
                usernameLabel = new javax.swing.JLabel();
                usernameField = new javax.swing.JTextField();
                checkInLabel = new javax.swing.JLabel();
                birthField = new com.toedter.calendar.JDateChooser();
                passLabel2 = new javax.swing.JLabel();
                passField2 = new javax.swing.JPasswordField();
                registerButton = new javax.swing.JButton();
                returnToLoginButton = new javax.swing.JButton();
                nameField = new javax.swing.JTextField();
                registerErrorLabel = new javax.swing.JLabel();
                appControlButtons1 = new DesignObjects.AppControlButtons();
                loginPanel = new javax.swing.JPanel();
                usernameLabel1 = new javax.swing.JLabel();
                loginUsernameField = new javax.swing.JTextField();
                passLabel3 = new javax.swing.JLabel();
                loginPassField = new javax.swing.JPasswordField();
                loginButton = new javax.swing.JButton();
                loginRegisterButton = new javax.swing.JButton();
                registerLabel = new javax.swing.JLabel();
                loginErrorLabel = new javax.swing.JLabel();
                appControlButtons2 = new DesignObjects.AppControlButtons();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setUndecorated(true);

                cardPanel.setLayout(new java.awt.CardLayout());

                registerPanel.setBackground(new java.awt.Color(255, 255, 255));

                nameLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
                nameLabel.setForeground(new java.awt.Color(0, 0, 255));
                nameLabel.setText("Name");

                genderLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
                genderLabel.setForeground(new java.awt.Color(0, 0, 255));
                genderLabel.setText("Gender");

                genderComboBox.setModel(
                                new javax.swing.DefaultComboBoxModel<>(new String[] { "Man", "Woman", "Other" }));
                genderComboBox.setSelectedItem("Other");
                genderComboBox.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                genderComboBoxActionPerformed(evt);
                        }
                });

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

                checkInLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
                checkInLabel.setForeground(new java.awt.Color(0, 0, 255));
                checkInLabel.setText("Date of birth");

                passLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
                passLabel2.setForeground(new java.awt.Color(0, 0, 255));
                passLabel2.setText("Confirm password");

                registerButton.setBackground(new java.awt.Color(0, 153, 102));
                registerButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                registerButton.setForeground(new java.awt.Color(255, 255, 255));
                registerButton.setText("Register");
                registerButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                registerButtonActionPerformed(evt);
                        }
                });

                returnToLoginButton.setBackground(new java.awt.Color(0, 0, 255));
                returnToLoginButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                returnToLoginButton.setForeground(new java.awt.Color(255, 255, 255));
                returnToLoginButton.setText("Return to login");
                returnToLoginButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                returnToLoginButtonActionPerformed(evt);
                        }
                });

                nameField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
                nameField.setForeground(new java.awt.Color(0, 0, 0));
                nameField.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                nameFieldActionPerformed(evt);
                        }
                });

                registerErrorLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
                registerErrorLabel.setForeground(new java.awt.Color(255, 51, 51));
                registerErrorLabel.setText("Error Message");

                javax.swing.GroupLayout registerPanelLayout = new javax.swing.GroupLayout(registerPanel);
                registerPanel.setLayout(registerPanelLayout);
                registerPanelLayout.setHorizontalGroup(
                                registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(registerPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(registerPanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(registerPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(nameField,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                169,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(0, 232, Short.MAX_VALUE))
                                                                                .addComponent(registerErrorLabel,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                registerPanelLayout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                                                .addComponent(appControlButtons1,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addContainerGap())
                                                .addGroup(registerPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(registerPanelLayout.createSequentialGroup()
                                                                                .addContainerGap()
                                                                                .addGroup(registerPanelLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addGroup(registerPanelLayout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGroup(registerPanelLayout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(surnameLabel,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                91,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(nameLabel,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                91,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(usernameLabel,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                91,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE))
                                                                                                .addGroup(registerPanelLayout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGroup(registerPanelLayout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                false)
                                                                                                                                .addComponent(surnameField,
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(usernameField,
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(birthField,
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addComponent(checkInLabel,
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                101,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(returnToLoginButton,
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                172,
                                                                                                                                                Short.MAX_VALUE))
                                                                                                                .addGap(0, 40, Short.MAX_VALUE)))
                                                                                .addGroup(registerPanelLayout
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
                                                                                                .addComponent(registerButton,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(genderComboBox,
                                                                                                                0, 169,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(emailField)
                                                                                                .addComponent(passField2)
                                                                                                .addComponent(passField1)
                                                                                                .addComponent(passLabel2))
                                                                                .addContainerGap())));
                registerPanelLayout.setVerticalGroup(
                                registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(registerPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(appControlButtons1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                30,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(43, 43, 43)
                                                                .addComponent(nameField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                218,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(registerErrorLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                41,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(15, 15, 15))
                                                .addGroup(registerPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(registerPanelLayout.createSequentialGroup()
                                                                                .addGap(56, 56, 56)
                                                                                .addGroup(registerPanelLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(nameLabel)
                                                                                                .addGroup(registerPanelLayout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(genderLabel)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(genderComboBox,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addGap(6, 6, 6)
                                                                                .addGroup(registerPanelLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                false)
                                                                                                .addGroup(registerPanelLayout
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
                                                                                                .addGroup(registerPanelLayout
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
                                                                                .addGroup(registerPanelLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                .addComponent(registerButton,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                36,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(returnToLoginButton,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                36,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addContainerGap(71,
                                                                                                Short.MAX_VALUE))));

                cardPanel.add(registerPanel, "register");

                loginPanel.setBackground(new java.awt.Color(255, 255, 255));
                loginPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                usernameLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
                usernameLabel1.setForeground(new java.awt.Color(0, 0, 255));
                usernameLabel1.setText("Username");
                loginPanel.add(usernameLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

                loginUsernameField.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
                loginUsernameField.setForeground(new java.awt.Color(0, 0, 0));
                loginUsernameField.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                loginUsernameFieldActionPerformed(evt);
                        }
                });
                loginPanel.add(loginUsernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 330, -1));

                passLabel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
                passLabel3.setForeground(new java.awt.Color(0, 0, 255));
                passLabel3.setText("Password");
                loginPanel.add(passLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

                loginPassField.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
                loginPanel.add(loginPassField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 330, -1));

                loginButton.setBackground(new java.awt.Color(0, 153, 102));
                loginButton.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
                loginButton.setForeground(new java.awt.Color(255, 255, 255));
                loginButton.setText("LOGIN");
                loginButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                loginButtonActionPerformed(evt);
                        }
                });
                loginPanel.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 330, 30));

                loginRegisterButton.setBackground(new java.awt.Color(0, 0, 255));
                loginRegisterButton.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
                loginRegisterButton.setForeground(new java.awt.Color(255, 255, 255));
                loginRegisterButton.setText("Register");
                loginRegisterButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                loginRegisterButtonActionPerformed(evt);
                        }
                });
                loginPanel.add(loginRegisterButton,
                                new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 140, -1));

                registerLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
                registerLabel.setForeground(new java.awt.Color(70, 73, 75));
                registerLabel.setText("Don't have an account yet?");
                loginPanel.add(registerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 240, 30));

                loginErrorLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
                loginErrorLabel.setForeground(new java.awt.Color(255, 51, 51));
                loginErrorLabel.setText("Error Message");
                loginPanel.add(loginErrorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 330, 30));
                loginPanel.add(appControlButtons2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 70, 30));

                cardPanel.add(loginPanel, "login");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cardPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cardPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void genderComboBoxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_genderComboBoxActionPerformed
        }// GEN-LAST:event_genderComboBoxActionPerformed

        private void surnameFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_surnameFieldActionPerformed
        }// GEN-LAST:event_surnameFieldActionPerformed

        private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_emailFieldActionPerformed
        }// GEN-LAST:event_emailFieldActionPerformed

        private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_usernameFieldActionPerformed
        }// GEN-LAST:event_usernameFieldActionPerformed

        private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_registerButtonActionPerformed
                registerUser(nameField.getText(), surnameField.getText(), usernameField.getText(), birthField.getDate(),
                                emailField.getText(), new String(passField1.getPassword()),
                                new String(passField2.getPassword()));
        }// GEN-LAST:event_registerButtonActionPerformed

        private void returnToLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_returnToLoginButtonActionPerformed
                buttonCardAction(Card.LOGIN);
        }// GEN-LAST:event_returnToLoginButtonActionPerformed

        private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_nameFieldActionPerformed
        }// GEN-LAST:event_nameFieldActionPerformed

        private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_loginUsernameFieldActionPerformed
                loginUser(this.loginUsernameField.getText(), new String(loginPassField.getPassword()));
        }// GEN-LAST:event_loginUsernameFieldActionPerformed

        private void loginUsernameFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_loginUsernameFieldActionPerformed
        }// GEN-LAST:event_loginUsernameFieldActionPerformed

        private void loginRegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_loginRegisterButtonActionPerformed
                buttonCardAction(Card.REGISTER);
        }// GEN-LAST:event_loginRegisterButtonActionPerformed

        /**
         * @param args the command line arguments
         */
        public static void main(String args[]) {
                /* Set the Nimbus look and feel */
                // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
                // (optional) ">
                /*
                 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
                 * look and feel.
                 * For details see
                 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
                 */
                try {
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                }
                // </editor-fold>
                // </editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new LoginFrame().setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private DesignObjects.AppControlButtons appControlButtons1;
        private DesignObjects.AppControlButtons appControlButtons2;
        private com.toedter.calendar.JDateChooser birthField;
        private javax.swing.JPanel cardPanel;
        private javax.swing.JLabel checkInLabel;
        private javax.swing.JTextField emailField;
        private javax.swing.JLabel emailLabel;
        private javax.swing.JComboBox<String> genderComboBox;
        private javax.swing.JLabel genderLabel;
        private javax.swing.JButton loginButton;
        public javax.swing.JLabel loginErrorLabel;
        private javax.swing.JPanel loginPanel;
        private javax.swing.JPasswordField loginPassField;
        private javax.swing.JButton loginRegisterButton;
        private javax.swing.JTextField loginUsernameField;
        private javax.swing.JTextField nameField;
        private javax.swing.JLabel nameLabel;
        private javax.swing.JPasswordField passField1;
        private javax.swing.JPasswordField passField2;
        private javax.swing.JLabel passLabel1;
        private javax.swing.JLabel passLabel2;
        private javax.swing.JLabel passLabel3;
        private javax.swing.JButton registerButton;
        private javax.swing.JLabel registerErrorLabel;
        private javax.swing.JLabel registerLabel;
        private javax.swing.JPanel registerPanel;
        private javax.swing.JButton returnToLoginButton;
        private javax.swing.JTextField surnameField;
        private javax.swing.JLabel surnameLabel;
        private javax.swing.JTextField usernameField;
        private javax.swing.JLabel usernameLabel;
        private javax.swing.JLabel usernameLabel1;
        // End of variables declaration//GEN-END:variables
}
