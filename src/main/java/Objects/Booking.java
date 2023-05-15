package Objects;

import java.util.Date;
import java.util.concurrent.TimeUnit;

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

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
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

    public static int calculateStay(DateTime checkInDate, DateTime checkOutDate) {
        long diff = checkOutDate.toDate().getTime() - checkInDate.toDate().getTime();
        return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public static double calculateTotalCost(double price, int stay) {
        return price * stay;
    }

}
