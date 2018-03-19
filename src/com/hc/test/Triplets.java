package com.hc.test;

import java.util.Arrays;

public class Triplets {
	
	static long aliceCount =0;
	static long bobCount =0;
	
	static void solve(int ...a){
        // Complete this function
		
		int[] alice = Arrays.copyOfRange(a, 0, 3);
		int[] bob   =  Arrays.copyOfRange(a, 3, 6);
		
		for (int i=0;i<3;i++){
			if(alice[i] ==bob[i]){
				continue;
			} else if (alice[i] > bob[i]) {
				aliceCount++;
			} else {
				bobCount++;
			}
		}
		System.out.println(aliceCount);
		System.out.println(bobCount);
    }
	
	public static void main(String[] args) {
		
		int a0 = 5;
		int a1 = 6;
		int a2 = 7;
		
		int b0 = 3;
		int b1 = 6;
		int b2 = 10;
		solve(a0, a1, a2, b0, b1, b2);
	}

}
