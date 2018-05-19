package com.kodilla.stream.lambda;

import com.kodilla.stream.reference.FunctionalCalculator;
import org.junit.*;

public class ExpressionExecutorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests(){
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests(){
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest(){
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testExecuteExpression(){
        //Given
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        //When
        double lambdaAdd = expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        double lambdaSubstract = expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        double lambdaMultiply = expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        double lambdaDivision = expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        double methodRefMultiply = expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        double methodRefAdd = expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        double methodRefSubstract = expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        double methodRefDivision = expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        //Then
        Assert.assertEquals(15, lambdaAdd, 0.001);
        Assert.assertEquals(5, lambdaSubstract, 0.001);
        Assert.assertEquals(50, lambdaMultiply, 0.001);
        Assert.assertEquals(2, lambdaDivision, 0.001);

        Assert.assertEquals(12, methodRefMultiply, 0.001);
        Assert.assertEquals(7, methodRefAdd, 0.001);
        Assert.assertEquals(-1, methodRefSubstract, 0.001);
        Assert.assertEquals(0.75, methodRefDivision, 0.001);
    }


}
