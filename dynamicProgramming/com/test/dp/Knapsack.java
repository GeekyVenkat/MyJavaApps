package com.test.dp;

import javax.sql.rowset.CachedRowSet;

public class Knapsack {
	
	// Approach -1
	public static int maximumKnapsack(int[] wights, int[] profits, int maxCapacity , int weight, int index, int profit) {
		
		if(weight > maxCapacity) {
			return 0;
		}
		if (index >= wights.length && index >= profits.length){
			return profit;
		}
		return Math.max(maximumKnapsack(wights, profits ,maxCapacity, weight + wights[index], index + 1, profit + profits[index]),
					maximumKnapsack(wights, profits ,maxCapacity, weight, index + 1, profit));
	}
	
	// Approach - 2
	private static  int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
	    // base checks
	    if (capacity <= 0 || currentIndex >= profits.length)
	      return 0;

	    // recursive call after choosing the element at the currentIndex
	    // if the weight of the element at currentIndex exceeds the capacity, we shouldn't process this
	    int profit1 = 0;
	    if( weights[currentIndex] <= capacity )
	        profit1 = profits[currentIndex] + knapsackRecursive(profits, weights,
	                capacity - weights[currentIndex], currentIndex + 1);

	    // recursive call after excluding the element at the currentIndex
	    int profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1);

	    return Math.max(profit1, profit2);
	  }
	
	public static void main(String[] args) {
		
		/*int[] weights = {2, 3, 1, 4 };
		int[] profits = {4, 5, 3, 7 };
		
		int capacity = 5;
				
		System.out.println(maximumKnapsack(weights, profits, 6, 0, 0, 0));
		*/
		int[] profits = {1, 6, 10, 16};
	    int[] weights = {1, 2, 3, 5};
	    
	    System.out.println(maximumKnapsack(weights, profits, 7, 0, 0, 0));
	    
	    knapsackRecursive(profits, weights, 7, 0);
		
	}

}
