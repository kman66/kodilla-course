package com.kodilla.good.patterns.challenges;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Inventory {
    private static Set<Product> productsSet = new HashSet<>();

    public static void addProduct(Product ...products) {
        productsSet.addAll(Arrays.asList(products));
    }

    public static boolean deleteProduct(Product product) {
        return productsSet.remove(product);
    }

    public static boolean containsProduct(Product product) {
        return productsSet.contains(product);
    }

    public static Set<Product> getSetOfProducts(){
        return productsSet;
    }
}
