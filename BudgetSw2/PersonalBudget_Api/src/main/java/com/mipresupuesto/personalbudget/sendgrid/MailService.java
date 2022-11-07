package com.mipresupuesto.personalbudget.sendgrid;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

@Service
public class MailService {
	
	private static final Logger logger = LoggerFactory.getLogger(MailService.class);
	
	public String sendTextEmail(final Email from, final String subject, final Email to,  final Content content) throws IOException {
		// the sender email should be the same as we used to Create a Single Sender Verification
		    //Email from = new Email("add the sender email");
		    //String subject = "The subject";
		    //Email to = new Email("reciver");
		    //Content content = new Content("text/plain", "This is a test email");
		    Mail mail = new Mail(from, subject, to, content);
		    
		    //${spring.sendgrid.api-key}
		    SendGrid sg = new SendGrid("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");
		    Request request = new Request();
		    try {
		      request.setMethod(Method.POST);
		      request.setEndpoint("mail/send");
		      request.setBody(mail.build());
		      Response response = sg.api(request);
		      logger.info(response.getBody());
		      return response.getBody();	     
		    } catch (IOException ex) {
		      throw ex;
		    }	   
	}
}
