import Objects.Room;
import Objects.Room.RoomType;
import org.joda.time.DateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {
    private Room room;

    @BeforeEach
    public void setUp() {
        // Create a new Room instance before each test
        room = new Room(1, RoomType.STANDARD, 2);
    }

    @Test
    public void testRoomInitialization() {
        assertEquals(1, room.getId());
        assertEquals(RoomType.STANDARD, room.getType());
        assertEquals(2, room.getCapacity());
        assertEquals(150.0, room.getPrice());
    }

    @Test
    public void testRoomIsOccupied() {
        // Create a DateTime range for testing
        DateTime checkIn = new DateTime(2023, 9, 1, 0, 0);
        DateTime checkOut = new DateTime(2023, 9, 5, 0, 0);

        // Initially, the room should not be occupied
        assertFalse(room.isOccupied(checkIn, checkOut));
    }

    @Test
    public void testRoomIsAvailable() {
        // Create a DateTime range for testing
        DateTime checkIn = new DateTime(2023, 9, 1, 0, 0);
        DateTime checkOut = new DateTime(2023, 9, 5, 0, 0);

        // Initially, the room should be available
        assertTrue(room.isRoomAvailable(checkIn, checkOut));
    }

    @Test
    public void testRoomIsNotAvailable() {
        // Create a DateTime range for testing
        DateTime checkIn = new DateTime(2023, 9, 1, 0, 0);
        DateTime checkOut = new DateTime(2023, 9, 5, 0, 0);

        // Occupied the room for the test period
        room.isOccupied(checkIn, checkOut);

        // Now, the room should not be available
        assertFalse(room.isRoomAvailable(checkIn, checkOut));
    }

    @Test
    public void testGenerateAllDates() {
        // Test the generateAllDates helper method
        DateTime checkIn = new DateTime(2023, 9, 1, 0, 0);
        DateTime checkOut = new DateTime(2023, 9, 5, 0, 0);

        // Generate all dates between checkIn and checkOut
        var dates = Room.generateAllDates(checkIn, checkOut);

        // Verify that the number of generated dates is correct
        assertEquals(5, dates.size());
    }
}
