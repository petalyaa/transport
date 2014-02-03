package com.pet.transport.exception;

/**
 * Class Description	: 
 * Created By			: Khairul Ikhwan
 * Created Date			: Feb 3, 2014
 * Current Version		: 1.0
 * Latest Changes By	: 
 * Latest Changes Date	: 
 */
public class TransporterException extends Exception {

	private static final long serialVersionUID = -1684962105666700144L;
	
	public TransporterException(String msg) {
		super(msg);
	}
	
	public TransporterException() {
		super();
	}
	
	public TransporterException(String msg, Throwable tw) {
		super(msg, tw);
	}

}
