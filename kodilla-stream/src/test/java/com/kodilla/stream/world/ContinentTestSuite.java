package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ContinentTestSuite {
    @Test
    public void testAddCountry(){
        //Given
        Continent continent = new Continent("Europe");
        Country poland = new Country("Polska", new BigDecimal(38112048));

        //When
        continent.addCountry(poland);

        //Then
        Assert.assertEquals(1, continent.getCountries().size());
        Assert.assertTrue(continent.getCountries().contains(poland));

    }
}
