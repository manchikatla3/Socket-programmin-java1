import java.io.*;
import java.net.*;

public class Message {
    public static void main(String[] args) {
        try {
            // Bind server to your specific IP address
            InetAddress serverIP = InetAddress.getByName("172.16.41.148");
            ServerSocket serverSocket = new ServerSocket(1234, 50, serverIP);

            
            System.out.println("Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected ");

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            String message;

           
            while ((message = input.readLine()) != null) {
                System.out.println("Client says: " + message);
            }

            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
