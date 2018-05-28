package com.kodilla.exception.test;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

public class FirstChallangeTestSuite {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    // How can it be tested if exception has been thrown and caught?
    @Test
    public void testDivideWithExpectedException() {
        //Given
        FirstChallenge firstChallenge = new FirstChallenge();

        //When
        double res = firstChallenge.divide(3, 0);

        //Then
        thrown.expect(ArithmeticException.class);
    }

    @Test
    public void testDivide(){
        //Given
        FirstChallenge firstChallenge = new FirstChallenge();

        //When
        double resDivByZero = firstChallenge.divide(3,0);
        double resNormalDivision = firstChallenge.divide(49, 7);

        //Then
        Assert.assertEquals(0, resDivByZero, 0.001);
        Assert.assertEquals(7, resNormalDivision, 0.001);
    }
}
