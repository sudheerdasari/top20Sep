package com.alg.top20.set;


import com.alg.top20.set.ListNode;


public class HashSet implements ISet{
	
	//Array of list nodes (number of buckets in a hash table)
	private ListNode[] htb1;
	private int size;
	
	public HashSet() {
		//Set the default number of buckets while creating hashtable
		htb1 = new ListNode[11];
		//Pointing each bucket to a head node of a linked list
		for (int i = 0; i < htb1.length; i++) {
			htb1[i] = new ListNode();
		}
	}

	//1.	Check if size of hashtable vs hashtable length to accommodate max 20 elements in a bucket 
	//		to achieve constant performance for other operations like contains,remove etc
	//2.	Check if element already exist, duplicate check for set
	//3.	If not, Find the bucket of the element by calculating hashvalue --> create new node with the given value
    //		-->map new node pointer to first element(after head) of linked list --> map header node to new node  
	public boolean add(Integer e) {
		if (size / htb1.length > 20) {
			rehash();
		}
		if(!contains(e)) {
			int bucket = e.hashCode()%htb1.length;
			ListNode temp = new ListNode(e);
			temp.next = htb1[bucket].next;
			htb1[bucket].next = temp;
			++size;
			return true;
		} else {
			return false;
		}
	}

	/*
	 * 1. Create new hashtable(htb2) with double the size of previous table (Doubling the number of buckets)
	 * 2. Create ListNodes in each bucket (Dummy head node)
	 * 3. Loop1-Iterate through each bucket in previous hashtable(htb1) and get the first node value, which is head.next
	 * 4. Loop2-Calculate the bucket value for new hashtable for the current node value using hash function which now has new table length
	 * 5. Store the next node value before moving current node to new table bucket
	 * 6. Link current node with first node of the new bucket, which is next of head node
	 * 7. Link head node to current node to complete adding current node from old table to new table
	 * 8. Assign current to next node in previous table, which we stored in step 5 
	 * 
	 */
	private void rehash() {
		ListNode[] htb2 = new ListNode[2*htb1.length];
		for (int i = 0; i < htb2.length; i++) {
			htb2[i] = new ListNode();
		}
		ListNode current;
		ListNode temp;
		for (int i = 0; i < htb1.length; i++) {
			current = htb1[i].next;
			while(current !=null){
				int bucket = current.data.hashCode()%htb2.length;
				temp = current.next;
				current.next = htb2[bucket].next;
				htb2[bucket].next=current;
				current = temp;
			}
		}
		htb1=htb2;
	}

	//Find the bucket of the element by calculating hashvalue
	//Iterate through the bucket linked list(Skip HeaddNode) and check the data equals to given element
	// T.C --> O(1) (Iterating through the bucket itself which we can maintain fixed size)
	public boolean contains(Integer e) {
		int bucket = e.hashCode()%htb1.length;
		//htb1[bucket]=headNode of that bucket
		for (ListNode current = htb1[bucket].next; current!=null; current=current.next) {
			if (current.data.equals(e)) {
				return true;
			}
		}
		return false;
	}

	//Find the bucket of the element by calculating hashvalue
	//Iterate through the bucket linked list starting from head node
	//At current node check next node value, if found unlink the next node
	//T.C --> O(1) (Iterating through the bucket itself which we can maintain fixed size)
	public boolean remove(Integer e) {
		int bucket = e.hashCode()%htb1.length;
		ListNode nextNode;
		for (ListNode current = htb1[bucket]; current!=null; current=current.next) {
			nextNode = current.next;
			if(nextNode.data.equals(e)) {
				current.next=nextNode.next;
				--size;
				return true;
			}
		}
		return false;
	}

	public int size() {
		return size;
	}

	//Iterate through each bucket and each linked list in that bucket and print the values
	//T.C --> O(n)
	public void display() {
		ListNode current;
		for (int i = 0; i < htb1.length; i++) {
			System.out.println("");
			System.out.print("Bucket-"+i+":");
			current = htb1[i].next;
			while (current!=null) {
				System.out.print(current.data+" ");
				current = current.next;
			}
		}
		
	}

}
