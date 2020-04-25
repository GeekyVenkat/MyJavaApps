package com.test.optum;

import java.util.HashMap;

public class MaxByValue {
	
	public static int getIndex(int[] a, int start, int element) {
		
		for(int i = a.length-1; i> start ; i--) {
			if(a[i] == element)
				return i;
		}
		return -1;
	}
	public static int solution (int[] a) {
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int e : a) {
			if (!map.containsKey(e))
				map.put(e, 0);
		}
		if (map.size() == 2) {
			return a.length;
		}
		else  {
	
			int maxValue = 0;
			for( int i=0; i< a.length -1; i++) {
				
				int lastSliceIndex = getIndex(a, i, a[i]);
				
				if(lastSliceIndex != -1) {
					int diff =  lastSliceIndex -i+1;
					if(diff > maxValue)
						maxValue = diff;
				}
			}
			return maxValue;
		}
	
	}

	public static void main(String[] args) {
		
		int[] byValueSlice = {4, 2, 2, 4 , 2};
		
		int[] byValueSlice1 = {1,2,3, 4};
		
		int[] byValueSlice2 = {0,5,4, 4,5, 12};
		
		int[] byValueSlice3 = {4, 4};
		
		System.out.println(solution(byValueSlice));
		System.out.println(solution(byValueSlice1));
		System.out.println(solution(byValueSlice2));
		System.out.println(solution(byValueSlice3));
	}
}
