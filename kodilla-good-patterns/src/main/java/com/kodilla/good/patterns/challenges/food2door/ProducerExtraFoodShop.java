package com.kodilla.good.patterns.challenges.food2door;

public class ProducerExtraFoodShop extends Producer {
    public ProducerExtraFoodShop(String producerId, String name, String location) {
        super(producerId, name, location);
    }

    @Override
    protected boolean process(OrderRequest orderRequest) {
        if (orderRequest.getSupplier().getHeadquarters().equals(Headquarters.CHELMNO)) {
            return true;
        }
        return false;
    }
}
