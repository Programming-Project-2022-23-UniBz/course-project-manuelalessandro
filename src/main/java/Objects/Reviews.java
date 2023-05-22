/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author aless
 */
public class Reviews {
    private User user;
    private String review;
    private int stars;
    
    public Reviews(User user, String Review, int Stars){
        this.user = user;
        this.review = Review;
        this.stars = Stars;
    }
    
    public User getUser(){
        return this.user;
    }
    
    public String getReview(){
        return this.review;
    }
    
    public int getStars(){
        return this.stars;
    }
    
    //to remove the review from reviews.json
    public void removeFromJson() {
        try {
            // Read existing reviews from the JSON file
            JsonParser parser = new JsonParser();
            JsonArray jsonArray = parser.parse(new FileReader("src/main/java/Objects/json/reviews.json")).getAsJsonArray();

            // Find and remove the review from the array
            int index = findIndexOfJson(jsonArray, "GuestName", this.user.getName());
            if (index != -1) {
                JsonObject reviewObject = jsonArray.get(index).getAsJsonObject();
                String storedReview = reviewObject.get("Review").getAsString();
                if (storedReview.equals(review)) {
                    jsonArray.remove(index);
                }
            }

            // Write the updated array back to the JSON file
            try (FileWriter writer = new FileWriter("src/main/java/Objects/json/reviews.json")) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(jsonArray, writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
    public void addToJson(){
        try {
            // Read existing reviews from the JSON file
            JsonParser parser = new JsonParser();
            JsonArray jsonArray = parser.parse(new FileReader("src/main/java/Objects/json/reviews.json")).getAsJsonArray();

            // Create a new review object
            JsonObject reviewObject = new JsonObject();
            reviewObject.addProperty("GuestName", this.user.getName());
            reviewObject.addProperty("Review", review);

            // Add the new review to the array
            jsonArray.add(reviewObject);

            // Write the updated array back to the JSON file
            try (FileWriter writer = new FileWriter("src/main/java/Objects/json/reviews.json")) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(jsonArray, writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private int findIndexOfJson(JsonArray jsonArray, String key, String value) {
        int index = -1;
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
            JsonElement jsonElement = jsonObject.get(key);
            if (jsonElement != null && jsonElement.getAsString().equals(value)) {
                index = i;
                break;
            }
        }
        return index;
    }
    public static int getJsonCount(){
        int arrayLength=0;
        try {
            // Parse the JSON contents
            try ( // Read the JSON file
                    FileReader fileReader = new FileReader("src/main/java/Objects/json/reviews.json")) {
                // Parse the JSON contents
                JsonElement jsonElement = JsonParser.parseReader(fileReader);
                JsonArray jsonArray = jsonElement.getAsJsonArray();
                // Check the length of the array
                arrayLength = jsonArray.size();
                System.out.println("Array length: " + arrayLength);
                // Close the file reader
            }
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
        }
        return arrayLength;
    }
    
}
