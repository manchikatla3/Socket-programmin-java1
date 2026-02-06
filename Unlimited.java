import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Unlimited {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("172.16.41.148", 1234);
            System.out.println("Connected to server.");

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true
            );

            Scanner scanner = new Scanner(System.in);
            String message;

            
            while (true) {
                System.out.print("Enter message: ");
                message = scanner.nextLine();
                output.println(message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}