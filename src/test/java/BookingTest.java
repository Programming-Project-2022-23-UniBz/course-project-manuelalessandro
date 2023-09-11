import org.joda.time.DateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Objects.Booking;

public class BookingTest {

    @Test
    public void testCalculateStay() {
        DateTime checkIn = new DateTime(2023, 9, 10, 14, 0); // September 10, 2023, 2 PM
        DateTime checkOut = new DateTime(2023, 9, 12, 10, 0); // September 12, 2023, 10 AM
        int expectedStay = 1; // 1 night stay

        int actualStay = Booking.calculateStay(checkIn.toDate(), checkOut.toDate());

        Assertions.assertEquals(expectedStay, actualStay);
    }

    @Test
    public void testCalculateTotalCost() {
        double price = 100.5; // Price per night
        int stay = 2; // 2 nights stay
        double expectedTotalCost = 201.0;

        double actualTotalCost = Booking.calculateTotalCost(price, stay);

        Assertions.assertEquals(expectedTotalCost, actualTotalCost);
    }

    @Test
    public void testGenerateId() {
        Booking booking = new Booking(
                new DateTime(2023, 9, 10, 14, 0), // September 10, 2023, 2 PM
                new DateTime(2023, 9, 12, 10, 0), // September 12, 2023, 10 AM
                103,
                "user123");

        String generatedId = booking.generateId();

        Assertions.assertTrue(generatedId.matches("APH_\\d{8}_\\d{4}"));
    }

    @Test
    public void testIsIdUnique() {
        Booking booking1 = new Booking(
                new DateTime(2023, 9, 10, 14, 0), // September 10, 2023, 2 PM
                new DateTime(2023, 9, 12, 10, 0), // September 12, 2023, 10 AM
                100,
                "user123");

        Booking booking2 = new Booking(
                new DateTime(2023, 9, 13, 14, 0), // September 13, 2023, 2 PM
                new DateTime(2023, 9, 15, 10, 0), // September 15, 2023, 10 AM
                102,
                "user456");

        Assertions.assertTrue(booking1.isIdUnique(booking1.generateId()));
        Assertions.assertTrue(booking2.isIdUnique(booking2.generateId()));
    }

}
