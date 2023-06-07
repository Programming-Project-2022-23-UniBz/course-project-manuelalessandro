package Objects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.joda.time.DateTime;

import com.google.gson.Gson;

import Objects.Room.RoomType;

public class RoomControl {

    private static Room[] rooms;
    private static Gson gson = new Gson();

    public static void pullData() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/main/resources/json/rooms.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String roomJson = null;
        if (scanner.hasNextLine())
            roomJson = scanner.nextLine();
        scanner.close();
        rooms = gson.fromJson(roomJson, Room[].class);
    }

    public static void pushData() {
        String usersJson = gson.toJson(rooms);
        try {
            FileWriter writer = new FileWriter("src/main/resources/json/rooms.json");
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

    public static Room[] getRoomsArray(){
        for (Room room: rooms) {
            System.out.println(room.toString());
        }
        return rooms;
    }

    public static void setRoomsArray(Room[] newRooms){
       rooms = newRooms;
    }



    // returns first free room that matches parameters
    // throws Exception if no room matches
    /**
     * @param roomType
     * @param capacity
     * @param checkIn
     * @param checkOut
     * @return
     * @throws Exception
     */
    public static int getFreeRoomId(RoomType roomType, int capacity, DateTime checkIn, DateTime checkOut)
            throws Exception {
        int result = -1;
        for (int i = 0; i < rooms.length; i++)
            if (rooms[i] != null)
                if (rooms[i].getType().equals(roomType) && rooms[i].getCapacity() == capacity
                        && rooms[i].isOccupied(checkIn, checkOut) == false) {
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
    private static void initRoomsTest() {
        rooms = new Room[400];
        RoomType type = RoomType.STANDARD;

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

        System.out.println(type);
    }

    // Used to initialize rooms.json to 0 rooms
    // if used, json will be reset and old data lost
    private static void initRooms() {
        rooms = new Room[0];
    }

    public static ArrayList<Room> getRoomsByTypeCapacity(RoomType roomType, int capacity) {
        pullData();
        ArrayList<Room> roomsByType = new ArrayList<>();
        for (Room room : rooms) {
            if (room != null && !room.isOccupied(new DateTime(), new DateTime()) && room.getType() == roomType
                    && room.getCapacity() == capacity) {
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

        pushData();
    }
}