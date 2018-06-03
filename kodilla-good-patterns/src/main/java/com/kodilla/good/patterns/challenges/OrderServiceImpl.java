package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {
    private boolean userExist;
    private boolean allProductsAvailable;
    private Map<Product, Boolean> mapOfOrderedProducts = new HashMap<>();

    @Override
    public boolean order(final User user, final List<Product> productList, final LocalDateTime orderTime) {
        userExist = UserDataBase.getSetOfUsers().contains(user);
        allProductsAvailable = Inventory.getSetOfProducts().containsAll(productList);
        productList.stream()
                .forEach(p -> mapOfOrderedProducts.put(p, Inventory.containsProduct(p)));

        if(!userExist || !allProductsAvailable){
            return false;
        }

        Inventory.getSetOfProducts().removeAll(productList);
        return true;
    }

    public boolean isUserExist() {
        return userExist;
    }

    public boolean isAllProductsAvailable() {
        return allProductsAvailable;
    }

    public Map<Product, Boolean> getMapOfOrderedProducts() {
        return mapOfOrderedProducts;
    }
}
