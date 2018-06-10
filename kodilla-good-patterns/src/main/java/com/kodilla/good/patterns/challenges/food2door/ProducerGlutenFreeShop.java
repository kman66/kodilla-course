package com.kodilla.good.patterns.challenges.food2door;

public class ProducerGlutenFreeShop extends Producer {
    private int minimalAmountOfProducts;

    public ProducerGlutenFreeShop(String producerId, String name, String location, int minimalAmountOfProducts) {
        super(producerId, name, location);
        this.minimalAmountOfProducts = minimalAmountOfProducts;
    }

    @Override
    protected boolean process(OrderRequest orderRequest) {
        return orderRequest.getAmountOfProducts() >= minimalAmountOfProducts;
    }
}
