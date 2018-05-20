package com.kodilla.stream.world;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Continent {
    private final String name;
    Set<Country> countries;

    public Continent(final String name) {
        this.name = name;
        countries = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Set<Country> getCountries() {
        return countries;
    }

    public void addCountry(Country country){
        countries.add(country);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Continent continent = (Continent) o;
        return Objects.equals(name, continent.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Continent{" +
                "name='" + name + '\'' +
                '}';
    }
}
