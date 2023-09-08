import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import Objects.User;
import Main.LoginFrame;

public class LoginTest {

    private User user;

    @BeforeEach
    public void setUp() {
        // Create a sample User object for testing
        Date dateOfBirth = null;
        try {
            dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1990");
        } catch (Exception e) {
            e.printStackTrace();
        }
        user = new User("John", "Doe", "johndoe", dateOfBirth, User.GenderType.MAN, "johndoe@example.com", "password123", "user");
    }

    @Test
    public void testLoginUserValidCredentials() {
        // Create a test instance of your login frame or class
        LoginFrame loginFrame = new LoginFrame();

        // Attempt to log in
        loginFrame.loginUser("johndoe", "password123");

        assertFalse(loginFrame.loginErrorLabel.isVisible());
    }

    @Test
    public void testLoginUserInvalidCredentials() {
        // Create a test instance of your login frame or class
        LoginFrame loginFrame = new LoginFrame(); // Replace with your actual class name

        // Set up the login frame or fields as needed
        String username = "invalidU";
        String pass = "invalid2";

        // Attempt to log in
        loginFrame.loginUser(username, pass);

        assertTrue(loginFrame.loginErrorLabel.isVisible());
    }

    @Test
    public void testRegisterUserValidInput() {
        // Create a test instance of your registration frame or class
        LoginFrame registrationFrame = new LoginFrame(); // Replace with your actual class name

        // Set up the registration frame or fields as needed
        String name = "John";
        String surname = "Doe";
        String username = "johndoe2";
        Date birth = null;
        String email = "johndoe@gmail.com";
        String pass1 = "superSecurePass23";
        String pass2 = "superSecurePass23";



        // Attempt to register
        registrationFrame.registerUser(name, surname, username, birth, email, pass1, pass2);

        assertFalse(registrationFrame.loginErrorLabel.isVisible());
    }

    @Test
    public void testRegisterUserInvalidInput() {
        // Create a test instance of your registration frame or class
        LoginFrame registrationFrame = new LoginFrame(); // Replace with your actual class name

        // Set up the registration frame or fields as needed
        String name = "john";
        String surname = "doe";
        String username = "johndoe2";
        Date birth = null;
        String email = "johndoe";
        String pass1 = "supersecure";
        String pass2 = "supersecure";



        // Attempt to register
        registrationFrame.registerUser(name, surname, username, birth, email, pass1, pass2);

        assertTrue(registrationFrame.loginErrorLabel.isVisible());
    }
}

