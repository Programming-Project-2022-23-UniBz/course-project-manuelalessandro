package Objects;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.*;
import com.google.gson.annotations.*;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.stream.JsonToken;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ArrayList;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class User {

    public static DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ITALY);

    public enum GenderType {
        MALE, FEMALE, OTHER
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
        this.encryptedPassword =encrypt(password);
        
        //ID is related to the length of the array
        //so, to the number of users, admins have all a mod 10 id so these are skipped
        if(getJsonCount()%10==0){
            this.id = getJsonCount()+1;
        }else{
            this.id = getJsonCount();
        }
        
        //useful for logins
        this.username=getUsername();
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

    
    //username is formed with name.surname+count+1
    public final String getUsername(){
        return this.name+"."+this.surname+this.id;

    }

    // getters and setters
    public String getRole() {
        return this.role;
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

    public String getPassword() {
        return decrypt(this.encryptedPassword);
    }

    public void setPassword(String password, int key) {
        this.encryptedPassword = encrypt(password);
    }

    public String getFullName() {
        return surname + " " + name;
    }

    public boolean equals(User user) {
        return this.id == user.getId();
    }
    
    public static int getJsonCount(){
        int arrayLength=0;
        try {
            // Parse the JSON contents
            try ( // Read the JSON file
                    FileReader fileReader = new FileReader("src/main/java/Objects/json/users.json")) {
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

    //Admins will have ids, 0, 10, 20, 30, 40 and so on, 
    //technically there should be just one admin, but just in case
    public boolean isAdmin() {
        return this.id%10 == 0;
    }

     public static String encrypt(String plainText) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            Key key = new SecretKeySpec(ENCRYPTION_KEY.getBytes(StandardCharsets.UTF_8), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
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
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
        }
        return null;
    }
    
    public void addToJson(){
        try {
            // Read the existing JSON file
            JsonParser parser = new JsonParser();
            JsonArray jsonArray = parser.parse(new FileReader("src/main/java/Objects/json/users.json"))
                    .getAsJsonArray();

            // Create a Gson instance
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            // Convert the User object to JSON and add it to the array
            jsonArray.add(gson.toJsonTree(this));

            // Write the updated array back to the JSON file
            try (FileWriter writer = new FileWriter("src/main/java/Objects/json/users.json")) {
                gson.toJson(jsonArray, writer);
            }
        } catch (IOException | JsonIOException e) {
        }
    }

}
