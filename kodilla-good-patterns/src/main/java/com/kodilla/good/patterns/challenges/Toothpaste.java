package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class Toothpaste extends Product {
    private String typeOfToothpaste;
    private LocalDateTime expiryDate;

    public Toothpaste(String id, String typeOfProduct, String name, String typeOfToothpaste, LocalDateTime expiryDate) {
        super(id, typeOfProduct, name);
        this.typeOfToothpaste = typeOfToothpaste;
        this.expiryDate = expiryDate;
    }

    public String getTypeOfToothpaste() {
        return typeOfToothpaste;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "Toothpaste{" +
                "id='" + super.getId() + '\'' +
                ", name='" + super.getName()+ '\'' +
                ", typeOfToothpaste='" + typeOfToothpaste + '\'' +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
