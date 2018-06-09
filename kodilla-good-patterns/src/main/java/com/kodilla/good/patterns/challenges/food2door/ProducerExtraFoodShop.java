package com.kodilla.good.patterns.challenges.food2door;

public class ProducerExtraFoodShop extends Producer {
    private Headquarters favouriteHeadquarterOfSupplier;

    public ProducerExtraFoodShop(String producerId, String name, String location, Headquarters favouriteHeadquarterOfSupplier) {
        super(producerId, name, location);
        this.favouriteHeadquarterOfSupplier = favouriteHeadquarterOfSupplier;
    }

    @Override
    protected boolean process(OrderRequest orderRequest) {
        if (orderRequest.getSupplier().getHeadquarters().equals(favouriteHeadquarterOfSupplier)) {
            return true;
        }
        return false;
    }
}
