package com.hc.test;

import java.util.Scanner;

public class PlusMinus {
	
	static void plusMinus(int[] arr) {
		
		double l = arr.length;
		long zeroCount = 0;
		long negativeCount = 0;
		long positiveCount = 0;
		
		for (int i: arr) {
			if (i == 0) zeroCount++;
			if (i > 0) positiveCount++;
			if (i < 0) negativeCount++;
		}
		System.out.printf("%.6f",positiveCount/l);
		System.out.println();
		System.out.printf("%.6f",negativeCount/l);
		System.out.println();
		System.out.printf("%.6f",zeroCount/l);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        plusMinus(arr);
        in.close();
    }

}
