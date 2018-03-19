package com.hc.test;

public class CastTest {

	public static  String getEmployeeName (Employee e) {
		
		return (String) e.getName(); 
	}
	
	public static void main(String[] args) {
		
		Employee e = new Employee();
				
		String name = getEmployeeName(e);
		
		System.out.println("Name "+name );
		
		
	}
	
}

class Employee {
	private String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}