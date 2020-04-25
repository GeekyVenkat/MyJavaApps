package com.test.dp;

public class RodCuttingProblem {
	
	
	public static int maximizeProfit(int[] a, int[] prices, int totalprice, int index, int rodLength) {
		
		//System.out.println(index +" "+rodLength+" "+totalprice);
		if (rodLength == 0)
			return totalprice;
		if(rodLength < 0)
			return 0;
		if (index >= a.length)
			return totalprice;
		
		int price1 = maximizeProfit(a, prices, totalprice+prices[index], index, rodLength-a[index]);
		int price2 = maximizeProfit(a, prices,totalprice, index+1, rodLength);		
		return Math.max(price1, price2);
	}
	
	
	public static void main(String[] args) {
		
		int[] lengths = {1, 2, 3, 4, 5};
		int[] prices  = {2, 6, 7, 10, 13};
		int maxRodLength = 5;
		
		System.out.println(maximizeProfit(lengths, prices, 0, 0, 5));
	}

}
