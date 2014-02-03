package com.pet.transport.test;

import com.pet.transport.Transporter;
import com.pet.transport.exception.TransporterException;
import com.pet.transport.model.Result;
import com.pet.transport.smtp.SMTPTransporter;
import com.pet.transport.smtp.model.EmailAddress;
import com.pet.transport.smtp.model.EmailTransportMessage;
import com.pet.transport.smtp.model.EmailTransporterInfo;

/**
 * Class Description	: 
 * Created By			: Khairul Ikhwan
 * Created Date			: Feb 3, 2014
 * Current Version		: 1.0
 * Latest Changes By	: 
 * Latest Changes Date	: 
 */
public class Test {

	public static void main(String[] args) {
		EmailAddress from = new EmailAddress("Khairul", "petalyaa@gmail.com");
		EmailAddress to = new EmailAddress("khairul ikhwan", "petalyaa@gmail.com");
		EmailAddress toAddresses[] = new EmailAddress[1];
		toAddresses[0] = to;
		String htmlMessage = "<h3>This is just a test</h3>";
		String textMessage = "This is just a test";
		String subject = "This is just a test";
		EmailTransportMessage msg = new EmailTransportMessage();
		msg.setFrom(from);
		msg.setHtmlMessage(htmlMessage);
		msg.setSubject(subject);
		msg.setTextMessage(textMessage);
		msg.setTo(toAddresses);
		//msg.addAttachmentPath("c:/users/khairul/desktop/test.csv");
		
		EmailTransporterInfo info = new EmailTransporterInfo();
		info.setSmtpAuth(true);
		info.setSmtpHost("smtp.gmail.com");
		info.setSocketFactoryPort(465);
		info.setSocketFactoryClass("javax.net.ssl.SSLSocketFactory");
		info.setSmtpPort(465);
		info.setUsername("");
		info.setPassword("");
		Transporter smtpTransporter = new SMTPTransporter(info);
		smtpTransporter.startup();
		
		// Send message here
		try {
			Result result = smtpTransporter.send(msg);
			if(result == Result.SUCCESS) {
				System.err.println("Succesfully sent email message!!");
			} else {
				System.err.println("Failed to send email message");
			}
		} catch (TransporterException e) {
			e.printStackTrace();
		}
		smtpTransporter.shutdown();
	}
	
}
