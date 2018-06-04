package com.kodilla.good.patterns.challenges;

public class Game extends Product {
    private String typeOfGame;

    public Game(String id, String typeOfProduct, String name, String typeOfGame) {
        super(id, typeOfProduct, name);
        this.typeOfGame = typeOfGame;
    }

    public String getTypeOfGame() {
        return typeOfGame;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id='" + super.getId() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", typeOfGame='" + typeOfGame + '\'' +
                '}';
    }
}
