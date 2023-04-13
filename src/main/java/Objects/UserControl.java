package Objects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

import com.google.gson.Gson;

public class UserControl {

    private static User[] users;
    private static Gson gson = new Gson();

    public static void pullData() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("users.json"));
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
            FileWriter writer = new FileWriter("users.json");
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

    public static void main(String[] args) {
        pullData();
        System.out.println(users[1].getEmail());

    }
}
