import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MainClient implements AutoCloseable {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8083;
        Scanner scanner = new Scanner(System.in);

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new
                     PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new
                     InputStreamReader(clientSocket.getInputStream()))) {

             String resp = in.readLine();
             System.out.println(resp);

             while (scanner.hasNext()) {
                 serverExchange(scanner, out, in);
             }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void serverExchange(Scanner scanner, PrintWriter out, BufferedReader in) throws IOException {

        String msg, resp;

        msg = scanner.nextLine();
        out.println(msg);

        resp = in.readLine();
        System.out.println(resp);

    }

    @Override
    public void close() throws Exception {

    }
}