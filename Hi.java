import java.io.*;
import java.net.*;

public class Hi {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server started. Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");


            BufferedReader input =
                new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output =
                new PrintWriter(socket.getOutputStream(), true);

            BufferedReader keyboard =
                new BufferedReader(new InputStreamReader(System.in));

            String clientMsg, serverMsg;

            while (true) {
                clientMsg = input.readLine();
                if (clientMsg == null || clientMsg.equalsIgnoreCase("bye")) {
                    System.out.println("Charan: bye");
                    break;
                }
                System.out.println("Charan: " + clientMsg);

                System.out.print("Meghana: ");
                serverMsg = keyboard.readLine();
                output.println(serverMsg);

                if (serverMsg.equalsIgnoreCase("bye")) {
                    break;
                }
            }

            socket.close();
            serverSocket.close();
            System.out.println("Server connection closed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}