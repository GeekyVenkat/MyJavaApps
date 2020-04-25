package com.test.dp;

public class PowerSet {

	public static void powerSet(int[] set, int index, String s) {
		System.out.println(index + " :: " + s);

		if (index >= set.length)
			return;
		System.out.println(index + " :: " + s + " " + set[index]);
		powerSet(set, index + 1, s + " " + set[index]);
		powerSet(set, index + 1, s);
	}

	public static void main(String[] args) {
		
		int[] set = {2, 3, 1, 4};
		powerSet(set, 0, "");
		
	}

}
