package com.test.dp;

import java.util.Arrays;

public class CountOfSubSetSum {
	
	static int count = 0;
	
	public static int countSubSetsSum(int[] a, int index, int tsum, int sum, int count) {
		
		if(index >= a.length)   {//{1, 1, 2, 3}
			if(tsum == sum ) {
				count ++;
			}
			return count;
		}
		else{
			int count1 = countSubSetsSum (a, index+1, tsum-a[index], sum, count);
			int count2 = countSubSetsSum(a, index+1, tsum, sum, count);
			return count1 + count2;
		}
		
	}
	public static void main(String[] args) {
		
		int[] a = {1, 1, 2, 3};
		
		int[] b = {1, 2, 7, 1, 5};
		
		int sum = Arrays.stream(b).sum();
		System.out.println(countSubSetsSum(b, 0 , sum, 9, 0));
	//	System.out.println(count);
		
	}

}
