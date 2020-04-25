package com.test.rnd;

public class Test {

	static String reverse(String s) {
		return reverse (s.toCharArray(), s.length());
	}
	
	static String reverse(char[] ch, int index) {
		if (index <= 0 ) {
			return "";
		}
		System.out.println(ch[index-1] +" "+index);
		return ""+ch[index-1] +""+reverse(ch , index-1);
	}
	
	public static void main(String[] args) {
		
		String s = "abcdef";
		System.out.println(reverse(s));
		
	}
}
