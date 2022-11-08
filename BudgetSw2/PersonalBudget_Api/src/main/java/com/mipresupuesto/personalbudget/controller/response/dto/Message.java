package com.mipresupuesto.personalbudget.controller.response.dto;

import com.mipresupuesto.personalbudget.controller.response.enumeration.MessageLevel;

public final class Message {
	
	private String text;
	private String title;
	private MessageLevel level;
	
	public Message(final String text, final String title, final MessageLevel level) {
		setText(text);
		setTitle (title);
		setLevel(level);
	}
	
	public static Message createMessage(final String text, final String title, final MessageLevel level) {
		return new Message(text, title, level);
	}
	
	public static Message createMessage(final String text, final MessageLevel level) {
		return new Message(text,text,level);
	}
	
	public static Message createFatalMessage(final String text) {
		return new Message(text,text,MessageLevel.FATAL);
	}

	public static Message createErrorMessage(final String text) {
		return new Message(text,text,MessageLevel.ERROR);
	}
	
	public static Message createWarningMessage(final String text) {
		return new Message(text,text,MessageLevel.WARNING);
	}
	
	public static Message createInformationMessage(final String text) {
		return new Message(text,text,MessageLevel.INFORMATION);
	}
	
	public static Message createSuccessMessage(final String text) {
		return new Message(text,text,MessageLevel.SUCCESS);
	}
	
	private final void setText(final String text) {
		if(text == null || " ".intern() == text.intern().trim()) {
			this.text = "";
		}else {
			this.text = text.trim();
		}
	}



	private final void setTitle(final String title) {
		if(title == null || " ".intern() == title.intern().trim()) {
			this.title = "";
		}else {
			this.title = title.trim();
		}
	}



	private final void setLevel(final MessageLevel level) {
		if(level == null ) {
			this.level = MessageLevel.FATAL;
		}else {
			this.level = level;
		}
	}



	public final String getText() {
		if(text == null || " ".intern() == text.intern().trim()) {
			this.text = "";
		}
		return text;
	}

	public final String getTitle() {
		if(title == null || " ".intern() == title.intern().trim()) {
			this.title = "";
		}
		return title;
	}

	public final MessageLevel getLevel() {
		if(level == null ) {
			this.level = MessageLevel.FATAL;
		}
		return level;
	}
	
	

}
