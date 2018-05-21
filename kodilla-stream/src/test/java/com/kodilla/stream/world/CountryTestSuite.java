package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CountryTestSuite {
    @Test
    public void testGetPeopleQuantity(){
        //Given
        Country poland = new Country("Polska", new BigDecimal(38112048));

        //When
        BigDecimal peopleQuantityOfPoland = poland.getPeopleQuantity();

        //Then
        Assert.assertEquals(new BigDecimal(38112048), peopleQuantityOfPoland);
    }
}
