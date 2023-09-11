import Objects.Booking;
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
        DateTime checkIn = new DateTime(2023, 9, 1, 0, 0);
        DateTime checkOut = new DateTime(2023, 9, 5, 0, 0);
        Booking[] bookings = new Booking[0];

        assertFalse(room.isOccupied(bookings, checkIn, checkOut));
    }

    @Test
    public void testRoomIsAvailable() {
        DateTime checkIn = new DateTime(2023, 9, 1, 0, 0);
        DateTime checkOut = new DateTime(2023, 9, 5, 0, 0);

        assertTrue(room.isRoomAvailable(checkIn, checkOut));
    }

    @Test
    public void testGenerateAllDates() {
        DateTime checkIn = new DateTime(2023, 9, 1, 0, 0);
        DateTime checkOut = new DateTime(2023, 9, 5, 0, 0);

        var dates = Room.generateAllDates(checkIn, checkOut);

        assertEquals(5, dates.size());
    }
}
