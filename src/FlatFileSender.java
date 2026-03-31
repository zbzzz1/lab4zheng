/**
 * Project: Lab4
 * Purpose: Send pizza as flat file
 * Course: IST242
 * Author: Ziyan Zheng
 * Date Developed: 3/30/26
 * Last Date Changed: 3/30/26
 * Rev: 1
 */

import java.io.FileWriter;

public class FlatFileSender {
    public static void main(String[] args) throws Exception {
        Pizza pizza = new Pizza("Large", "Thick", "Pepperoni");
        String line = pizza.getSize() + ";" + pizza.getCrust() + ";" + pizza.getTopping();
        FileWriter writer = new FileWriter("pizza.txt");
        writer.write(line);
        writer.close();
        System.out.println("Sent flat file: " + line);
    }
}
