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
        
        Date dateOfBirth = null;
        try {
            dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1990");
        } catch (Exception e) {
            e.printStackTrace();
        }
        user = new User("Ale", "Marc", "alemarc", dateOfBirth, User.GenderType.MAN, "alemarc@example.com", "password123", "user");
    }

    @Test
    public void testLoginUserValidCredentials() {
        
        LoginFrame loginFrame = new LoginFrame();

        // Attempt to log in
        loginFrame.loginUser("alemarc", "password123");

        assertFalse(loginFrame.loginErrorLabel.isVisible());
    }

    @Test
    public void testLoginUserInvalidCredentials() {
        LoginFrame loginFrame = new LoginFrame();

        String username = "invalidU";
        String pass = "invalid2";

        loginFrame.loginUser(username, pass);

        assertTrue(loginFrame.loginErrorLabel.isVisible());
    }

    @Test
    public void testRegisterUserValidInput() {
        
        LoginFrame registrationFrame = new LoginFrame(); 
        String name = "Ale";
        String surname = "Marc";
        String username = "alemarc3";
        Date birth = null;
        String email = "alemarc@gmail.com";
        String pass1 = "superSecurePass23";
        String pass2 = "superSecurePass23";
        registrationFrame.registerUser(name, surname, username, birth, email, pass1, pass2);

        assertFalse(registrationFrame.loginErrorLabel.isVisible());
    }

    @Test
    public void testRegisterUserInvalidInput() {
        LoginFrame registrationFrame = new LoginFrame();

        String name = "ale";
        String surname = "marc";
        String username = "alemarc3";
        Date birth = null;
        String email = "alemarc";
        String pass1 = "supersecure";
        String pass2 = "supersecure";

        registrationFrame.registerUser(name, surname, username, birth, email, pass1, pass2);

        assertTrue(registrationFrame.loginErrorLabel.isVisible());
    }
}

