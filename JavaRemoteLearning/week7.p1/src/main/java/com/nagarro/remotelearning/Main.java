package com.nagarro.remotelearning;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(new Country("India", "New Delhi"));
        countries.add(new Country("United States", "Washington D.C."));
        countries.add(new Country("China", "Beijing"));
        countries.add(new Country("France", "Paris"));
        countries.add(new Country("Brazil", "Brasilia"));


        int result = binarySearchByCapital(countries, "Paris");

        if (result != -1) {
            System.out.println("Capital found at index: " + result);
            System.out.println("Country: " + countries.get(result).getName());
        } else {
            System.out.println("Capital not found.");
        }
    }

    public static int binarySearchByCapital(ArrayList<Country> countries, String targetCapital) {
        int left = 0;
        int right = countries.size() - 1;
        Comparator<Country> capitalComparator = new Country().capitalComparator;
        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = capitalComparator.compare(countries.get(mid), new Country("", targetCapital));
            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
