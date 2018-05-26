package com.kodilla.stream.com.kodilla.stream.array;

import com.kodilla.stream.array.ArrayOperations;
import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage(){
        //Given
        int[] testValues = {4, 6, 9, 28, 1, 0, 0, 456, 3, 10};

        //When
        double testAverage = ArrayOperations.getAverage(testValues);
        double testAverageOfZero = ArrayOperations.getAverage(new int[0]);

        //Then
        Assert.assertEquals(51.7, testAverage, 0);
        Assert.assertEquals(0, testAverageOfZero, 0);
    }

    @Test
    public void testGetAverageWithOf(){
        //Given
        int[] testValues = {4, 6, 9, 28, 1, 0, 0, 456, 3, 10};

        //When
        double testAverage = ArrayOperations.getAverageWithOf(testValues);
        double testAverageOfZero = ArrayOperations.getAverageWithOf(new int[0]);

        //Then
        Assert.assertEquals(51.7, testAverage, 0);
        Assert.assertEquals(0, testAverageOfZero, 0);
    }
}
