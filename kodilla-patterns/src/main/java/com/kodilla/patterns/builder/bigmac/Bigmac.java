package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public final class Bigmac {
    private final Bun bun;
    private final Integer noOfBurgers;
    private final Burger burger;
    private final String sauce;
    private final List<String> ingredients;

    public static class BigmacBuilder {
        private Bun bun;
        private Integer noOfBurgers;
        private Burger burger;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder bun(String bunType, String flourType) {
            this.bun = BunFactory.chooseBun(bunType, flourType);
            return this;
        }

        public BigmacBuilder noOfBurgers(int noOfBurgers) {
            this.noOfBurgers = noOfBurgers;
            return this;
        }

        public BigmacBuilder burger(BurgerCookingWay burgerCookingWay) {
            Burger burgerBuf = new Burger();
            if (burgerCookingWay != null) {
                burgerBuf.setBurgerCookingWay(burgerCookingWay);
            }
            this.burger = burgerBuf;
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredients(String ingriedent) {
            ingredients.add(ingriedent);
            return this;
        }

        public Bigmac build() {
            boolean isIllegalState = false;
            String message = "";

            if (bun == null) {
                message += "|Unknown type of bun.|";
                isIllegalState = true;
            }

            if (burger == null) {
                message += "|Unknown type of burger.|";
                isIllegalState = true;
            }

            if (noOfBurgers < 0) {
                message += "|Quantity of burgers cannot be negative.|";
                isIllegalState = true;
            }

            if (!SauceTypes.getSauceTypes().contains(sauce)) {
                message += "|Unknown type of sauce.|";
                isIllegalState = true;
            }

            if (!ingredients.isEmpty() && !IngredientsTypes.getIngriedientsTypes().containsAll(ingredients)) {
                message += "|Unknown ingredient.|";
                isIllegalState = true;
            }

            if (isIllegalState) {
                throw new IllegalStateException(message);
            }

            return new Bigmac(bun, noOfBurgers, burger, sauce, ingredients);
        }

    }

    private Bigmac(Bun bun, Integer noOfBurgers, Burger burger, String sauce, List<String> ingredients) {
        this.bun = bun;
        this.noOfBurgers = noOfBurgers == null ? 2 : noOfBurgers;
        this.burger = burger;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public Bun getBun() {
        return bun;
    }

    public int getNoOfBurgers() {
        return noOfBurgers;
    }

    public Burger getBurger() {
        return burger;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun='" + bun + '\'' +
                ", noOfBurgers=" + noOfBurgers +
                ", burger=" + burger.cookBurger() +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
