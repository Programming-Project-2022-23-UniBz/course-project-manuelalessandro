package Objects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
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
    }

    // getters and setters
    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId() {
        this.bookingId = bookingIdGenerator();
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

    public void setTotalCost() {
        this.totalCost = calculateTotalCost();
    }

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

    public double calculateTotalCost() {

        long diff = this.checkOutDate.getTime() - this.checkInDate.getTime();
        int stay = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        return stay * this.room.getPrice();
    }

}
