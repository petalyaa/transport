package com.pet.transport.smtp;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.pet.transport.Transporter;
import com.pet.transport.exception.TransporterException;
import com.pet.transport.model.Result;
import com.pet.transport.model.TransportMessage;
import com.pet.transport.smtp.model.EmailAddress;
import com.pet.transport.smtp.model.EmailTransportMessage;
import com.pet.transport.smtp.model.EmailTransporterInfo;
import com.pet.transport.util.Util;

/**
 */
public class SMTPTransporter extends Transporter {
	
	private Session session;
	
	private String username;
	
	private String password;
	
	public SMTPTransporter(EmailTransporterInfo info) {
		super(info);
		this.username = info.getUsername();
		this.password = info.getPassword();
	}

	/* (non-Javadoc)
	 * @see com.pet.transport.Transporter#startup()
	 */
	@Override
	public void startup() {
		session = Session.getDefaultInstance(systemProperties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
	}
	
	/* (non-Javadoc)
	 * @see com.pet.transport.Transporter#send(com.pet.transport.model.TransportMessage)
	 */
	@Override
	public Result send(TransportMessage msg) throws TransporterException {
		Result result = Result.FAILED;
		try {
			EmailTransportMessage emailMsg = (EmailTransportMessage) msg;
			InternetAddress[] addresses = new InternetAddress[emailMsg.getTo().length];
			for(int i = 0; i < addresses.length; i++) {
				EmailAddress emailAddr = emailMsg.getTo()[i]; 
				addresses[i] = new InternetAddress(emailAddr.getEmail(), emailAddr.getName());
			}
			
			// Check if contain attachment
			boolean containAttachment = false;
			if(emailMsg.getAttachmentPath() != null) 
				containAttachment = true;

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(emailMsg.getFrom().getEmail(), emailMsg.getFrom().getName()));
			message.setRecipients(Message.RecipientType.TO, addresses);
			message.setSubject(emailMsg.getSubject());

			if(!containAttachment) {
				if(!Util.isNullEmptyString(emailMsg.getTextMessage()))
					message.setText(emailMsg.getTextMessage());
				if(!Util.isNullEmptyString(emailMsg.getHtmlMessage()))
					message.setContent(emailMsg.getHtmlMessage(), "text/html");
			} else {
				BodyPart messageBodyPart = new MimeBodyPart();
				if(!Util.isNullEmptyString(emailMsg.getTextMessage()))
					messageBodyPart.setText(emailMsg.getTextMessage());
				if(!Util.isNullEmptyString(emailMsg.getHtmlMessage()))
					messageBodyPart.setContent(emailMsg.getHtmlMessage(), "text/html");
				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(messageBodyPart);
				for(String attachmentPath : emailMsg.getAttachmentPath()) {
					File file = new File(attachmentPath);
					messageBodyPart = new MimeBodyPart();
					DataSource source = new FileDataSource(attachmentPath);
					messageBodyPart.setDataHandler(new DataHandler(source));
					messageBodyPart.setFileName(file.getName());
					multipart.addBodyPart(messageBodyPart);
				}
				message.setContent(multipart);
			}
			Transport.send(message);
			result = Result.SUCCESS;
		} catch (UnsupportedEncodingException e) {
			throw new TransporterException("Failed to send email message", e);
		} catch (MessagingException e) {
			throw new TransporterException("Failed to send email message", e);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.pet.transport.Transporter#sendBulk(java.util.List)
	 */
	@Override
	public List<Result> sendBulk(List<TransportMessage> msgList) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pet.transport.Transporter#shutdown()
	 */
	@Override
	public void shutdown() {
	}

}
