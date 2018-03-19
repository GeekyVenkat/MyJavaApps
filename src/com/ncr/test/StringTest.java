package com.ncr.test;

public class StringTest {

	static final public long NO_TIMEOUT = 0L;
	static final public long ONE_MINUTE_TIMEOUT = 60L * 1000L;
	static final public long TEN_MINUTE_TIMEOUT = 10L * ONE_MINUTE_TIMEOUT;

	static private long DEFAULT_CUT_OVER_TIME_OUT = 5 * ONE_MINUTE_TIMEOUT;
	
	static private long TIMEOUT_PERIOD_NEXT_PRIMARY = 1 * ONE_MINUTE_TIMEOUT;
	
	public static void main(String[] args) throws InterruptedException {
		
		 long lStartTime = System.nanoTime();
		  Thread.sleep(1000*60);
		  
		 long lEndTime = System.nanoTime();
		 
		 long output = lEndTime - lStartTime;
		 System.out.println("Elapsed time in milliseconds: " + output / 1000000);
		 
		 System.out.println(TIMEOUT_PERIOD_NEXT_PRIMARY);
		
	}
}
