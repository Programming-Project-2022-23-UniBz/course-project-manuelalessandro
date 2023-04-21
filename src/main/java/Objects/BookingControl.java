package Objects;

import com.google.gson.Gson;

import Objects.Room.RoomType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;

public class BookingControl {
    private static Booking[] bookings;
    private static Gson gson = new Gson();

    public static void pullData() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/main/java/Objects/json/bookings.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String json = null;
        if (scanner.hasNextLine())
            json = scanner.nextLine();
        scanner.close();
        bookings = gson.fromJson(json, Booking[].class);
    }

    public static void pushData() {
        String json = gson.toJson(bookings);
        try {
            FileWriter writer = new FileWriter("src/main/java/Objects/json/bookings.json");
            writer.append(json);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void incrementBookings() {
        Booking[] newArr = new Booking[bookings.length + 1];
        for (int i = 0; i < bookings.length; i++) {
            newArr[i] = bookings[i];
        }
        bookings = newArr;
    }

    public static Booking getBooking(int id) throws IllegalArgumentException {
        Booking booking = null;
        if (bookings.length > id)
            booking = bookings[id];
        if (booking == null)
            throw new IllegalArgumentException("Room does not exist");
        else
            return booking;
    }

    public static void addBooking(Booking booking) {
        incrementBookings();
        bookings[bookings.length - 1] = booking;
    }

    // Used to initialize bookings.json for test purposes
    // if used, json will be reset and old data lost
    private static void initBookingsForTest() {
        bookings = new Booking[2];

        // Admin Room
        Room room1 = RoomControl.getRoom(RoomControl.getFreeRoomId(RoomType.DELUXE, 2));
        User user1 = UserControl.getUser(0); // adminUser
        Booking booking1 = new Booking(new GregorianCalendar(2023, 2, 11).getTime(),
                new GregorianCalendar(2023, 2, 16).getTime(), room1, user1);
        bookings[0] = booking1;

        // Guest Room
        Room room2 = RoomControl.getRoom(RoomControl.getFreeRoomId(RoomType.DELUXE, 1));
        User user2 = UserControl.getUser(1); // guestUser
        Booking booking2 = new Booking(new GregorianCalendar(2023, 5, 18).getTime(),
                new GregorianCalendar(2023, 5, 26).getTime(), room2, user2);
        bookings[1] = booking2;
    }

    // Used to initialize bookings.json
    // if used, json will be reset and old data lost
    private static void initBookings() {
        bookings = new Booking[0];
    }

    public static String getString() {
        String result = "";
        for (int i = 0; i < bookings.length; i++) {
            result += "User email: " + bookings[i].getUser().getEmail() + ", Room Nr: " + bookings[i].getRoom().getId()
                    + "\n";
        }
        return result;
    }

    public static void main(String[] args) {
        pullData();

        pushData();
    }
}