package com.hc.test;

import java.util.Scanner;

public class StairCase {
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
        String str="#";
        for (int i=0;i<n;i++)
        { 
        	System.out.printf("%"+(n+1)+"s",str+"\n");
            	str=str+"#";
        }
        in.close();
      }
}
