package com.kodilla.patterns.builder.bigmac;

public class Burger {
    private BurgerCookingWay burgerCookingWay;

    public Burger() {
        this.burgerCookingWay = new WellDoneWay();
    }

    public BurgerCookingWay getBurgerCookingWay() {
        return burgerCookingWay;
    }

    public String cookBurger() {
        return burgerCookingWay.cook();
    }

    public void setBurgerCookingWay(BurgerCookingWay burgerCookingWay) {
        this.burgerCookingWay = burgerCookingWay;
    }
}
