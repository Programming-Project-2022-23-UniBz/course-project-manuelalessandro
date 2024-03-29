package Objects;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Represents a user with various attributes.
 * 
 * @Author ManuelVillotti
 */
public class User {

    // A date formatter for formatting date of birth.
    public static DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ITALY);

    /**
     * Enum representing different gender types.
     */
    public enum GenderType {
        MAN, WOMAN, OTHER
    }

    // instance variables
    private String id;
    private String name;
    private String surname;
    private Date dateOfBirth;
    private GenderType gender;
    private String email;
    private String password;
    private String role;
    private static final String ENCRYPTION_KEY = "4t7w!z%C*F-JaNdRgUkXn2r5u8x/A?D("; // unused
    private String username;
    // public String repositoryPath = System.getProperty("user.dir");
    // public final String remoteName = "origin";
    // public String branchName = "pushpull";

    /**
     * Constructs a User object with specified attributes.
     *
     * @param name        The user's first name.
     * @param surname     The user's last name.
     * @param username    The username for login.
     * @param dateOfBirth The user's date of birth.
     * @param gender      The user's gender.
     * @param email       The user's email address.
     * @param password    The user's password.
     * @param role        The user's role.
     * @throws IllegalArgumentException If any of the arguments are invalid.
     */
    public User(String name, String surname, String username, Date dateOfBirth, GenderType gender, String email,
            String password,
            String role)
            throws IllegalArgumentException {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;

        // useful for logins
        this.username = username;
        this.role = role;
        this.password = password;
    }

    /**
     * Constructs a User object with specified attributes, for creating user from
     * AdminFrame.
     *
     * @param name        The user's first name.
     * @param surname     The user's last name.
     * @param dateOfBirth The user's date of birth.
     * @param gender      The user's gender.
     * @param email       The user's email address.
     * @throws IllegalArgumentException If any of the arguments are invalid.
     */
    public User(String name, String surname, Date dateOfBirth, GenderType gender, String email)
            throws IllegalArgumentException {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
        this.password = null;
        this.role = "user";
        this.username = email; // because the user won't be able to login
    }

    // ------------- getters and setters

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        if (surname != null && name != null)
            return surname + " " + name;
        else
            return "null";
    }

    /**
     * Pushes changes made to the user data to the data source.
     * 
     * @throws Exception If an error occurs during the process.
     */
    public void pushChanges() throws Exception {
        User[] users = (User[]) GeneralController.pullData(User.class);

        int index = -1;
        for (int i = 0; i < users.length; i++)
            if (users[i].getId().equals(getId()))
                index = i;

        if (index != -1)
            users[index] = this;
        else
            throw new Exception("En error was found in pushing changes (User not found)");

        GeneralController.pushData(User.class, users);
    }

    // ----------------------------------------------------------------

    public boolean equals(User user) {
        return this.id == user.getId();
    }

    /**
     * Generates a unique ID for a user based on current date and random digits.
     * 
     * @return The generated user ID.
     */
    public static String generateId() {
        String prefix = "UID_";

        // Get today's date in the format "yyyyMMdd"
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String currentDate = dateFormat.format(new Date());

        // Generate 4 random digits
        int randomDigits = 1000 + new Random().nextInt(9000);

        // Combine the components to form the ID
        String generatedBookingId = prefix + currentDate + "_" + randomDigits;

        User[] users = (User[]) GeneralController.pullData(User.class);

        if (isIdUnique(users, generatedBookingId)) {
            return generatedBookingId;
        } else {
            // If the generated ID is not unique, recursively call the method to
            // generate another ID
            return generateId();
        }
    }

    /**
     * Generates a unique ID for a user based on current date and random digits,
     * while
     * ensuring uniqueness among a given array of users.
     * 
     * @param users An array of users to check for uniqueness.
     * @return The generated user ID.
     */
    public static String generateId(User[] users) {
        String prefix = "UID_";

        // Get today's date in the format "yyyyMMdd"
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String currentDate = dateFormat.format(new Date());

        // Generate 4 random digits
        int randomDigits = 1000 + new Random().nextInt(9000);

        // Combine the components to form the ID
        String generatedBookingId = prefix + currentDate + "_" + randomDigits;

        if (isIdUnique(users, generatedBookingId)) {
            return generatedBookingId;
        } else {
            // If the generated ID is not unique, recursively call the method to
            // generate another ID
            return generateId();
        }
    }

    /**
     * Checks if a user ID is unique among a given array of users.
     * 
     * @param users  An array of users to check against.
     * @param userId The user ID to check for uniqueness.
     * @return True if the user ID is unique, otherwise false.
     */
    private static boolean isIdUnique(User[] users, String userId) {
        if (users != null)
            for (User user : users) {
                if (user != null && user.getId().equals(userId)) {
                    return false; // Matching booking ID found, not unique
                }
            }
        return true; // unique
    }

    @SuppressWarnings("deprecation")
    /**
     * Adds a review for the user and stores it in a JSON file.
     * 
     * @param review The review text.
     * @param Stars  The star rating for the review.
     */
    public void addReview(String review, int Stars) {
        try {
            // GitCommandExecutor.pullChanges(repositoryPath, remoteName, branchName);
            // Read existing reviews from the JSON file
            JsonParser parser = new JsonParser();
            JsonArray jsonArray = parser.parse(new FileReader("src/main/resources/json/reviews.json")).getAsJsonArray();

            // Create a new review object
            JsonObject reviewObject = new JsonObject();
            reviewObject.addProperty("GuestName", getFullName());
            reviewObject.addProperty("Review", review);
            reviewObject.addProperty("Stars", Stars);

            // Add the new review to the array
            jsonArray.add(reviewObject);

            // Write the updated array back to the JSON file
            try (FileWriter writer = new FileWriter("src/main/resources/json/reviews.json")) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(jsonArray, writer);
            }
            // GitCommandExecutor.stageChanges(repositoryPath, ".");
            // GitCommandExecutor.commitChanges(repositoryPath, "changed reviews.json");
            // GitCommandExecutor.pushChanges(repositoryPath, remoteName, branchName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ----------------------------------------------------------------

    /**
     * Checks if the user has admin privileges.
     * 
     * @return True if the user is an admin, otherwise false.
     */
    public boolean isAdmin() {
        if (this.role.equals("admin"))
            return true;
        return false;
    }

    /**
     * Encrypts a given plain text using AES encryption.
     * 
     * @param plainText The text to be encrypted.
     * @return The encrypted text.
     */
    public static String encrypt(String plainText) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            Key key = new SecretKeySpec(ENCRYPTION_KEY.getBytes(StandardCharsets.UTF_8), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException
                | NoSuchPaddingException e) {
        }
        return null;
    }

    /**
     * Decrypts an encrypted text using AES decryption.
     * 
     * @param encryptedText The text to be decrypted.
     * @return The decrypted text.
     */
    public static String decrypt(String encryptedText) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            Key key = new SecretKeySpec(ENCRYPTION_KEY.getBytes(StandardCharsets.UTF_8), "AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException
                | NoSuchPaddingException e) {
        }
        return null;
    }

    @SuppressWarnings("deprecation")
    /**
     * Removes a review associated with the user from the reviews JSON file.
     * 
     * @param review The review text to be removed.
     */
    public void removeReview(String review) {
        try {
            // GitCommandExecutor.pullChanges(repositoryPath, remoteName, branchName);
            // Read existing reviews from the JSON file
            JsonParser parser = new JsonParser();
            JsonArray jsonArray = parser.parse(new FileReader("src/main/resources/json/reviews.json")).getAsJsonArray();

            // Find and remove the review from the array
            int index = findIndexOfJson(jsonArray, "GuestName", getFullName());
            if (index != -1) {
                JsonObject reviewObject = jsonArray.get(index).getAsJsonObject();
                String storedReview = reviewObject.get("Review").getAsString();
                if (storedReview.equals(review)) {
                    jsonArray.remove(index);
                }
            }

            // Write the updated array back to the JSON file
            try (FileWriter writer = new FileWriter("src/main/resources/json/reviews.json")) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(jsonArray, writer);
            }
            // GitCommandExecutor.stageChanges(repositoryPath, ".");
            // GitCommandExecutor.commitChanges(repositoryPath, "removed from
            // reviews.json");
            // GitCommandExecutor.pushChanges(repositoryPath, remoteName, branchName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param jsonArray
     * @param key
     * @param value
     * @return
     */
    private int findIndexOfJson(JsonArray jsonArray, String key, String value) {
        int index = -1;
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
            JsonElement jsonElement = jsonObject.get(key);
            if (jsonElement != null && jsonElement.getAsString().equals(value)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @SuppressWarnings("deprecation")
    /**
     * Retrieves the review associated with the user from the reviews JSON file.
     * 
     * @Author alessandro
     * 
     * @return The user's review.
     */
    public String getReview() {
        String review = "";
        try {
            JsonParser parser = new JsonParser();
            JsonArray jsonArray = parser.parse(new FileReader("src/main/resources/json/reviews.json")).getAsJsonArray();
            int index = findIndexOfJson(jsonArray, "GuestName", getFullName());
            JsonObject userObject = jsonArray.get(index).getAsJsonObject();
            review = userObject.get("Review").getAsString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return review;
    }

    @SuppressWarnings("deprecation")
    /**
     * Retrieves the rating associated with the user's review from the reviews JSON
     * file.
     * 
     * @Author alessandro
     * 
     * @return The user's review rating.
     */
    public int getRating() {
        int rating = 0;
        try {
            JsonParser parser = new JsonParser();
            JsonArray jsonArray = parser.parse(new FileReader("src/main/resources/json/reviews.json")).getAsJsonArray();
            int index = findIndexOfJson(jsonArray, "GuestName", getFullName());
            JsonObject userObject = jsonArray.get(index).getAsJsonObject();
            rating = userObject.get("Stars").getAsInt();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return rating;
    }

    @SuppressWarnings("deprecation")
    /**
     * Checks if the user has submitted a review.
     * 
     * @Author alessandro
     * 
     * @return True if the user has submitted a review, otherwise false.
     */
    public boolean hasReview() {
        try {
            // GitCommandExecutor.pullChanges(repositoryPath, remoteName, branchName);
            // Read existing reviews from the JSON file
            JsonParser parser = new JsonParser();
            JsonArray jsonArray = parser.parse(new FileReader("src/main/resources/json/reviews.json")).getAsJsonArray();

            // Check if the user has the specified review
            int index = findIndexOfJson(jsonArray, "GuestName", getFullName());
            if (index != -1) {
                JsonObject userObject = jsonArray.get(index).getAsJsonObject();
                String storedUser = userObject.get("GuestName").getAsString();
                return storedUser.equals(getFullName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    // -------------- Valid entries checkers
    /**
     * Checks if the provided email is valid.
     * 
     * @param email The email to validate.
     * @return True if the email is valid, otherwise false.
     * @throws Exception If an error occurs during the validation process.
     */
    public static boolean emailValid(String email) throws Exception {
        if (email == null)
            return false;

        User[] users = (User[]) GeneralController.pullData(User.class);
        for (User user : users)
            if (user.getEmail() != null && user.getEmail().equals(email))
                throw new Exception("Email is already registered to an account");

        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.compile(emailRegex)
                .matcher(email)
                .matches();
    }

    /**
     * @param pass1
     * @param pass2
     * @return
     * @throws Exception
     */
    public static boolean passwordValid(String pass1, String pass2) throws Exception {
        if (pass1 == null || pass2 == null)
            return false;

        // Password must contain at least one digit [0-9].
        // Password must contain at least one lowercase Latin character [a-z].
        // Password must contain at least one uppercase Latin character [A-Z].
        // Password must contain at least one special character like ! @ # & ( ).
        // Password must contain a length of at least 8 characters and a maximum of 20
        // characters.

        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()\u2013[{}]:;',?/*~$^+=<>]).{8,20}$";

        // Check if pass1 and pass2 are equal
        if (!pass1.equals(pass2))
            throw new Exception("Passwords are not equal");

        // Check if the input matches the pattern
        return Pattern.compile(pattern)
                .matcher(pass1)
                .matches();
    }

    public static String getPasswordRequirements() {
        return "1.\tPassword must contain at least one digit [0-9].\r\n" + //
                "2.\tPassword must contain at least one lowercase Latin character [a-z].\r\n" + //
                "3.\tPassword must contain at least one uppercase Latin character [A-Z].\r\n" + //
                "4.\tPassword must contain at least one special character like ! @ # & ( ).\r\n" + //
                "5.\tPassword must contain a length of at least 8 characters and a maximum of 20 characters. ";
    }

    /**
     * @param name
     * @param surname
     * @return
     */
    public static boolean nameValid(String name, String surname) {
        String regex = "^[A-Z][a-zA-Z]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher1 = pattern.matcher(name);
        Matcher matcher2 = pattern.matcher(surname);
        return matcher1.matches() && matcher2.matches();
    }

    /**
     * Checks if the provided birth date is valid.
     * 
     * @param birthDate The birth date to validate.
     * @return True if the birth date is valid, otherwise false.
     * @throws Exception If an error occurs during the validation process.
     */
    public static boolean birthDateValid(Date birthDate) throws Exception {
        if (birthDate == null)
            return false;
        if (isGuestOver100(birthDate))
            throw new Exception("No user can be over 100 years old.");
        if (isGuestUnder18(birthDate))
            throw new Exception("No user can be under 18 years old.");
        return true;
    }

    /**
     * Checks if the provided username is valid.
     * 
     * @param username The username to validate.
     * @return True if the username is valid, otherwise false.
     */
    public static boolean usernameValid(String username) {
        if (username == null)
            return false;
        if (username.length() < 4)
            return false;

        User[] users = (User[]) GeneralController.pullData(User.class);
        for (User user : users)
            if (user.getUsername().equals(username))
                return false;
        return true;
    }

    // Method to check if the guest is under 18 years old
    public static boolean isGuestUnder18(Date dateOfBirth) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -18); // Subtract 18 years from the current date
        Date eighteenYearsAgo = calendar.getTime();

        return dateOfBirth.toInstant().isAfter(eighteenYearsAgo.toInstant());
    }

    // Method to check if the guest is over 100 years old
    public static boolean isGuestOver100(Date dateOfBirth) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -100); // Subtract 100 years from the current date
        Date hundredYearsAgo = calendar.getTime();

        return dateOfBirth.toInstant().isBefore(hundredYearsAgo.toInstant());
    }

}
