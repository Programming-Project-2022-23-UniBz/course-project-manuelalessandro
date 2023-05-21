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
import UserGUI.UserFrame;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class LoginFrame extends JFrame {
    // private variables, don't change
    private final JButton login;
    private final JButton register;
    private final JTextField username;
    private final JPasswordField password;
    private final JLabel passwordLab;
    private final JLabel usernameLab;
    private final Gson gson = new Gson();
    private static final String ENCRYPTION_KEY = "4t7w!z%C*F-JaNdRgUkXn2r5u8x/A?D(";

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
        P = encrypt(P);

        JsonArray users;

        try {
            FileReader file = new FileReader("src/main/resources/json/UserData.json");
            JsonElement jsonElement = JsonParser.parseReader(file);
            users = jsonElement.getAsJsonArray();
        } catch (JsonIOException | JsonSyntaxException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "error occurred: " + ex);
            return;
        }

        // checking User in UserData.json
        int index = findIndexOfJson(U, P, users);
        String userRole = "";
        JsonObject user = null;
        int storedId = -1;
        String storedUsername = null;
        String storedPassword = null;
        String storedUserRole = null;
        try {
            user = users.get(index).getAsJsonObject();
            storedId = user.get("id").getAsInt();
            storedUsername = user.get("username").getAsString();
            storedPassword = user.get("password").getAsString();
            storedUserRole = user.get("role").getAsString();
        } catch (IndexOutOfBoundsException | JsonParseException a) {
        }

        if (U.equals(storedUsername) && P.equals(storedPassword)) {
            userRole = storedUserRole;
            JOptionPane.showMessageDialog(null, "login successful as " + userRole);

            if (userRole.equals("admin")) {
                closeApplication();
                AdminFrame frame = new AdminFrame();
                frame.setVisible(true);
            } else if (userRole.equals("user")) {
                closeApplication();
                UserFrame frame = new UserFrame(getUserById(storedId));
                frame.setVisible(true);
                System.out.println("user");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error: invalid username or password");
        }
    }

    public void registerOnAction(ActionEvent e) {
        RegisterFrame r = new RegisterFrame();
        closeApplication();
    }

    // json file is an array, i have to find an index for a given username and
    // password
    public int findIndexOfJson(String U, String P, JsonArray users) {
        int index = 0;
        for (JsonElement userObj : users) {
            JsonObject user = userObj.getAsJsonObject();
            String storedUsername = user.get("username").getAsString();
            String storedPassword = user.get("password").getAsString();

            if (U.equals(storedUsername) && P.equals(storedPassword)) {
                break;
            }
            index++;
        }
        return index;
    }

    public static User getUserById(int id) {
        try {
            // Read the JSON file
            JsonParser parser = new JsonParser();
            JsonArray jsonArray = parser.parse(new FileReader("src/main/resources/json/users.json"))
                    .getAsJsonArray();

            // Create a Gson instance
            Gson gson = new Gson();

            // Iterate over the array to find the user with the specified ID
            for (JsonElement jsonElement : jsonArray) {
                User user = gson.fromJson(jsonElement, User.class);
                if (user.getId() == id) {
                    return user;
                }
            }
        } catch (IOException | JsonIOException e) {
            e.printStackTrace();
        }

        return null; // User with the specified ID was not found
    }

    public static String encrypt(String plainText) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            Key key = new SecretKeySpec(ENCRYPTION_KEY.getBytes(StandardCharsets.UTF_8), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException
                | NoSuchPaddingException e) {
        }
        return null;
    }

    public String decrypt(String encryptedText) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            Key key = new SecretKeySpec(ENCRYPTION_KEY.getBytes(StandardCharsets.UTF_8), "AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException
                | NoSuchPaddingException e) {
        }
        return null;
    }

    private void closeApplication() {
        this.dispose();
    }

}

// TODO: nell'admin frame aggiungere opzione per creare nuovo admin