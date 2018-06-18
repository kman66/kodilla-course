package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BunFactoryTestSuite {
    @Test
    public void testChooseBunSuccessfull() {
        //Given
        //When
        Bun bun = BunFactory.chooseBun(BunFactory.BUN, Bun.WHEAT);
        Bun bunWithSesame = BunFactory.chooseBun(BunFactory.BUN_WITH_SESAME, Bun.RYE);

        //Then
        Assert.assertNotNull(bun);
        Assert.assertTrue(bun instanceof Bun);

        Assert.assertNotNull(bunWithSesame);
        Assert.assertTrue(bunWithSesame instanceof BunWithSesame);
    }

    @Test
    public void testChooseBunFailure() {
        //Given
        //When
        Bun bun = BunFactory.chooseBun("New bun", Bun.RYE);

        //Then
        Assert.assertNull(bun);
    }
}
