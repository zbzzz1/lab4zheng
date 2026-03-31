/**
 * Project: Lab4
 * Purpose: Receive Pizza JSON and print details
 * Course: IST242
 * Author: Ziyan Zheng
 * Date Developed: 3/30/26
 * Last Date Changed: 3/30/26
 * Rev: 1
 */
import com.rabbitmq.client.*;
import com.google.gson.Gson;

public class RabbitMQReceiver {
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