import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 8080;

        try (Socket socket = new Socket(hostname, port)) {
            // Input and Output streams to communicate with the server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            // Get user input for calculation
            System.out.println("Enter calculation : ");
            String request = userInput.readLine();

            // Send the request to the server
            out.println(request);

            // Receive and print the result from the server
            String response = in.readLine();
            System.out.println("Server response: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}