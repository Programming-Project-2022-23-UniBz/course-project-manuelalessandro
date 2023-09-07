import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Objects.User;

public class UserTest {
    private User user;

    @BeforeEach
    public void setUp() {
        // Create a sample User object for testing
        Date dateOfBirth = null;
        try {
            dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1990");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user = new User("John", "Doe", "johndoe", dateOfBirth, User.GenderType.MAN, "johndoe@example.com", "password123", "user");
    }

    @Test
    public void testGenerateId() {
        String id = User.generateId();
        Assertions.assertNotNull(id);
        Assertions.assertTrue(id.startsWith("UID_"));
    }

    @Test
    public void testEmailValid() throws Exception {
        Assertions.assertTrue(User.emailValid("johndoe@example.com"));
        Assertions.assertThrows(Exception.class, () -> User.emailValid("invalid_email"));
    }

    @Test
    public void testPasswordValid() throws Exception {
        Assertions.assertTrue(User.passwordValid("Abcd123!", "Abcd123!"));
        Assertions.assertThrows(Exception.class, () -> User.passwordValid("weakpassword", "weakpassword"));
        Assertions.assertThrows(Exception.class, () -> User.passwordValid("Abcd123!", "Abcd1234"));
    }

    @Test
    public void testNameValid() {
        Assertions.assertTrue(User.nameValid("John", "Doe"));
        Assertions.assertFalse(User.nameValid("123", "Doe"));
        Assertions.assertFalse(User.nameValid("John", "123"));
    }

    @Test
    public void testBirthDateValid() throws Exception {
        Assertions.assertTrue(User.birthDateValid(new Date()));
        Assertions.assertThrows(Exception.class, () -> User.birthDateValid(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1900")));
        Assertions.assertThrows(Exception.class, () -> User.birthDateValid(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2025")));
    }

    @Test
    public void testUsernameValid() {
        Assertions.assertTrue(User.usernameValid("johndoe"));
        Assertions.assertFalse(User.usernameValid("jo"));
    }

    @Test
    public void testIsAdmin() {
        Assertions.assertFalse(user.isAdmin()); // User role is "user" by default
        user.setRole("admin");
        Assertions.assertTrue(user.isAdmin());
    }

    @Test
    public void testGetFullName() {
        Assertions.assertEquals("Doe John", user.getFullName());
        user.setName(null);
        user.setSurname(null);
        Assertions.assertEquals("null", user.getFullName());
    }

    @Test
    public void testEquals() {
        User otherUser = new User("Jane", "Doe", "janedoe", new Date(), User.GenderType.WOMAN, "janedoe@example.com", "password123", "user");
        Assertions.assertFalse(user.equals(otherUser));
        user.setId("1");
        otherUser.setId("1");
        Assertions.assertTrue(user.equals(otherUser));
    }
}