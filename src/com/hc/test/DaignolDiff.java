package com.hc.test;

import java.util.Scanner;

public class DaignolDiff {
	
	static int diagonalDifference(int[][] a) {
      
		long s1 = 0;
		long s2 = 0;
		
		for (int i=0;i<a.length;i++) {
			s1 = s1 + a[i][i];
		}
		int k = 0;
		for (int j=a.length-1;j>=0; j--) {
			s2 = s2 + a[j][k];
			k++;
		}
		return (int) Math.abs(s1-s2) ;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n][n];
        for(int a_i = 0; a_i < n; a_i++){
            for(int a_j = 0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }
        int result = diagonalDifference(a);
        System.out.println(result);
        in.close();
    }

}
