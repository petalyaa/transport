package com.pet.transport.model;

import java.util.Properties;

/**
 * Class Description	: 
 * Created By			: Khairul Ikhwan
 * Created Date			: Feb 3, 2014
 * Current Version		: 1.0
 * Latest Changes By	: 
 * Latest Changes Date	: 
 */
public class TransportMessage {
	
	private Properties header;
	
	private String message;

	/**
	 * @return the header
	 */
	public Properties getHeader() {
		return header;
	}

	/**
	 * @param header the header to set
	 */
	public void setHeader(Properties header) {
		this.header = header;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
