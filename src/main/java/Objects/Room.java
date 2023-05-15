package Objects;

import java.util.Date;
import java.time.Year;
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

    public boolean isOccupied(DateTime checkIn, DateTime checkOut) {
        boolean result = false;
        ArrayList<Booking> bookings = new ArrayList<Booking>();

        for (int i = 0; i < bookings.size(); i++) {
            if (checkIn.toDate().compareTo(bookings.get(i).getCheckInDate().toDate()) >= 0
                    && checkOut.toDate().compareTo(bookings.get(i).getCheckOutDate().toDate()) <= 0)
                result = true;
        }

        return result;
    }

    // --------------------Help
    // methods----------------------------------------------
    /**
     * @param checkIn
     * @param checkOut
     * @return ArrayList<Date> containing all dates between checkIn and checkOut
     */
    private static ArrayList<DateTime> generateAllDates(DateTime checkIn, DateTime checkOut) {
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
