package com.sendemailapi.model;

public class EmailModel {

	private String to;
	private String cc;
	private String subject;
	private String messagebody;
	
	public EmailModel(String to, String cc, String subject, String messagebody) {
		super();
		this.to = to;
		this.cc = cc;
		this.subject = subject;
		this.messagebody = messagebody;
	}

	public EmailModel() {
		super();
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessagebody() {
		return messagebody;
	}

	public void setMessagebody(String messagebody) {
		this.messagebody = messagebody;
	}

	@Override
	public String toString() {
		return "EmailModel [to=" + to + ", cc=" + cc + ", subject=" + subject + ", messagebody=" + messagebody + "]";
	}
	
}
