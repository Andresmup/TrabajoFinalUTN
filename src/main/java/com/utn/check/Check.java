package com.utn.check;

import java.lang.reflect.Field;

public class Check {

	public boolean checkIntegridad(Object objeto) throws IllegalAccessException {
	    for (Field field : objeto.getClass().getDeclaredFields()) {
	        field.setAccessible(true);
	        if (field.get(objeto) == null) {
	            return false;
	        }
	    }
	    return true;
	}

}
