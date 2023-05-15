package Objects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;

import org.joda.time.DateTime;

public class Booking {

    private String bookingId;
    private DateTime checkInDate;
    private DateTime checkOutDate;
    private Room room;
    private User user;
    private double totalCost;

    public Booking(DateTime checkInDate, DateTime checkOutDate, Room room, User user) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.room = room;
        this.user = user;
        this.totalCost = calculateTotalCost(room.getPrice(), calculateStay(checkInDate, checkOutDate));
    }

    // getters and setters
    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId() {
        this.bookingId = bookingIdGenerator();
    }

    public DateTime getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(DateTime checkInDate) {
        this.checkInDate = checkInDate;
    }

    public DateTime getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(DateTime checkOutDate) {
        this.checkOutDate = checkOutDate;
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
        String generatedbookingId = prefix + currentDate + randomDigits;

        return generatedbookingId;
    }

    public static int calculateStay(DateTime checkInDate, DateTime checkOutDate) {
        long diff = checkOutDate.toDate().getTime() - checkInDate.toDate().getTime();
        return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public static double calculateTotalCost(double price, int stay) {
        return price * stay;
    }

}
