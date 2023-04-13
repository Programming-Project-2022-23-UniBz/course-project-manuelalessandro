package Objects;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Path;

import com.google.gson.Gson;

public class Room {

    public enum RoomType {
        STANDARD, DELUXE, KING
    }

    // instance variables
    private int id;
    private RoomType type;
    private int capacity;
    private int price;
    private boolean isOccupied;

    public Room(int id, RoomType type, int capacity, int price) {

        this.id = id;
        this.type = type;
        this.capacity = capacity;
        this.price = price;
        isOccupied = false;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPrice() {
        return price;
    }

    // Used to initialize rooms.json
    public static void initRooms() {
        Room[] arr = new Room[400];

        for (int i = 100; i < arr.length && i < 126; i++) {
            if (i < 116)
                arr[i] = new Room(i, RoomType.STANDARD, 1, 100);
            else
                arr[i] = new Room(i, RoomType.STANDARD, 2, 150);
        }

        for (int i = 200; i < arr.length && i < 226; i++) {
            if (i < 216)
                arr[i] = new Room(i, RoomType.DELUXE, 1, 200);
            else
                arr[i] = new Room(i, RoomType.DELUXE, 2, 250);
        }

        for (int i = 300; i < arr.length && i < 326; i++) {
            arr[i] = new Room(i, RoomType.KING, 1, 400);
        }
        Gson gson = new Gson();
        String roomsJson = gson.toJson(arr);

        try {
            File file = new File("rooms.json");
            FileWriter writer = new FileWriter(file);
            writer.append(roomsJson);
            writer.flush();
            writer.close();
            System.out.println("success");
        } catch (Exception e) {
            System.out.println("Exception");
        }

    }
}
