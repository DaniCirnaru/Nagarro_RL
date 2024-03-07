package com.nagarro.remotelearning;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertTrue;

public class CountryTest {
    private ArrayList<Country> countries;

    @Before
    public void setUp() {
        countries = new ArrayList<>();
        countries.add(new Country("India", "New Delhi"));
        countries.add(new Country("United States", "Washington D.C."));
        countries.add(new Country("China", "Beijing"));
        countries.add(new Country("Brazil", "Brasilia"));
    }

    @Test
    public void testSortingByName() {
        Collections.sort(countries);

        System.out.println("Sorted list of countries by name:");
        for (Country country : countries) {
            System.out.println(country.getName() + " - " + country.getCapital());
        }

        for (int i = 0; i < countries.size() - 1; i++) {
            assertTrue(countries.get(i).compareTo(countries.get(i + 1)) <= 0);
        }
    }

    @Test
    public void testSortingByCapital() {

        countries.sort(new Country().capitalComparator);
        System.out.println("Sorted list of countries by capital:");
        for (Country country : countries) {
            System.out.println(country.getName() + " - " + country.getCapital());
        }
        for (int i = 0; i < countries.size() - 1; i++) {
            assertTrue(new Country().capitalComparator.compare(countries.get(i), countries.get(i + 1)) <= 0);
        }
    }

}
