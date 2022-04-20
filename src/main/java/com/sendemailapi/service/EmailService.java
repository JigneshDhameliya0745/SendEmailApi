package com.sendemailapi.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EmailService {

	public boolean sendEmail(String to, String cc, String subject, String message, @RequestParam("file") MultipartFile file) {
		boolean found = false;

		String from = "dhameliyajignesh214@gmail.com";
		String host = "smtp.gmail.com";

		Properties properties = System.getProperties();
		System.out.println("PROPERTIES " + properties);

		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("dhameliyajignesh214@gmail.com", "fwojxfizuysqfxsj");
			}

		});

//		session.setDebug(true);

		MimeMessage mimeMessage = new MimeMessage(session);

		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom(from);
			mimeMessageHelper.setTo(to);
			mimeMessageHelper.setCc(cc);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(message);
			mimeMessageHelper.addAttachment(file.getOriginalFilename(), file);
			
			Transport.send(mimeMessage);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return found;
	}

}
