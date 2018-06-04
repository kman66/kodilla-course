package com.kodilla.good.patterns.challenges.food2door;

public class ProducerGlutenFreeShop extends Producer {
    public ProducerGlutenFreeShop(String producerId, String name, String location) {
        super(producerId, name, location);
    }

    @Override
    protected boolean process(OrderRequest orderRequest) {
        if (orderRequest.getAmountOfProducts() >= 10) {
            return true;
        }
        return false;
    }
}
