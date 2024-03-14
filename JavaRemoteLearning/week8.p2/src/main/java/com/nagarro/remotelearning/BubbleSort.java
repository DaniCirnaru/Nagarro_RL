package com.nagarro.remotelearning;

import java.util.List;

public class BubbleSort {

    public <T extends Comparable<T>> void bubbleSort(List<T> list) {
        int n = list.size();
        boolean swapped;

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (list.get(i - 1).compareTo(list.get(i)) > 0) {
                    T temp = list.get(i - 1);
                    list.set(i - 1, list.get(i));
                    list.set(i, temp);
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

}
