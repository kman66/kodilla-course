package com.kodilla.good.patterns.challenges.food2door;

import org.junit.Assert;
import org.junit.Test;

public class ProducerHealthyShopTestSuite {
    @Test
    public void testProcessSuccessCase() {
        //Given
        OrderRequest orderRequest = ProducerHelpClass.generateOrderRequest(Headquarters.CHOJNICE, ProductTypes.OWOCE, 100);
        Producer producer = new ProducerHealthyShop("3", "Healthy shop", Headquarters.CHELMNO.toString());

        //When
        boolean result = producer.process(orderRequest);

        //Then
        Assert.assertTrue(result);
    }

    @Test
    public void testProcessFailureCase() {
        //Given
        OrderRequest orderRequest = ProducerHelpClass.generateOrderRequest(Headquarters.CHOJNICE, ProductTypes.MIESO, 100);
        Producer producer = new ProducerHealthyShop("2", "Healthy shop", Headquarters.CHELMNO.toString());

        //When
        boolean result = producer.process(orderRequest);

        //Then
        Assert.assertFalse(result);
    }
}
