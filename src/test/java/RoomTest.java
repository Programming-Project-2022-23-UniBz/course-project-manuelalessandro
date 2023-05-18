import Objects.Room;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

public class RoomTest {

    @Test
    public void testIsOccupied_WithNoBookings_ReturnsFalse() {
        // Arrange
        Room room = new Room(1, Room.RoomType.STANDARD, 2);
        DateTime checkIn = new DateTime(2023, 5, 1, 0, 0);
        DateTime checkOut = new DateTime(2023, 5, 3, 0, 0);

        // Act
        boolean occupied = room.isOccupied(checkIn, checkOut);

        // Assert
        Assert.assertFalse(occupied);
    }

    @Test
    public void testIsOccupied_WithOccupiedDates_ReturnsTrue() {
        //TODO
    }

    @Test
    public void testIsOccupied_WithPartialOverlap_ReturnsTrue() {
        //TODO
    }

    @Test
    public void testIsOccupied_WithNoOverlap_ReturnsFalse() {
        //TODO
    }
    
    @Test
    public void testIsOccupied_WithNoBookingsForToday() {
        // Arrange
        Room room = new Room(1, Room.RoomType.STANDARD, 2);

        // Check availability for today's date
        DateTime today = new DateTime();

        // Act
        boolean occupied = room.isOccupied();

        // Assert
        Assert.assertFalse(occupied);
    }
    
}

