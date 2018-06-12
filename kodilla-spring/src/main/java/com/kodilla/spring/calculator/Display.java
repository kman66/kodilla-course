package com.kodilla.spring.calculator;

import org.springframework.stereotype.Controller;

@Controller
public final class Display {
    public String displayValue(double val) {
        return String.valueOf(val);
    }
}
