package com.vecv.model;

import java.util.Date;

public class EvExceptionResponse {
	private Date timestamp;
	private String message;
	private Object details;

	public EvExceptionResponse(Date timestamp, String message, Object details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public Object getDetails() {
		return details;
	}

}