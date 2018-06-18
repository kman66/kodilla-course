package com.kodilla.patterns.builder.bigmac;

public class Bun {
    public static final String RYE = "RYE";
    public static final String WHEAT = "WHEAT";
    private final String flourType;

    public Bun(String flourType) {
        if (!flourType.equals(RYE) && !flourType.equals(WHEAT)) {
            throw new IllegalStateException("Unknown type of flour");
        }
        this.flourType = flourType;
    }

    public String getFlourType() {
        return flourType;
    }

    @Override
    public String toString() {
        return "Bun{" +
                "flourType='" + flourType + '\'' +
                '}';
    }
}
