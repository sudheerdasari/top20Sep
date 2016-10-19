package com.alg.top20.linkedlist;

import java.util.LinkedList;

import com.alg.top20.list.AbstractList;

public class DoubleLinkedList extends AbstractList{
	
	DoubleListNode head;
	private int size;
	
	public DoubleLinkedList() {
		head = new DoubleListNode();
		size = 0;
	}

	//Appends the specified element to the end of this list.
	//T.C --> O(1)
	public void add(int e) {
		DoubleListNode temp = new DoubleListNode(e);
		temp.prev=head.prev.next;
		head.prev=temp.next;
		++size;
		
	}

	/**
    * Inserts the specified element at the specified position in this list.
    * Shifts the element currently at that position (if any) and any
    * subsequent elements to the right
    */
	//T.C --> O(n)
	public void add(int ind, int e) {
		if(ind<size) {
			DoubleListNode temp = new DoubleListNode(e);
			DoubleListNode current = head;
			for (int i = 0; i < ind; i++) {
				current =current.next; 
			}
			temp.next=current.next;
			current.next=temp.prev;
			++size;
		}
	}

	public void set(int ind, int e) {
		add(ind,e);
	}

	public void remove(int ind) {
		if(ind < size) {
			DoubleListNode temp;
			DoubleListNode current = head;
			for (int i = 0; i < ind; i++) {
				current =current.next; 
			}
			temp =current.next;
			current.next=temp.next;
			temp.prev=current;
		}
	}

	@Override
	public int get(int ind) {
		if(ind < size) {
			DoubleListNode current = head.next;
			for (int i = 0; i < ind; i++) {
				current =current.next; 
			}
			return current.data;
		}
		return 0;
	}

	@Override
	public boolean contains(int e) {
		DoubleListNode current=head.next;
		while(current!=null) {
			if(current.data.equals(e)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public void display() {
		DoubleListNode current=head.next;
		while(current!=null) {
				System.out.println(current.data);
				System.out.println("=====");
				current = current.next;
		}
	}

	public int indexOf(int e) {
		DoubleListNode current=head.next;
		for (int i = 0; i < size; i++) {
			if(current.data.equals(e)) {
				return i;
			}
		}
		return 0;
	}
	
}
