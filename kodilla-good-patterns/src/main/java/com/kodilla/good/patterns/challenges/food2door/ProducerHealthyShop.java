package com.kodilla.good.patterns.challenges.food2door;

public class ProducerHealthyShop extends Producer {
    public ProducerHealthyShop(String producerId, String name, String location) {
        super(producerId, name, location);
    }

    @Override
    protected boolean process(OrderRequest orderRequest) {
        if (orderRequest.getProduct().getType().equals(ProductTypes.MIESO)) {
            return false;
        }
        return true;
    }
}
