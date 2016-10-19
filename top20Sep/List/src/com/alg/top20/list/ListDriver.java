package com.alg.top20.list;

import java.util.Random;

public class ListDriver {

	public static void testList(IList list) {
		Random rand = new Random(20);
		for (int i = 0; i < 11; i++) {
			list.add(rand.nextInt(15)+1);
		}
		list.display();
		list.remove(14);
		list.display();
		//System.out.println("Index--"+list.indexOf(14));
	}
	
	public static void main(String[] args) {
		//java.util.ArrayList<Integer> arr = new java.util.ArrayList<>();
		java.util.LinkedList<Integer> list = new java.util.LinkedList<>();
		//testList(new ArrayList());
		testList(new LinkedList());
	}
}
