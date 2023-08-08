package Objects;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.joda.time.DateTime;

public class Booking {

    private String bookingId;
    private Date checkInDate;
    private Date checkOutDate;
    private Room room;
    private User user;
    private double totalCost;

    public Booking(DateTime checkInDate, DateTime checkOutDate, Room room, User user) {
        // Set check-in time to 2 PM
        this.checkInDate = checkInDate.withHourOfDay(14).withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0)
                .toDate();
        // Set check-out time to 10 AM
        this.checkOutDate = checkOutDate.withHourOfDay(10).withMinuteOfHour(0).withSecondOfMinute(0)
                .withMillisOfSecond(0).toDate();
        this.room = room;
        this.user = user;
        this.totalCost = calculateTotalCost(room.getPrice(), calculateStay(this.checkInDate, this.checkOutDate));
        setId();
    }

    // getters and setters
    public String getId() {
        return bookingId;
    }

    public void setId() {
        this.bookingId = bookingIdGenerator();
    }

    public DateTime getCheckInDate() {
        return new DateTime(checkInDate);
    }

    public void setCheckInDate(DateTime checkInDate) {
        this.checkInDate = checkInDate.toDate();
        this.totalCost = calculateTotalCost(this.room.getPrice(), calculateStay(this.checkInDate, this.checkOutDate));
    }

    public DateTime getCheckOutDate() {
        return new DateTime(checkOutDate);
    }

    public void setCheckOutDate(DateTime checkOutDate) {
        this.checkOutDate = checkOutDate.toDate();
        this.totalCost = calculateTotalCost(this.room.getPrice(), calculateStay(this.checkInDate, this.checkOutDate));
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
        this.totalCost = calculateTotalCost(this.room.getPrice(), calculateStay(this.checkInDate, this.checkOutDate));
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

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", room=" + room +
                ", user=" + user +
                ", totalCost=" + totalCost +
                '}';
    }

    public String bookingIdGenerator() {
        String prefix = "APH_";

        // Get today's date in the format "yyyyMMdd"
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String currentDate = dateFormat.format(new Date());

        // Generate 4 random digits
        int randomDigits = 1000 + new Random().nextInt(9000);

        // Combine the components to form the booking ID
        String generatedBookingId = prefix + currentDate + "_" + randomDigits;

        if (isBookingIdUnique(generatedBookingId)) {
            return generatedBookingId;
        } else {
            // If the generated booking ID is not unique, recursively call the method to
            // generate another ID
            return bookingIdGenerator();
        }
    }

    private boolean isBookingIdUnique(String bookingId) {
        Booking[] bookings = (Booking[]) GeneralController.pullData(Booking.class);

        for (Booking booking : bookings) {
            if (booking.getId().equals(bookingId)) {
                return false; // Matching booking ID found, not unique
            }
        }
        return true; // unique
    }

    // @returns the duration of a stay in terms of the number of nights
    public static int calculateStay(Date checkIn, Date checkOut) {
        DateTime checkInDate = new DateTime(checkIn);
        DateTime checkOutDate = new DateTime(checkOut);

        long diff = checkOutDate.toDate().getTime() - checkInDate.toDate().getTime();

        int stay = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

        return stay;
    }

    public static double calculateTotalCost(double price, int stay) {
        return price * stay;
    }

}
