import Objects.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import com.google.gson.Gson;

public class RoomControlTest {
    /*
     * private static final Gson gson = new Gson();
     * 
     * @Test
     * public void testPullData() {
     * 
     * RoomControl.pullData();
     * 
     * assertNotNull(RoomControl.getRoomsArray(), "Rooms array should not be null");
     * 
     * assertTrue(RoomControl.getRoomsArray().length > 0,
     * "Rooms array should not be empty");
     * }
     * 
     * @Test
     * public void testPushData() {
     * 
     * Room room1 = new Room(1, Room.RoomType.STANDARD, 2);
     * Room room2 = new Room(2, Room.RoomType.DELUXE, 2);
     * Room room3 = new Room(3, Room.RoomType.KING, 2);
     * 
     * Room[] rooms = RoomControl.getRoomsArray();
     * Room[] newRooms = new Room[rooms.length + 3];
     * 
     * for (int i = 0; i < rooms.length; i++) {
     * newRooms[i] = rooms[i];
     * }
     * 
     * newRooms[rooms.length] = room1;
     * newRooms[rooms.length + 1] = room2;
     * newRooms[rooms.length + 2] = room3;
     * 
     * RoomControl.setRoomsArray(newRooms);
     * RoomControl.pushData();
     * 
     * // Verify that the rooms.json file exists
     * String filePath = "src/main/resources/json/rooms.json";
     * assertTrue(Files.exists(Paths.get(filePath)),
     * "rooms.json file should exist");
     * 
     * try {
     * List<String> fileContents = Files.readAllLines(Paths.get(filePath));
     * String lastLine = fileContents.get(fileContents.size() - 1);
     * //newRooms array to a JSON string
     * String expectedJson = gson.toJson(newRooms);
     * 
     * assertEquals(expectedJson, lastLine,
     * "JSON data in file should contain the newly added rooms");
     * } catch (IOException e) {
     * e.printStackTrace();
     * System.out.println("Failed to read file contents: " + e.getMessage());
     * }
     * }
     * 
     * @Test
     * public void testGetRoom() {
     * Room[] originalRooms = RoomControl.getRoomsArray();
     * 
     * // Test with a valid room ID
     * int validId = 100;
     * Room expectedRoom = originalRooms[validId];
     * 
     * Room retrievedRoom = null;
     * try {
     * retrievedRoom = RoomControl.getRoom(validId);
     * } catch (IllegalArgumentException e) {
     * e.printStackTrace();
     * System.out.println("An exception occurred while retrieving a valid room: " +
     * e.getMessage());
     * }
     * assertEquals(expectedRoom, retrievedRoom,
     * "Retrieved room should match the expected room");
     * 
     * // Test with an invalid room ID
     * int invalidId = -784;
     * try {
     * RoomControl.getRoom(invalidId);
     * System.out.
     * println("Expected IllegalArgumentException to be thrown for an invalid room ID"
     * );
     * } catch (IllegalArgumentException e) {
     * // Exception should be thrown, test passed
     * }
     * }
     */
}