package com.nagarro.remotelearning.week4p1;

public interface List<T> {

	void add(T element);
	
	T get(int positon);
	
	boolean contains(T element);
	
	boolean containsAll(List<T> foreignList);
	
	int size();
}
