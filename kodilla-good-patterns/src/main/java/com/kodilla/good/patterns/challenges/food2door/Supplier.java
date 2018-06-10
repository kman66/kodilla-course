package com.kodilla.good.patterns.challenges.food2door;

public class Supplier {
    private String supplierId;
    private String name;
    private Headquarters headquarters;

    public Supplier(String supplierId, String name, Headquarters headquarters) {
        this.supplierId = supplierId;
        this.name = name;
        this.headquarters = headquarters;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public String getName() {
        return name;
    }

    public Headquarters getHeadquarters() {
        return headquarters;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId='" + supplierId + '\'' +
                ", name='" + name + '\'' +
                ", headquarters=" + headquarters +
                '}';
    }
}
