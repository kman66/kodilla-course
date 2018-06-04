package com.kodilla.good.patterns.challenges.food2door;

public class Store {
    private String storeId;
    private String name;

    public Store(String storeId, String name) {
        this.storeId = storeId;
        this.name = name;
    }

    public String getStoreId() {
        return storeId;
    }

    public String getName() {
        return name;
    }
}
