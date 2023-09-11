import org.joda.time.DateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

import Objects.GeneralController;
import Objects.User;
import Objects.User.GenderType;
import Main.LoginFrame;

public class LoginTest {

    private static User getSampleUser() {
        User user = new User("Uname", "Usurname", "userTest", new DateTime(1980, 05, 05, 0, 0).toDate(), GenderType.MAN,
                "u1@test.it",
                "U1password!", "user");
        return user;
    }

    @Test
    public void testRegisterUserValidInput() throws Exception {
        User user = getSampleUser();
        String name = user.getName();
        String surname = user.getSurname();
        String username = user.getUsername();
        Date birth = user.getDateOfBirth();
        String email = user.getEmail();
        String pass1 = user.getPassword();
        String pass2 = user.getPassword();

        LoginFrame registrationFrame = new LoginFrame();
        assertTrue(registrationFrame.registerUser(name, surname, username, birth, email, pass1, pass2));
        assertFalse(registrationFrame.isVisible());

        user = GeneralController.searchUser(email);
        String userId = user.getId();
        // remove the test user and assert it doesn't exist
        assertDoesNotThrow(() -> {
            GeneralController.removeUser(userId);
        });
        assertThrows(Exception.class, () -> {
            GeneralController.searchUser(username, pass1);
        });
    }

    @Test
    public void testLoginUserValidCredentials() {
        User user = getSampleUser();
        String username = user.getUsername();
        String password = user.getPassword();
        GeneralController.addUser(user);

        LoginFrame loginFrame = new LoginFrame();

        assertTrue(loginFrame.loginUser(username, password)); // Attempt to log in
        assertFalse(loginFrame.isVisible()); // assert is not visible anymore

        user = GeneralController.searchUser(username, password);
        String userId = user.getId();
        // remove the test user and assert it doesn't exist
        assertDoesNotThrow(() -> {
            GeneralController.removeUser(userId);
        });
        assertThrows(Exception.class, () -> {
            GeneralController.searchUser(username, password);
        });
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
