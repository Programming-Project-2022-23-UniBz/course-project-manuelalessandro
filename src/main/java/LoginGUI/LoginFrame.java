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
import Objects.User;
import java.io.FileWriter;
import UserGUI.UserFrame;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import java.io.FileNotFoundException;

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

        JsonArray users;

        try {
            FileReader file = new FileReader("src/main/java/Objects/json/users.json");
            JsonElement jsonElement = JsonParser.parseReader(file);
            users = jsonElement.getAsJsonArray();
        } catch (JsonIOException | JsonSyntaxException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "error occurred: " + ex);
            return;
        }
        // checking User in UserData.json

        int index = findIndexOfJson(U, P, users);
        String userRole = "";
        JsonObject user = users.get(index).getAsJsonObject();
        String storedUsername = user.get("username").getAsString();
        String storedPassword = user.get("password").getAsString();
        String storedUserRole = user.get("role").getAsString();

        if (U.equals(storedUsername) && P.equals(storedPassword)) {
            userRole = storedUserRole;
            JOptionPane.showMessageDialog(null, "login successful as " + userRole);

            if (userRole.equals("admin")) {
                this.setVisible(false);
                AdminFrame frame = new AdminFrame();
                frame.setVisible(true);
            } else if (userRole.equals("user")) {
                this.setVisible(false);
                UserFrame frame = new UserFrame(new Gson().fromJson(user, User.class));
                frame.setVisible(true);
                System.out.println("user");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error: invalid username or password");
        }
    }

    public void registerOnAction(ActionEvent e) {
        RegisterFrame r = new RegisterFrame();
        this.setVisible(false);
    }

    // json file is an array, i have to find an index for a given username and
    // password
    public int findIndexOfJson(String U, String P, JsonArray users) {
        int index = 0;
        for (Object userObj : users) {
            JsonObject user = (JsonObject) userObj;
            String storedUsername = user.get("username").getAsString();
            String storedPassword = user.get("password").getAsString();
            String storedUserRole = user.get("role").getAsString();

            if (U.equals(storedUsername) && P.equals(storedPassword)) {
                break;
            }
            index++;
        }

        return index;
    }

}

// TODO: nell'admin frame aggiungere opzione per creare nuovo admin