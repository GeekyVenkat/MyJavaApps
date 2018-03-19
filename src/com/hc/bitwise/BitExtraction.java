package com.hc.bitwise;

public class BitExtraction {
	
	public static void main(String[] args) {
		
		String configValue = "0x6B";
		int x = 0x1E0;
		
		int val = (Integer.decode(configValue) & x) >>> 4;
		System.out.println("Config Value :"+Integer.toBinaryString(Integer.decode(configValue)));
		System.out.println("x :"+Integer.toBinaryString(x));
		System.out.println("Isolation"+Integer.toBinaryString(Integer.decode(configValue) & x));
		System.out.println(Integer.toBinaryString(val));

		System.out.println(val);
				
	}

}
