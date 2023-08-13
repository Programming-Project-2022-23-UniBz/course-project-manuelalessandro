/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LoginGUI;

/**
 *
 * @author aless
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
import com.google.gson.Gson;
import AdminGUI.AdminFrame;
import Objects.GeneralController;
import Objects.User;
import UserGUI.UserFrame;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class LoginFrame extends JFrame {
    // private variables, don't change
    private final JButton login;
    private final JButton register;
    private final JTextField username;
    private final JPasswordField password;
    private final JLabel passwordLab;
    private final JLabel usernameLab;
    private final Gson gson = new Gson();

    public LoginFrame() {

        // setting panel
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        // setting up all components
        usernameLab = new JLabel("Username");
        usernameLab.setBounds(100, 125, 70, 20);

        username = new JTextField();
        username.setBounds(100, 150, 193, 30);

        passwordLab = new JLabel("Password");
        passwordLab.setBounds(100, 190, 70, 20);

        password = new JPasswordField();
        password.setBounds(100, 215, 200, 30);

        login = new JButton("Login");
        login.setBounds(150, 250, 100, 25);
        login.setForeground(Color.WHITE);
        login.setBackground(Color.BLACK);
        login.addActionListener((java.awt.event.ActionEvent evt) -> {
            loginOnAction(evt);
        });

        register = new JButton("Register");
        register.setBounds(150, 280, 100, 25);
        register.setForeground(Color.WHITE);
        register.setBackground(Color.BLACK);
        register.addActionListener((java.awt.event.ActionEvent evt) -> {
            registerOnAction(evt);
        });

        // adding every component to the panel
        this.add(usernameLab);
        this.add(username);
        this.add(passwordLab);
        this.add(password);
        this.add(login);
        this.add(register);

        this.setVisible(true);
    }

    // login button on action
    public void loginOnAction(ActionEvent e) {
        String U = this.username.getText();
        String P = this.password.getText();

        try {
            // searching for user that logged in
            User user = GeneralController.searchUser(U, P);
            String userRole = user.getRole();

            if (userRole.equals("admin")) {
                closeApplication();
                AdminFrame frame = new AdminFrame();
                frame.setVisible(true);
            } else {
                closeApplication();
                UserFrame frame = new UserFrame(user);
                frame.setVisible(true);
            }
            JOptionPane.showMessageDialog(null, "login successful as " + userRole);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Error: invalid username or password");
            exception.printStackTrace();
        }

    }

    public void registerOnAction(ActionEvent e) {
        RegisterFrame r = new RegisterFrame();
        closeApplication();
    }

    private void closeApplication() {
        this.dispose();
    }

}

// TODO: nell'admin frame aggiungere opzione per creare nuovo admin