package com.finalist.view.emailservice;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSenderImpl javaMailSenderImpl;

	public EmailService() {

	}

	public void sendMail(String to , String subject , String txt) {

		MimeMessage message = javaMailSenderImpl.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setFrom("dikrandono@gmail.com");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(txt);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		javaMailSenderImpl.send(message);
	}

}
