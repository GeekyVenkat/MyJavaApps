package com.hc.test;

import java.util.HashMap;
import java.util.Scanner;

public class BirthdayCake {
	

    static int birthdayCakeCandles(int n, int[] ar) {
        // Complete this function
    	 Integer max = Integer.MIN_VALUE;
    	 int count = 1;
    	 HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	 
    	 for(int i: ar) {
    		 if(i>=max){
    			 max = i;
    			 if(map.containsKey(max)){
    				 count = map.get(max)+1;
    				 map.put(max, count);
    			 } else {
    				 map.put(max, count);
    			 }
    		 }
    	 }
    	 return map.get(max);
    }
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }

}
