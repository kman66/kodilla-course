package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public abstract class AbtractPizzaOrderDecorator implements PizzaOrder {
    private PizzaOrder pizzaOrder;

    public AbtractPizzaOrderDecorator(PizzaOrder pizzaOrder) {
        this.pizzaOrder = pizzaOrder;
    }

    @Override
    public BigDecimal getCost() {
        return pizzaOrder.getCost();
    }

    @Override
    public String getDescription() {
        return pizzaOrder.getDescription();
    }
}
