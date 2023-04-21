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
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import AdminGUI.AdminFrame;
import java.io.FileWriter;

public class LoginFrame extends JFrame{
    //private variables, don't change
    private JButton login, register;
    private JTextField username;
    private JPasswordField password;
    private JLabel passwordLab, usernameLab;
    
    public LoginFrame(){
        
        //setting panel
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        
        //setting up all components
        usernameLab = new JLabel("Username");
        usernameLab.setBounds(100, 125, 70, 20);
        
        username = new JTextField();
        username.setBounds(100, 150, 193, 30);
        
        passwordLab = new JLabel("Password");
        passwordLab.setBounds(100, 190, 70, 20);

        password = new JPasswordField();
        password.setBounds(100 , 215, 200, 30);
        
        login = new JButton("Login");
        login.setBounds(150, 250, 100, 25);
        login.setForeground(Color.WHITE);
        login.setBackground(Color.BLACK);
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginOnAction(evt);
            }
        });
        
        register = new JButton("Register");
        register.setBounds(150, 280, 100, 25 );
        register.setForeground(Color.WHITE);
        register.setBackground(Color.BLACK);
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerOnAction(evt);
            }
        });
        
        //adding every component to the panel
        this.add(usernameLab);
        this.add(username);
        this.add(passwordLab);
        this.add(password);
        this.add(login);
        this.add(register);
        
        this.setVisible(true);
    }
    
    //login button on action
    public void loginOnAction(ActionEvent e){
        String U = this.username.getText();
        String P = this.password.getText(); 
        
        JSONArray users = new JSONArray();
        JSONParser jp = new JSONParser();
        
        //extracting data from the json file
        try{
            FileReader file = new FileReader("src/main/java/Objects/json/UserData.json");
            users = (JSONArray) jp.parse(file);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "error occured: "+ex);
            return;
        }
        
        // checking User in UserData.json
        String userRole = "";
        for(Object userObj : users){
            JSONObject user = (JSONObject) userObj;
            String storedUsername = (String) user.get("username");
            String storedPassword = (String) user.get("password");
            String storedUserRole = (String) user.get("role");
            if (U.equals(storedUsername) && P.equals(storedPassword)) {
                userRole = storedUserRole;
                JOptionPane.showMessageDialog(null, "login successful as " + userRole);
            }else{
                JOptionPane.showMessageDialog(null, "Error: invalid username or password");
            }
            if(userRole.equals("admin")){
                //boh tipo adminframe
                System.out.println("admin");
            }else if(userRole.equals("costumer")){
                //costumer frame
                System.out.println("costumer");
            }     
        }
        
    }
    
    public void registerOnAction(ActionEvent e) {
        RegisterFrame r = new RegisterFrame();
    }
    
}

//nell'admin frame aggiungere opzione per creare nuovo admin