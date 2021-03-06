package com.hc.test;

import java.util.Scanner;
import java.util.TreeSet;

public class MiniMaxSum {
	
	static void miniMaxSum(int[] arr) {
        
		long sum =0;
		for(int i:arr){
			sum = sum+i;
		}
		
		TreeSet<Long> tset = new TreeSet<Long>();
		
		for(long i:arr){
			tset.add(sum-i);
		}
		System.out.println(tset.first() +" "+ tset.last());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for(int arr_i = 0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        miniMaxSum(arr);
        in.close();
    }

}
