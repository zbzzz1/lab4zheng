/**
 * Course: IST242
 * Author: Ziyan Zheng
 * Purpose: Send Pizza to JSON
 * Date Developed: 3/30/26
 * Last Date Changed: 3/30/26
 * Rev: 1
 */

import java.net.*;
import java.io.*;

public class WebServiceSender {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8080);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String json = "{\"size\":\"Medium\",\"crust\":\"Stuffed\",\"topping\":\"Pepperoni\"}";
        out.println(json);

        System.out.println("Sent: " + json);
        System.out.println("Pizza data sent to server!");

        out.close();
        socket.close();
    }
}
