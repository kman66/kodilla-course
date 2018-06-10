package com.kodilla.good.patterns.challenges.food2door;


public abstract class Producer {
    private String producerId;
    private String name;
    private String location;

    public Producer(String producerId, String name, String location) {
        this.producerId = producerId;
        this.name = name;
        this.location = location;
    }

    public String getProducerId() {
        return producerId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    protected abstract boolean process(final OrderRequest orderRequest);
}
