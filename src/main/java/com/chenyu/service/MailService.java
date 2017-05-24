package com.chenyu.service;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	@Value("${mailService.host}")
	private String host;

	@Value("${mailService.port}")
	private String port;

	@Value("${mailService.username}")
	private String username;

	@Value("${mailService.password}")
	private String password;
	
	/**
	 * 
	 * @param recipient
	 * @param title
	 * @param content
	 */
	public void sendMail(String recipient, String title, String content) {
		Properties props = System.getProperties();
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.auth", "true");
	    // host
	    props.put("mail.smtp.host", host);
	    // port
	    props.put("mail.smtp.port", port);
	    // username
	    props.put("mail.smtp.user", username);
	    // password
	    props.put("mail.smtp.password", password);
	    
	    Session session = Session.getDefaultInstance(props, null);
	    
	    MimeMessage mime = new MimeMessage(session);
	    
	    try {
			// 发件人
			InternetAddress from = new InternetAddress(username);
			mime.setFrom(from);
			// 收件人
			InternetAddress to = new InternetAddress(recipient);
			mime.addRecipient(Message.RecipientType.TO,to);
			// 标题
			mime.setSubject(title);
			// 内容
			mime.setText(content);
			Transport t = session.getTransport("smtp");
	        t.connect(host, username, password);
	        t.sendMessage(mime, mime.getAllRecipients());
	        
	        t.close();
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 发送含附件的邮件
	 * @param recipient
	 * @param title
	 * @param content
	 * @param filePaths
	 */
	public void sendMail(String recipient, String title, String content, String... filePaths) {
		Properties props = System.getProperties();
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.auth", "true");
	    // host
	    props.put("mail.smtp.host", host);
	    // port
	    props.put("mail.smtp.port", port);
	    // username
	    props.put("mail.smtp.user", username);
	    // password
	    props.put("mail.smtp.password", password);
	    
	    Session session = Session.getDefaultInstance(props, null);
	    
	    MimeMessage mime = new MimeMessage(session);
	    
	    try {
			// 发件人
			InternetAddress from = new InternetAddress(username);
			mime.setFrom(from);
			// 收件人
			InternetAddress to = new InternetAddress(recipient);
			mime.addRecipient(Message.RecipientType.TO,to);
			// 标题
			mime.setSubject(title);

			// 内容
			Multipart mm = new MimeMultipart();
			BodyPart mbp = new MimeBodyPart();
			mbp.setContent(content, "text/plain");
			mm.addBodyPart(mbp);
			for (String filePath : filePaths) {
				mbp = new MimeBodyPart();
				mbp.setDataHandler(new DataHandler(new FileDataSource(filePath)));
				mbp.setFileName(filePath.substring(filePath.lastIndexOf("\\"), filePath.length()));
				mm.addBodyPart(mbp);
			}
			mime.setContent(mm);
			mime.saveChanges();
			
			Transport t = session.getTransport("smtp");
	        t.connect(host, username, password);
	        t.sendMessage(mime, mime.getAllRecipients());
	        
	        t.close();
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
