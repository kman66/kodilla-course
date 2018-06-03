package com.kodilla.good.patterns.challenges;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductOrderServiceTestSuite {
    @Test
    public void testProcessOrderSuccessCase() {
        //Given
        ProductOrderService productOrderService = new ProductOrderService(new InformationServiceMailImpl(),
                new OrderServiceImpl(), new OrderRepositoryFileImpl());
        OrderRequest testOrderRequest = prepareTestData(false);

        //When
        OrderDto testOrderDto = productOrderService.process(testOrderRequest);

        //Then
        Assert.assertNotNull(testOrderDto);
        Assert.assertEquals(2, testOrderDto.getMapOfOrderedProducts().size());
        Assert.assertTrue(testOrderDto.isAllProductsAvailable());
        Assert.assertTrue(testOrderDto.isUserExist());
        Assert.assertTrue(testOrderDto.isOrdered());
    }

    @Test
    public void testProcessOrderFailureCase() {
        //Given
        ProductOrderService productOrderService = new ProductOrderService(new InformationServiceMailImpl(),
                new OrderServiceImpl(), new OrderRepositoryFileImpl());
        OrderRequest testOrderRequest = prepareTestData(true);

        //When
        OrderDto testOrderDto = productOrderService.process(testOrderRequest);

        //Then
        Assert.assertNotNull(testOrderDto);
        Assert.assertEquals(2, testOrderDto.getMapOfOrderedProducts().size());
        Assert.assertTrue(testOrderDto.isAllProductsAvailable());
        Assert.assertFalse(testOrderDto.isUserExist());
        Assert.assertFalse(testOrderDto.isOrdered());
    }

    private OrderRequest prepareTestData(boolean fail) {
        //Create some products
        Product sensodyneWhitening = new Toothpaste("1", "toothpaste", "Sensodyne",
                "whitening", LocalDateTime.of(2025, 12, 01, 12, 0));
        Product fallout3 = new Game("2", "game", "Fallout 3", "rpg");
        Product sensodyneFluorid = new Toothpaste("3", "toothpaste", "Sensodyne",
                "fluorid", LocalDateTime.of(2020, 1, 01, 12, 0));

        //Initialize testUser
        User testUser;

        //Add products and user to sets
        Inventory.addProduct(sensodyneWhitening, fallout3, sensodyneFluorid);
        if(!fail) {
            testUser = new User("1", "John", "Smith", "johnsmith@mail.com");
            UserDataBase.addUser(testUser);
        } else {
            testUser = new User("2", "Joanne", "Blanc", "joanneblanc@mail.com");
        }

        //Create test list for products and fill it up
        List<Product> products = new ArrayList<>();
        products.add(sensodyneWhitening);
        products.add(fallout3);

        return new OrderRequest(testUser, products, LocalDateTime.now());
    }
}
