package com.alg.top20.list;

/**
 * Resizable-array implementation of the <tt>List</tt> interface.  Implements
 * all optional list operations, and permits all elements, including
 * <tt>null</tt>.  In addition to implementing the <tt>List</tt> interface,
 * this class provides methods to manipulate the size of the array that is
 * used internally to store the list.  (This class is roughly equivalent to
 * <tt>Vector</tt>, except that it is unsynchronized.)
 *
 * <p>The <tt>size</tt>, <tt>isEmpty</tt>, <tt>get</tt>, <tt>set</tt>,
 * <tt>iterator</tt>, and <tt>listIterator</tt> operations run in constant
 * time.  The <tt>add</tt> operation runs in <i>amortized constant time</i>,
 * that is, adding n elements requires O(n) time.  All of the other operations
 * run in linear time (roughly speaking).  The constant factor is low compared
 * to that for the <tt>LinkedList</tt> implementation.
 * 
 *  * <p>Each <tt>ArrayList</tt> instance has a <i>capacity</i>.  The capacity is
 * the size of the array used to store the elements in the list.  It is always
 * at least as large as the list size.  As elements are added to an ArrayList,
 * its capacity grows automatically.  The details of the growth policy are not
 * specified beyond the fact that adding an element has constant amortized
 * time cost.
 *
 * <p>An application can increase the capacity of an <tt>ArrayList</tt> instance
 * before adding a large number of elements using the <tt>ensureCapacity</tt>
 * operation.  This may reduce the amount of incremental reallocation.
 */

public class ArrayList extends AbstractList{
	
	private int[] array;
	
	//Initialize the array to default size
	public ArrayList() {
		array = new int[10];
		size = 0;
	}

	//Check if array is full or not
	//If full - Double the array and copy the old array elements into new array
	//Else - Adding element at the end using size++ as index (Includes incrementing the size variable))
	public void add(int e) {
		if (size == array.length) {
			int[] newArray = new int[2*size];
			for (int i = 0; i < size; i++) {
				newArray[i] = array[i];
			}
			array = newArray;
		}
		array[size++] = e;
	}

	@Override
	public void add(int ind, int e) {
		// TODO Auto-generated method stub
		
	}

	
	// T.C --> O(1)
	public void set(int ind, int e) {
		array[ind]=e;
	}


	// T.C --> O(n)
	//Removing is nothing but assigning the next index value to the given index, 
	//and repeat upto the end of array to rearrangement
	//Decrement the size of array
	public void remove(int ind) {
		--size;
		for (int i = ind; i < size; i++) {
			array[ind] = array[ind+1];
		}
		
	}

	// T.C --> O(1) 
	public int get(int ind) {
		return array[ind];
	}

	
	// T.C --> O(n)
	public boolean contains(int e) {
		for (int i = 0; i < size; i++) {
			if( array[i] == e) {
				return true;
			}
		}
		return false;
	}

	// T.C --> O(n)
	public void display() {
		for (int i = 0; i < size; i++) {
			System.out.println(array[i]);
		}
	}

	/**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element
     */
	// T.C --> O(n)
	public int indexOf(int e) {
		for (int i = 0; i < size; i++) {
			if (e == array[i]) {
				return i;
			}
		}
		return -1;
	}

}
