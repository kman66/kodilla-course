package com.kodilla.good.patterns.challenges.food2door;

public class ProductOrderService {
    private Producer producer;
    private Store store;

    public ProductOrderService(final Producer producer, final Store store) {
        this.producer = producer;
        this.store = store;
    }

    public OrderDto processOrder(final OrderRequest orderRequest) {
        boolean isOrdered = producer.process(orderRequest);
        if (isOrdered) {
            return new OrderDto(store, producer, true);
        } else {
            return new OrderDto(store, producer, false);
        }
    }
}
