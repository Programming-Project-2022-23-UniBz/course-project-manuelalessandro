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
    private int id;
    private String name;
    private String surname;
    private Date dateOfBirth;
    private GenderType gender;
    private String email;
    private String encryptedPassword;
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
        this.encryptedPassword = encrypt(password);

        // ID is related to the length of the array
        // so, to the number of users, admins have all a mod 10 id so these are skipped
        if (getJsonCount() % 10 == 0) {
            this.id = getJsonCount() + 1;
        } else {
            this.id = getJsonCount();
        }

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
        this.encryptedPassword = null;
    }

    // username is formed with name.surname+count+1
    public final String getUsername() {
        return this.name + "." + this.surname + this.id;

    }

    // getters and setters
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getEncPassword() {
        return encryptedPassword;
    }

    public String getPassword() {
        return decrypt(this.encryptedPassword);
    }

    public void setPassword(String password) {
        this.encryptedPassword = encrypt(password);
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

    public static int getJsonCount() {
        int arrayLength = 0;
        try {
            // Parse the JSON contents
            try ( // Read the JSON file
                    FileReader fileReader = new FileReader("src/main/resources/json/users.json")) {
                // Parse the JSON contents
                JsonElement jsonElement = JsonParser.parseReader(fileReader);
                JsonArray jsonArray = jsonElement.getAsJsonArray();
                // Check the length of the array
                arrayLength = jsonArray.size();
                System.out.println("Array length: " + arrayLength);
                // Close the file reader
            }
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
        }
        return arrayLength;
    }
    // ----------------------------------------------------------------

    // Admins will have ids, 0, 10, 20, 30, 40 and so on,
    // technically there should be just one admin, but just in case
    public boolean isAdmin() {
        return this.id % 10 == 0;
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

    public String decrypt(String encryptedText) {
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

    public void addToJson() {

        UserControl.addUser(this);

        // Add the user data to the UserData.json file
        try {
            // Read the existing JSON file
            JsonParser parser = new JsonParser();
            JsonArray jsonArray = parser.parse(new FileReader("src/main/resources/json/UserData.json"))
                    .getAsJsonArray();

            // Create a Gson instance
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            // Convert the User object to a JsonObject
            JsonObject userJson = new JsonObject();
            userJson.addProperty("id", getId());
            userJson.addProperty("username", getUsername());
            userJson.addProperty("password", getEncPassword());
            userJson.addProperty("role", getRole());

            // Add the JsonObject to the array
            jsonArray.add(userJson);

            // Write the updated array back to the JSON file
            try (FileWriter writer = new FileWriter("src/main/resources/json/UserData.json")) {
                gson.toJson(jsonArray, writer);
            }
        } catch (IOException | JsonIOException e) {
            e.printStackTrace();
        }
    }

    // to remove User from users.json and UserData.json
    public void removeFromJson() {
        try {
            // Read the existing JSON file
            JsonParser parser = new JsonParser();
            JsonArray jsonArray = parser.parse(new FileReader("src/main/resources/json/users.json"))
                    .getAsJsonArray();

            // Remove the user from the array
            int index = findIndexOfJson(jsonArray, "id", id);
            if (index != -1) {
                jsonArray.remove(index);
            }

            // Write the updated array back to the JSON file
            try (FileWriter writer = new FileWriter("src/main/resources/json/users.json")) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(jsonArray, writer);
            }
        } catch (IOException | JsonIOException e) {
            e.printStackTrace();
        }

        // Remove the user data from the UserData.json file
        try {
            // Read the existing JSON file
            JsonParser parser = new JsonParser();
            JsonArray jsonArray = parser.parse(new FileReader("src/main/resources/json/UserData.json"))
                    .getAsJsonArray();

            // Remove the user from the array
            int index = findIndexOfJson(jsonArray, "id", id);
            if (index != -1) {
                jsonArray.remove(index);
            }

            // Write the updated array back to the JSON file
            try (FileWriter writer = new FileWriter("src/main/resources/json/UserData.json")) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(jsonArray, writer);
            }
        } catch (IOException | JsonIOException e) {
            e.printStackTrace();
        }
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
