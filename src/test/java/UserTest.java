import org.junit.jupiter.api.Test;
import org.joda.time.DateTime;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import Objects.User;

public class UserTest {
    private User user;

    @BeforeEach
    public void setUp() {
        Date dateOfBirth = null;
        user = new User("Ale", "Marc", "alemarc2", dateOfBirth, User.GenderType.MAN, "alemarc@example.com",
                "password123", "user");
    }

    @Test
    public void testGenerateId() {
        String id = User.generateId();
        assertNotNull(id);
        assertTrue(id.startsWith("UID_"));
    }

    @Test
    public void testEmailValid() throws Exception {
        assertTrue(User.emailValid("alemarc@example.com"));
    }

    @Test
    public void testPasswordValid() throws Exception {
        assertTrue(User.passwordValid("Abcd123!", "Abcd123!"));
    }

    @Test
    public void testNameValid() {
        assertTrue(User.nameValid("Ale", "Marc"));
        assertFalse(User.nameValid("123", "Marc"));
        assertFalse(User.nameValid("Ale", "123"));
    }

    @Test
    public void testBirthDateValid() throws Exception {
        // invalid because <18
        assertThrows(Exception.class, () -> {
            User.birthDateValid(new Date());
        });
        // invalid because >100
        assertThrows(Exception.class, () -> {
            User.birthDateValid(new DateTime(1900, 1, 1, 0, 0).toDate());
        });
        // valid date of birth
        assertDoesNotThrow(() -> {
            User.birthDateValid(new DateTime(2000, 1, 1, 0, 0).toDate());
        });
    }

    @Test
    public void testUsernameValid() {
        assertTrue(User.usernameValid("alemarc2"));
        assertFalse(User.usernameValid("al"));
    }

    @Test
    public void testIsAdmin() {
        assertFalse(user.isAdmin()); // User role is "user" by default
        user.setRole("admin");
        assertTrue(user.isAdmin());
    }

    @Test
    public void testGetFullName() {
        assertEquals("Marc Ale", user.getFullName());
        user.setName(null);
        user.setSurname(null);
        assertEquals("null", user.getFullName());
    }

}