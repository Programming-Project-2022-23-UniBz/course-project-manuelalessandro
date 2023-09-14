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

///// PASSWORDS FOR TESTING                                 ///////
////  admin = admin123                                      ///////
////  Alessandro.Marconi2 = Alessandro45+-                  ///////
////  GuestName.GuestSurname1 = Guest45+-                   ///////

public class User {

    public static DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ITALY);

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
    private static final String ENCRYPTION_KEY = "4t7w!z%C*F-JaNdRgUkXn2r5u8x/A?D(";
    private String username;
    public String repositoryPath = System.getProperty("user.dir");
    public final String remoteName = "origin";
    public String branchName = "pushpull";

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

    // Creating the user from from AdminFrame
    public User(String name, String surname, Date dateOfBirth, GenderType gender, String email)
            throws IllegalArgumentException {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
        this.password = null;
        this.role = "user";
        this.username = email; // TODO: change
    }

    // getters and setters
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

    public void pushChanges() throws Exception {
        User[] users = (User[]) GeneralController.pullData(User.class);

        int index = -1;
        for (int i = 0; i < users.length; i++)
            if (users[i].getId().equals(id))
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

    private static boolean isIdUnique(User[] users, String userId) {
        if (users != null)
            for (User user : users) {
                if (user != null && user.getId().equals(userId)) {
                    return false; // Matching booking ID found, not unique
                }
            }
        return true; // unique
    }

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

    // technically there should be just one admin, but just in case
    public boolean isAdmin() {
        if (this.role.equals("admin"))
            return true;
        return false;
    }

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

    // to remove the review from reviews.json
    public void removeReview(String review) {
        try {
            //GitCommandExecutor.pullChanges(repositoryPath, remoteName, branchName);
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
            //GitCommandExecutor.stageChanges(repositoryPath, ".");
            //GitCommandExecutor.commitChanges(repositoryPath, "removed from reviews.json");
            //GitCommandExecutor.pushChanges(repositoryPath, remoteName, branchName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int findIndexOfJson(JsonArray jsonArray, String key, int value) {
        int index = -1;
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
            JsonElement jsonElement = jsonObject.get(key);
            if (jsonElement != null && jsonElement.getAsInt() == value) {
                index = i;
                break;
            }
        }
        return index;
    }

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

    public boolean hasReview(String review) {
        try {
            //GitCommandExecutor.pullChanges(repositoryPath, remoteName, branchName);
            // Read existing reviews from the JSON file
            JsonParser parser = new JsonParser();
            JsonArray jsonArray = parser.parse(new FileReader("src/main/resources/json/reviews.json")).getAsJsonArray();

            // Check if the user has the specified review
            int index = findIndexOfJson(jsonArray, "GuestName", getFullName());
            if (index != -1) {
                JsonObject reviewObject = jsonArray.get(index).getAsJsonObject();
                String storedReview = reviewObject.get("Review").getAsString();
                return storedReview.equals(review);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Valid entries checkers

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

    public static boolean nameValid(String name, String surname) {
        String regex = "^[A-Z][a-zA-Z]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher1 = pattern.matcher(name);
        Matcher matcher2 = pattern.matcher(surname);
        return matcher1.matches() && matcher2.matches();
    }

    public static boolean birthDateValid(Date birthDate) throws Exception {
        if (birthDate == null)
            return false;
        if (isGuestOver100(birthDate))
            throw new Exception("No user can be over 100 years old.");
        if (isGuestUnder18(birthDate))
            throw new Exception("No user can be under 18 years old.");
        return true;
    }

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
