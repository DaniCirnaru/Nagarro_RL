package com.nagarro.remotelearning.model;

import com.nagarro.remotelearning.week4p1.List;

class IndexOutOfBoundsException extends Exception {
    public IndexOutOfBoundsException(String message) {
        super(message);
    }
}

public class StringList implements List<String> {
    java.util.List<String> data = new java.util.ArrayList<String>();
    java.util.List<String> operationsLog = new java.util.ArrayList<String>();


    @Override
    public void add(String element) {
        try {
            if (element == null || element.isEmpty()) {
                throw new IllegalArgumentException("Added value cannot be null or empty");
            }
            Double.parseDouble(element);
            data.add(element);
            operationsLog.add("Added element: " + element);
        } catch (NumberFormatException e) {
            operationsLog.add("Failed to add element: " + element + ". Invalid number format.");
        }
    }


    @Override
    public String get(int position) {
        try {
            if (position < 0 || position >= data.size())
                throw new IndexOutOfBoundsException("Index out of bounds: " + position);
            operationsLog.add("Accessed element at position: " + position);
            return data.get(position);
        } catch (IndexOutOfBoundsException e) {
            operationsLog.add("Failed to access element at position: " + position + ". Index out of bounds.");
            return null;
        }
    }


    @Override
    public boolean contains(String element) {
        return data.contains(element);
    }

    @Override
    public boolean containsAll(List<String> foreignList) {
        for (int i = 0; i < foreignList.size(); i++) {
            if (!contains(foreignList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return data.size();
    }

    public java.util.List<String> getOperationsLog() {

        return operationsLog;
    }
}
