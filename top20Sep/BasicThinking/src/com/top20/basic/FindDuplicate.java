package com.top20.basic;

/*Given an array of n integers in which each element is between 1 and n-1, write an
efficient function to determine any duplicated integer. You may destroy the array.
What are the time and space complexities of your solution?
*/
public class FindDuplicate {

	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
		int[] in1 = new int[size];
		for (int i = 1; i < size; i++) {
			in1[i-1] = i;
		}
		in1[size-1]=1;
		long start = System.currentTimeMillis();
		System.out.println(findDuplicate1(in1));
		long end = System.currentTimeMillis();
		System.out.println("Time:" + (end - start) / 1000.0 + " Seconds");
	}

	
	public static int findDuplicate1(int[] in1) {
		int duplicate = 0;
		return duplicate;
	}

}
