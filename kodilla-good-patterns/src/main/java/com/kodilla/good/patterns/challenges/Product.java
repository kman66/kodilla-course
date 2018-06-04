package com.kodilla.good.patterns.challenges;

import java.util.Objects;

public abstract class Product {
    private String id;
    private String typeOfProduct;
    private String name;

    public Product(String id, String typeOfProduct, String name) {
        this.id = id;
        this.typeOfProduct = typeOfProduct;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getTypeOfProduct() {
        return typeOfProduct;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
