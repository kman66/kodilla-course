package com.kodilla.exception.test;

import org.junit.Assert;
import org.junit.Test;

public class ExceptionHandlingTestSuite {
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
