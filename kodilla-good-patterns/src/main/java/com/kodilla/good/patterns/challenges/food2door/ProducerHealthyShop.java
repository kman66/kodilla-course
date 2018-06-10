package com.kodilla.good.patterns.challenges.food2door;

public class ProducerHealthyShop extends Producer {
    private ProductTypes notAcceptableProductType;

    public ProducerHealthyShop(String producerId, String name, String location, ProductTypes notAcceptableProductType) {
        super(producerId, name, location);
        this.notAcceptableProductType = notAcceptableProductType;
    }

    @Override
    protected boolean process(OrderRequest orderRequest) {
        return !orderRequest.getProduct().getType().equals(notAcceptableProductType);
    }
}
