package com.pet.transport;

import java.util.List;
import java.util.Properties;

import com.pet.transport.exception.TransporterException;
import com.pet.transport.model.Result;
import com.pet.transport.model.TransportMessage;
import com.pet.transport.model.TransporterInfo;

/**
 */
public abstract class Transporter {
	
	protected Properties systemProperties;
	
	public Transporter(TransporterInfo info) {
		this.systemProperties = System.getProperties();
		init(info);
	}
	
	public void init(TransporterInfo info) {
		systemProperties.putAll(info);
	}
	
	public abstract void startup();
	
	public abstract Result send(TransportMessage msg) throws TransporterException;
	
	public abstract List<Result> sendBulk(List<TransportMessage> msgList);
	
	public abstract void shutdown();
	
}
