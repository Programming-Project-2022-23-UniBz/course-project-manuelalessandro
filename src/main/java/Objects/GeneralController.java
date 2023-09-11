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
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneralController {
    static Gson gson = new Gson();

    // ----------------------------------------------------------------
    // -------------------- General part ------------------------------
    // ----------------------------------------------------------------

    public static void main(String[] args) throws Exception {
        initUsers();
        initBookingsTest();
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
        else if (c.equals(String.class))
            array = (String[]) gson.fromJson(json, String[].class);
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
        return getAverageCost(bookings);
    }

    public static Booking findBooking(Booking[] bookings, String userId) {
        Booking result = null;
        if (bookings != null)
            for (int i = 0; i < bookings.length; i++) {
                String bookingUserId = bookings[i].getUserId();
                if (bookingUserId != null && bookingUserId.equals(userId)) {
                    result = bookings[i];
                    break;
                }
            }
        return result;
    }

    public static Booking findBooking(String userId) {
        Booking[] bookings = (Booking[]) pullData(Booking.class);
        return findBooking(bookings, userId);
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
        return getBookingById(bookings, id);
    }

    public static Booking[] removeBookingById(Booking[] bookings, String id) throws IllegalArgumentException {
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

        return bookings;
    }

    public static void removeBookingById(String id) throws IllegalArgumentException {
        Booking[] bookings = (Booking[]) pullData(Booking.class);
        bookings = removeBookingById(bookings, id);
        pushData(Booking.class, bookings);
    }

    // @return ArrayList<Booking> that contains all the bookings that have that room
    public static ArrayList<Booking> getAllBookings(Booking[] bookings, int roomId) {
        if (bookings == null) {
            bookings = new Booking[0];
        }

        ArrayList<Booking> result = new ArrayList<Booking>();
        for (int i = 0; i < bookings.length; i++)
            if (bookings[i] != null)
                if (bookings[i].getRoomId() == roomId)
                    result.add(bookings[i]);
        return result;
    }

    // @return ArrayList<Booking> that contains all the bookings that have that room
    public static ArrayList<Booking> getAllBookings(int roomId) {
        Booking[] bookings = (Booking[]) pullData(Booking.class);
        return getAllBookings(bookings, roomId);
    }

    // @return ArrayList<Booking> that contains all the bookings that have that user
    public static ArrayList<Booking> getAllBookings(Booking[] bookings, User user) {
        if (bookings == null) {
            bookings = new Booking[0];
        }

        ArrayList<Booking> result = new ArrayList<Booking>();
        for (int i = 0; i < bookings.length; i++)
            if (bookings[i] != null)
                if (bookings[i].getUserId().equals(user.getId()))
                    result.add(bookings[i]);
        return result;
    }

    // @return ArrayList<Booking> that contains all the bookings that have that user
    public static ArrayList<Booking> getAllBookings(User user) {
        Booking[] bookings = (Booking[]) pullData(Booking.class);
        return getAllBookings(bookings, user);
    }

    public static Booking[] incrementBookings(Booking[] bookings) {
        Booking[] newArray = new Booking[bookings.length + 1];
        for (int i = 0; i < bookings.length; i++)
            newArray[i] = bookings[i];
        return newArray;
    }

    public static Booking[] addBooking(Booking[] bookings, Booking booking) {
        if (bookings == null) {
            bookings = new Booking[0];
        }
        bookings = incrementBookings(bookings);
        bookings[bookings.length - 1] = booking;

        return bookings;
    }

    public static void addBooking(Booking booking) {
        Booking[] bookings = (Booking[]) pullData(Booking.class);
        bookings = addBooking(bookings, booking);
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
        return calculateTotalAmountForMonth(bookings, month);
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
        return getTotalEarningFromBookings(bookings);
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

            // Admin Room
            DateTime checkInAdmin = new DateTime(2023, 2, 11, 0, 0);
            DateTime checkOutAdmin = new DateTime(2023, 2, 16, 0, 0);
            Room room1 = getFreeRoom(RoomType.DELUXE, 2, checkInAdmin, checkOutAdmin);
            User user1 = searchUser("admin@email.com"); // adminUser
            Booking booking1 = new Booking(checkInAdmin, checkOutAdmin, room1.getId(), user1.getId());
            bookings[0] = booking1;

            // Guest Room
            DateTime checkInGuest = new DateTime(2023, 5, 18, 0, 0);
            DateTime checkOutGuest = new DateTime(2023, 5, 26, 0, 0);
            Room room2 = getFreeRoom(RoomType.DELUXE, 1, checkInGuest, checkOutGuest);
            User user2 = searchUser("guest@email.com"); // guestUser
            Booking booking2 = new Booking(checkInGuest, checkOutGuest, room2.getId(), user2.getId());
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

    public static User[] removeUser(User[] users, String id) {
        User[] newArr = new User[users.length - 1];
        int index = -1;
        for (int i = 0; i < users.length; i++)
            if (users[i].getId().equals(id))
                index = i;

        if (index != -1) {
            for (int i = 0; i < index; i++) {
                newArr[i] = users[i];
            }
            for (int i = index; i < newArr.length; i++) {
                newArr[i] = users[i + 1];
            }
            users = newArr;
        } else {
            throw new InvalidParameterException("Id does not exist");
        }

        return users;
    }

    public static void removeUser(String id) {
        User[] users = (User[]) pullData(User.class);
        users = removeUser(users, id);
        pushData(User.class, users);
    }

    public static User[] incrementUsers(User[] users) {
        User[] newArray = new User[users.length + 1];
        for (int i = 0; i < users.length; i++)
            newArray[i] = users[i];
        return newArray;
    }

    public static User[] addUser(User[] users, User user) {
        user.setId(User.generateId(users));

        users = incrementUsers(users);
        int index = users.length - 1;
        users[index] = user;

        return users;
    }

    public static void addUser(User user) {
        User[] users = (User[]) pullData(User.class);
        users = addUser(users, user);
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
        return searchUser(users, email);
    }

    public static User searchUser(User[] users, String username, String password) throws IllegalArgumentException {
        for (int i = 0; i < users.length; i++)
            if (users[i].getUsername().equals(username) && users[i].getPassword().equals(password))
                return users[i];
        throw new IllegalArgumentException("Username not found");
    }

    public static User searchUser(String username, String password) throws IllegalArgumentException {
        User[] users = (User[]) pullData(User.class);
        return searchUser(users, username, password);
    }

    public static User getUser(User[] users, String id) throws IllegalArgumentException {
        User result = null;
        if (users != null)
            for (int i = 0; i < users.length; i++)
                if (users[i].getId().equals(id))
                    result = users[i];

        if (result != null)
            return result;
        else
            throw new IllegalArgumentException("Id does not exist");
    }

    public static User getUser(String id) throws IllegalArgumentException {
        User[] users = (User[]) pullData(User.class);

        User result = null;
        if (users != null)
            for (int i = 0; i < users.length; i++)
                if (users[i].getId().equals(id))
                    result = users[i];

        if (result != null)
            return result;
        else
            throw new IllegalArgumentException("Id does not exist");
    }

    // Used to initialize users.json
    // if used, json will be reset and old data lost
    private static void initUsers() {
        User[] users = new User[2];
        User admin = new User("admin", null, "admin", null, null, "admin@email.com", "password", "admin");
        admin.setId(User.generateId(users));

        users[0] = admin;
        User guestTest = null;
        try {
            guestTest = new User("GuestName", "GuestSurname", "guest", User.dateFormatter.parse("01/01/1990"),
                    GenderType.OTHER, "guest@email.com", "password",
                    "guest");
            guestTest.setId(User.generateId(users));
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
    public static int getFreeRoomId(Booking[] bookings, RoomType roomType, int capacity, DateTime checkIn,
            DateTime checkOut)
            throws Exception {
        Room[] rooms = (Room[]) pullData(Room.class);

        int result = -1;
        for (int i = 0; i < rooms.length; i++)
            if (rooms[i] != null)
                if (rooms[i].getType().equals(roomType) && rooms[i].getCapacity() == capacity
                        && rooms[i].isOccupied(bookings, checkIn, checkOut) == false) {
                    result = i;
                    break;
                }

        // throwing exception if no room matches
        if (result == -1)
            throw new Exception("No room avaiable for the selected dates."); // message appears in the CreateRoomPanel
        return result;
    }

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
        Booking[] bookings = (Booking[]) pullData(Booking.class);
        return getFreeRoomId(bookings, roomType, capacity, checkIn, checkOut);
    }

    /**
     * @param roomType
     * @param capacity
     * @param checkIn
     * @param checkOut
     * @return
     * @throws Exception
     */
    public static Room getFreeRoom(Booking[] bookings, RoomType roomType, int capacity, DateTime checkIn,
            DateTime checkOut)
            throws Exception {
        Room[] rooms = (Room[]) pullData(Room.class);

        Room result = null;
        for (int i = 0; i < rooms.length; i++)
            if (rooms[i] != null)
                if (rooms[i].getType().equals(roomType) && rooms[i].getCapacity() == capacity
                        && rooms[i].isOccupied(bookings, checkIn, checkOut) == false) {
                    result = rooms[i];
                    break;
                }

        // throwing exception if no room matches
        if (result == null)
            throw new Exception("No room avaiable for the selected dates."); // message appears in the CreateRoomPanel
        return result;
    }

    /**
     * @param roomType
     * @param capacity
     * @param checkIn
     * @param checkOut
     * @return
     * @throws Exception
     */
    public static Room getFreeRoom(RoomType roomType, int capacity, DateTime checkIn, DateTime checkOut)
            throws Exception {
        Booking[] bookings = (Booking[]) pullData(Booking.class);
        return getFreeRoom(bookings, roomType, capacity, checkIn, checkOut);
    }

    /**
     * @param bookings
     * @param roomType
     * @param capacity
     * @return
     */
    public static ArrayList<Room> getRoomsByTypeCapacity(Booking[] bookings, RoomType roomType, int capacity) {
        Room[] rooms = (Room[]) pullData(Room.class);

        ArrayList<Room> roomsByType = new ArrayList<>();
        for (Room room : rooms) {
            if (room != null && !room.isOccupied(bookings, new DateTime(), new DateTime()) && room.getType() == roomType
                    && room.getCapacity() == capacity) {
                roomsByType.add(room);
            }
        }
        return roomsByType;
    }

    /**
     * @param roomType
     * @param capacity
     * @return
     */
    public static ArrayList<Room> getRoomsByTypeCapacity(RoomType roomType, int capacity) {
        Booking[] bookings = (Booking[]) pullData(Booking.class);
        return getRoomsByTypeCapacity(bookings, roomType, capacity);
    }

    // Used to initialize rooms.json
    // if used, json will be reset and old data lost
    public static Room[] initRooms() {
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
            rooms[i] = new Room(i, RoomType.KING, 2);
        }

        pushData(Room.class, rooms);
        return rooms;
    }
}
