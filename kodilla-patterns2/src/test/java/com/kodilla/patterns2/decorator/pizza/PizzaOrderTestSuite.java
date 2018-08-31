package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PizzaOrderTestSuite {
    @Test
    public void testBasicPizzaOrderGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(15), theCost);
    }

    @Test
    public void testBasicPizzaOrderGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Pizza with tomato sauce and cheese", description);
    }

    @Test
    public void testItalianDoughGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ItalianDoughDecarator(theOrder);
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(25), theCost);
    }

    @Test
    public void testItalianDoughGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ItalianDoughDecarator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Pizza with tomato sauce and cheese italian art dough", description);
    }

    @Test
    public void testMeatPizzaGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new MeatPizzaDecorator(theOrder);
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(35), theCost);
    }

    @Test
    public void testMeatPizzaGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new MeatPizzaDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Pizza with tomato sauce and cheese with meat", description);
    }

    @Test
    public void testBasicPizzaWithMeatAndVegetablesGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new MeatPizzaDecorator(theOrder);
        theOrder = new VegetablesPizzaDecorator(theOrder);
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(45), theCost);
    }

    @Test
    public void testBasicPizzaWithMeatAndVegetablesGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new MeatPizzaDecorator(theOrder);
        theOrder = new VegetablesPizzaDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Pizza with tomato sauce and cheese with meat with vegetables", description);
    }

    @Test
    public void testItalianArtPizzaWithMeatAndExtraCheeseGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ItalianDoughDecarator(theOrder);
        theOrder = new MeatPizzaDecorator(theOrder);
        theOrder = new ExtraCheeseDecorator(theOrder);
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(60), theCost);
    }

    @Test
    public void testItalianArtPizzaWithMeatAndExtraCheese() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ItalianDoughDecarator(theOrder);
        theOrder = new MeatPizzaDecorator(theOrder);
        theOrder = new ExtraCheeseDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Pizza with tomato sauce and cheese italian art dough with meat + extra cheese", description);
    }
}