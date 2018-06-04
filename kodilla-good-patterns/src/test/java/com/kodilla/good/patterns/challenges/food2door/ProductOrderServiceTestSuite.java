package com.kodilla.good.patterns.challenges.food2door;

import org.junit.Assert;
import org.junit.Test;

public class ProductOrderServiceTestSuite {
    @Test
    public void testProcessOrderSuccessCase() {
        //Given
        OrderRequest orderRequest = ProducerHelpClass.generateOrderRequest(Headquarters.CHOJNICE, ProductTypes.WARZYWA, 100);
        Producer producer = new ProducerHealthyShop("3", "Healthy shop", Headquarters.SZCZAWNICA.toString());
        Store store = new Store("1", "Tesco");
        ProductOrderService productOrderService = new ProductOrderService(producer, store);

        //When
        OrderDto orderDto = productOrderService.processOrder(orderRequest);

        //Then
        Assert.assertNotNull(orderDto);
        Assert.assertTrue(orderDto.isOrdered());
        Assert.assertEquals(producer, orderDto.getProducer());
        Assert.assertEquals(store, orderDto.getStore());
    }

    @Test
    public void testProcessOrderFailureCase() {
        //Given
        OrderRequest orderRequest = ProducerHelpClass.generateOrderRequest(Headquarters.CHOJNICE, ProductTypes.MIESO, 100);
        Producer producer = new ProducerHealthyShop("3", "Healthy shop", Headquarters.SZCZAWNICA.toString());
        Store store = new Store("1", "Tesco");
        ProductOrderService productOrderService = new ProductOrderService(producer, store);

        //When
        OrderDto orderDto = productOrderService.processOrder(orderRequest);

        //Then
        Assert.assertNotNull(orderDto);
        Assert.assertFalse(orderDto.isOrdered());
        Assert.assertEquals(producer, orderDto.getProducer());
        Assert.assertEquals(store, orderDto.getStore());
    }
}
