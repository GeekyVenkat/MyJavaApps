package com.test.optum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class SleepHours {
	
	static HashMap<String , Integer> map = new HashMap<String, Integer>();
	  
	  static {
		  
		  map.put("Mon", 1);
		  map.put("Tue", 2);
		  map.put("Wed", 3);
		  map.put("Thu", 4);
		  map.put("Fri", 5);
		  map.put("Sat", 6);
		  map.put("Sun", 7);
		  
	  }
	  	
	 public static int solution(String S) {
	        // write your code in Java SE 8
		 String[] days= S.split("\\R");
		 
		 List<Time> meetings = new ArrayList<Time>();
		 
		 for(String s: days) {
			 
			 String[] tmp = s.split(" ");
			 String   day = tmp[0];
			 String   slot = tmp[1];
			 
			 Time meeting = new Time ();
			 
			 String[] timeStamps = slot.split("-");
			 
			 int shours = Integer.parseInt(timeStamps[0].substring(0, 2));
			 int smin   = Integer.parseInt(timeStamps[0].substring(3));
			 
			 int ehours = Integer.parseInt(timeStamps[1].substring(0, 2));
			 int emin   = Integer.parseInt(timeStamps[1].substring(3));
			
			 
			 Time t = new Time(map.get(day), shours, ehours, smin, emin);
			 
			 meetings.add(t);
		 }
		 
		 Collections.sort(meetings,new DaysComparator());
		 
		 int maxTimetoSleep = 0;
		 
		 for(int i = 0; i < meetings.size()-1; i++)  {
			// System.out.println(meetings.get(i));
			 
			 if(meetings.get(i).day == meetings.get(i+1).day) {
				int timeDiff = TimeDifferenceOfTheDay(meetings.get(i), meetings.get(i+1));
				
				if(timeDiff > maxTimetoSleep) 
					maxTimetoSleep = timeDiff;
			 }else {
				 int timeDiff = TimeDifferenceOfAnotherDay(meetings.get(i), meetings.get(i+1));
				 if(timeDiff > maxTimetoSleep) 
						maxTimetoSleep = timeDiff;
			 }
		 }
		 System.out.println(maxTimetoSleep); 
		return maxTimetoSleep;
	 }
	 public static void main(String[] args) {
			
			String S= "Mon 01:00-23:00\r\n" + 
					"Tue 01:00-23:00\r\n" + 
					"Wed 01:00-23:00\r\n" + 
					"Thu 01:00-23:00\r\n" + 
					"Fri 01:00-23:00\r\n" + 
					"Sat 01:00-23:00\r\n" + 
					"Sun 01:00-21:00";
			
			String S2 ="Sun 10:00-20:00\r\n" + 
					"Fri 05:00-10:00\r\n" + 
					"Fri 16:30-23:50\r\n" + 
					"Sat 10:00-24:00\r\n" + 
					"Sun 01:00-04:00\r\n" + 
					"Sat 02:00-06:00\r\n" + 
					"Tue 03:30-18:15\r\n" + 
					"Tue 19:00-20:00\r\n" + 
					"Wed 04:25-15:14\r\n" + 
					"Wed 15:14-22:40\r\n" + 
					"Thu 00:00-23:59\r\n" + 
					"Mon 05:00-13:00\r\n" + 
					"Mon 15:00-21:00";
			//solution(S);
			
			String s3 = "Mon 01:00-23:00\r\n" + 
					"  Tue 01:00-23:00\r\n" + 
					"  Wed 01:00-23:00\r\n" + 
					"  Thu 01:00-23:00\r\n" + 
					"  Fri 01:00-23:00\r\n" + 
					"  Sat 01:00-23:00\r\n" + 
					"  Sun 01:00-21:00";
			solution(s3);
		}
	
	 public static int TimeDifferenceOfTheDay(Time t1, Time t2) {
		 
		int  totalTimeDiff = 0;
		 if(t1.endTimeMin > 0) {
			   int diff = 60 - t1.getEndTimeMin() + t2.getStartTimeMin();
			   int startTimehr = t1.endTimehr +1;
			  
			   int  endTimeHr = t2.startTimehr;
			   					   
			   if(diff > 60) {
				    endTimeHr = t2.getStartTimehr() +1;
				   
				    diff = diff - 60;
			   }
			   
			   int hrDiff = endTimeHr - startTimehr;
			   
			   totalTimeDiff = hrDiff *60 + diff;
				 
		 }else {
			 int hrDiff = t2.startTimehr - t1.endTimehr;
			 totalTimeDiff = hrDiff *60 + t2.endTimeMin;
		 }
		 return totalTimeDiff;
		 
		// int diff2 = ;
		 
	 }

	 public static int TimeDifferenceOfAnotherDay(Time t1, Time t2) {
		 
		 int hoursTosleepMin = 0;
		 
		if(t1.endTimeMin > 0) {
			
			int totalMinToSleep = 60 - t1.getEndTimeMin() +t2.getStartTimeMin();
			int hoursTosleep = 24- t1.getEndTimehr() +1 + t2.getStartTimehr();
			
			if(totalMinToSleep > 60) {
				hoursTosleep = hoursTosleep+1;
				totalMinToSleep = totalMinToSleep -60;
				hoursTosleepMin = hoursTosleep  *60 + totalMinToSleep;
			}
			
		}else {
			int hoursTosleep = 24 - t1.getEndTimehr() +1 + t2.getStartTimehr();
			hoursTosleepMin = hoursTosleep* 60 + t2.getStartTimeMin();
		}
		return  hoursTosleepMin;
	 }
	 

	
}

class DaysComparator implements Comparator<Time>{

	@Override
	public int compare(Time t1, Time t2) {
		
		if(t1.day != t2.day)
			return t1.day - t2.day;
		else 
			return t1.startTimehr - t2.endTimehr;
	}
	
	
}

class Time {
	
	
	int day;
	
	int startTimehr;
	
	int endTimehr;
	
	int startTimeMin;
	
	int endTimeMin;
	
	public  Time(){
		 
	 }

	public Time(int day, int startTimehr, int endTimehr, int startTimeMin, int endTimeMin) {
		super();
		this.day = day;
		this.startTimehr = startTimehr;
		this.endTimehr = endTimehr;
		this.startTimeMin = startTimeMin;
		this.endTimeMin = endTimeMin;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getStartTimehr() {
		return startTimehr;
	}

	public void setStartTimehr(int startTimehr) {
		this.startTimehr = startTimehr;
	}

	public int getEndTimehr() {
		return endTimehr;
	}

	public void setEndTimehr(int endTimehr) {
		this.endTimehr = endTimehr;
	}

	public int getStartTimeMin() {
		return startTimeMin;
	}

	public void setStartTimeMin(int startTimeMin) {
		this.startTimeMin = startTimeMin;
	}

	public int getEndTimeMin() {
		return endTimeMin;
	}

	public void setEndTimeMin(int endTimeMin) {
		this.endTimeMin = endTimeMin;
	}

	@Override
	public String toString() {
		return "Time [day=" + day + ", startTimehr=" + startTimehr + ", endTimehr=" + endTimehr + ", startTimeMin="
				+ startTimeMin + ", endTimeMin=" + endTimeMin + "]";
	}
	 
	
}
