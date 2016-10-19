package com.alg.top20.list;

public interface IList {
	
	void add(int e);
	void add(int ind, int e);
	void set(int ind, int e);
	//void remove(int e);
	void remove(int ind);
	int get(int ind);
	boolean contains(int e);
	int size();
	void display();
	int indexOf(int e);
}
