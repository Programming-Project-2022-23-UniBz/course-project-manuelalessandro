package Objects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.InvalidParameterException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import Objects.User.GenderType;

public class ExUserControl {

    private static User[] users;
    private static Gson gson = new Gson();

    // Todo: remove following method
    public static void OLDpullData() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/main/resources/json/users.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String userJson = null;
        if (scanner.hasNextLine())
            userJson = scanner.nextLine();
        scanner.close();
        users = gson.fromJson(userJson, User[].class);
    }

    public static void pullData() {
        try {
            FileReader file = new FileReader("src/main/resources/json/users.json");
            JsonElement jsonElement = JsonParser.parseReader(file);
            users = gson.fromJson(jsonElement.getAsJsonArray(), User[].class);
        } catch (JsonIOException | JsonSyntaxException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "error occurred: " + ex);
            return;
        }
    }

    public static void pushData() {
        String usersJson = gson.toJson(users);
        try {
            FileWriter writer = new FileWriter("src/main/resources/json/users.json");
            writer.append(usersJson);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void incrementUsers() {
        User[] newArr = new User[users.length + 1];
        for (int i = 0; i < users.length; i++) {
            newArr[i] = users[i];
        }
        users = newArr;
    }

    private static void setRightId() {
        for (int i = 1; i < users.length; i++) {
            users[i].setId(i);
        }
    }

    public static void removeUser(int id) {
        User[] newArr = new User[users.length - 1];
        if (users.length > id) {
            for (int i = 0; i < id; i++) {
                newArr[i] = users[i];
            }
            for (int i = id; i < newArr.length; i++) {
                newArr[i] = users[i + 1];
            }
            users = newArr;
            setRightId();
        } else {
            throw new InvalidParameterException("Id does not exist");
        }
    }

    public static void addUser(User user) {
        incrementUsers();
        int index = users.length - 1;
        users[index] = user;
        users[index].setId(index);
    }

    public static User searchUser(String email) throws IllegalArgumentException {
        for (int i = 1; i < users.length; i++)
            if (users[i].getEmail().equals(email))
                return users[i];
        throw new IllegalArgumentException("Email does not exist");
    }

    public static User getUser(int id) throws IllegalArgumentException {
        if (users.length > id)
            return users[id];
        else
            throw new IllegalArgumentException("Id does not exist");
    }

    // Used to initialize users.json
    // if used, json will be reset and old data lost
    private static void initUsersTest() {
        users = new User[2];
        User admin = new User("admin", null, null, null, null, "password", "admin");
        admin.setId(0);
        users[0] = admin;
        User guestTest = null;
        try {
            guestTest = new User("GuestName", "GuestSurname", User.dateFormatter.parse("01/01/1990"),
                    GenderType.OTHER, "guest@email.com", "password",
                    "guest");
            guestTest.setId(1);
            users[1] = guestTest;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Used to initialize users.json
    // if used, json will be reset and old data lost
    private static void initUsers() {
        users = new User[0];
    }

}
