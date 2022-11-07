package com.mipresupuesto.personalbudget.crosscutting.Utils;

import com.sendgrid.Content;
import com.sendgrid.Email;

public final class SendGridHelper {
	
	public static final String STRING_EMAIL_DEFAULT = "zebaxthian08@hotmail.com";
	
	public static final Email EMAIL_FROM_DEFAULT = new Email(STRING_EMAIL_DEFAULT);
	
	private SendGridHelper() {
		super();
	}
	
	public static Email getEmailFromString(String email) {
		return new Email(email);
	}
	
	public static Content getContent(String type, String value) {
		return new Content(type, value);
	}
	

}
