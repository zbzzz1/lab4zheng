/**
 * Course: IST242
 * Author: Ziyan Zheng
 * Purpose: Receive Pizza from JSON
 * Last Date Changed: 3/30/26
 * Rev: 1
 */

import java.net.*;
import java.io.*;

public class WebServiceReceiver {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Web Service running on port 8080...");

        Socket socket = server.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String json = in.readLine();

        System.out.println("Received: " + json);
        System.out.println("Web Service Done!");

        in.close();
        socket.close();
        server.close();
    }
}
