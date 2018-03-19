package com.hc.test;

import java.util.Scanner;

public class FindDigits {
	
	  static int findDigits(int n) {
		  int count =0;
		  int v = n;
		  while (n>0) {
			  int d = n%10;
			  n  = n/10;
			  if(d!=0 && v%d == 0) {
				  count++;
			  }
		  }
		 return count;
	  }

	   public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        for(int a0 = 0; a0 < t; a0++){
	            int n = in.nextInt();
	            int result = findDigits(n);
	          System.out.println(result);
	        }
	        in.close();
	    }
}
