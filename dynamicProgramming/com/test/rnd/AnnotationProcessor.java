package com.test.rnd;

import java.lang.reflect.Method;
import java.util.Objects;

public class AnnotationProcessor {

	private static void checkIfSerializable(Object object) throws JsonSerializationException {
	    if (Objects.isNull(object)) {
	        throw new JsonSerializationException("The object to serialize is null");
	    }
	         
	    Class<?> clazz = object.getClass();
	    if (!clazz.isAnnotationPresent(JsonSerializable.class)) {
	        throw new JsonSerializationException("The class "
	          + clazz.getSimpleName() 
	          + " is not annotated with JsonSerializable");
	    }
	}
	
	private void initializeObject(Object object) throws Exception {
	    Class<?> clazz = object.getClass();
	    for (Method method : clazz.getDeclaredMethods()) {
	        if (method.isAnnotationPresent(Init.class)) {
	            method.setAccessible(true);
	            method.invoke(object);
	        }
	    }
	 }
	public static void main(String[] args) {
		
		Person p = new Person();
		p.setFirstName("Adapa");
		p.setLastName("Yashika");
		p.setAge("23");
		
		try {
			checkIfSerializable(p);
		} catch (JsonSerializationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
		
	}
}
