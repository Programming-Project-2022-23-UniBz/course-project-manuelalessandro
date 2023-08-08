package Objects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.joda.time.DateTime;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import Objects.Room.RoomType;

public class GeneralController {
    static Gson gson = new Gson();

    // ----------------------------------------------------------------
    // -------------------- General part ------------------------------
    // ----------------------------------------------------------------

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
        else
            throw new IllegalArgumentException("Invalid class to pull data from: " + c);

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
        else
            throw new IllegalArgumentException("Invalid class to push data to: " + c);

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

    private static void incrementBookings(Booking[] bookings) {
        Booking[] newArr = new Booking[bookings.length + 1];
        for (int i = 0; i < bookings.length; i++) {
            newArr[i] = bookings[i];
        }
        bookings = newArr;
    }

    public static void addBooking(Booking[] bookings, Booking booking) {
        if (bookings == null) {
            bookings = new Booking[0];
        }
        incrementBookings(bookings);
        bookings[bookings.length - 1] = booking;
        pushData(Booking.class, bookings);
    }

    public static void addBooking(Booking booking) {
        Booking[] bookings = (Booking[]) pullData(Booking.class);
        incrementBookings(bookings);
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
    private static void initBookingsForTest() throws Exception {
        Booking[] bookings;
        try {
            bookings = new Booking[2];

            // Admin Room
            DateTime checkInAdmin = new DateTime(2023, 2, 11, 0, 0);
            DateTime checkOutAdmin = new DateTime(2023, 2, 16, 0, 0);
            int id1 = RoomControl.getFreeRoomId(RoomType.DELUXE, 2, checkInAdmin, checkOutAdmin);
            Room room1 = RoomControl.getRoom(id1);
            User user1 = UserControl.getUser(0); // adminUser
            Booking booking1 = new Booking(checkInAdmin, checkOutAdmin, room1, user1);
            bookings[0] = booking1;

            // Guest Room
            DateTime checkInGuest = new DateTime(2023, 5, 18, 0, 0);
            DateTime checkOutGuest = new DateTime(2023, 5, 26, 0, 0);
            int id2 = RoomControl.getFreeRoomId(RoomType.DELUXE, 1, checkInGuest, checkOutGuest);
            Room room2 = RoomControl.getRoom(id2);
            User user2 = UserControl.getUser(1); // guestUser
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
    // -------------------- Users control --------------------------
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------

}
