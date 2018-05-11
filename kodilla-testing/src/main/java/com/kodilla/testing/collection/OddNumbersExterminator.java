package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.Objects;

public class OddNumbersExterminator {
    private String name;

    public OddNumbersExterminator(String name) {
        this.name = name;
    }

    public ArrayList<Integer> exterminate(ArrayList<Integer> list){
        ArrayList<Integer> newList = new ArrayList<Integer>();
        for(Integer i : list){
            if(i%2 == 0){
                newList.add(i);
            }
        }

        return newList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OddNumbersExterminator that = (OddNumbersExterminator) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
