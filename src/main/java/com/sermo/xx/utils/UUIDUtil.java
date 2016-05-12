package com.sermo.xx.utils;

import java.util.UUID;

public class UUIDUtil {
	
	public static String UUIDGenerator(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
