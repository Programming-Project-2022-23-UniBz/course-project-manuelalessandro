package Objects;

import com.google.gson.Gson;

import Objects.Room.RoomType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;
import org.joda.time.DateTime;

public class BookingControl {
    private static Booking[] bookings;
    private static Gson gson = new Gson();

    public static void pullData() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/main/resources/json/bookings.json"));
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
            FileWriter writer = new FileWriter("src/main/resources/json/bookings.json");
            writer.append(json);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static int getBookingCount(){
        pullData();
        
        if (bookings == null) {
            return 0; // Return 0 if there are no bookings
        }
        
        return bookings.length;
    }
    
    public static double calculateAverageCost() {
        pullData();
        
        if (bookings == null || bookings.length == 0) {
            return 0.0; // Return 0 if there are no bookings
        }

        double totalCost = 0;
        for (Booking booking : bookings) {
            totalCost += booking.getTotalCost();
        }

        return totalCost / bookings.length;
    }

    private static void incrementBookings() {
        Booking[] newArr = new Booking[bookings.length + 1];
        for (int i = 0; i < bookings.length; i++) {
            newArr[i] = bookings[i];
        }
        bookings = newArr;
    }

    public static Booking findBooking(User user) {
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

    public static Booking getBookingById(String id) throws IllegalArgumentException {
        BookingControl.pullData();

        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(id)) {
                return booking;
            }
        }
        throw new IllegalArgumentException("Booking with ID " + id + " not found.");
    }

    public static void removeBookingById(String id) throws IllegalArgumentException {
        pullData();

        int index = -1;
        //Find the index of the booking to remove
        for (int i = 0; i < bookings.length; i++) {
            if (bookings[i].getBookingId().equals(id)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            Booking[] updatedBookings = new Booking[bookings.length - 1];

            //Operations to copy the bookings before and after the index to the updatedBookings array.
            if (index > 0) {
                //starts from index 0 in the source array (bookings) and index 0 in the destination array
                //copies index number of elements from the source array to the destination array
                System.arraycopy(bookings, 0, updatedBookings, 0, index);
            }
            if (index < bookings.length - 1) {
                //skips the element at the index position and copies the remaining elements after that position
                System.arraycopy(bookings, index + 1, updatedBookings, index, bookings.length - index - 1);
            }
            bookings = updatedBookings;
        } else {
            throw new IllegalArgumentException("Booking with ID " + id + " not found.");
        }

        pushData();
    }

    // @return ArrayList<Booking> that contains all the bookings that have that room
    public static ArrayList<Booking> getAllBookings(Room room) {
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

    public static void createBooking(User user, Room room, Date checkIn, Date checkOut) {
        Booking booking = new Booking(new DateTime(checkIn), new DateTime(checkOut), room, user);
        addBooking(booking);
    }

    public static void addBooking(Booking booking) {
        if (bookings == null) {
            bookings = new Booking[0];
        }
        incrementBookings();
        bookings[bookings.length - 1] = booking;
    }

    // Used to initialize bookings.json for test purposes
    // if used, json will be reset and old data lost
    private static void initBookingsForTest() throws Exception {
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
    }

    public static Booking[] getBookings() {
        return bookings;
    }

    // @returns the total amount earned for a specific month
    public static double calculateTotalAmountForMonth(int month) {
        pullData();

        double totalAmount = 0;
        boolean hasBookings = false;

        for (Booking booking : bookings) {
            DateTime checkInDate = new DateTime(booking.getCheckInDate());

            /*
            It retrieves the check-in date of each booking and checks if
            the month of the check-in date matches the specified month.
            If there is a match, that particular booking will be counted in the total income for the given month
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

    public static double totalEarningFromBookings(){
        pullData();
        double amount = 0.0;

        for (Booking booking: bookings) {
            amount+= booking.getTotalCost();
        }

        return amount;
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
        RoomControl.pullData();
        UserControl.pullData();
        pullData();

        pushData();
        RoomControl.pushData();
        UserControl.pushData();
    }
}