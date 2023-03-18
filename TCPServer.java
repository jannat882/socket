import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Server started");
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());
            handleClient(clientSocket);
        }
    }

    private static void handleClient(Socket clientSocket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        String request = in.readLine();
        System.out.println("Received request: " + request);

        String[] parts = request.split(",");
        int num1 = Integer.parseInt(parts[0]);
        int num2 = Integer.parseInt(parts[1]);

        int result = num1 + num2;
        System.out.println("Sending response: " + result);
        out.println(result);

        in.close();
        out.close();
        clientSocket.close();
    }
}