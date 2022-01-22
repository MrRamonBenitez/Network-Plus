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

            System.out.println(String.format("New connection accepted. Port: %d%n", clientSocket.getPort()));
            final String name = in.readLine();

            out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
            serverSocket.close();
        }
    }
}

