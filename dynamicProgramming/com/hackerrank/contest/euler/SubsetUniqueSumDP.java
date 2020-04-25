package com.hackerrank.contest.euler;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class SubsetUniqueSumDP {
	
	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	static HashSet<UIndex> set  = new HashSet<UIndex>();
	
	public static void subSetSum(int[] a, int index ,int sum, int subsetLength, UIndex i) {
		
		if(index >= a.length)  {
			if(subsetLength ==0) {
				if(map.containsKey(sum))
					map.put(sum, map.get(sum)+1);
				else 
					map.put(sum, 1);
				set.add(i);
				return;
			}
			return;
		}
		if(subsetLength == 0) {  //{1, 3, 6, 8, 10 , 11};
			if(map.containsKey(sum))
				map.put(sum, map.get(sum)+1);
			else 
				map.put(sum, 1);
			set.add(i);
			return;
		}
		else  if(!set.contains(i)) {
			subSetSum(a, index+1, a[index]+sum, subsetLength-1, new UIndex(a[index]+sum, index+1));
			subSetSum(a, index+1, sum, subsetLength, new UIndex(sum, index));
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);
		
		String[] str = scanner.nextLine().split(" ");
        
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
	
		int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        
        subSetSum(arr, 0, 0, m, new UIndex(0, 0));
		int sum = 0;
		
		for(Integer e: map.keySet()) {
			if(map.get(e) ==1) {
				sum = sum+e;
			}
		}
		System.out.println(sum);
	}
	
}

class UIndex {
	
	int sum;
	int index;

	
	public UIndex(int sum, int index) {
		super();
		this.sum = sum;
		this.index = index;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
		result = prime * result + sum;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UIndex other = (UIndex) obj;
		if (index != other.index)
			return false;
		if (sum != other.sum)
			return false;
		return true;
	}
	
	
}


