package com.kodilla.good.patterns.challenges;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderServiceImplTestSuite {
    @Test
    public void testOrderNormalCase() {
        //Given
        User johnSmith = prepareTestUser();
        List<Product> testProducts = prepareTestProducts();
        OrderService orderService = new OrderServiceImpl();

        //When
        boolean result = orderService.order(johnSmith, testProducts, LocalDateTime.now());
        Map<Product, Boolean> testOrderedProducts = orderService.getMapOfOrderedProducts();

        //Then
        Assert.assertTrue(result);
        Assert.assertTrue(orderService.isAllProductsAvailable());
        Assert.assertTrue(orderService.isUserExist());
        Assert.assertFalse(Inventory.containsProduct(testProducts.get(0)));
        Assert.assertFalse(Inventory.containsProduct(testProducts.get(1)));
        Assert.assertEquals(1, Inventory.getSetOfProducts().size());
        Assert.assertEquals(2, orderService.getMapOfOrderedProducts().size());
        Assert.assertTrue(orderService.getMapOfOrderedProducts().get(testProducts.get(0)));
        Assert.assertTrue(orderService.getMapOfOrderedProducts().get(testProducts.get(1)));
    }

    @Test
    public void testOrderOneProductMissingCase() {
        //Given
        User johnSmith = prepareTestUser();
        List<Product> testProducts = prepareTestProducts();
        Product romeTw = new Game("4", "game", "Rome TW", "strategy");
        testProducts.add(romeTw);
        OrderService orderService = new OrderServiceImpl();

        //When
        boolean result = orderService.order(johnSmith, testProducts, LocalDateTime.now());
        Map<Product, Boolean> testOrderedProducts = orderService.getMapOfOrderedProducts();

        //Then
        Assert.assertFalse(result);
        Assert.assertFalse(orderService.isAllProductsAvailable());
        Assert.assertTrue(orderService.isUserExist());
        Assert.assertEquals(3, Inventory.getSetOfProducts().size());
        Assert.assertEquals(3, orderService.getMapOfOrderedProducts().size());
        Assert.assertFalse(orderService.getMapOfOrderedProducts().get(testProducts.get(2)));
    }

    @Test
    public void testOrderUserNotExistInDbCase() {
        //Given
        User joanneBlanc = new User("2", "Joanne", "Blanc", "joanneblanc@mail.com");
        List<Product> testProducts = prepareTestProducts();
        OrderService orderService = new OrderServiceImpl();

        //When
        boolean result = orderService.order(joanneBlanc, testProducts, LocalDateTime.now());
        Map<Product, Boolean> testOrderedProducts = orderService.getMapOfOrderedProducts();

        //Then
        Assert.assertFalse(result);
        Assert.assertFalse(orderService.isUserExist());
        Assert.assertTrue(orderService.isAllProductsAvailable());
        Assert.assertEquals(3, Inventory.getSetOfProducts().size());
        Assert.assertEquals(2, orderService.getMapOfOrderedProducts().size());
    }

    private List<Product> prepareTestProducts() {
        Product sensodyneWhitening = new Toothpaste("1", "toothpaste", "Sensodyne",
                "whitening", LocalDateTime.of(2025, 12, 01, 12, 0));
        Product fallout3 = new Game("2", "game", "Fallout 3", "rpg");
        Product sensodyneFluorid = new Toothpaste("3", "toothpaste", "Sensodyne",
                "fluorid", LocalDateTime.of(2020, 1, 01, 12, 0));

        Inventory.addProduct(sensodyneWhitening, fallout3, sensodyneFluorid);

        List<Product> products = new ArrayList<>();
        products.add(sensodyneWhitening);
        products.add(fallout3);

        return products;
    }

    private User prepareTestUser() {
        User johnSmith = new User("1", "John", "Smith", "johnsmith@mail.com");
        UserDataBase.addUser(johnSmith);
        return johnSmith;
    }
}
