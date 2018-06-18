package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BurgerTestSuite {
    @Test
    public void testDefaultCookingStrategy() {
        //Given
        Burger burger = new Burger();

        //When
        String result = burger.cookBurger();

        //Then
        Assert.assertEquals("Well done burger", result);
    }

    @Test
    public void testIndividualCookingStrategy() {
        //Given
        Burger burger = new Burger();

        //When
        burger.setBurgerCookingWay(new MediumWay());
        String result = burger.cookBurger();

        //Then
        Assert.assertEquals("Medium burger", result);
    }
}
