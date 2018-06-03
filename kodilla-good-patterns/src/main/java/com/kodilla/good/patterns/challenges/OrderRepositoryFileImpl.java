package com.kodilla.good.patterns.challenges;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class OrderRepositoryFileImpl implements OrderRepository {
    private static int orderNo = 0;

    @Override
    public void createOrder(User user, List<Product> productList, LocalDateTime orderTime) {
        FileWriter writer;
        //String filePath = "kodilla-good-patterns/src/main/resources/orders/order".concat(String.valueOf(++orderNo) + ".txt");
        String filePath = ("/home/veles/Dokumente/Projekten/IDEA/kodilla-course-module6/" +
                "kodilla-good-patterns/src/main/resources/orders/order").concat(String.valueOf(++orderNo) + ".txt");

        File file = new File(filePath);

        try {
            System.out.println("Saving information of order number " + orderNo + " into file...");
            file.createNewFile();
            writer = new FileWriter(file);
            writer.write("Order number: " + orderNo + "\n");
            writer.write("at: " + orderTime.toString() + "\n");
            writer.write(user.toString() + "\n");
            writer.write(productList.toString() + "\n");
            writer.flush();
            writer.close();
            System.out.println("Data has been successfully saved.");
        } catch(IOException ioe) {
            System.out.println(ioe);
        }
    }
}
