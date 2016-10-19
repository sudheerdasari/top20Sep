package com.top20.basic;

import java.util.Arrays;
import java.util.HashSet;

/*Problem 2: (Intersection of arrays)
Given two arrays of m and n integers respectively, find an efficient approach to determine the number of common 
elements between them. Assume that the arrays does contain distinct elements respectively. 
What are the time and space complexities of your solution?
*/

/* Ref:
 * https://github.com/algorithmica-repository/top20-september/blob/master/basic-thinking/src/com/alg/top20/basic/Intersection.java
 * http://codinghelmet.com/?path=exercises/array-intersection
 * http://articles.leetcode.com/here-is-phone-screening-question-from/
 * http://www.geeksforgeeks.org/union-and-intersection-of-two-sorted-arrays-2/
 * http://www.geeksforgeeks.org/find-union-and-intersection-of-two-unsorted-arrays/
 */

public class FindIntersectionOfArrays {

	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
		int[] in1 = new int[size];
		int[] in2 = new int[size];

		for (int i = 0; i < size; ++i) {
			in1[i] = i;
			in2[i] = i + size;
		}
		long start = System.currentTimeMillis();
		//System.out.println(findCommon1(in1, in2));
		long end = System.currentTimeMillis();
		System.out.println("Time:" + (end - start) / 1000.0 + " Seconds");
		start = System.currentTimeMillis();
		System.out.println(findCommon2(in1, in2));
		end = System.currentTimeMillis();
		System.out.println("Time:" + (end - start) / 1000.0 + " Seconds");
		start = System.currentTimeMillis();
		System.out.println(findCommon3(in1, in2));
		end = System.currentTimeMillis();
		System.out.println("Time:" + (end - start) / 1000.0 + " Seconds");
		start = System.currentTimeMillis();
		System.out.println(findCommon4(in1, in2));
		end = System.currentTimeMillis();
		System.out.println("Time:" + (end - start) / 1000.0 + " Seconds");
	}

	/*
	 * Solution with Brute force Approach 
	 * --> Compare each & every element of two arrays 
	 * --> Take element from 1st array and search for it in 2nd array
	 * T.C <= n+n+------+m 
	 *     <= n*m
	 */

	public static int findCommon1(int[] in1, int[] in2) {
		int common = 0;
		//n*m Comparisions
		for (int i = 0; i < in1.length; i++) {
			for (int j = 0; j < in2.length; j++) {
				if(in1[i] == in2[j]) {
					++common;
				}
				
			}
		}
		return common;
	}
	
	/*
	 * Solution with Sorting of One Array and Compare (Partial Sort)
	 * --> Sort one/first array 
	 * --> Take element from sorted array and search for it in unsorted array
	 * T.C <= nlogn (Sorting) + logn+logn+------m times (Searching)
	 *     <= nlogn (Sorting) + mlogn (Searching)
	 *     <= logn (m+n)
	 */
	
	public static int findCommon2(int[] in1, int[] in2) {
		int common = 0;
		//iterate through the shorter array and do a binary search for every element of short array in big array
		if (in2.length > in1.length) {
			findCommon2(in2, in1);
		}
		//nlogn
		Arrays.sort(in2);
		//mlogn
		for (int i = 0; i < in1.length; i++) {
			if(Arrays.binarySearch(in2, in1[i]) > 0) {
				++common;
			}
		}
		return common;
	}
	
	/*
	 * Solution with HashSet data structure
	 * --> Insert one array into Hashset (insert smaller array which takes less space)
	 * --> Check other array elements which contains or not
	 * T.C <= m*c (insert) + n*c (search)
	 *     <= (m+n)*c
	 * S.C --> min(n,m)
	 */
	
	public static int findCommon3(int[] in1, int[] in2) {
		int common = 0;
		HashSet<Integer> hSet = new HashSet<Integer>();
		
		//Check the smaller array and insert into Hashset
		if (in1.length > in2.length) {
			findCommon3(in2, in1);
		}
		//m*c --> insert
		for (int i = 0; i < in1.length; i++) {
			hSet.add(in1[i]);
		}
		//n*c --> retrive
		for (int i = 0; i < in2.length; i++) {
			if (hSet.contains(in2[i])) {
				++common;
			}
		}
		return common;
	}
	
	/*
	 * Solution with sort both arrays and scan through (Full Sort)
	 * We can have two index, which both starts at zero. Compare the two first elements of A and B. 
	 * If A[0] is greater than B[0], we increase index of B by one. If B[0] is greater than A[0], 
	 * we increase index of A by one. If they are equal, we know an intersection has occurred, 
	 * so add it to the list and increment index of A and B by one. 
	 * Once either index reaches the end of A or B, we have found all the intersections of A and B.
	 * T.C <= (m+n)-1 (If both arrays are sorted)
	 * T.C <= mlogn+nlogn+(m+n)-1
	 */
	public static int findCommon4(int[] in1, int[] in2) {
		int common = 0;
		//mlogn
		Arrays.sort(in1);
		//nlogn
		Arrays.sort(in2);
		//m+n-1 (as one element will remain uncompared in the end)
		int i=0,j=0;
		while (i < in1.length && j < in2.length) {
			if (in1[i] == in2[j]) {
				++common;
				++i;
				++j;
			} else if (in1[i] < in2[j]) {
				++i;
			} else {
				++j;
			}
		}
		return common;
	}

}
