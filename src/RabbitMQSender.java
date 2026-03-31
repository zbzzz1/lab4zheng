/**
 * Project: Lab4
 * Purpose: Send Pizza object as JSON
 * Course: IST242
 * Author: Ziyan Zheng
 * Date Developed: 3/30/26
 * Last Date Changed: 3/30/26
 * Rev: 1
 */

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.google.gson.Gson;

public class RabbitMQSender {
    private final static String QUEUE_NAME = "pizzaQueue";

    public static void main(String[] args) throws Exception {
        Pizza pizza = new Pizza("Large", "Thin", "Cheese");
        Gson gson = new Gson();
        String json = gson.toJson(pizza);

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.basicPublish("", QUEUE_NAME, null, json.getBytes());
        System.out.println("Sent JSON Pizza: " + json);

        channel.close();
        connection.close();
    }
}
