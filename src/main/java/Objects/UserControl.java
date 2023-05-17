package Objects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

import com.google.gson.Gson;

import Objects.User.GenderType;

public class UserControl {

    private static User[] users;
    private static Gson gson = new Gson();

    public static void pullData() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/main/java/Objects/json/users.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String userJson = null;
        if (scanner.hasNextLine())
            userJson = scanner.nextLine();
        scanner.close();
        users = gson.fromJson(userJson, User[].class);
    }

    public static void pushData() {
        String usersJson = gson.toJson(users);
        try {
            FileWriter writer = new FileWriter("src/main/java/Objects/json/users.json");
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
            System.out.println("Id does not exist");
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
    private static void initUsers() {
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

    public static void main(String[] args) {
        pullData();

        System.out.println(users.length);
        pushData();
    }
}
