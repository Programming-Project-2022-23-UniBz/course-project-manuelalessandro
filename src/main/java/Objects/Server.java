
package Objects;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    
    public static void main(String[] args){
        try{
            ServerSocket serverSocket = new ServerSocket(1234);
            Socket clientSocket = serverSocket.accept();
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String message = new String(buffer, 0, bytesRead);
            // Send response to client
            String response = "Hello from server!";
            outputStream.write(response.getBytes());

            // Close the sockets and streams
            inputStream.close();
            outputStream.close();
            clientSocket.close();
            serverSocket.close();
        }catch(IOException e){
            
        }
    }
    
}
