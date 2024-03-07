package com.nagarro.remotelearning;

import java.util.Comparator;

public class Country implements Comparable<Country> {
    private final String name;
    private final String capital;

    public Comparator<Country> capitalComparator = Comparator.comparing(c -> c.capital);

    public Country(String name, String capital) {
        this.name = name;
        this.capital = capital;
    }

    public Country() {
        this.name = "";
        this.capital = "";
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    @Override
    public int compareTo(Country other) {

        return this.name.compareTo(other.name);
    }

}
