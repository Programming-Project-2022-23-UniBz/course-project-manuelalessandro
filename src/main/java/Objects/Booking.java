package Objects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.joda.time.DateTime;

/**
 * Represents a booking for a room.
 * 
 * @Author ManuelVillotti
 */
public class Booking {

    private String bookingId;
    private Date checkInDate;
    private Date checkOutDate;
    private int roomId;
    private String userId;
    private double totalCost;

    /**
     * Constructs a new Booking object with specified parameters.
     *
     * @param checkInDate  The check-in date and time.
     * @param checkOutDate The check-out date and time.
     * @param roomId       The ID of the room being booked.
     * @param userId       The ID of the user making the booking.
     */
    public Booking(DateTime checkInDate, DateTime checkOutDate, int roomId, String userId) {
        // Set check-in time to 2 PM
        this.checkInDate = checkInDate.withHourOfDay(14).withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0)
                .toDate();
        // Set check-out time to 10 AM
        this.checkOutDate = checkOutDate.withHourOfDay(10).withMinuteOfHour(0).withSecondOfMinute(0)
                .withMillisOfSecond(0).toDate();
        this.roomId = roomId;
        this.userId = userId;
        this.totalCost = calculateTotalCost(GeneralController.getRoom(roomId).getPrice(),
                calculateStay(this.checkInDate, this.checkOutDate));
        setId();
    }

    // ---- getters and setters

    /**
     * Gets the unique booking ID.
     *
     * @return The booking ID.
     */
    public String getId() {
        return bookingId;
    }

    /**
     * Generates a unique booking ID and sets it for the booking.
     */
    public void setId() {
        this.bookingId = generateId();
    }

    /**
     * Gets the check-in date and time as a Joda-Time DateTime object.
     *
     * @return The check-in date and time.
     */
    public DateTime getCheckInDate() {
        return new DateTime(checkInDate);
    }

    /**
     * Sets the check-in date and time for the booking and recalculates the total
     * cost.
     *
     * @param checkInDate The new check-in date and time.
     */
    public void setCheckInDate(DateTime checkInDate) {
        this.checkInDate = checkInDate.toDate();
        this.totalCost = calculateTotalCost(GeneralController.getRoom(roomId).getPrice(),
                calculateStay(this.checkInDate, this.checkOutDate));
    }

    /**
     * Gets the check-out date and time as a Joda-Time DateTime object.
     *
     * @return The check-out date and time.
     */
    public DateTime getCheckOutDate() {
        return new DateTime(checkOutDate);
    }

    /**
     * Sets the check-out date and time for the booking and recalculates the total
     * cost.
     *
     * @param checkOutDate The new check-out date and time.
     */
    public void setCheckOutDate(DateTime checkOutDate) {
        this.checkOutDate = checkOutDate.toDate();
        this.totalCost = calculateTotalCost(GeneralController.getRoom(roomId).getPrice(),
                calculateStay(this.checkInDate, this.checkOutDate));
    }

    /**
     * Gets the ID of the room being booked.
     *
     * @return The room ID.
     */
    public int getRoomId() {
        return roomId;
    }

    /**
     * Sets the ID of the room being booked and recalculates the total cost.
     *
     * @param roomId The new room ID.
     */
    public void setRoomId(int roomId) {
        this.roomId = roomId;
        this.totalCost = calculateTotalCost(GeneralController.getRoom(roomId).getPrice(),
                calculateStay(this.checkInDate, this.checkOutDate));
    }

    /**
     * Gets the ID of the user making the booking.
     *
     * @return The user ID.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the ID of the user making the booking.
     *
     * @param userId The new user ID.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets the total cost of the booking.
     *
     * @return The total cost.
     */
    public double getTotalCost() {
        return totalCost;
    }

    /**
     * Sets the total cost of the booking.
     *
     * @param totalCost The new total cost.
     */
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
                ", room=" + roomId +
                ", user=" + userId +
                ", totalCost=" + totalCost +
                '}';
    }

    /**
     * Generates a unique booking ID based on a predefined format.
     *
     * @return The generated booking ID.
     */
    public String generateId() {
        String prefix = "APH_";

        // Get today's date in the format "yyyyMMdd"
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String currentDate = dateFormat.format(new Date());

        // Generate 4 random digits
        int randomDigits = 1000 + new Random().nextInt(9000);

        // Combine the components to form the booking ID
        String generatedBookingId = prefix + currentDate + "_" + randomDigits;

        if (isIdUnique(generatedBookingId)) {
            return generatedBookingId;
        } else {
            // If the generated booking ID is not unique, recursively call the method to
            // generate another ID
            return generateId();
        }
    }

    /**
     * Checks if a given booking ID is unique among existing bookings.
     *
     * @param bookingId The booking ID to check for uniqueness.
     * @return True if the booking ID is unique, false otherwise.
     */
    public boolean isIdUnique(String bookingId) {
        Booking[] bookings = (Booking[]) GeneralController.pullData(Booking.class);
        if (bookings != null)
            for (Booking booking : bookings) {
                if (booking.getId().equals(bookingId)) {
                    return false; // Matching booking ID found, not unique
                }
            }
        return true; // unique
    }

    /**
     * Calculates the duration of a stay in terms of the number of nights.
     *
     * @param checkIn  The check-in date and time.
     * @param checkOut The check-out date and time.
     * @return The duration of the stay in nights.
     */
    public static int calculateStay(Date checkIn, Date checkOut) {
        DateTime checkInDate = new DateTime(checkIn);
        DateTime checkOutDate = new DateTime(checkOut);

        long diff = checkOutDate.toDate().getTime() - checkInDate.toDate().getTime();

        int stay = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

        return stay;
    }

    /**
     * Calculates the total cost of a booking based on the price per night and the
     * duration of the stay.
     *
     * @param price The price per night for the room.
     * @param stay  The duration of the stay in nights.
     * @return The total cost of the booking.
     */
    public static double calculateTotalCost(double price, int stay) {
        return price * stay;
    }

}
