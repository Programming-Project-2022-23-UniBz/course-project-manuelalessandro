package Objects;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.joda.time.DateTime;

import com.google.gson.Gson;

import Objects.Room.RoomType;
import Objects.User.GenderType;

/**
 * Controller class responsible for managing general operations like
 * reading/writing data from/to files.
 * 
 * @Author ManuelVillotti
 */
public class GeneralController {
    static Gson gson = new Gson();

    private static String usersPath = "src/main/resources/json/users.json";
    private static String bookingsPath = "src/main/resources/json/bookings.json";
    private static String roomsPath = "src/main/resources/json/rooms.json";
    private static String reviewsPath = "src/main/resources/json/reviews.json";

    // ----------------------------------------------------------------
    // -------------------- General part ------------------------------
    // ----------------------------------------------------------------

    /**
     * Main method for testing purposes.
     * 
     * @param args Command line arguments.
     * @throws Exception Throws an exception if an error occurs during execution.
     */
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to initialize every json file? [Yes/No]:");
        String answer = scanner.next();
        if (answer.equals("yes") || answer.equals("Yes")) {
            cleanFile(User.class);
            cleanFile(Booking.class);
            cleanFile(Room.class);
            initRooms();
            initUsers();
            initBookingsTest();
            System.out.println("INITIALIZED");
        } else
            System.out.println("not initialized");
        scanner.close();
    }

    /**
     * Retrieves an array of objects of a specified class type from the
     * corresponding JSON file.
     * 
     * @param c The class type of the object to be retrieved.
     * @return An array of objects of the specified class type.
     */
    @SuppressWarnings("rawtypes")
    public static Object[] pullData(Class c) {
        String path = "";
        if (c.equals(User.class))
            path = usersPath;
        else if (c.equals(Booking.class))
            path = bookingsPath;
        else if (c.equals(Room.class))
            path = roomsPath;
        else if (c.equals(Review.class))
            path = reviewsPath;
        else
            throw new IllegalArgumentException("Invalid class to pull data from: " + c);

        return pullData(c, path);
    }

    /**
     * Retrieves an array of objects of a specified class type from a specified JSON
     * file.
     * 
     * @param c    The class type of the object to be retrieved.
     * @param path The path to the JSON file.
     * @return An array of objects of the specified class type.
     */
    @SuppressWarnings("rawtypes")
    public static Object[] pullData(Class c, String path) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String json = null;
        if (scanner != null) {
            if (scanner.hasNextLine())
                json = scanner.nextLine();
            scanner.close();
        }

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

    /**
     * Pushes an array of objects to the corresponding JSON file.
     * 
     * @param <T>     The type of objects to be pushed.
     * @param c       The class type of the object to be pushed.
     * @param content An array of objects to be pushed.
     */
    public static <T> void pushData(Class<T> c, T[] content) {

        String path = "";
        if (c.equals(User.class))
            path = usersPath;
        else if (c.equals(Booking.class))
            path = bookingsPath;
        else if (c.equals(Room.class))
            path = roomsPath;
        else if (c.equals(Review.class))
            path = reviewsPath;
        else
            throw new IllegalArgumentException("Invalid class to push data to: " + c);

        pushData(c, path, content);
    }

    /**
     * Pushes an array of objects to a specified JSON file.
     * 
     * @param <T>     The type of objects to be pushed.
     * @param c       The class type of the object to be pushed.
     * @param path    The path to the JSON file.
     * @param content An array of objects to be pushed.
     */
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

    /**
     * Clears the content of a specified JSON file.
     * 
     * @param <T> The type of objects to be cleared.
     * @param c   The class type of the object to be cleared.
     */
    public static <T> void cleanFile(Class<T> c) {

        String path = "";
        if (c.equals(User.class))
            path = usersPath;
        else if (c.equals(Booking.class))
            path = bookingsPath;
        else if (c.equals(Room.class))
            path = roomsPath;
        else if (c.equals(Review.class))
            path = reviewsPath;

        try {
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write("");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    // -------------------- Bookings control --------------------------
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------

    /**
     * Calculates the average cost of a list of bookings.
     *
     * @param bookings An array of Booking objects.
     * @return The average cost of the bookings.
     */
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

    /**
     * Calculates the average cost of all bookings.
     *
     * @return The average cost of all bookings.
     */
    public static double getAverageCost() {
        Booking[] bookings = (Booking[]) pullData(Booking.class);
        return getAverageCost(bookings);
    }

    /**
     * Finds a booking associated with a specific user ID.
     *
     * @param bookings An array of Booking objects to search in.
     * @param userId   The user ID to search for.
     * @return The Booking object associated with the user ID, or null if not found.
     */
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

    /**
     * Finds a booking associated with a specific user ID from all bookings.
     *
     * @param userId The user ID to search for.
     * @return The Booking object associated with the user ID, or null if not found.
     */
    public static Booking findBooking(String userId) {
        Booking[] bookings = (Booking[]) pullData(Booking.class);
        return findBooking(bookings, userId);
    }

    /**
     * Retrieves a booking by its unique ID.
     *
     * @param bookings An array of Booking objects to search in.
     * @param id       The unique ID of the booking.
     * @return The Booking object with the specified ID.
     * @throws IllegalArgumentException If no booking with the given ID is found.
     */
    public static Booking getBookingById(Booking[] bookings, String id) throws IllegalArgumentException {
        for (Booking booking : bookings) {
            if (booking.getId().equals(id)) {
                return booking;
            }
        }
        throw new IllegalArgumentException("Booking with ID " + id + " not found.");
    }

    /**
     * Retrieves a booking by its unique ID from all bookings.
     *
     * @param id The unique ID of the booking.
     * @return The Booking object with the specified ID.
     * @throws IllegalArgumentException If no booking with the given ID is found.
     */
    public static Booking getBookingById(String id) throws IllegalArgumentException {
        Booking[] bookings = (Booking[]) pullData(Booking.class);
        return getBookingById(bookings, id);
    }

    /**
     * Removes a booking from a list of bookings by its unique ID.
     *
     * @param bookings An array of Booking objects.
     * @param id       The unique ID of the booking to be removed.
     * @return The updated array of Booking objects after removal.
     * @throws IllegalArgumentException If no booking with the given ID is found.
     */
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

    /**
     * Removes a booking from all bookings by its unique ID.
     *
     * @param id The unique ID of the booking to be removed.
     * @throws IllegalArgumentException If no booking with the given ID is found.
     */
    public static void removeBookingById(String id) throws IllegalArgumentException {
        Booking[] bookings = (Booking[]) pullData(Booking.class);
        bookings = removeBookingById(bookings, id);
        pushData(Booking.class, bookings);
    }

    /**
     * Retrieves all bookings associated with a specific room ID.
     *
     * @param bookings An array of Booking objects to search in.
     * @param roomId   The ID of the room to search for.
     * @return An ArrayList of Booking objects associated with the room ID.
     */
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

    /**
     * Retrieves all bookings associated with a specific room ID from all bookings.
     *
     * @param roomId The ID of the room to search for.
     * @return An ArrayList of Booking objects associated with the room ID.
     */
    public static ArrayList<Booking> getAllBookings(int roomId) {
        Booking[] bookings = (Booking[]) pullData(Booking.class);
        return getAllBookings(bookings, roomId);
    }

    /**
     * Retrieves all bookings associated with a specific user.
     *
     * @param bookings An array of Booking objects to search in.
     * @param user     The User object to search for.
     * @return An ArrayList of Booking objects associated with the user.
     */
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

    /**
     * Retrieves all bookings associated with a specific user from all bookings.
     *
     * @param user The User object to search for.
     * @return An ArrayList of Booking objects associated with the user.
     */
    public static ArrayList<Booking> getAllBookings(User user) {
        Booking[] bookings = (Booking[]) pullData(Booking.class);
        return getAllBookings(bookings, user);
    }

    /**
     * Increments the length of an array of bookings by one.
     *
     * @param bookings An array of Booking objects.
     * @return A new array of Booking objects with one additional slot.
     */
    public static Booking[] incrementBookings(Booking[] bookings) {
        Booking[] newArray = new Booking[bookings.length + 1];
        for (int i = 0; i < bookings.length; i++)
            newArray[i] = bookings[i];
        return newArray;
    }

    /**
     * Adds a new booking to an array of bookings.
     *
     * @param bookings An array of Booking objects.
     * @param booking  The Booking object to be added.
     * @return The updated array of Booking objects after addition.
     */
    public static Booking[] addBooking(Booking[] bookings, Booking booking) {
        if (bookings == null) {
            bookings = new Booking[0];
        }
        bookings = incrementBookings(bookings);
        bookings[bookings.length - 1] = booking;

        return bookings;
    }

    /**
     * Adds a new booking to all bookings.
     *
     * @param booking The Booking object to be added.
     */
    public static void addBooking(Booking booking) {
        Booking[] bookings = (Booking[]) pullData(Booking.class);
        bookings = addBooking(bookings, booking);
        pushData(Booking.class, bookings);
    }

    /**
     * Calculates the total amount earned for a specific month.
     *
     * @param bookings An array of Booking objects.
     * @param month    The month (1-12) to calculate the earnings for.
     * @return The total earnings for the specified month.
     */
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

    /**
     * Calculates the total amount earned for a specific month from all bookings.
     *
     * @param month The month (1-12) to calculate the earnings for.
     * @return The total earnings for the specified month.
     */
    public static double calculateTotalAmountForMonth(int month) {
        Booking[] bookings = (Booking[]) pullData(Booking.class);
        return calculateTotalAmountForMonth(bookings, month);
    }

    /**
     * Calculates the total earning from all bookings.
     *
     * @param bookings An array of Booking objects.
     * @return The total earning.
     */
    public static double getTotalEarningFromBookings(Booking[] bookings) {
        double amount = 0.0;

        for (Booking booking : bookings) {
            amount += booking.getTotalCost();
        }

        return amount;
    }

    /**
     * Calculates the total earning from all bookings.
     *
     * @return The total earning.
     */
    public static double getTotalEarningFromBookings() {
        Booking[] bookings = (Booking[]) pullData(Booking.class);
        return getTotalEarningFromBookings(bookings);
    }

    /**
     * Gets the number of bookings stored.
     *
     * @return The number of bookings.
     */
    public static int getBookingsLength() {
        Booking[] bookings = (Booking[]) pullData(Booking.class);
        return bookings.length;
    }

    @SuppressWarnings("unused")
    /**
     * Initializes the bookings data with sample Booking objects for testing
     * purposes.
     *
     * @throws Exception If an error occurs during the initialization process.
     */
    private static void initBookingsTest() throws Exception {
        Booking[] bookings;
        try {
            bookings = new Booking[1];

            // Guest Room
            DateTime checkInGuest = new DateTime(2023, 5, 18, 0, 0);
            DateTime checkOutGuest = new DateTime(2023, 5, 26, 0, 0);
            Room room2 = getFreeRoom(RoomType.DELUXE, 1, checkInGuest, checkOutGuest);
            User user2 = searchUser("guest@email.com"); // guestUser
            Booking booking2 = new Booking(checkInGuest, checkOutGuest, room2.getId(), user2.getId());
            bookings[0] = booking2;

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Init bookings failed.");
        }
        pushData(Booking.class, bookings);
    }

    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    // -------------------- Users control -----------------------------
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    /**
     * Removes a user from an array of User objects based on their ID.
     *
     * @param users An array of User objects.
     * @param id    The ID of the user to be removed.
     * @return The updated array of User objects after removal.
     * @throws IllegalArgumentException If no user with the given ID is found.
     */
    public static User[] removeUser(User[] users, String id) throws IllegalArgumentException {
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
            throw new IllegalArgumentException("Id does not exist");
        }

        return users;
    }

    /**
     * Removes a user from all users based on their ID.
     *
     * @param id The ID of the user to be removed.
     * @throws IllegalArgumentException If no user with the given ID is found.
     */
    public static void removeUser(String id) throws IllegalArgumentException {
        User[] users = (User[]) pullData(User.class);
        users = removeUser(users, id);
        pushData(User.class, users);
    }

    /**
     * Increments the length of an array of users by one.
     *
     * @param users An array of User objects.
     * @return A new array of User objects with one additional slot.
     */
    public static User[] incrementUsers(User[] users) {
        User[] newArray = new User[users.length + 1];
        for (int i = 0; i < users.length; i++)
            newArray[i] = users[i];
        return newArray;
    }

    /**
     * Adds a new user to an array of users, generating a unique ID for them.
     *
     * @param users An array of User objects.
     * @param user  The User object to be added.
     * @return The updated array of User objects after addition.
     */
    public static User[] addUser(User[] users, User user) {
        if (user.getId() == null || user.getId().length() < 2)
            user.setId(User.generateId(users));

        users = incrementUsers(users);
        int index = users.length - 1;
        users[index] = user;

        return users;
    }

    /**
     * Adds a new user to all users, generating a unique ID for them.
     *
     * @param user The User object to be added.
     */
    public static void addUser(User user) {
        User[] users = (User[]) pullData(User.class);
        users = addUser(users, user);
        pushData(User.class, users);
    }

    /**
     * Searches for a user by their email address within an array of User objects.
     *
     * @param users An array of User objects to search in.
     * @param email The email address to search for.
     * @return The User object associated with the email address.
     * @throws IllegalArgumentException If no user with the given email address is
     *                                  found.
     */
    public static User searchUser(User[] users, String email) throws IllegalArgumentException {
        for (int i = 0; i < users.length; i++)
            if (users[i].getEmail().equals(email))
                return users[i];
        throw new IllegalArgumentException("Email does not exist");
    }

    /**
     * Searches for a user by their email address within all users.
     *
     * @param email The email address to search for.
     * @return The User object associated with the email address.
     * @throws IllegalArgumentException If no user with the given email address is
     *                                  found.
     */
    public static User searchUser(String email) throws IllegalArgumentException {
        User[] users = (User[]) pullData(User.class);
        return searchUser(users, email);
    }

    /**
     * Searches for a user by their username and password within an array of User
     * objects.
     *
     * @param users    An array of User objects to search in.
     * @param username The username to search for.
     * @param password The password to search for.
     * @return The User object associated with the username and password.
     * @throws IllegalArgumentException If no user with the given username and
     *                                  password is found.
     */
    public static User searchUser(User[] users, String username, String password) throws IllegalArgumentException {
        for (int i = 0; i < users.length; i++)
            if (users[i].getUsername().equals(username) && users[i].getPassword().equals(password))
                return users[i];
        throw new IllegalArgumentException("Username not found");
    }

    /**
     * Searches for a user by their username and password within all users.
     *
     * @param username The username to search for.
     * @param password The password to search for.
     * @return The User object associated with the username and password.
     * @throws IllegalArgumentException If no user with the given username and
     *                                  password is found.
     */
    public static User searchUser(String username, String password) throws IllegalArgumentException {
        User[] users = (User[]) pullData(User.class);
        return searchUser(users, username, password);
    }

    /**
     * Retrieves a user by their unique ID within an array of User objects.
     *
     * @param users An array of User objects to search in.
     * @param id    The unique ID of the user.
     * @return The User object with the specified ID.
     * @throws IllegalArgumentException If no user with the given ID is found.
     */
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

    /**
     * Retrieves a user by their unique ID within all users.
     *
     * @param id The unique ID of the user.
     * @return The User object with the specified ID.
     * @throws IllegalArgumentException If no user with the given ID is found.
     */
    public static User getUser(String id) throws IllegalArgumentException {
        User[] users = (User[]) pullData(User.class);
        return getUser(users, id);
    }

    @SuppressWarnings("unused")
    /**
     * Initializes the users data with sample User objects for testing purposes.
     */
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
    // -------------------- Review Control ----------------------------
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------

    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    // -------------------- Room control ------------------------------
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------

    /**
     * Retrieves a Room object by its unique ID.
     *
     * @param id The unique ID of the room to be retrieved.
     * @return The Room object with the specified ID.
     * @throws IllegalArgumentException If no room with the given ID is found.
     */
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

    /**
     * Initializes the rooms data with sample Room objects for testing purposes.
     * This method creates and assigns rooms with unique IDs and room types
     * (STANDARD, DELUXE, KING) to simulate a hotel's room inventory.
     * 
     * @return An array of Room objects representing the initialized rooms.
     * @throws IllegalArgumentException If an error occurs during the initialization
     *                                  process.
     */
    public static Room[] initRooms() {
        Room[] rooms = new Room[400];

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
