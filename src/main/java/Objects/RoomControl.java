package Objects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
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
    public static int getFreeRoomId(RoomType roomType) {
        int result = -1;
        for (int i = 0; i < rooms.length; i++)
            if (rooms[i] != null)
                if (rooms[i].getType().equals(roomType) && rooms[i].isAvailable() == true) {
                    result = i;
                    break;
                }
        return result;
    }

    // Used to initialize rooms.json
    // if used, json will be reset and old data lost
    private static void initRooms() {
        rooms = new Room[600];

        for (int i = 100; i < rooms.length && i < 126; i++) {
            rooms[i] = new Room(i, RoomType.SINGLE_ROOM_STANDARD);
        }

        for (int i = 200; i < rooms.length && i < 226; i++) {
            rooms[i] = new Room(i, RoomType.SINGLE_ROOM_DELUXE);
        }

        for (int i = 300; i < rooms.length && i < 326; i++) {
            rooms[i] = new Room(i, RoomType.DOUBLE_ROOM_STANDARD);
        }

        for (int i = 400; i < rooms.length && i < 426; i++) {
            rooms[i] = new Room(i, RoomType.DOUBLE_ROOM_DELUXE);
        }

        for (int i = 500; i < rooms.length && i < 526; i++) {
            rooms[i] = new Room(i, RoomType.KING_SUITE);
        }

    }

    public static ArrayList<Room> getRoomsByType(RoomType roomType) {
        pullData();
        ArrayList<Room> roomsByType = new ArrayList<>();
        for (Room room : rooms) {
            if (room != null && room.isAvailable() && room.getType() == roomType) {
                roomsByType.add(room);
            }
        }
        return roomsByType;
    }

    public static Room getRoomById(int roomNr) {
        pullData();
        for (Room room : rooms) {
            if (room != null && room.getId() == roomNr) {
                return room;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        pullData();
        initRooms();
        pushData();
    }
}