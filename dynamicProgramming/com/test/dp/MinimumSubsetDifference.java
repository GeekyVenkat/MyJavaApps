package com.test.dp;

import java.util.Arrays;

public class MinimumSubsetDifference {
	
	
	public static int minSubsetDiff(int[] a, int index, int sum1 ,int sum2) {
		
		if(index >= a.length)
			return Math.abs(sum1-sum2);
		else { 		
			int diff1 = minSubsetDiff(a, index+1, sum1+a[index], sum2);
			
			int diff2 = minSubsetDiff(a, index+1, sum1, sum2+a[index]);
			
			return Math.min (diff1, diff2);
		}
	}
	
	
	public static void main(String[] args) {
		
		int[] a = {1, 2, 3, 9};
		
		int[] b = {1, 3, 100, 4};
		
		int[] c = {1, 2, 7, 1, 5};
		
		int tsum = Arrays.stream(c).sum();
		
	//	System.out.println(minSubsetDiff(a, 0, 0, tsum));
		System.out.println(minSubsetDiff(c, 0, 0, 0));
	}

}
