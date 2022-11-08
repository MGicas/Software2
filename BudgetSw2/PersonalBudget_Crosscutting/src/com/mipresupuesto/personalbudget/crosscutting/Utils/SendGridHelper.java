package com.mipresupuesto.personalbudget.crosscutting.Utils;

import com.sendgrid.Content;
import com.sendgrid.Email;

public class SendGridHelper {
	
	public static final String EMAIL_STRING_DEFAULT = "zebaxthian08@hotmail.com";
	
	public static final Email EMAIL_DEFAULT = new Email(EMAIL_STRING_DEFAULT);
	
	
	public static Email getEmailFromString(String email) {
		return new Email(email);
	}
	
	public static String getStringFromEmail(Email e) {
		return e.toString();
	}
	
	public static Content getContent(String type, String value) {
		return new Content(type, value);
	}

}
