package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class IngredientsTypes {
    public static final String LETTUCE = "LETTUCE";
    public static final String ONION = "ONION";
    public static final String BACON = "BACON";
    public static final String CUCCUMBER = "CUCCUMBER";
    public static final String CHILLI_PEPPER = "CHILLI_PEPPER";
    public static final String MUSHROOM = "MUSHROOM";
    public static final String PRAWNS = "PRAWNS";
    public static final String CHEESE = "CHEESE";

    public static List<String> getIngriedientsTypes() {
        List<String> ingredientsTypes = new ArrayList<>();
        ingredientsTypes.add(LETTUCE);
        ingredientsTypes.add(ONION);
        ingredientsTypes.add(BACON);
        ingredientsTypes.add(CUCCUMBER);
        ingredientsTypes.add(CHILLI_PEPPER);
        ingredientsTypes.add(MUSHROOM);
        ingredientsTypes.add(PRAWNS);
        ingredientsTypes.add(CHEESE);

        return ingredientsTypes;
    }
}
