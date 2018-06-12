package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    private static ApplicationContext context;
    private static Calculator calculator;
    private static Display display;

    @BeforeClass
    public static void initiateNeededObjects() {
        //Given
        context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        calculator = context.getBean(Calculator.class);
        display = calculator.getDisplay();
    }

    @Test
    public void testAdd() {
        //When
        BigDecimal resultOfCalculator = calculator.add(12.34, 43.12);
        String resultOfDisplay = display.displayValue(resultOfCalculator.doubleValue());

        //Then
        Assert.assertEquals(BigDecimal.valueOf(55.46), resultOfCalculator);
        Assert.assertEquals("55.46", resultOfDisplay);
    }

    @Test
    public void testSub() {
        //When
        BigDecimal resultOfCalculator = calculator.sub(12.34, 43.12);
        String resultOfDisplay = display.displayValue(resultOfCalculator.doubleValue());

        //Then
        Assert.assertEquals(BigDecimal.valueOf(-30.78), resultOfCalculator);
        Assert.assertEquals("-30.78", resultOfDisplay);
    }

    @Test
    public void testMul() {
        //When
        BigDecimal resultOfCalculator = calculator.mul(12.34, 43.12);
        String resultOfDisplay = display.displayValue(resultOfCalculator.doubleValue());

        //Then
        Assert.assertEquals(BigDecimal.valueOf(532.1008), resultOfCalculator);
        Assert.assertEquals("532.1008", resultOfDisplay);
    }

    @Test
    public void testDiv() {
        //When
        BigDecimal resultOfCalculator = calculator.div(12.34, 43.12);
        String resultOfDisplay = display.displayValue(resultOfCalculator.doubleValue());

        //Then
        Assert.assertEquals(BigDecimal.valueOf(0.2861781), resultOfCalculator);
        Assert.assertEquals("0.2861781", resultOfDisplay);
    }
}
