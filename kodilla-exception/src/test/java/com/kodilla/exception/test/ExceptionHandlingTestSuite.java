package com.kodilla.exception.test;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExceptionHandlingTestSuite {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testHandleProbablyIWillThrowException(){
        //Given
        ExceptionHandling exceptionHandling = new ExceptionHandling();

        //When
        String resultWithoutException = exceptionHandling.handleProbablyIWillThrowException(1.5, 1);
        String resultWithException = exceptionHandling.handleProbablyIWillThrowException(1.5, 1.5);

        //Then
        Assert.assertEquals("Done!", resultWithoutException);
        Assert.assertEquals("Done!", resultWithException);
    }
}
