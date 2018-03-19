package com.hc.bitwise;

import java.util.Arrays;
import java.util.Scanner;

public class AorB {

	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
	    int numOfTestCases=Integer.parseInt(in.nextLine());
	    int A=0;
	    int B=0;
	    int C=0;
	    int k =0;
	    for (int j=0;j<numOfTestCases; j++){
	    	
	    	 int bitChange =0;
	    	 k = Integer.parseInt(in.nextLine());
	    	 A =  Integer.decode("0x"+in.nextLine());
	    	 B =  Integer.decode("0x"+in.nextLine());
	    	 C =  Integer.decode("0x"+in.nextLine());
	    	 
	    		int x = Integer.toBinaryString(A).length();
	    		int y = Integer.toBinaryString(B).length();
	    		int z = Integer.toBinaryString(C).length();
	    		
	    		int maxBits = Math.max(Math.max(x,y),z);
	    		
	    		byte bA[] = new byte[maxBits];
	    		byte bB[] = new byte[maxBits];
	    		byte bC[] = new byte[maxBits];
	    		
	    		Arrays.fill( bA, Byte.valueOf("48") );
	    		Arrays.fill( bB,  Byte.valueOf("48") );
	    		Arrays.fill( bC,  Byte.valueOf("48"));
	    		
	    		System.arraycopy(Integer.toBinaryString(A).getBytes(), 0, bA, bA.length-Integer.toBinaryString(A).getBytes().length, Integer.toBinaryString(A).getBytes().length);
	    		System.arraycopy(Integer.toBinaryString(B).getBytes(), 0, bB, bB.length-Integer.toBinaryString(B).getBytes().length, Integer.toBinaryString(B).getBytes().length);
	    		System.arraycopy(Integer.toBinaryString(C).getBytes(), 0, bC, bC.length-Integer.toBinaryString(C).getBytes().length, Integer.toBinaryString(C).getBytes().length);
	    		
	    		for (int i =0; i<maxBits; i++){
	    				
	    				if((bA[i] | bB[i]) == bC[i]) {
	    					continue;
	    				}else  if(bA[i] == 49 && bB[i] == 49 && bC[i] == 48){
	    					bitChange = bitChange +2;
	    					bA[i] = 48;
	    					bB[i] = 48;
	    				} else if ( bA[i] == 48 &&  bB[i] == 49 && bC[i] == 48 ){
	    					bB[i] =48;
	    					bitChange++;
	    				} else if(bA[i] == 48 && bB[i] == 48  && bC[i] == 49 ) {
	    					bB[i] = 49;
	    					bitChange++;
	    				} else if(bA[i] == 49 && bB[i] == 48 &&  bC[i] == 48 ) {
	    					bA[i] = 48;
	    					bitChange++;
	    				}
	    				
	    			}
	    			if(bitChange <= k) {
	    				int d1 = Integer.parseInt(new String(bA),2);
	    			//	System.out.println(Integer.toBinaryString(d1));
	    				String hexStrA = Integer.toString(d1,16);
	    				
	    				int d2 = Integer.parseInt(new String(bB),2);
	    				String hexStrB = Integer.toString(d2,16);
	    				//System.out.println(Integer.toBinaryString(d2));
	    				
	    				System.out.println(hexStrA);
	    				System.out.println(hexStrB);
	    			} else {
	    				System.out.println(-1);
	    			}
	    		}
	    		
	     }
	
}
