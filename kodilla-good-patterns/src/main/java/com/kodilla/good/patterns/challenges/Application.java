package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        //Create some products
        Product sensodyneWhitening = new Toothpaste("1", "toothpaste", "Sensodyne",
                "whitening", LocalDateTime.of(2025, 12, 01, 12, 0));
        Product fallout3 = new Game("2", "game", "Fallout 3", "rpg");
        Product sensodyneFluorid = new Toothpaste("3", "toothpaste", "Sensodyne",
                "fluorid", LocalDateTime.of(2020, 1, 01, 12, 0));

        //Create user
        User johnSmith = new User("1", "John", "Smith", "johnsmith@mail.com");

        //Add products and user to sets
        Inventory.addProduct(sensodyneWhitening, fallout3, sensodyneFluorid);
        UserDataBase.addUser(johnSmith);

        //Create test list for products and fill it up
        List<Product> products = new ArrayList<>();
        products.add(sensodyneWhitening);
        products.add(fallout3);

        //Execute ordering process
        OrderRequest orderRequest = new OrderRequest(johnSmith, products, LocalDateTime.now());
        ProductOrderService productOrderService = new ProductOrderService(new InformationServiceMailImpl(),
                new OrderServiceImpl(), new OrderRepositoryFileImpl());
        productOrderService.process(orderRequest);
    }
}
