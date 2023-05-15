package Objects;

public class Room {

    public enum RoomType {
        SINGLE_ROOM_STANDARD, SINGLE_ROOM_DELUXE, DOUBLE_ROOM_STANDARD, DOUBLE_ROOM_DELUXE, KING_SUITE
    }

    // instance variables
    private int id;
    private RoomType roomType;
    private int capacity;
    private double price;
    private boolean isAvailable;

    public Room(int id, RoomType roomType) {

        this.id = id;
        this.roomType = roomType;

        switch (roomType) {
            case SINGLE_ROOM_STANDARD:
                this.capacity = 1;
                this.price = 150.00;
                break;
            case SINGLE_ROOM_DELUXE:
                this.capacity = 1;
                this.price = 200.00;
                break;
            case DOUBLE_ROOM_STANDARD:
                this.capacity = 2;
                this.price = 160.00;
                break;
            case DOUBLE_ROOM_DELUXE:
                this.capacity = 2;
                this.price = 280.00;
                break;
            case KING_SUITE:
                this.capacity = 2;
                this.price = 350.00;
                break;
            default:
                break;
        }
        this.isAvailable = true;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType type) {
        this.roomType = type;
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
