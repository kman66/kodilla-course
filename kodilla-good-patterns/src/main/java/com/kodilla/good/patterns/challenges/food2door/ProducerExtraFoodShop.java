package com.kodilla.good.patterns.challenges.food2door;

public class ProducerExtraFoodShop extends Producer {
    public ProducerExtraFoodShop(String producerId, String name, String location) {
        super(producerId, name, location);
    }

    @Override
    protected boolean process(OrderRequest orderRequest) {
        return orderRequest.getSupplier().getHeadquarters().toString().equals(getLocation());
    }
}
