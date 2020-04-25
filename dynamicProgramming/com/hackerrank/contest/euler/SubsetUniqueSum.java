package com.hackerrank.contest.euler;

import java.util.HashMap;

public class SubsetUniqueSum {
	
	static HashMap<Index, Integer> map = new HashMap<Index, Integer>();
	static HashMap<Integer,Integer> map2 = new HashMap<Integer, Integer>();
	
	public static void subSetSum(int[] a, int sum ,int index, int midIndex, int endIndex, Index key ) {
		
		if(sum!= 0 && !map.containsKey(key)) {
			map.put(key, sum);
			
			if(!map2.containsKey(sum))
				map2.put(sum, 1);
			else 
				map2.put(sum, map2.get(sum)+1);
		}
		
		if(index >= a.length || midIndex >= a.length || endIndex >= a.length)
			return;
		
		else {
			System.out.println(" "+a[index]+" "+a[midIndex]+" "+a[endIndex]);
			subSetSum(a, a[index]+a[midIndex]+a[endIndex], index, midIndex+1 , endIndex+1, new Index(index, midIndex, endIndex)) ;
			subSetSum(a, a[index]+a[midIndex]+a[endIndex], index, midIndex , endIndex+1, new Index(index, midIndex, endIndex)) ;
			subSetSum(a, a[index]+a[midIndex]+a[endIndex], index+1, midIndex+1 , endIndex+1, new Index(index, midIndex, endIndex));
		}
		
	}
/*
	public static int subSetSum(int[] a) {
		
	}
	
	*/
	public static void main(String[] args) {
	
		int[] a = {1, 3, 6, 8, 10 , 11};
		
		subSetSum(a, 0, 0, 1, 2, new Index(0, 1, 2));
		
		int tsum = 0;
		for(Integer key: map2.keySet()) {
			if(map2.get(key) == 1)
				tsum = tsum + key;
		}
		
		System.out.println(tsum);
	}

}

class Index {
	
	private int start;
	private int middle;
	private int end;
	
	public Index(int start, int middle, int end) {
		super();
		this.start = start;
		this.middle = middle;
		this.end = end;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + end;
		result = prime * result + middle;
		result = prime * result + start;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Index other = (Index) obj;
		if (end != other.end)
			return false;
		if (middle != other.middle)
			return false;
		if (start != other.start)
			return false;
		return true;
	}
	
	
	
}