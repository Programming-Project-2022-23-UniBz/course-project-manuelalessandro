package Objects;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
public class Client {
    public static void main(String[] args) {
        try {
            // Create client socket and connect to the server
            Socket clientSocket = new Socket("localhost", 1234);
            
            // Get input/output streams for communication
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();

            // Send message to server
            String message = "Hello from client!";
            outputStream.write(message.getBytes());

            // Read response from server
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String response = new String(buffer, 0, bytesRead);
            System.out.println("Received response from server: " + response);

            // Close the socket and streams
            inputStream.close();
            outputStream.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
