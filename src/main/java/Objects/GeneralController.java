package Objects;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Scanner;

import org.joda.time.DateTime;

import com.google.gson.Gson;

import Objects.Room.RoomType;
import Objects.User.GenderType;

public class GeneralController {
    static Gson gson = new Gson();

    // ----------------------------------------------------------------
    // -------------------- General part ------------------------------
    // ----------------------------------------------------------------

    public static void main(String[] args) {

    }

    public static Object[] pullData(Class c) {

        String path = "src/main/resources/json/";
        if (c.equals(User.class))
            path += "users.json";
        else if (c.equals(Booking.class))
            path += "bookings.json";
        else if (c.equals(Room.class))
            path += "rooms.json";
        else if (c.equals(Review.class))
            path += "reviews.json";
        else
            throw new IllegalArgumentException("Invalid class to pull data from: " + c);

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

        Object[] array;
        if (c.equals(User.class))
            array = (User[]) gson.fromJson(json, User[].class);
        else if (c.equals(Booking.class))
            array = (Booking[]) gson.fromJson(json, Booking[].class);
        else if (c.equals(Room.class))
            array = (Room[]) gson.fromJson(json, Room[].class);
        else if (c.equals(Review.class))
            array = (Review[]) gson.fromJson(json, Review[].class);
        else
            throw new IllegalArgumentException("Invalid class to pull data from: " + c);

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
        else if (c.equals(Review.class))
            path += "reviews.json";
        else
            throw new IllegalArgumentException("Invalid class to push data to: " + c);

        pushData(c, path, content);
    }

