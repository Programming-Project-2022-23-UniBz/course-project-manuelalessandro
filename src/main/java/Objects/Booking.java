package Objects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.joda.time.DateTime;
import static Objects.BookingControl.getBookings;

public class Booking {

    private String bookingId;
    private Date checkInDate;
    private Date checkOutDate;
    private Room room;
    private User user;
    private double totalCost;

    public Booking(DateTime checkInDate, DateTime checkOutDate, Room room, User user) {
        this.checkInDate = checkInDate.toDate();
        this.checkOutDate = checkOutDate.toDate();
        this.room = room;
        this.user = user;
        this.totalCost = calculateTotalCost(room.getPrice(), calculateStay(this.checkInDate, this.checkOutDate));
        setBookingId();
    }

    // getters and setters
    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId() {
        this.bookingId = bookingIdGenerator();
    }

    public DateTime getCheckInDate() {
        return new DateTime(checkInDate);
    }

    public void setCheckInDate(DateTime checkInDate) {
        this.checkInDate = checkInDate.toDate();
    }

    public DateTime getCheckOutDate() {
        return new DateTime(checkOutDate);
    }

    public void setCheckOutDate(DateTime checkOutDate) {
        this.checkOutDate = checkOutDate.toDate();
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    // --------------------------------------------------------

    public String bookingIdGenerator() {
        String prefix = "ADH_";

        // Get today's date in the format "yyyyMMdd"
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String currentDate = dateFormat.format(new Date());

        // Generate 4 random digits
        int randomDigits = 1000 + new Random().nextInt(9000);

        // Combine the components to form the booking ID
        String generatedBookingId = prefix + currentDate + randomDigits;

        if (isBookingIdUnique(generatedBookingId)) {
            return generatedBookingId;
        } else {
            // If the generated booking ID is not unique, recursively call the method to generate another ID
            return bookingIdGenerator();
        }
    }
    private boolean isBookingIdUnique(String bookingId) {
        Booking[] bookings = getBookings();

        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(bookingId)) {
                return false; // Matching booking ID found, not unique
            }
        }
        return true; //unique
    }

    public static int calculateStay(Date checkIn, Date checkOut) {
        DateTime checkInDate = new DateTime(checkIn);
        DateTime checkOutDate = new DateTime(checkOut);

        // If check-in and check-out dates are on the same day, return 1
        if (isSameDay(checkInDate, checkOutDate)) {
            return 1;
        }

        long diff = checkOutDate.toDate().getTime() - checkInDate.toDate().getTime();
        return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    private static boolean isSameDay(DateTime dateTime1, DateTime dateTime2) {
        return dateTime1.toLocalDate().isEqual(dateTime2.toLocalDate());
    }

    public static double calculateTotalCost(double price, int stay) {
        return price * stay;
    }

}
