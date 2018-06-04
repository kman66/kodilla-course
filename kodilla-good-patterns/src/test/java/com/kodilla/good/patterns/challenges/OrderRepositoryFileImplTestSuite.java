package com.kodilla.good.patterns.challenges;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryFileImplTestSuite {
    @Test
    public void testCreateOrder() {
        //Given
        OrderRepositoryFileImpl orderRepositoryFile = new OrderRepositoryFileImpl();
        List<Product> products = new ArrayList<>();
        User johnSmith = new User("1", "John", "Smith", "johnsmith@mail.com");
        Product sensodyneWhitening = new Toothpaste("1", "toothpaste", "Sensodyne",
                "whitening", LocalDateTime.of(2025, 12, 01, 12, 0));
        Product fallout3 = new Game("2", "game", "Fallout 3", "rpg");
        Product sensodyneFluorid = new Toothpaste("3", "toothpaste", "Sensodyne",
                "fluorid", LocalDateTime.of(2020, 1, 01, 12, 0));
        products.add(sensodyneWhitening);
        products.add(fallout3);
        products.add(sensodyneFluorid);

        //When
        orderRepositoryFile.createOrder(johnSmith, products, LocalDateTime.now());

        //Then
        Assert.assertTrue(fileExist());
    }

    private boolean fileExist() {
        return new File("/home/veles/Dokumente/Projekten/IDEA/kodilla-course-module6/kodilla-good-patterns/src/main/resources/orders/order1.txt").exists();
    }
}
