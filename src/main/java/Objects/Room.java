package Objects;

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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
