package com.synergisticit.service;

// Importing required classes
import jakarta.mail.Multipart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import jakarta.mail.internet.MimeBodyPart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.synergisticit.domain.Policy;
import com.synergisticit.domain.Request;

@Service
public class EmailService {

	@Autowired private JavaMailSender javaMailSender;
	@Autowired private InvoiceService invoiceService;


	@Async
	public void sendBookingConfirmationEmail(Policy policy, Request request)
	{

		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			
			byte[] invoiceByte = invoiceService.generateInvoice(policy, request);
			MimeBodyPart part = new MimeBodyPart();
			part.setContent(invoiceByte, "application/pdf");
			part.setFileName("AutoInsuranceInvoice.pdf");
			
			MimeBodyPart textPart = new MimeBodyPart();
			textPart.setContent(this.getEmailBody(policy, request), "text/html;charset=UTF-8"); //set content type to HTML
			
			helper.setTo(request.getEmail());
			helper.setSubject("Time to Celebrate: Your Autoinsurance Payment Is Successful!");
			
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(part);
			multipart.addBodyPart(textPart);
			
			message.setContent(multipart);
			javaMailSender.send(message);
		} catch (Exception e) {
			System.err.println("Email sending exception: " + e.getMessage());
		}
	}


	private String getEmailBody(Policy policy, Request request) {
		StringBuilder guestTable = new StringBuilder();
		
		String htmlTemplate = """
				<!DOCTYPE html>
				<html>
				<head>
					<title>Hotel Confirmation</title>
				</head>
				<body>
				
				<div class="container">
					<h1>Your Payment for %s is Confirmed!</h1>
					<h3>Your Payment Invoice is also attached below. Please check it out.</h3>
					<p>Insurance Policy ID: # %s</p>
					<p>Insurance Start Date: %s</p>
					<p>Insurance End Date: %s</p>
					<p>Insurance Type: %s</p>
					<p>Insurance Final Price: $ %s USD</p>
					<p>Status: Succeeded</p>
					<hr/>
					<h3>Attention:</h3>
					<h4>Please use this <a href="http://localhost:8282/upload">link</a> to upload all the required documents for the next step.</h4>
				</div>
				</body>
				</html>
				""".formatted(
						request.getProductName(),
						policy.getPolicyId(),
						request.getStartDate(),
						request.getEndDate(),
						request.getType(),
						request.getAmount()
						);
		
		return htmlTemplate;
	}

	
}
