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
        Date dateOfBirth = null;
        user = new User("Ale", "Marc", "alemarc2", dateOfBirth, User.GenderType.MAN, "alemarc@example.com", "password123", "user");
    }

    @Test
    public void testGenerateId() {
        String id = User.generateId();
        Assertions.assertNotNull(id);
        Assertions.assertTrue(id.startsWith("UID_"));
    }

    @Test
    public void testEmailValid() throws Exception {
        Assertions.assertTrue(User.emailValid("alemarc@example.com"));
    }

    @Test
    public void testPasswordValid() throws Exception {
        Assertions.assertTrue(User.passwordValid("Abcd123!", "Abcd123!"));
    }

    @Test
    public void testNameValid() {
        Assertions.assertTrue(User.nameValid("Ale", "Marc"));
        Assertions.assertFalse(User.nameValid("123", "Marc"));
        Assertions.assertFalse(User.nameValid("Ale", "123"));
    }

    @Test
    public void testBirthDateValid() throws Exception {
        Assertions.assertTrue(User.birthDateValid(new Date()));
    }

    @Test
    public void testUsernameValid() {
        Assertions.assertTrue(User.usernameValid("alemarc2"));
        Assertions.assertFalse(User.usernameValid("al"));
    }

    @Test
    public void testIsAdmin() {
        Assertions.assertFalse(user.isAdmin()); // User role is "user" by default
        user.setRole("admin");
        Assertions.assertTrue(user.isAdmin());
    }

    @Test
    public void testGetFullName() {
        Assertions.assertEquals("Marc Ale", user.getFullName());
        user.setName(null);
        user.setSurname(null);
        Assertions.assertEquals("null", user.getFullName());
    }
    
    @Test
    public void testHasReview() {
        Assertions.assertFalse(user.hasReview("nice place")); // user shouldn't have any review
        user.addReview("Hello, nice place!", 5); // add the review for the user
        Assertions.assertTrue(user.hasReview("Hello, nice place!")); // review should be found
        user.removeReview("Hello, nice place!"); // remove review
        Assertions.assertFalse(user.hasReview("Hello, nice place!")); // review shouldn't be found
    }
    
    @Test
    public void testGuestAge(){
        Date dateOfBirth2 = null; //da cambiare in qualcosa sotto i 18 anni
        user.setDateOfBirth(dateOfBirth2);
        Assertions.assertTrue(user.isGuestUnder18(dateOfBirth2));
        Assertions.assertFalse(user.isGuestOver100(dateOfBirth2));
        dateOfBirth2 = null; // da cambiare in qualcosa sopra 100
        user.setDateOfBirth(dateOfBirth2);
        Assertions.assertTrue(user.isGuestOver100(dateOfBirth2));
        Assertions.assertFalse(user.isGuestUnder18(dateOfBirth2));
    }

}