package LoginGUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.json.simple.*;
import Objects.User;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aless
 */
public class RegisterFrame extends JFrame {
    private JButton login, register;
    private JTextField username, email, name, surname;
    private JPasswordField password;
    private JLabel passwordLab, usernameLab, emailLab, nameLab;
    private int x, y;

    public RegisterFrame() {

        // initiate coordinates
        x = 100;
        y = 125;

        // setting panel
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        // setting up all components
        nameLab = new JLabel("Name and Surname");
        nameLab.setBounds(x, y - 50, 200, 20);

        name = new JTextField();
        name.setBounds(x, y - 25, 90, 30);

        surname = new JTextField();
        surname.setBounds(x + 110, y - 25, 90, 30);

        emailLab = new JLabel("Email");
        emailLab.setBounds(x, y, 70, 20);

        email = new JTextField();
        email.setBounds(x, y + 25, 200, 30);

        usernameLab = new JLabel("Username");
        usernameLab.setBounds(x, y + 50, 70, 20);

        username = new JTextField();
        username.setBounds(x, y + 75, 200, 30);

        passwordLab = new JLabel("Password");
        passwordLab.setBounds(x, y + 100, 70, 20);

        password = new JPasswordField();
        password.setBounds(x, y + 125, 200, 30);

        register = new JButton("Register");
        register.setBounds(x + 50, y + 175, 100, 25);
        register.setForeground(Color.WHITE);
        register.setBackground(Color.BLACK);
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    RegisterOnAction(evt);
                } catch (IOException ex) {
                    Logger.getLogger(RegisterFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // adding every component to the panel
        this.add(nameLab);
        this.add(name);
        this.add(surname);
        this.add(emailLab);
        this.add(email);
        this.add(usernameLab);
        this.add(username);
        this.add(passwordLab);
        this.add(password);
        this.add(register);

        this.setVisible(true);
    }

    // register button on action
    public void RegisterOnAction(ActionEvent e) throws IOException {
        String email = this.email.getText();
        String password = this.password.getText();
        String username = this.username.getText();
        String name = this.name.getText();
        String surname = this.surname.getText();

        // creating new user with the given info and adding it to the json
        
    }
}
