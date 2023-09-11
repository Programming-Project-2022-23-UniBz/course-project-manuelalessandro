package Objects;

import java.util.Date;
import java.util.ArrayList;
import org.joda.time.DateTime;

public class Room {

    public enum RoomType {
        STANDARD, DELUXE, KING
    }

    // instance variables
    private int id;
    private RoomType type;
    private int capacity;
    private double price;

    public Room(int id, RoomType roomType, int capacity) {

        this.id = id;
        this.type = roomType;
        this.capacity = capacity;
        if (this.capacity > 2)
            this.capacity = 2;
        if (roomType.equals(RoomType.STANDARD))
            if (capacity == 1)
                price = 100;
            else
                price = 150;
        else if (roomType.equals(RoomType.DELUXE))
            if (capacity == 1)
                price = 200;
            else
                price = 250;
        else
            price = 400;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", type=" + type +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Room other = (Room) obj;
        return id == other.id;
    }

    public boolean isOccupied(Booking[] bookingsGeneral, DateTime checkIn, DateTime checkOut) {
        boolean result = false;

        // get all bookings that have this room
        ArrayList<Booking> bookings = GeneralController
                .getAllBookings(bookingsGeneral, this.getId());

        Date checkInDate = checkIn.toDate();
        Date checkOutDate = checkOut.toDate();

        for (int i = 0; i < bookings.size(); i++) {
            Booking booking = bookings.get(i);
            // checks if dates are in between of the booking
            if (checkInDate.compareTo(booking.getCheckInDate().toDate()) >= 0
                    && checkOutDate.compareTo(booking.getCheckOutDate().toDate()) <= 0)
                result = true;

            // checks checkout is between
            else if (checkOutDate.compareTo(booking.getCheckInDate().toDate()) >= 0
                    && checkOutDate.compareTo(booking.getCheckOutDate().toDate()) <= 0)
                result = true;

            // checks checkin is between
            else if (checkInDate.compareTo(booking.getCheckInDate().toDate()) >= 0
                    && checkInDate.compareTo(booking.getCheckOutDate().toDate()) <= 0)
                result = true;

            // checks if booking is between dates
            else if (checkInDate.compareTo(booking.getCheckInDate().toDate()) <= 0
                    && checkOutDate.compareTo(booking.getCheckOutDate().toDate()) >= 0)
                result = true;
        }

        return result;
    }

    // checks if room is free for today
    public boolean isOccupied(Booking[] bookings) {
        DateTime today = new DateTime();
        return isOccupied(bookings, today, today);
    }

    public boolean isRoomAvailable(DateTime checkInDateTime, DateTime checkOutDateTime) {

        Booking[] bookings = (Booking[]) GeneralController.pullData(Booking.class);

        for (Booking booking : bookings) {
            if (booking.getRoomId() == this.getId()) {

                // Check if the booking overlaps with the desired check-in and check-out dates
                DateTime existingCheckInDateTime = booking.getCheckInDate();
                DateTime existingCheckOutDateTime = booking.getCheckOutDate();

                boolean overlap = (checkInDateTime.isBefore(existingCheckOutDateTime)
                        || checkInDateTime.isEqual(existingCheckOutDateTime))
                        && (checkOutDateTime.isAfter(existingCheckInDateTime)
                                || checkOutDateTime.isEqual(existingCheckInDateTime));

                if (overlap) {
                    return false; // Room is not available
                }
            }
        }
        return true; // Room is available
    }

    // --------------------Help methods-----------------------------
    /**
     * @param checkIn
     * @param checkOut
     * @return ArrayList<Date> containing all dates between checkIn and checkOut
     */
    public static ArrayList<DateTime> generateAllDates(DateTime checkIn, DateTime checkOut) {
        ArrayList<DateTime> result = new ArrayList<>();
        DateTime date = checkIn;
        while (!date.equals(checkOut)) {
            result.add(date);
            date = date.plusDays(1);
        }
        if (date != null)
            result.add(date);
        return result;
    }

}
