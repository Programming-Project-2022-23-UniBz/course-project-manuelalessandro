package Objects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

import com.google.gson.Gson;

import Objects.Room.RoomType;

public class RoomControl {

    private static Room[] rooms;
    private static Gson gson = new Gson();

    public static void pullData() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/main/java/Objects/json/rooms.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String userJson = null;
        if (scanner.hasNextLine())
            userJson = scanner.nextLine();
        scanner.close();
        rooms = gson.fromJson(userJson, Room[].class);
    }

    public static void pushData() {
        String usersJson = gson.toJson(rooms);
        try {
            FileWriter writer = new FileWriter("src/main/java/Objects/json/rooms.json");
            writer.append(usersJson);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void incrementRooms() {
        Room[] newArr = new Room[rooms.length + 1];
        for (int i = 0; i < rooms.length; i++) {
            newArr[i] = rooms[i];
        }
        rooms = newArr;
    }

    public static Room getRoom(int id) throws IllegalArgumentException {
        Room room = null;
        if (rooms.length > id)
            room = rooms[id];
        if (room == null)
            throw new IllegalArgumentException("Room does not exist");
        else
            return room;
    }

    // returns first free room that matches parameters
    // returns -1 if no room matches
    public static int getFreeRoomId(RoomType roomType, int capacity) throws Exception {
        int result = -1;
        for (int i = 0; i < rooms.length; i++)
            if (rooms[i] != null)
                if (rooms[i].getType() == roomType && rooms[i].getCapacity() == capacity
                        && rooms[i].isOccupied() == false) {
                    result = i;
                    break;
                }

        // throwing exception if no room matches
        if (result == -1)
            throw new Exception("No room avaiable for the selected dates."); // message appears in the CreateRoomPanel
        return result;
    }

    // Used to initialize rooms.json
    // if used, json will be reset and old data lost
    private static void initRooms() {
        rooms = new Room[400];

        for (int i = 100; i < rooms.length && i < 126; i++) {
            if (i < 116)
                rooms[i] = new Room(i, RoomType.STANDARD, 1);
            else
                rooms[i] = new Room(i, RoomType.STANDARD, 2);
        }

        for (int i = 200; i < rooms.length && i < 226; i++) {
            if (i < 216)
                rooms[i] = new Room(i, RoomType.DELUXE, 1);
            else
                rooms[i] = new Room(i, RoomType.DELUXE, 2);
        }

        for (int i = 300; i < rooms.length && i < 326; i++) {
            rooms[i] = new Room(i, RoomType.KING, 1);
        }
    }

    public static void main(String[] args) {
        pullData();

        pushData();
    }
}