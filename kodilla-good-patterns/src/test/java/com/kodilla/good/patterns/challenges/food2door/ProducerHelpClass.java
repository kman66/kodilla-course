package com.kodilla.good.patterns.challenges.food2door;

public class ProducerHelpClass {
    protected static OrderRequest generateOrderRequest(Headquarters headquarters, ProductTypes productType, int amountOfProducts) {
        Supplier supplier = new Supplier("1", "DummyName", headquarters);
        Product product = new Product("1", "DummyName", productType);

        return new OrderRequest(supplier, product, amountOfProducts);
    }
}
