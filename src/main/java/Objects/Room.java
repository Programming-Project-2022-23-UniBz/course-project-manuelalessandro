package Objects;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Path;

import javax.lang.model.util.ElementScanner14;

import com.google.gson.Gson;

public class Room {

    public enum RoomType {
        STANDARD, DELUXE, KING
    }

    // instance variables
    private int id;
    private RoomType roomType;
    private int capacity;
    private double price;
    private boolean isOccupied;

    public Room(int id, RoomType roomType, int capacity) {

        this.id = id;
        this.roomType = roomType;
        this.capacity = capacity;
        if (this.capacity > 2)
            this.capacity = 2;
        if (roomType.equals(RoomType.STANDARD))
            if (capacity == 1)
                price = 100;
            else
                price = 150;
        else if (roomType.equals(RoomType.DELUXE))
            if (capacity == 1)
                price = 200;
            else
                price = 250;
        else
            price = 400;
        this.isOccupied = false;

    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType type) {
        this.roomType = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    // ------------------------------------------------------------------

    // Used to initialize rooms.json
    // if used, json will be reset and old data lost
    public static void initRooms() {
        Room[] arr = new Room[400];

        for (int i = 100; i < arr.length && i < 126; i++) {
            if (i < 116)
                arr[i] = new Room(i, RoomType.STANDARD, 1);
            else
                arr[i] = new Room(i, RoomType.STANDARD, 2);
        }

        for (int i = 200; i < arr.length && i < 226; i++) {
            if (i < 216)
                arr[i] = new Room(i, RoomType.DELUXE, 1);
            else
                arr[i] = new Room(i, RoomType.DELUXE, 2);
        }

        for (int i = 300; i < arr.length && i < 326; i++) {
            arr[i] = new Room(i, RoomType.KING, 1);
        }
        Gson gson = new Gson();
        String roomsJson = gson.toJson(arr);

        try {
            FileWriter writer = new FileWriter("rooms.json");
            writer.append(roomsJson);
            writer.flush();
            writer.close();
            System.out.println("success");
        } catch (Exception e) {
            System.out.println("Exception");
        }

    }

}
