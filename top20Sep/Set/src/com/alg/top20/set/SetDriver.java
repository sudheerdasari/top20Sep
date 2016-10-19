package com.alg.top20.set;

import java.util.Random;

public class SetDriver {
	
	public static void main(String[] args) {
		HashSet hset = new HashSet();
		
		int limit = Integer.parseInt(args[0]);
		Random r = new Random(100);
		
		for(int i = 1; i <= limit; ++i) {
			hset.add(r.nextInt(1000));
		}
		System.out.println(hset.size());
		hset.display();
	}

}
