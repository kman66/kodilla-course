package com.kodilla.patterns.builder.bigmac;

public class BunFactory {
    public static final String BUN = "BUN";
    public static final String BUN_WITH_SESAME = "BUN_WITH_SESAME";

    public static Bun chooseBun(String bunType, String flourType) {
        switch (bunType) {
            case BUN : return new Bun(flourType);
            case BUN_WITH_SESAME : return new BunWithSesame(flourType);
            default : return null;
        }
    }
}
