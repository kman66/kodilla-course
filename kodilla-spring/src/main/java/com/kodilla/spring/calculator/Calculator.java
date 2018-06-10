package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;

@Service
public final class Calculator {
    @Autowired
    private Display display;

    public BigDecimal add(double a, double b) {
        BigDecimal result = BigDecimal.valueOf(a).add(BigDecimal.valueOf(b));
        display.displayValue(result.doubleValue());
        return result;
    }

    public BigDecimal sub(double a, double b) {
        BigDecimal result = BigDecimal.valueOf(a).subtract(BigDecimal.valueOf(b));
        display.displayValue(result.doubleValue());
        return result;
    }

    public BigDecimal mul(double a, double b) {
        BigDecimal result = BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(b));
        display.displayValue(result.doubleValue());
        return result;
    }

    public BigDecimal div(double a, double b) {
        BigDecimal result = BigDecimal.valueOf(a).divide(BigDecimal.valueOf(b), MathContext.DECIMAL32);
        display.displayValue(result.doubleValue());
        return result;
    }

    public Display getDisplay() {
        return display;
    }
}
