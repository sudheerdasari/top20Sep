package com.alg.top20.linkedlist;

public class DoubleListNode {
	Integer data;
	DoubleListNode prev;
	DoubleListNode next;
	
	public DoubleListNode() {
		prev = next = this;
	}
	public DoubleListNode(int i) {
		data = i;
		prev = next = this;
	}
}
