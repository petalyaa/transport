package com.pet.transport.smtp.model;

import com.pet.transport.model.TransporterInfo;
import com.pet.transport.util.Util;

/**
 * Class Description	: 
 * Created By			: Khairul Ikhwan
 * Created Date			: Feb 3, 2014
 * Current Version		: 1.0
 * Latest Changes By	: 
 * Latest Changes Date	: 
 */
public class EmailTransporterInfo extends TransporterInfo {

	private static final long serialVersionUID = 7396339650641115094L;

	public static final String MAIL_SMTP_SOCKET_FACTORY_PORT = "mail.smtp.socketFactory.port";

	public static final String MAIL_SMTP_SOCKET_FACTORY_CLASS = "mail.smtp.socketFactory.class";

	public static final String MAIL_SMTP_AUTH = "mail.smtp.auth";

	public static final String MAIL_SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable";

	public static final String MAIL_SMTP_HOST = "mail.smtp.host";

	public static final String MAIL_SMTP_PORT = "mail.smtp.port";
	
	private String username;
	
	private String password;
	
	/**
	 * @return the socketFactoryPort
	 */
	public int getSocketFactoryPort() {
		return Util.toInt(getProperty(MAIL_SMTP_SOCKET_FACTORY_PORT));
	}

	/**
	 * @param socketFactoryPort the socketFactoryPort to set
	 */
	public void setSocketFactoryPort(int socketFactoryPort) {
		setProperty(MAIL_SMTP_SOCKET_FACTORY_PORT, String.valueOf(socketFactoryPort));
	}

	/**
	 * @return the socketFactoryClass
	 */
	public String getSocketFactoryClass() {
		return getProperty(MAIL_SMTP_SOCKET_FACTORY_CLASS);
	}

	/**
	 * @param socketFactoryClass the socketFactoryClass to set
	 */
	public void setSocketFactoryClass(String socketFactoryClass) {
		setProperty(MAIL_SMTP_SOCKET_FACTORY_CLASS, socketFactoryClass);
	}

	/**
	 * @return the smtpAuth
	 */
	public boolean isSmtpAuth() {
		return Util.toBoolean(getProperty(MAIL_SMTP_AUTH));
	}

	/**
	 * @param smtpAuth the smtpAuth to set
	 */
	public void setSmtpAuth(boolean smtpAuth) {
		setProperty(MAIL_SMTP_AUTH, String.valueOf(smtpAuth));
	}

	/**
	 * @return the smtpStartTLSEnable
	 */
	public boolean isSmtpStartTLSEnable() {
		return Util.toBoolean(getProperty(MAIL_SMTP_STARTTLS_ENABLE));
	}

	/**
	 * @param smtpStartTLSEnable the smtpStartTLSEnable to set
	 */
	public void setSmtpStartTLSEnable(boolean smtpStartTLSEnable) {
		setProperty(MAIL_SMTP_STARTTLS_ENABLE, String.valueOf(smtpStartTLSEnable));
	}

	/**
	 * @return the smtpHost
	 */
	public String getSmtpHost() {
		return getProperty(MAIL_SMTP_HOST);
	}

	/**
	 * @param smtpHost the smtpHost to set
	 */
	public void setSmtpHost(String smtpHost) {
		setProperty(MAIL_SMTP_HOST, smtpHost);
	}

	/**
	 * @return the smtpPort
	 */
	public int getSmtpPort() {
		return Util.toInt(getProperty(MAIL_SMTP_PORT));
	}

	/**
	 * @param smtpPort the smtpPort to set
	 */
	public void setSmtpPort(int smtpPort) {
		setProperty(MAIL_SMTP_PORT, String.valueOf(smtpPort));
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
