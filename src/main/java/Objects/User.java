package Objects;

import java.io.FileWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import com.google.gson.Gson;

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

    public User(String name, String surname, Date dateOfBirth, GenderType gender, String email, String password)
            throws IllegalArgumentException {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    // getters and setters
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

    public void setPassword(String password) {
        this.password = password;
    }
    // ----------------------------------------------------------------

    public boolean isAdmin() {
        if (id == 1)
            return true;
        else
            return false;
    }

}
