import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Objects.User;

public class UserTest {
    @Test
    public void testAddUserToJson() {
        // Create a new user
        String name = "John";
        String surname = "Doe";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateOfBirth = null;
        try {
            dateOfBirth = dateFormat.parse("01/01/1990");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        User.GenderType gender = User.GenderType.MALE;
        String email = "john.doe@example.com";
        String password = "password123";
        String role = "user";

        User user = new User(name, surname, dateOfBirth, gender, email, password, role);

        // Add user to JSON files
        user.addToJson();
        
        // Check if the user is added to the JSON files correctly
        int initialCount = User.getJsonCount();

        // Remove the user from the JSON files
        user.removeFromJson();

        int finalCount = User.getJsonCount();

        // Assert that the final count is greater than the initial count
        Assertions.assertTrue(finalCount > initialCount, "User should be added to the JSON file");
    }

    @Test
    public void testAddReview() {
        // Create a user
        String name = "John";
        String surname = "Doe";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateOfBirth = null;
        try {
            dateOfBirth = dateFormat.parse("01/01/1990");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        User.GenderType gender = User.GenderType.MALE;
        String email = "john.doe@example.com";
        String password = "password123";
        String role = "user";

        User user = new User(name, surname, dateOfBirth, gender, email, password, role);

        // Add a review
        String review = "Very nice!";
        user.addReview(review);

        // Check if the review is added correctly
        boolean reviewAdded = user.hasReview(review);
        Assertions.assertTrue(reviewAdded, "Review should be added to the user");

        // Cleanup - remove the review
        user.removeReview(review);
    }
}