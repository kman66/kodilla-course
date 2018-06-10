package com.kodilla.good.patterns.challenges.food2door;

public class OrderDto {
    private Store store;
    private Producer producer;
    private boolean isOrdered;

    public OrderDto(Store store, Producer producer, boolean isOrdered) {
        this.store = store;
        this.producer = producer;
        this.isOrdered = isOrdered;
    }

    public Store getStore() {
        return store;
    }

    public Producer getProducer() {
        return producer;
    }

    public boolean isOrdered() {
        return isOrdered;
    }
}
