package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;
import java.util.List;

public class OrderRequest {
    private User user;
    private List<Product> productList;
    private LocalDateTime dateOfOrder;

    public OrderRequest(final User user, final List<Product> productList, final LocalDateTime dateOfOrder) {
        this.user = user;
        this.dateOfOrder = dateOfOrder;
        this.productList = productList;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getDateOfOrder() {
        return dateOfOrder;
    }

    public List<Product> getProductList() {
        return productList;
    }
}
