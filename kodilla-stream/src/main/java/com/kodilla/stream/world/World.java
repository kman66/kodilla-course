package com.kodilla.stream.world;

import com.kodilla.stream.forum.ForumUser;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class World {
    private Set<Continent> continents = new HashSet<>();

    public void addContinent(Continent continent){
        continents.add(continent);
    }

    public Set<Continent> getContinents() {
        return continents;
    }

    public BigDecimal getPeopleQuantity(){
        return continents.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }
}
