package com.nagarro.remotelearning.util;

import java.util.Collection;

public class CustomList<T> implements MyCollection <T>{
    private java.util.List<T> list = new java.util.ArrayList<>();
    @Override
    public boolean containsAll(Collection<T> c) {

        return list.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<T> c) {

        return list.addAll(c);
    }


}
