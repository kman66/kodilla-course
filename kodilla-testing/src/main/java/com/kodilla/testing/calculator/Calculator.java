package com.kodilla.testing.calculator;

import java.util.Objects;

public class Calculator {
    private String name;

    public Calculator(String name) {
        this.name = name;
    }

    public double add(int a, int b){
        double res = Math.round((a+b)*100);
        return res/100;
    }

    public double subtract(int a, int b){
        double res = Math.round((a-b)*100);
        return res/100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calculator that = (Calculator) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
