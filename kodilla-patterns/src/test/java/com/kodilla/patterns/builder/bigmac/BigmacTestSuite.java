package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.junit.Assert.fail;

public class BigmacTestSuite {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testBigmacNewNormalCase() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun(BunFactory.BUN, Bun.WHEAT)
                .noOfBurgers(2)
                .burger(null)
                .sauce(SauceTypes.STANDARD)
                .ingredients(IngredientsTypes.CHEESE)
                .ingredients(IngredientsTypes.BACON)
                .build();
        System.out.println(bigmac);

        //When
        Bun bun = bigmac.getBun();
        String typeOfBun = bigmac.getBun().getFlourType();
        int noOfBurgers = bigmac.getNoOfBurgers();
        BurgerCookingWay burgerCookingWay = bigmac.getBurger().getBurgerCookingWay();
        String sauce = bigmac.getSauce();
        List<String> ingredients = bigmac.getIngredients();

        //Then
        Assert.assertNotNull(bigmac);
        Assert.assertTrue(bun instanceof Bun);
        Assert.assertEquals(Bun.WHEAT, typeOfBun);
        Assert.assertEquals(2, noOfBurgers);
        Assert.assertTrue(burgerCookingWay instanceof WellDoneWay);
        Assert.assertEquals(SauceTypes.STANDARD, sauce);
        Assert.assertEquals(2, ingredients.size());
        Assert.assertTrue(ingredients.contains(IngredientsTypes.CHEESE));
        Assert.assertTrue(ingredients.contains(IngredientsTypes.BACON));
    }

    @Test
    public void testBigmacNewWithoutIngredients() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun(BunFactory.BUN_WITH_SESAME, Bun.RYE)
                .noOfBurgers(3)
                .burger(new MediumWay())
                .sauce(SauceTypes.THOUSAND_ISLANDS)
                .build();
        System.out.println(bigmac);

        //When
        Bun bunWithSesame = bigmac.getBun();
        String typeOfBun = bigmac.getBun().getFlourType();
        int noOfBurgers = bigmac.getNoOfBurgers();
        BurgerCookingWay burgerCookingWay = bigmac.getBurger().getBurgerCookingWay();
        String sauce = bigmac.getSauce();
        List<String> ingredients = bigmac.getIngredients();

        //Then
        Assert.assertNotNull(bigmac);
        Assert.assertTrue(bunWithSesame instanceof BunWithSesame);
        Assert.assertEquals(Bun.RYE, typeOfBun);
        Assert.assertEquals(3, noOfBurgers);
        Assert.assertTrue(burgerCookingWay instanceof MediumWay);
        Assert.assertEquals(SauceTypes.THOUSAND_ISLANDS, sauce);
        Assert.assertTrue(ingredients.isEmpty());
    }

    @Test
    public void testBigmacNewExceptionCase() {
        //Given
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("|Unknown type of bun.||Unknown type of burger.||Unknown ingredient.|");

        //When
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .noOfBurgers(0)
                .sauce(SauceTypes.STANDARD)
                .ingredients("New Ingredient")
                .ingredients(IngredientsTypes.BACON)
                .build();

        //Then
        fail("This method should throw the IllegalStateException");
    }
}
