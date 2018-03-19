package com.ncr.test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumbers {
	
	public static void main(String[] args) {
		for (int i=1;i<40;i++) {
				//System.out.println();
			int x=	ThreadLocalRandom.current().nextInt(11-1)+1;
		}
	}

}
