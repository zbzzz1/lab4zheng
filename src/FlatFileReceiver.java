/**
 * Project: Lab4
 * Purpose: Receive pizza from flat file
 * Course: IST242
 * Author: Ziyan Zheng
 * Date Developed: 3/30/26
 * Last Date Changed: 3/30/26
 * Rev: 1
 */
import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.File;
import java.util.Scanner;

public class FlatFileReceiver {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("pizza.txt"));
        String line = scan.nextLine();
        String[] arr = line.split(",");
        Pizza pizza = new Pizza(arr[0], arr[1], arr[2]);
        System.out.println("Received Pizza:");
        System.out.println("Size: " + pizza.getSize());
        System.out.println("Crust: " + pizza.getCrust());
        System.out.println("Topping: " + pizza.getTopping());
    }

    /**
     * Project: Lab4
     * Purpose: Receive Pizza JSON from RabbitMQ
     * Course: IST242
     * Author: Ziyan Zheng
     * Date: 3/30/26
     */
    public static class RabbitMQReceiver {
        private final static String QUEUE_NAME = "pizzaQueue";

        public static void main(String[] args) throws Exception {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String json = new String(delivery.getBody());
                Gson gson = new Gson();
                Pizza pizza = gson.fromJson(json, Pizza.class);

                System.out.println("Received Pizza:");
                System.out.println("Size: " + pizza.getSize());
                System.out.println("Crust: " + pizza.getCrust());
                System.out.println("Topping: " + pizza.getTopping());
            };

            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {});
        }
    }
}
