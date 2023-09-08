import org.junit.jupiter.api.*;

import Objects.Booking;
import Objects.GeneralController;
import Objects.Room;
import Objects.User;
import Objects.Room.RoomType;
import Objects.User.GenderType;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.joda.time.DateTime;

public class GeneralControllerTest {

    public static void main(String[] args) throws Exception {
        GeneralController.initRooms();
        System.out.println("TotalAmount: " + GeneralController.calculateTotalAmountForMonth(getSampleBookings(), 9));
    }

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        GeneralController.initRooms();
    }

    @AfterAll
    public static void tearDownAfterClass() throws Exception {
        // Cleanup after all tests, if needed.
    }

    @BeforeEach
    public void setUp() throws Exception {
        // Setup before each individual test here.
    }

    @AfterEach
    public void tearDown() throws Exception {
        // Cleanup after each individual test, if needed.
    }

    private static User[] getSampleUsers() {
        User u1 = new User("u1name", "u1surname", "u1", new DateTime(1980, 05, 05, 0, 0).toDate(), GenderType.MAN,
                "u1@test.it",
                "u1pass", "admin");
        User u2 = new User("u2name", "u2surname", "u2", new DateTime(2000, 05, 05, 0, 0).toDate(), GenderType.WOMAN,
                "u2@test.it",
                "u2pass", "user");
        User u3 = new User("u3name", "u3surname", "u3", new DateTime(2003, 05, 05, 0, 0).toDate(), GenderType.OTHER,
                "u3@test.it",
                "u3pass", "user");
        User[] users = new User[0];
        users = GeneralController.addUser(users, u1);
        users = GeneralController.addUser(users, u2);
        users = GeneralController.addUser(users, u3);
        return users;
    }

    public static Booking[] getSampleBookings() throws Exception {
        // Create an array of sample bookings
        User[] users = getSampleUsers();

        Booking[] bookings = new Booking[0];

        // booking 1
        DateTime dateTime1 = new DateTime(2022, 9, 2, 0, 0);
        DateTime dateTime2 = new DateTime(2022, 9, 5, 0, 0);
        Room r1 = GeneralController.getFreeRoom(bookings, RoomType.STANDARD, 1, dateTime1,
                dateTime2);
        Booking b1 = new Booking(dateTime1, dateTime2, r1.getId(), users[0].getId());
        bookings = GeneralController.addBooking(bookings, b1);

        // booking 2
        Room r2 = GeneralController.getFreeRoom(bookings, RoomType.DELUXE, 2, new DateTime(),
                new DateTime().plusDays(2));
        Booking b2 = new Booking(new DateTime(), new DateTime().plusDays(2), r2.getId(), users[1].getId());
        bookings = GeneralController.addBooking(bookings, b2);

        // booking 3
        Room r3 = GeneralController.getFreeRoom(bookings, RoomType.KING, 2, new DateTime(),
                new DateTime().plusDays(3));
        Booking b3 = new Booking(new DateTime(), new DateTime().plusDays(3), r3.getId(), users[2].getId());
        bookings = GeneralController.addBooking(bookings, b3);

        return bookings;
    }

    private static Booking getSampleBooking1() throws Exception {
        return getSampleBookings()[0];
    }

    private static Booking getSampleBooking2() throws Exception {
        return getSampleBookings()[1];
    }

    @Test
    public void testGetAverageCost() throws Exception {
        // Create an array of sample bookings
        Booking[] bookings = getSampleBookings();

        // Calculate the average cost using the method
        double averageCost = GeneralController.getAverageCost(bookings);

        // Verify that the calculated average cost matches the expected value
        assertEquals(416.66, averageCost, 0.01);
    }

    @Test
    public void testFindBooking() throws Exception {
        // Create an array of sample bookings
        Booking[] bookings = getSampleBookings();

        // Test finding an existing booking by ID
        Booking foundBooking = GeneralController.findBooking(bookings, bookings[1].getUserId());
        assertNotNull(foundBooking);
        assertEquals(bookings[1].getId(), foundBooking.getId());

        // Test finding a non-existing booking by ID
        Booking nonExistingBooking = GeneralController.findBooking(bookings, "non-existing-id");
        assertNull(nonExistingBooking);
    }

    @Test
    public void testGetBookingById() throws Exception {
        // Create an array of sample bookings
        Booking[] bookings = getSampleBookings();

        // Test getting an existing booking by ID
        Booking existingBooking = GeneralController.getBookingById(bookings, bookings[1].getId());
        assertNotNull(existingBooking);
        assertEquals(bookings[1].getId(), existingBooking.getId());

        // Test getting a non-existing booking by ID, which should throw an exception
        assertThrows(IllegalArgumentException.class, () -> {
            GeneralController.getBookingById(bookings, "non-existing-id");
        });
    }

    @Test
    public void testRemoveBookingById() throws Exception {
        // Create a test booking and add it to the data
        Booking[] bookingsOriginal = getSampleBookings();
        Booking[] bookings = getSampleBookings();

        // Remove the booking by ID
        bookings = GeneralController.removeBookingById(bookings, bookings[0].getId());

        boolean exceptionRaised = false;
        try {
            GeneralController.getBookingById(bookings, bookingsOriginal[0].getId());
        } catch (IllegalArgumentException e) {
            exceptionRaised = true;
        }
        assertTrue(exceptionRaised);
    }

    @Test
    public void testGetAllBookings() throws Exception {
        // Create test bookings and retrieve all bookings
        Booking booking1 = getSampleBooking1();
        Booking booking2 = getSampleBooking2();

        // ########## by room id ##########
        // set same room id for both
        Room room = GeneralController.getFreeRoom(Room.RoomType.STANDARD, 1, new DateTime(),
                new DateTime().plusDays(3));
        booking1.setRoomId(room.getId());
        booking2.setRoomId(room.getId());

        Booking[] bookings = new Booking[0];
        bookings = GeneralController.addBooking(bookings, booking1);
        bookings = GeneralController.addBooking(bookings, booking2);

        ArrayList<Booking> allBookings = GeneralController.getAllBookings(bookings, room.getId());

        // Verify that the retrieved bookings list contains the expected bookings
        assertNotNull(allBookings);
        assertEquals(2, allBookings.size());
        assertEquals(booking1.getId(), allBookings.get(0).getId());
        assertEquals(booking2.getId(), allBookings.get(1).getId());

        // ########## by user id ##########
        // set same user id for both
        User user = getSampleUsers()[0];
        booking1.setUserId(user.getId());
        booking2.setUserId(user.getId());

        bookings = new Booking[0];
        bookings = GeneralController.addBooking(bookings, booking1);
        bookings = GeneralController.addBooking(bookings, booking2);

        allBookings = GeneralController.getAllBookings(bookings, user);

        // Verify that the retrieved bookings list contains the expected bookings
        assertNotNull(allBookings);
        assertEquals(2, allBookings.size());
        assertEquals(booking1.getId(), allBookings.get(0).getId());
        assertEquals(booking2.getId(), allBookings.get(1).getId());
    }

    @Test
    public void testCalculateTotalAmountForMonth() throws Exception {
        Booking[] bookings = getSampleBookings();
        int monthToCalculate = 9;
        double expectedTotal = 1250.0;

        double actualTotal = GeneralController.calculateTotalAmountForMonth(bookings, monthToCalculate);

        assertEquals(expectedTotal, actualTotal, 0.001);
    }

    @Test
    public void testGetUser() {
        User[] users = getSampleUsers();
        User expectedUser = users[0];

        User actualUser = GeneralController.getUser(users, expectedUser.getId());

        assertEquals(expectedUser, actualUser);

        String nonExistentUserId = "";
        assertThrows(IllegalArgumentException.class, () -> {
            GeneralController.getUser(users, nonExistentUserId);
        });
    }

    @Test
    public void testRemoveUser() {
        User[] users = getSampleUsers();
        String userIdToRemove = users[0].getId();

        // Remove the user by ID
        users = GeneralController.removeUser(users, userIdToRemove);

        // Verify that the user no longer exists in the array
        User userExists = GeneralController.getUser(users, userIdToRemove);
        assertNull(userExists);
    }

    @Test
    public void testAddUser() {
        // Create test users
        User[] users = getSampleUsers();
        User newUser = new User(null, null, null, null, null);
        newUser.setId("testId");

        // Add the new user to the array
        users = GeneralController.addUser(users, newUser);

        // Verify that the new user exists in the array
        User userExists = GeneralController.getUser(users, newUser.getId());
        assertEquals(userExists, newUser);
    }

    @Test
    public void testSearchUser() {
        // Create test users
        User[] users = getSampleUsers(); // Replace with your test data
        String emailToSearch = "user@example.com"; // Replace with the email to search for

        // Search for the user by email
        User foundUser = GeneralController.searchUser(users, emailToSearch);

        // Verify that the correct user is found
        assertNotNull(foundUser);
        assertEquals(emailToSearch, foundUser.getEmail());
    }

    @Test
    public void testGetRoom() {
        // Create test rooms and retrieve rooms by ID.
        // Use assertions to verify that the correct room is returned or an exception is
        // thrown when expected.
    }

    @Test
    public void testGetFreeRoomId() {
        // Create test rooms and bookings, and find a free room.
        // Use assertions to verify that a valid room ID is returned or an exception is
        // thrown when no room is available.
    }

    @Test
    public void testGetFreeRoom() {
        // Create test rooms and bookings, and find a free room.
        // Use assertions to verify that a valid room object is returned or an exception
        // is thrown when no room is available.
    }

    @Test
    public void testGetRoomsByTypeCapacity() {
        // Create test rooms and retrieve rooms by type and capacity.
        // Use assertions to verify that the returned list contains the expected rooms.
    }
}
