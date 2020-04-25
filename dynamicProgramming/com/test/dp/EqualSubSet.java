package com.test.dp;

import java.util.Arrays;

public class EqualSubSet {
	
/*	public static int  equalSubset(int[] a, int index, int sum , int totalsum) {
		
		if(index >= a.length) {
			return totalSum;
		}
		else {
			int Sum1 = equalSubset(a, index+1, sum - a[index],totalsum);
			int Sum2 = equalSubset(a, index+1, sum, totalsum);
			
			if(Sum1*2 == totalsum || Sum2 *2 ==  totalsum) {
				System.out.println(" Has Equal Subsets ");
			}
			return 0;
		}
			
	}*/
	
	public static boolean  equalSubset(int[] a, int index, int sum ) {
		
		if (sum == 0)
			return true;

		if (index >= a.length && a.length == 0) {
			return false;
		} else {

			if (a[index] <= sum) {
				if (equalSubset(a, index + 1, sum - a[index]))
					return true;
			}
			return equalSubset(a, index + 1, sum);
		}

	}

	public static void main(String[] args) {
		
		int[] a = {1,2,3,4};
		
		
		int totalSum = Arrays.stream(a).sum();
	//	System.out.println(totalSum);
		
		Integer[][] dp = new Integer[a.length+1][totalSum+1];
		equalSubset(a, 0, totalSum);
	}
	
}
