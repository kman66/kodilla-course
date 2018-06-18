package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.fail;

public class BunTestSuite {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testBunNewNormalCase() {
        //Given
        //When
        Bun bun = new Bun(Bun.WHEAT);

        //Then
        Assert.assertEquals(Bun.WHEAT, bun.getFlourType());
    }

    @Test
    public void testBunNewWrongFlourTypeCase() {
        //Given
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("Unknown type of flour");

        //When
        Bun bun = new Bun("New flour type");

        //Then
        fail("This method should throw the IllegalStateException");
    }
}
