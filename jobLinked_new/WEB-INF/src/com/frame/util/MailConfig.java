package com.frame.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
*
* @author Yuzana Zaw Zaw
*/
public class MailConfig {
	private static Log log = LogFactory.getLog(MailConfig.class);

	public void sendToOne(String recipient, String subject, String message,
			String from) throws MessagingException {

		boolean debug = false;
		// 1. Prepare Properties for mail server
		Properties props = new Properties();
		// setting the mail server host
		// prop.put("mail.smtp.host", "192.168.48.13");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		// 2. create mail Session
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"joblinked.jl@gmail.com", "qsxwcxgkthrknlts");
				}
				});
		session.setDebug(debug);
		// 3. create mimeMessage
		Message msg = new MimeMessage(session);
		// 4.prepare the From and To address
		InternetAddress fromAddress = new InternetAddress(from);

		// set from address
		msg.setFrom(fromAddress);
		// set to addresses
		// msg.setRecipients(Message.RecipientType.TO, toAddress);
		// msg.setRecipient(Message.RecipientType.TO,
		// InternetAddress(recipent));
		InternetAddress toAddress = new InternetAddress(recipient);
		msg.setRecipient(Message.RecipientType.TO, toAddress);
		// set subject
		msg.setSubject(subject);
		// set Message body
		// msg.setContent(message, "text/plain");
		msg.setContent(message, "text/plain");
		// 5. Mail send
		Transport.send(msg);
		System.out.println("send mail");
	}

}