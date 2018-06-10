package com.kodilla.good.patterns.challenges.food2door;

public class OrderRequest {
    private Supplier supplier;
    private Product product;
    private int amountOfProducts;

    public OrderRequest(Supplier supplier, Product product, int amountOfProducts) {
        this.supplier = supplier;
        this.product = product;
        this.amountOfProducts = amountOfProducts;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public Product getProduct() {
        return product;
    }

    public int getAmountOfProducts() {
        return amountOfProducts;
    }
}
