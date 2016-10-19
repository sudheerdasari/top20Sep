package com.alg.top20.set;

import java.util.List;

public interface ISortedSet extends ISet{
	int findMin();
	int findMax();
	int select(int k);
	List<Integer> findRange(Integer start, Integer end);

}
