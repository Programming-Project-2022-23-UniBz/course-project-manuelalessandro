package Objects;

import java.time.Duration;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Booking {

    private String bookingId;
    private Date checkInDate;
    private Date checkOutDate;
    private Room room;
    private User user;
    private double totalCost;

    public Booking(Date checkInDate, Date checkOutDate, Room room, User user) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.room = room;
        this.user = user;
        this.totalCost = calculateTotalCost();
    }

    // getters and setters
    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
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

    public int calculateStay() {
        long diff = checkOutDate.getTime() - checkInDate.getTime();
        return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));;

        //TODO test
    }

    public double calculateTotalCost() {
        return room.getPrice() * calculateStay();
    }

}
