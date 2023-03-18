import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9999);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        int num1 = 10;
        int num2 = 20;
        String request = num1 + "," + num2;
        System.out.println("Sending request: " + request);
        out.println(request);

        String response = in.readLine();
        System.out.println("Received response: " + response);

        out.close();
        in.close();
        socket.close();
    }
}