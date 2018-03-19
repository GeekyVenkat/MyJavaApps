package com.hc.test;

import java.util.Scanner;

public class NewYearChos {
	
	
	static void minimumBribes(int[] q) {
		
		long ans = 0;
	    for (int i = q.length - 1; i >= 0; i--) {
	        if (q[i] - (i + 1) > 2) {
	            System.out.println("Too chaotic");
	            return;
	        }
	        for (int j = Math.max(0, q[i] - 2); j < i; j++)
	            if (q[j] > q[i]) {
	            	ans++;
	            }
	       
	    }
	    System.out.println(ans);
	}
	
	/*static void minimumBribes(int[] q) {
        long  totalInversion =0;
	      for (int i=0; i< q.length; i++) {
	    		  int inversion = q[i] - (i+1) ;
	    		  int inversion1 =0;
	    		  int inversion2 =0;
	    		  if(inversion ==0 && i+2 < q.length){
	    			  inversion2  = (q[i] > q[i+2]) ? 2:0;
	    		
	    		  }
	    		  if(inversion>2) {
	    			  System.out.println("Too chaotic");
					return;
	    		  }
	    		  if(inversion+inversion1+inversion2>0)
	    			//  System.out.println("i "+(i+1)+" Inversions" +inversion+inversion1+inversion2);
	    			  totalInversion = totalInversion+inversion+inversion1+inversion2;
	    	  }
			System.out.println(totalInversion);
	    }*/

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        for(int a0 = 0; a0 < t; a0++){
	            int n = in.nextInt();
	            int[] q = new int[n];
	            for(int q_i = 0; q_i < n; q_i++){
	                q[q_i] = in.nextInt();
	            }
	            minimumBribes(q);
	        }
	       
	        in.close();
	    }

}
