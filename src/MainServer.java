import java.io.*;
import java.net.*;

public class MainServer {
    public static void main(String[] args) throws IOException {
        System.out.println("Server started");
        int port = 8083;

        while (true) {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            out.println("Greetings, good friend! Say your name->");

            String msg = in.readLine();
            out.println(String.format("Hi, %s, do you want to buy football tickets? (yes/no)", msg));

            msg = in.readLine();
            if ("yes".equals(msg)) {
                out.println("One football ticket costs 10. How many tickets would you like to purchase?");
            } else {
                out.println("All the best! See you next time!");
            }

            msg = in.readLine();
            if (0 < Integer.parseInt(msg)) {
                out.println(String.format("Ticket price will be %d euros. Buy it? (yes/no)", Integer.parseInt(msg) * 10));
            } else {
                out.println("All the best! See you next time!");
            }

            msg = in.readLine();
            if ("yes".equals(msg)) {
                out.println("Thank you for your purchase! See you next time!");
            } else {
                out.println("All the best! See you next time!");
            }


            serverSocket.close();
        }
    }
}

