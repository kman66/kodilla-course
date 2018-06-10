package com.kodilla.good.patterns.challenges.food2door;

import java.util.Objects;

public class Product {
    private String productId;
    private String name;
    private ProductTypes type;

    public Product(String productId, String name, ProductTypes type) {
        this.productId = productId;
        this.name = name;
        this.type = type;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public ProductTypes getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(productId);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
