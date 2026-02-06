import java.io.*;
import java.net.*;

public class Bye {
    public static void main(String[] args) {
        try {
           
            Socket socket = new Socket("172.16.41.148", 1234);
            System.out.println("Connected to server.");

            BufferedReader input =
                new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output =
                new PrintWriter(socket.getOutputStream(), true);

            BufferedReader keyboard =
                new BufferedReader(new InputStreamReader(System.in));

            String serverMsg, clientMsg;

            while (true) {
                System.out.print("Charan: ");
                clientMsg = keyboard.readLine();
                output.println(clientMsg);

                if (clientMsg.equalsIgnoreCase("bye")) {
                    break;
                }

                serverMsg = input.readLine();
                if (serverMsg == null || serverMsg.equalsIgnoreCase("bye")) {
                    System.out.println("Meghana: bye");
                    break;
                }
                System.out.println("Meghana: " + serverMsg);
            }

            socket.close();
            System.out.println("Client connection closed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}