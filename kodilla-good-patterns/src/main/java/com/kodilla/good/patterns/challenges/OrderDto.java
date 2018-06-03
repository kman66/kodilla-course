package com.kodilla.good.patterns.challenges;

import java.util.Map;

public class OrderDto {
    private User user;
    private Map<Product, Boolean> mapOfOrderedProducts;
    private boolean allProductsAvailable;
    private boolean userExist;
    private boolean isOrdered;

    public OrderDto(User user, Map<Product, Boolean> mapOfOrderedProducts, boolean allProductsAvailable, boolean userExist, boolean isOrdered) {
        this.user = user;
        this.mapOfOrderedProducts = mapOfOrderedProducts;
        this.allProductsAvailable = allProductsAvailable;
        this.userExist = userExist;
        this.isOrdered = isOrdered;
    }

    public User getUser() {
        return user;
    }

    public Map<Product, Boolean> getMapOfOrderedProducts() {
        return mapOfOrderedProducts;
    }

    public boolean isAllProductsAvailable() {
        return allProductsAvailable;
    }

    public boolean isUserExist() {
        return userExist;
    }

    public boolean isOrdered() {
        return isOrdered;
    }
}
