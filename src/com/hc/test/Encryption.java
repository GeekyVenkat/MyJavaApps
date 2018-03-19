package com.hc.test;

import java.util.Scanner;

public class Encryption {
	

    static String encryption(String s) {
       int c=0;
       int r =0;
    	int l = s.length();
    	int k = (int) Math.sqrt(l);
    	if(k*k == l){
    		c=k;
    		r=k;
    	}else {
    		c=k+1;
    		r= k;
    	}
    	while ((r*c)<l){
    		r = r+1;
    		if(r*c >= l)
    			break;
    		c= c+1;
    	}    	
    	k= 0;
    	String[] a =  new String[r];
    	
    	for ( int i = 0; i < r; i++){
    		if(i==r-1){
    			a[i] =s.substring(k);
    		}else {
    			a[i] = s.substring(k,k+c);
    			k = k+c;
    		}
    		
    	}
    	StringBuilder result = new StringBuilder();
    	for(int i=0;i<c; i++){
    		String str ="";
    		for(int j=0; j<r; j++){
    			if(i<a[j].length())
    				str = str+a[j].charAt(i);
    	 	}
    		result.append(str+" ");
       	}
    	return result.toString().trim();
    }

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = encryption(s);
        System.out.println(result);
        in.close();
    }
	
}
