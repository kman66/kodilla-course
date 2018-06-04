package com.kodilla.good.patterns.challenges.food2door;

import org.junit.Assert;
import org.junit.Test;

public class ProducerGlutenFreeShopTestSuite {
    @Test
    public void testProcessSuccessCase() {
        //Given
        OrderRequest orderRequest = ProducerHelpClass.generateOrderRequest(Headquarters.CHELMNO, ProductTypes.OWOCE, 200);
        Producer producer = new ProducerGlutenFreeShop("2", "Gluten free shop", Headquarters.SZCZAWNICA.toString());

        //When
        boolean result = producer.process(orderRequest);

        //Then
        Assert.assertTrue(result);
    }

    @Test
    public void testProcessFailureCase() {
        //Given
        OrderRequest orderRequest = ProducerHelpClass.generateOrderRequest(Headquarters.SZCZAWNICA, ProductTypes.OWOCE, 9);
        Producer producer = new ProducerGlutenFreeShop("2", "Gluten free shop", Headquarters.SZCZAWNICA.toString());

        //When
        boolean result = producer.process(orderRequest);

        //Then
        Assert.assertFalse(result);
    }
}
