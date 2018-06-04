package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface OrderService {
    boolean order(final User user, final List<Product> listOfProducts, final LocalDateTime orderTime);
    boolean isUserExist();
    boolean isAllProductsAvailable();
    Map<Product, Boolean> getMapOfOrderedProducts();
}
