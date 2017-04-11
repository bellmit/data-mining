package com.jdrx.dm.baseinfo.commons;

import java.util.UUID;

public class UUIDUtil {

	public static String uuid(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
}
