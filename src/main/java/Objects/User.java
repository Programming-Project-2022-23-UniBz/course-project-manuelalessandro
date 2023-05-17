package Objects;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

//=======
//>>>>>>> c5099d07ad4c6471a1724330b683cc5fe2d7e131
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
    private String password;
    private String role;

    public User(String name, String surname, Date dateOfBirth, GenderType gender, String email, String password, String role)
            throws IllegalArgumentException {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
<<<<<<< HEAD
        this.password = Encrypt(password,110);
        this.role = role;
=======
        this.password = Encrypt(password, 110);
    }
    
    //Creating the user from from AdminFrame
    public User(String name, String surname, Date dateOfBirth, GenderType gender, String email)
            throws IllegalArgumentException {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
        this.password = null;
>>>>>>> a526cab955808c43dcd7efc1beaa3b2aa0e0d0af
    }
    
    //username is formed with name.surname+count+1
    public String getUsername(){
        return this.name+"."+this.surname;
    }
    
    // getters and setters
    public String getRole(){
        return this.role;
    }
    
    public void setRole(String role){
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
        return password;
    }

    public void setPassword(String password, int key) {
        this.password = Encrypt(password, key);
    }
    
    public String getFullName(){
        return surname + " " + name;
    }

    public boolean equals(User user) {
        if (this.id == user.getId())
            return true;
        return false;
    }
    // ----------------------------------------------------------------

    // the ids are structured this way, every id with a 1 as first number is an
    // admin, the ones with the 2 are costumers
    // implementing this into this method: Work in Progress
    public boolean isAdmin() {
        if (id == 1)
            return true;
        else
            return false;
    }

    // password encrypting using matrices and a public key
    // temporary, because still to simple to break
    public static String Encrypt(String text, int publicKey) {

        // create Array with the length of the given String
        // char pwd[][] = new char[text.length()][2];
        // char encrypted [] = new char[text.length()];
        // int key[][] = new int[2][2];
        int pwd1[] = new int[text.length()];
        int pwd2[] = new int[text.length()];
        int pwd[] = new int[text.length() * 2];
        // encode with a matrix, first number pwd[i][] is the ascii number of the letter
        // second number pwd[j] is the number assigned to the ascii code of key/2 places
        // forward
        // fill first row

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int ascii = (int) ch;
            pwd1[i] = (char) ascii;
            ascii = (int) ch + publicKey + i;
            pwd2[i] = (char) ascii;
        }

        // change places in array of pwd1 and pwd2
        for (int i1 = 0; i1 < pwd1.length; i1++) {
            pwd1[i1] = pwd1[pwd1.length - 1 - i1];
            pwd2[i1] = pwd2[pwd2.length - 1 - i1];
        }

        // unite the two arrays into one
        // first numbers are the pwd2 array
        for (int i2 = 0; i2 < pwd2.length; i2++) {
            pwd[i2] = pwd2[i2];
        }

        // second numbers are pwd1 array
        for (int i3 = 0; i3 < pwd1.length; i3++) {
            pwd[pwd2.length + i3] = pwd1[i3];
        }

        String str = "";
        for (int i = 0; i < pwd.length - 1; i++) {
            str += pwd[i];
        }
        return str;
    }

    public static String Decrypt(String encryptedText, int publicKey) {
        // reverse engineering del metodo di sopra
        // WORK IN PROGRESS //
        return "";
    }

    // method to convert user info into json string
    // uses Gson object to serialize the object to a JSon string
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    // for the UserData.json that stores only credentials
    // role is the role, during registering role can only be admin,
    // "admin" is given only from the admin panel, only admins can create admins
    public String toJsonCred(String role) {
        JSONArray users = new JSONArray();
        JSONParser jp = new JSONParser();
        try {
            FileWriter fileWriter = new FileWriter("src/main/java/Objects/json/users.json");
            FileReader file = new FileReader("src/main/java/Objects/json/users.json");
            users = (JSONArray) jp.parse(file);
        } catch (Exception ex) {
            System.out.println("" + ex);
        }

        String storedUsername = "";
        String storedPassword = "";
        for (Object userObj : users) {
            JSONObject user = (JSONObject) userObj;
            storedUsername = (String) user.get("username");
            storedPassword = (String) user.get("password");

        }

        return "{\"username\":\"" + storedUsername + "\",\"password\":\"" + storedPassword + "\",\"role\":\"" + role
                + "\"}";
    }

    // method to add the user to the json file
    // should read the current file, copy all into a string, add the new user and
    // rewrite the whole file
    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // !!!!!!!!!!!!!!!!!!!!!!!!!!! NOT TESTED YET !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public void addToJson() {
        try {
            // writing in the users.json file
            FileWriter fileWriter = new FileWriter("src/main/java/Objects/json/users.json");
            FileReader file = new FileReader("src/main/java/Objects/json/users.json");
            String fileToString = file.toString();
            fileToString += toJson();
            fileWriter.write(fileToString);

            // writing credentials in the UserData.json
            FileWriter fileWriterCred = new FileWriter("src/main/java/Objects/json/UserData.json");
            FileReader fileCred = new FileReader("src/main/java/Objects/json/UserData.json");
            String fileCredToString = fileCred.toString();
            String role = "";
            if (isAdmin() == true) { // checking user role
                role = "admin";
            } else {
                role = "costumer";
            }
            fileCredToString += toJsonCred(role); // adding to the
            fileWriterCred.write(fileCredToString);
            // System.out.println(fileToString); //uncomment for debugging
        } catch (Exception ex) {
            System.out.println("" + ex);
        }
    }

}
