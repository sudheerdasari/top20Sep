package com.alg.top20.list;

/* Ref:
 * http://www.geeksforgeeks.org/data-structures/#LinkedList
 */

public class LinkedList extends AbstractList {
	
	private ListNode head;
	private ListNode last;
	public LinkedList() {
		head = new ListNode();
		last = head;
	}
	
	// T.C --> O(1)
	public void add(int e) {
		ListNode temp = new ListNode(e);
		last.next=temp;
		last=temp;
		++size;
	}
	
	@Override
	public void add(int ind, int e) {
		// TODO Auto-generated method stub
		
	}
	
	// T.C --> O(n)
	public void set(int ind, int e) {
		ListNode current = head;
		for (int i = 0; i < ind; i++) {
			current = current.next;
		}
		current.data=e;
	}
	
	//Removes the first element
	// T.C --> O(1)
	public void remove() {
		ListNode current = head.next;
		ListNode temp = current.next;
		head.next = temp;
		--size;
	}
	
	// T.C --> O(n)
	public void remove(int ind) {
		ListNode current = head;
		for (int i = 0; i < ind; i++) {
			current = current.next;
		}
		ListNode temp = current.next;
		current.next = temp.next;
		--size;
	}
	
	//Removes the first occurrence of element
	// T.C --> O(n)
	public boolean remove(Object o) {
		ListNode current=head;
		ListNode temp;
		while(current!=null) {
			temp = current.next;
			if(temp.data.equals(o)) {
				current.next=temp.next;
				--size;
				return true;
			}
			current = current.next;
		}
		return false;
		/*	for (int i = 0; i < size; i++) {
			current = prev.next;
			if (current.data.equals(o)) {
				prev.next=current.next;
				--size;
				return true;
			}
		}*/
	}
	
	
	// T.C --> O(n)
	public int get(int ind) {
		ListNode current = head.next;
		for (int i = 0; i < ind; i++) {
			current = current.next;
		}
		return current.data;
	}

	// T.C --> O(n)
	public boolean contains(int e) {
		ListNode current = head;
		while(current!=null) {
			if(current.data == e) {
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	// T.C --> O(n)
	public void display() {
		ListNode current = head.next;
		while (current!=null) {
			System.out.println(current.data);
			System.out.println("=====");
			current = current.next;
		}
	}
	
	@Override
	public int indexOf(int e) {
		return 0;
	}

}