    public static <T> void pushData(Class<T> c, String path, T[] content) {
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

    public static void increment(Object[] array) {
        Object[] newArray = new Object[array.length + 1];
        for (int i = 0; i < array.length; i++)
            newArray[i] = array[i];
        array = newArray;
    }

    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    // -------------------- Bookings control --------------------------
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------

    public static double getAverageCost(Booking[] bookings) {
        if (bookings == null || bookings.length == 0) {
            return 0.0; // Return 0 if there are no bookings
        }

        double totalCost = 0;
        for (Booking booking : bookings) {
            totalCost += booking.getTotalCost();
        }

        return totalCost / bookings.length;
    }

    public static double getAverageCost() {
        Booking[] bookings = (Booking[]) pullData(Booking.class);
        if (bookings == null || bookings.length == 0) {
            return 0.0; // Return 0 if there are no bookings
        }

        double totalCost = 0;
        for (Booking booking : bookings) {
            totalCost += booking.getTotalCost();
        }

        return totalCost / bookings.length;
    }

    public static Booking findBooking(Booking[] bookings, User user) {
        Booking result = null;
        if (bookings != null)
            for (int i = 0; i < bookings.length; i++) {
                User bookingUser = bookings[i].getUser();
                if (bookingUser != null && bookingUser.equals(user)) {
                    result = bookings[i];
                    break;
                }
            }

        return result;
    }

    public static Booking findBooking(User user) {
        Booking[] bookings = (Booking[]) pullData(Booking.class);

        Booking result = null;
        if (bookings != null)
            for (int i = 0; i < bookings.length; i++) {
                User bookingUser = bookings[i].getUser();
                if (bookingUser != null && bookingUser.equals(user)) {
                    result = bookings[i];
                    break;
                }
            }

        return result;
    }

    public static Booking getBookingById(Booking[] bookings, String id) throws IllegalArgumentException {
        for (Booking booking : bookings) {
            if (booking.getId().equals(id)) {
                return booking;
            }
        }
        throw new IllegalArgumentException("Booking with ID " + id + " not found.");
    }

    public static Booking getBookingById(String id) throws IllegalArgumentException {
        Booking[] bookings = (Booking[]) pullData(Booking.class);

        for (Booking booking : bookings) {
            if (booking.getId().equals(id)) {
                return booking;
            }
        }
        throw new IllegalArgumentException("Booking with ID " + id + " not found.");
    }

    public static void removeBookingById(Booking[] bookings, String id) throws IllegalArgumentException {
        int index = -1;
        // Find the index of the booking to remove
        for (int i = 0; i < bookings.length; i++) {
            if (bookings[i].getId().equals(id)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            Booking[] updatedBookings = new Booking[bookings.length - 1];

            // Operations to copy the bookings before and after the index to the
            // updatedBookings array.
            if (index > 0) {
                // starts from index 0 in the source array (bookings) and index 0 in the
                // destination array
                // copies index number of elements from the source array to the destination
                // array
                System.arraycopy(bookings, 0, updatedBookings, 0, index);
            }
            if (index < bookings.length - 1) {
                // skips the element at the index position and copies the remaining elements
                // after that position
                System.arraycopy(bookings, index + 1, updatedBookings, index, bookings.length - index - 1);
            }
            bookings = updatedBookings;
        } else {
            throw new IllegalArgumentException("Booking with ID " + id + " not found.");
        }

        pushData(Booking.class, bookings);
    }

    public static void removeBookingById(String id) throws IllegalArgumentException {
        Booking[] bookings = (Booking[]) pullData(Booking.class);

        int index = -1;
        // Find the index of the booking to remove
        for (int i = 0; i < bookings.length; i++) {
            if (bookings[i].getId().equals(id)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            Booking[] updatedBookings = new Booking[bookings.length - 1];

            // Operations to copy the bookings before and after the index to the
            // updatedBookings array.
            if (index > 0) {
                // starts from index 0 in the source array (bookings) and index 0 in the
                // destination array
                // copies index number of elements from the source array to the destination
                // array
                System.arraycopy(bookings, 0, updatedBookings, 0, index);
            }
            if (index < bookings.length - 1) {
                // skips the element at the index position and copies the remaining elements
                // after that position
                System.arraycopy(bookings, index + 1, updatedBookings, index, bookings.length - index - 1);
            }
            bookings = updatedBookings;
        } else {
            throw new IllegalArgumentException("Booking with ID " + id + " not found.");
        }

        pushData(Booking.class, bookings);
    }

    // @return ArrayList<Booking> that contains all the bookings that have that room
    public static ArrayList<Booking> getAllBookings(Booking[] bookings, Room room) {
        if (bookings == null) {
            bookings = new Booking[0];
        }

        ArrayList<Booking> result = new ArrayList<Booking>();
        for (int i = 0; i < bookings.length; i++)
            if (bookings[i] != null)
                if (bookings[i].getRoom().equals(room))
                    result.add(bookings[i]);
        return result;
    }

    // @return ArrayList<Booking> that contains all the bookings that have that room
    public static ArrayList<Booking> getAllBookings(Room room) {
        Booking[] bookings = (Booking[]) pullData(Booking.class);

        if (bookings == null) {
            bookings = new Booking[0];
        }

        ArrayList<Booking> result = new ArrayList<Booking>();
        for (int i = 0; i < bookings.length; i++)
            if (bookings[i] != null)
                if (bookings[i].getRoom().equals(room))
                    result.add(bookings[i]);
        return result;
    }

    // @return ArrayList<Booking> that contains all the bookings that have that user
    public static ArrayList<Booking> getAllBookings(Booking[] bookings, User user) {
        if (bookings == null) {
            bookings = new Booking[0];
        }

        ArrayList<Booking> result = new ArrayList<Booking>();
        for (int i = 0; i < bookings.length; i++)
            if (bookings[i] != null)
                if (bookings[i].getUser().equals(user))
                    result.add(bookings[i]);
        return result;
    }

    // @return ArrayList<Booking> that contains all the bookings that have that user
    public static ArrayList<Booking> getAllBookings(User user) {
        Booking[] bookings = (Booking[]) pullData(Booking.class);

        if (bookings == null) {
            bookings = new Booking[0];
        }

        ArrayList<Booking> result = new ArrayList<Booking>();
        for (int i = 0; i < bookings.length; i++)
            if (bookings[i] != null)
                if (bookings[i].getUser().equals(user))
                    result.add(bookings[i]);
        return result;
    }

    public static void addBooking(Booking[] bookings, Booking booking) {
        if (bookings == null) {
            bookings = new Booking[0];
        }
        increment(bookings);
        bookings[bookings.length - 1] = booking;
        pushData(Booking.class, bookings);
    }

    public static void addBooking(Booking booking) {
        Booking[] bookings = (Booking[]) pullData(Booking.class);
        increment(bookings);
        bookings[bookings.length - 1] = booking;
        pushData(Booking.class, bookings);
    }

    // @returns the total amount earned for a specific month
    public static double calculateTotalAmountForMonth(Booking[] bookings, int month) {
        double totalAmount = 0;
        boolean hasBookings = false;

        for (Booking booking : bookings) {
            DateTime checkInDate = new DateTime(booking.getCheckInDate());

            /*
             * It retrieves the check-in date of each booking and checks if
             * the month of the check-in date matches the specified month.
             * If there is a match, that particular booking will be counted in the total
             * income for the given month
             */
            if (checkInDate.getMonthOfYear() == month) {
                totalAmount += booking.getTotalCost();
                hasBookings = true;
            }
        }

        if (!hasBookings) {
            return -1;
        }

        return totalAmount;
    }

    // @returns the total amount earned for a specific month
    public static double calculateTotalAmountForMonth(int month) {
        Booking[] bookings = (Booking[]) pullData(Booking.class);
        double totalAmount = 0;
        boolean hasBookings = false;

        for (Booking booking : bookings) {
            DateTime checkInDate = new DateTime(booking.getCheckInDate());

            /*
             * It retrieves the check-in date of each booking and checks if
             * the month of the check-in date matches the specified month.
             * If there is a match, that particular booking will be counted in the total
             * income for the given month
             */
            if (checkInDate.getMonthOfYear() == month) {
                totalAmount += booking.getTotalCost();
                hasBookings = true;
            }
        }

        if (!hasBookings) {
            return -1;
        }

        return totalAmount;
    }

    public static double getTotalEarningFromBookings(Booking[] bookings) {
        double amount = 0.0;

        for (Booking booking : bookings) {
            amount += booking.getTotalCost();
        }

        return amount;
    }

    public static double getTotalEarningFromBookings() {
        Booking[] bookings = (Booking[]) pullData(Booking.class);
        double amount = 0.0;

        for (Booking booking : bookings) {
            amount += booking.getTotalCost();
        }

        return amount;
    }

    public static String getBookingsString(Booking[] bookings) {
        String result = "";
        for (int i = 0; i < bookings.length; i++) {
            result += "User email: " + bookings[i].getUser().getEmail() + ", Room Nr: " + bookings[i].getRoom().getId()
                    + "\n";
        }
        return result;
    }

    public static String getBookingsString() {
        Booking[] bookings = (Booking[]) pullData(Booking.class);

        String result = "";
        for (int i = 0; i < bookings.length; i++) {
            result += "User email: " + bookings[i].getUser().getEmail() + ", Room Nr: " + bookings[i].getRoom().getId()
                    + "\n";
        }
        return result;
    }

    public static int getBookingsLength() {
        Booking[] bookings = (Booking[]) pullData(Booking.class);
        return bookings.length;
    }

    // Used to initialize bookings.json for test purposes
    // if used, json will be reset and old data lost
    private static void initBookingsTest() throws Exception {
        Booking[] bookings;
        try {
            bookings = new Booking[2];
            Room[] rooms = (Room[]) pullData(Room.class);

            // Admin Room
            DateTime checkInAdmin = new DateTime(2023, 2, 11, 0, 0);
            DateTime checkOutAdmin = new DateTime(2023, 2, 16, 0, 0);
            Room room1 = getFreeRoom(rooms, RoomType.DELUXE, 2, checkInAdmin, checkOutAdmin);
            User user1 = getUser(0); // adminUser
            Booking booking1 = new Booking(checkInAdmin, checkOutAdmin, room1, user1);
            bookings[0] = booking1;

            // Guest Room
            DateTime checkInGuest = new DateTime(2023, 5, 18, 0, 0);
            DateTime checkOutGuest = new DateTime(2023, 5, 26, 0, 0);
            Room room2 = getFreeRoom(rooms, RoomType.DELUXE, 1, checkInGuest, checkOutGuest);
            User user2 = getUser(1); // guestUser
            Booking booking2 = new Booking(checkInGuest, checkOutGuest, room2, user2);
            bookings[1] = booking2;

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Init bookings failes because room not found.");
        }
        pushData(Booking.class, bookings);
    }

    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    // -------------------- Users control -----------------------------
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------

    private static void setUsersRightId(User[] users) {
        for (int i = 1; i < users.length; i++) {
            users[i].setId(i);
        }
    }

    private static void setUsersRightId() {
        User[] users = (User[]) pullData(User.class);

        for (int i = 1; i < users.length; i++) {
            users[i].setId(i);
        }

        pushData(User.class, users);
    }

    public static void removeUser(User[] users, int id) {
        User[] newArr = new User[users.length - 1];
        if (users.length > id) {
            for (int i = 0; i < id; i++) {
                newArr[i] = users[i];
            }
            for (int i = id; i < newArr.length; i++) {
                newArr[i] = users[i + 1];
            }
            users = newArr;
            setUsersRightId(users);
        } else {
            throw new InvalidParameterException("Id does not exist");
        }
    }

    public static void removeUser(int id) {
        User[] users = (User[]) pullData(User.class);

        User[] newArr = new User[users.length - 1];
        if (users.length > id) {
            for (int i = 0; i < id; i++) {
                newArr[i] = users[i];
            }
            for (int i = id; i < newArr.length; i++) {
                newArr[i] = users[i + 1];
            }
            users = newArr;
            setUsersRightId();
        } else {
            throw new InvalidParameterException("Id does not exist");
        }

        pushData(User.class, users);
    }

    public static void addUser(User[] users, User user) {
        increment(users);
        int index = users.length - 1;
        users[index] = user;
        users[index].setId(index);
    }

    public static void addUser(User user) {
        User[] users = (User[]) pullData(User.class);

        increment(users);
        int index = users.length - 1;
        users[index] = user;
        users[index].setId(index);

        pushData(User.class, users);
    }

    public static User searchUser(User[] users, String email) throws IllegalArgumentException {
        for (int i = 1; i < users.length; i++)
            if (users[i].getEmail().equals(email))
                return users[i];
        throw new IllegalArgumentException("Email does not exist");
    }

    public static User searchUser(String email) throws IllegalArgumentException {
        User[] users = (User[]) pullData(User.class);

        for (int i = 1; i < users.length; i++)
            if (users[i].getEmail().equals(email))
                return users[i];
        throw new IllegalArgumentException("Email does not exist");
    }

    public static User getUser(User[] users, int id) throws IllegalArgumentException {
        if (users != null && users.length > id)
            return users[id];
        else
            throw new IllegalArgumentException("Id does not exist");
    }

    public static User getUser(int id) throws IllegalArgumentException {
        User[] users = (User[]) pullData(User.class);

        if (users != null && users.length > id)
            return users[id];
        else
            throw new IllegalArgumentException("Id does not exist");
    }

    // Used to initialize users.json
    // if used, json will be reset and old data lost
    private static void initUsers() {
        User[] users = new User[2];
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

        pushData(User.class, users);
    }

    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    // -------------------- Room control ------------------------------
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------

    public static Room getRoom(Room[] rooms, int id) throws IllegalArgumentException {
        Room room = null;
        if (rooms.length > id)
            room = rooms[id];
        if (room == null)
            throw new IllegalArgumentException("Room does not exist");
        else
            return room;
    }

    public static Room getRoom(int id) throws IllegalArgumentException {
        Room[] rooms = (Room[]) pullData(Room.class);

        Room room = null;
        if (rooms.length > id)
            room = rooms[id];
        if (room == null)
            throw new IllegalArgumentException("Room does not exist");
        else
            return room;
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
    public static int getFreeRoomId(Room[] rooms, RoomType roomType, int capacity, DateTime checkIn, DateTime checkOut)
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
        Room[] rooms = (Room[]) pullData(Room.class);

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

    public static Room getFreeRoom(Room[] rooms, RoomType roomType, int capacity, DateTime checkIn, DateTime checkOut)
            throws Exception {
        Room result = null;
        for (int i = 0; i < rooms.length; i++)
            if (rooms[i] != null)
                if (rooms[i].getType().equals(roomType) && rooms[i].getCapacity() == capacity
                        && rooms[i].isOccupied(checkIn, checkOut) == false) {
                    result = rooms[i];
                    break;
                }

        // throwing exception if no room matches
        if (result == null)
            throw new Exception("No room avaiable for the selected dates."); // message appears in the CreateRoomPanel
        return result;
    }

    public static Room getFreeRoom(RoomType roomType, int capacity, DateTime checkIn, DateTime checkOut)
            throws Exception {
        Room[] rooms = (Room[]) pullData(Room.class);

        Room result = null;
        for (int i = 0; i < rooms.length; i++)
            if (rooms[i] != null)
                if (rooms[i].getType().equals(roomType) && rooms[i].getCapacity() == capacity
                        && rooms[i].isOccupied(checkIn, checkOut) == false) {
                    result = rooms[i];
                    break;
                }

        // throwing exception if no room matches
        if (result == null)
            throw new Exception("No room avaiable for the selected dates."); // message appears in the CreateRoomPanel
        return result;
    }

    public static ArrayList<Room> getRoomsByTypeCapacity(Room[] rooms, RoomType roomType, int capacity) {
        ArrayList<Room> roomsByType = new ArrayList<>();
        for (Room room : rooms) {
            if (room != null && !room.isOccupied(new DateTime(), new DateTime()) && room.getType() == roomType
                    && room.getCapacity() == capacity) {
                roomsByType.add(room);
            }
        }
        return roomsByType;
    }

    public static ArrayList<Room> getRoomsByTypeCapacity(RoomType roomType, int capacity) {
        Room[] rooms = (Room[]) pullData(Room.class);

        ArrayList<Room> roomsByType = new ArrayList<>();
        for (Room room : rooms) {
            if (room != null && !room.isOccupied(new DateTime(), new DateTime()) && room.getType() == roomType
                    && room.getCapacity() == capacity) {
                roomsByType.add(room);
            }
        }
        return roomsByType;
    }

    public static Room getRoomById(Room[] rooms, int roomNr) {
        for (Room room : rooms) {
            if (room != null && room.getId() == roomNr) {
                return room;
            }
        }
        return null;
    }

    public static Room getRoomById(int roomNr) {
        Room[] rooms = (Room[]) pullData(Room.class);

        for (Room room : rooms) {
            if (room != null && room.getId() == roomNr) {
                return room;
            }
        }
        return null;
    }

    // Used to initialize rooms.json
    // if used, json will be reset and old data lost
    private static void initRooms() {
        Room[] rooms = new Room[400];
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

        pushData(Room.class, rooms);
    }
}
