package com.hc.recursion;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class PowerSum {

	static int n;
	static int e;
	static long x;
	static int l;
	static int c;
	
	
	static long nthRoot(int A, int N)
	{
	    // intially guessing a random number between
	    // 0 and 9
	    double xPre = ThreadLocalRandom.current().nextInt(9) + 1;
	 
	    //  smaller eps, denotes more accuracy
	    double eps = 1e-3;
	 
	    // initializing difference between two
	    // roots by INT_MAX
	    double delX = Integer.MAX_VALUE;
	 
	    //  xK denotes current value of x
	    double xK =0;
	 
	    //  loop untill we reach desired accuracy
	    while (delX > eps)
	    {
	        //  calculating current value from previous
	        // value by newton's method
	        xK = ((N - 1.0) * xPre +
	              (double)A/Math.pow(xPre, N-1)) / (double)N;
	        delX = Math.abs(xK - xPre);
	        xPre = xK;
	    }
	     return Math.round(xK);
	}

	public static void print(int i,int end, ArrayList<String> combList) {
		
		for(int j=i+1;j<=end; j++) {
			System.out.println(i+""+j);
			
			
		}
	}
	public static void main(String[] args) {

	//	long nthRoot = nthRoot(10,2);
	//	System.out.println(nthRoot);
		x =10;
		e=2;
		
		ArrayList<String> combList = new ArrayList<String>();
		IntStream.range(1, 4)
				 .mapToObj(i->combList.add(""+i));
		
		

		for(int i=1; i<=4; i++){
			System.out.println(i);
			print(i,4,combList);
		}
		
	}
}
