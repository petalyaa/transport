package com.pet.transport.model;

/**
 * Class Description	: 
 * Created By			: Khairul Ikhwan
 * Created Date			: Feb 3, 2014
 * Current Version		: 1.0
 * Latest Changes By	: 
 * Latest Changes Date	: 
 */
public enum Result {
	
	INITIATING(100), PENDING(200), SUCCESS(300), FAILED(400);
	
	private Result(int resultCode) {
		this.resultCode = resultCode;
	}
	
	public int getCode() {
		return this.resultCode;
	}
	
	private int resultCode;

}
