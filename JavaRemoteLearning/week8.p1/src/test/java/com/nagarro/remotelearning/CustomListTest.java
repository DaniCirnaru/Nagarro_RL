package com.nagarro.remotelearning;

import com.nagarro.remotelearning.util.CustomList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CustomListTest {

    @Test
    public void test_ListOfStrings() {
        CustomList<String> customList = new CustomList<>();
        List<String> list = new ArrayList<>();
        list.add("World");
        list.add("Hello");

        customList.addAll(list);
        assertTrue(customList.containsAll(list));
    }
    @Test
    public void test_ListOfIntegers() {
        CustomList<Integer> customList = new CustomList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        customList.addAll(list);
        assertTrue(customList.containsAll(list));
    }



}
