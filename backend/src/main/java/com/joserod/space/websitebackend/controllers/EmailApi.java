package com.joserod.space.websitebackend.controllers;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.joserod.space.websitebackend.pojos.Email;
@RestController
@Configuration
public class EmailApi {

	@Value("${EMAIL_TOKEN}")
	private String emailToken;

	@Value("${EMAIL_FROM}")
	private String emailFrom;

    @Value("${EMAIL_TO}")
	private String emailTo;

	@GetMapping(value="/status")
	public String hello() {
		return "okay";
	}

@RequestMapping(
    value = "/email", 
    method = RequestMethod.POST)
    public ResponseEntity<String> sendEmail(@RequestBody Email email) {
        String status = null;
        // Add recipient
        String to = emailTo;

        // Add sender
        String from = emailFrom;
        final String username = emailFrom;//your Gmail username 
        final String password = emailToken;//your Gmail password

        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); 
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // Get the Session object
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a default MimeMessage object
            Message message = new MimeMessage(session);
            
            message.setFrom(new InternetAddress(from));
            
            message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(to));
            
            // Set Subject
            message.setSubject("Website from: " + email.getFullName());
            
            // Put the content of your message
            message.setText(email.getMessage() + "\n"+ "email: " + email.getEmail());

            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully....");
            status = "sent";
        } catch (MessagingException e) {
            status = "error";
            return new ResponseEntity<String>(status, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>(status, HttpStatus.OK);
    }
}