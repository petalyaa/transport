package com.pet.transport.util;

/**
 * Class Description	: 
 * Created By			: Khairul Ikhwan
 * Created Date			: Feb 3, 2014
 * Current Version		: 1.0
 * Latest Changes By	: 
 * Latest Changes Date	: 
 */
public class Util {
	
	public static final int toInt(String s) {
		int i = 0;
		try {
			i = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public static final boolean toBoolean(String s) {
		return !isNullEmptyString(s) || s.equalsIgnoreCase("true") || s.equalsIgnoreCase("1") || s.equalsIgnoreCase("yes");
	}
	
	public static final boolean isNullEmptyString(String s) {
		return s == null || s.equals("");
	}

}
