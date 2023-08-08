package Objects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class GeneralController {
    static Gson gson = new Gson();

    public static Object[] pullData(Class c) {

        String path = "src/main/resources/json/";
        if (c.equals(User[].class))
            path += "users.json";
        else if (c.equals(Booking[].class))
            path += "bookings.json";
        else if (c.equals(Room[].class))
            path += "rooms.json";
        else if (c.equals(Reviews[].class))
            path += "reviews.json";

        System.out.println(path); // todo remove

        return pullData(c, path);
    }

    public static Object[] pullData(Class c, String path) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String json = null;
        if (scanner.hasNextLine())
            json = scanner.nextLine();
        scanner.close();
        Object[] array = (Object[]) gson.fromJson(json, c);
        return array;
    }

    public static <T> void pushData(Class<T> c, T[] content) {

        String path = "src/main/resources/json/";
        if (c.equals(User.class))
            path += "users.json";
        else if (c.equals(Booking.class))
            path += "bookings.json";
        else if (c.equals(Room.class))
            path += "rooms.json";
        else if (c.equals(Reviews.class))
            path += "reviews.json";

        pushData(path, content);
    }

    public static <T> void pushData(String path, T[] content) {
        String json = gson.toJson(content);
        try {
            FileWriter writer = new FileWriter(path);
            writer.append(json);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        User[] users = new User[2];
        pushData(User.class, users);

        users = (User[]) pullData(User[].class);
        System.out.println(users.length);
    }
}
