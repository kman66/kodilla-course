package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity(){
        //Given
        World world = new World();

        Continent europe = new Continent("Europe");
        Continent northAmerica = new Continent("North America");
        Continent asia = new Continent("Asia");

        europe.addCountry(new Country("Polska", new BigDecimal(38112048)));
        europe.addCountry(new Country("Deutschland", new BigDecimal(82274761)));
        europe.addCountry(new Country("United Kingdom", new BigDecimal(66530003)));

        northAmerica.addCountry(new Country("Canada", new BigDecimal(36916660)));
        northAmerica.addCountry(new Country("USA", new BigDecimal(326508530)));

        asia.addCountry(new Country("China", new BigDecimal(1414428017)));
        asia.addCountry(new Country("India", new BigDecimal(1352387090)));
        asia.addCountry(new Country("Iran", new BigDecimal(81916861)));
        asia.addCountry(new Country("Thailand", new BigDecimal(69166240)));

        //When
        world.addContinent(europe);
        world.addContinent(northAmerica);
        world.addContinent(asia);

        BigDecimal testedPeopleQuantity = world.getPeopleQuantity();

        //Then
        Assert.assertEquals(3, world.getContinents().size());
        Assert.assertTrue(world.getContinents().contains(europe));
        Assert.assertTrue(world.getContinents().contains(northAmerica));
        Assert.assertTrue(world.getContinents().contains(asia));
        Assert.assertEquals(new BigDecimal("3468240210"), testedPeopleQuantity);
    }
}
