package com.pet.transport.smtp.model;

import java.util.ArrayList;
import java.util.List;

import com.pet.transport.model.TransportMessage;

/**
 * Class Description	: 
 * Created By			: Khairul Ikhwan
 * Created Date			: Feb 3, 2014
 * Current Version		: 1.0
 * Latest Changes By	: 
 * Latest Changes Date	: 
 */
public class EmailTransportMessage extends TransportMessage {
	
	private EmailAddress[] to;
	
	private EmailAddress from;
	
	private String subject;
	
	private String htmlMessage;
	
	private String textMessage;
	
	private List<String> attachmentPath;

	/**
	 * @return the to
	 */
	public EmailAddress[] getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(EmailAddress[] to) {
		this.to = to;
	}

	/**
	 * @return the from
	 */
	public EmailAddress getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(EmailAddress from) {
		this.from = from;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the htmlMessage
	 */
	public String getHtmlMessage() {
		return htmlMessage;
	}

	/**
	 * @param htmlMessage the htmlMessage to set
	 */
	public void setHtmlMessage(String htmlMessage) {
		this.htmlMessage = htmlMessage;
	}

	/**
	 * @return the textMessage
	 */
	public String getTextMessage() {
		return textMessage;
	}

	/**
	 * @param textMessage the textMessage to set
	 */
	public void setTextMessage(String textMessage) {
		this.textMessage = textMessage;
	}

	/**
	 * @return the attachmentPath
	 */
	public List<String> getAttachmentPath() {
		return attachmentPath;
	}

	/**
	 * @param attachmentPath the attachmentPath to set
	 */
	public void addAttachmentPath(String attachmentPath) {
		if(this.attachmentPath == null) 
			this.attachmentPath = new ArrayList<String>();
		this.attachmentPath.add(attachmentPath);
	}
	
}
