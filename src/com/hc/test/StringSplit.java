package com.hc.test;

public class StringSplit {
	
	public static void main(String[] args) {
		
		String mdsStatus = "002D901:3A:36:30";
		String[] data = mdsStatus.split(":",2);
		
		
		if(data.length == 2){
		
			String deviceModule = data[0].substring(3);
			String EFCOcde = data[1];
			
			if("DI01".equalsIgnoreCase(deviceModule)|| "D901".equalsIgnoreCase(deviceModule) ){
				System.out.println("DONE");
			}
			
		}
		
	}

}
