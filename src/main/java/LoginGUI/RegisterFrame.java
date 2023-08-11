package LoginGUI;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.util.Date;
import javax.swing.*;
import Objects.User.GenderType;
import Objects.GeneralController;
import Objects.User;

/**
 *
 * @author aless
 */
public class RegisterFrame extends JFrame {

    // instance variables
    private final JTextField nameField;
    private final JTextField surnameField;
    private final JTextField emailField;
    private final JPasswordField passwordField;
    private final JSpinner birthDateSpinner;
    private final JComboBox<GenderType> genderComboBox;
    private final int x;
    private final int y;

    public RegisterFrame() {

        x = 75;
        y = 125;

        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        nameLabel.setBounds(x, y - 45, 200, 20);
        nameField.setBounds(x, y - 25, 90, 30);

        JLabel surnameLabel = new JLabel("Surname:");
        surnameField = new JTextField();
        surnameLabel.setBounds(x + 110, y - 45, 200, 20);
        surnameField.setBounds(x + 110, y - 25, 90, 30);

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        emailLabel.setBounds(x, y + 5, 70, 20);
        emailField.setBounds(x, y + 25, 200, 30);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        passwordLabel.setBounds(x, y + 55, 70, 20);
        passwordField.setBounds(x, y + 75, 200, 30);

        JLabel birthDateLabel = new JLabel("Birth Date:");
        SpinnerModel spinnerModel = new SpinnerDateModel();
        birthDateSpinner = new JSpinner(spinnerModel);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(birthDateSpinner, "dd/MM/yyyy");
        birthDateSpinner.setEditor(dateEditor);
        birthDateLabel.setBounds(x, y + 105, 70, 20);
        birthDateSpinner.setBounds(x, y + 125, 200, 30);

        JLabel genderLabel = new JLabel("Gender:");
        GenderType[] genderOptions = GenderType.values();
        genderComboBox = new JComboBox<>(genderOptions);
        genderLabel.setBounds(x, y + 155, 70, 20);
        genderComboBox.setBounds(x, y + 175, 200, 30);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(x + 50, y + 250, 100, 25);
        registerButton.addActionListener((ActionEvent e) -> {
            registerUser();
        });

        add(nameLabel);
        add(nameField);
        add(surnameLabel);
        add(surnameField);
        add(emailLabel);
        add(emailField);
        add(passwordLabel);
        add(passwordField);
        add(birthDateLabel);
        add(birthDateSpinner);
        add(genderLabel);
        add(genderComboBox);
        add(registerButton);

        setVisible(true);
    }

    private void registerUser() {
        String name = nameField.getText();
        String surname = surnameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        Date birthDate = (Date) birthDateSpinner.getValue();
        GenderType gender = (GenderType) genderComboBox.getSelectedItem();
        String role = "user";

        // TODO: Process the user registration logic here
        User user = new User(name, surname, birthDate, gender, email, password, role);
        GeneralController.addUser(user);
        JOptionPane.showMessageDialog(null, "Username for login: " + user.getUsername());
        closeApplication();
    }

    private void closeApplication() {
        this.dispose();
    }
}
