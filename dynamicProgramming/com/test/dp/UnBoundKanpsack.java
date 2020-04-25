package com.test.dp;

public class UnBoundKanpsack {
	
	
	private static  int unBoundknapsackRecursive(Integer[][] dp, int[] profits, int[] weights, int capacity, int currentIndex) {
	    // base checks
	    if (capacity <= 0 || currentIndex >= profits.length)
	      return 0;

	    if(dp[currentIndex][capacity] != null)
	    	return dp[currentIndex][capacity];
	    // recursive call after choosing the element at the currentIndex
	    // if the weight of the element at currentIndex exceeds the capacity, we shouldn't process this
	    int profit1 = 0;
	    if( weights[currentIndex] <= capacity )
	        profit1 = profits[currentIndex] + unBoundknapsackRecursive(dp,profits, weights,
	                capacity - weights[currentIndex], currentIndex);

	    // recursive call after excluding the element at the currentIndex
	    int profit2 = unBoundknapsackRecursive(dp, profits, weights, capacity, currentIndex + 1);
	    
	    dp[currentIndex][capacity] = Math.max(profit1, profit2);
	    
	    return dp[currentIndex][capacity];
	  }
	

	 public static void main(String[] args) {
		 
		 int[] weights = {1, 2, 3};
		 int[] profits = {15, 20, 50};
		 
		 int capacity = 5;
		 
		 Integer[][] dp = new Integer[weights.length][capacity + 1];
		 
		 System.out.println(unBoundknapsackRecursive(dp, profits, weights, capacity, 0 ));
		 
	
	}

}
