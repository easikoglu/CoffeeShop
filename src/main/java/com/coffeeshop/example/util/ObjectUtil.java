package com.coffeeshop.example.util;

public class ObjectUtil {
	
	public static boolean isNull(Object object){
		return object == null;
	}
	
	public static boolean isNotNull(Object object){
		return not(isNull(object));
	}

	public static boolean not(boolean value) {
		return !value;
	}

}
