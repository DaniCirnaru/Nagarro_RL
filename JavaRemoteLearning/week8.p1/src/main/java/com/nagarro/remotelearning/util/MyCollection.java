package com.nagarro.remotelearning.util;

import java.util.Collection;

interface MyCollection<T> {
    boolean containsAll(Collection<T> c);

    boolean addAll(Collection<T> c);

}