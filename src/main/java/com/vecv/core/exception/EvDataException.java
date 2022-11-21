package com.vecv.core.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Exception class which shall wrap the exceptions.
 * 
 * ConnectMRestException
 * 
 */
public class EvDataException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	private List<String> errorObjects = new ArrayList<>();;

	public EvDataException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public EvDataException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public EvDataException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public EvDataException(Throwable cause) {
		super(cause);
	}

	/**
	 * @return the errorObject
	 */
	public List<String> getErrorObjects() {
		return errorObjects;
	}

	/**
	 * @param errorObject
	 *            the errorObject to set
	 */
	public void setErrorObjects(List<String> errorObjects) {
		this.errorObjects = errorObjects;
	}

}
