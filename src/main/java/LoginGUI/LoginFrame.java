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
        
    }
   
}

//nell'admin frame aggiungere opzione per creare nuovo admin