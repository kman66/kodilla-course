package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class SauceTypes {
    public static final String STANDARD = "STANDARD";
    public static final String THOUSAND_ISLANDS = "THOUSAND_ISLANDS";
    public static final String BARBECUE = "BARBECUE";

    public static List<String> getSauceTypes() {
        List<String> sauceTypes = new ArrayList<>();
        sauceTypes.add(STANDARD);
        sauceTypes.add(THOUSAND_ISLANDS);
        sauceTypes.add(BARBECUE);

        return sauceTypes;
    }
}
