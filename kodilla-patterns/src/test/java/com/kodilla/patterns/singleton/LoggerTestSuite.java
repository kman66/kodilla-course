package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {
    @Test
    public void testGetLastLogIfOnlyOne() {
        //Given
        Logger logger = Logger.getInstance();
        logger.log("test log");

        //When
        String result = logger.getLastLog();

        //Then
        Assert.assertEquals("test log", result);
    }

    @Test
    public void testGetLastLogIfMoreThanOne() {
        //Given
        Logger logger = Logger.getInstance();
        logger.log("first log");
        logger.log("second log");
        logger.log("third log");

        //When
        String result = logger.getLastLog();

        //Then
        Assert.assertEquals("third log", result);
    }
}
