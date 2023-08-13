package Objects;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

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

    public User(String name, String surname, Date dateOfBirth, GenderType gender, String email, String password,
            String role)
            throws IllegalArgumentException {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
        this.password = password;

        // useful for logins
        this.username = getUsername();
        this.role = role;
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
    }

    // username is formed with name.surname+count+1
    public final String getUsername() {
        return this.username;
    }

    // getters and setters
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

    private static boolean isIdUnique(User[] users, String bookingId) {
        if (users != null)
            for (User user : users) {
                if (user.getId().equals(bookingId)) {
                    return false; // Matching booking ID found, not unique
                }
            }
        return true; // unique
    }

    public void addReview(String review) {
        try {
            // Read existing reviews from the JSON file
            JsonParser parser = new JsonParser();
            JsonArray jsonArray = parser.parse(new FileReader("reviews.json")).getAsJsonArray();

            // Create a new review object
            JsonObject reviewObject = new JsonObject();
            reviewObject.addProperty("GuestName", getName());
            reviewObject.addProperty("Review", review);

            // Add the new review to the array
            jsonArray.add(reviewObject);

            // Write the updated array back to the JSON file
            try (FileWriter writer = new FileWriter("reviews.json")) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(jsonArray, writer);
            }
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
            // Read existing reviews from the JSON file
            JsonParser parser = new JsonParser();
            JsonArray jsonArray = parser.parse(new FileReader("reviews.json")).getAsJsonArray();

            // Find and remove the review from the array
            int index = findIndexOfJson(jsonArray, "GuestName", getName());
            if (index != -1) {
                JsonObject reviewObject = jsonArray.get(index).getAsJsonObject();
                String storedReview = reviewObject.get("Review").getAsString();
                if (storedReview.equals(review)) {
                    jsonArray.remove(index);
                }
            }

            // Write the updated array back to the JSON file
            try (FileWriter writer = new FileWriter("reviews.json")) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(jsonArray, writer);
            }
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
            // Read existing reviews from the JSON file
            JsonParser parser = new JsonParser();
            JsonArray jsonArray = parser.parse(new FileReader("reviews.json")).getAsJsonArray();

            // Check if the user has the specified review
            int index = findIndexOfJson(jsonArray, "GuestName", getName());
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

    public static boolean emailValid(String mail) {
        // TODO
        return true;
    }

    public static boolean passwordValid(String pass1, String pass2) {
        // TODO
        return true;
    }

    public static boolean nameValid(String name, String surname) {
        // TODO
        return true;
    }

    public static boolean birthDateValid(Date birthDate) {
        // TODO
        return true;
    }
}
