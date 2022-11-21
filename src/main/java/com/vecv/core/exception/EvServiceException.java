package com.vecv.core.exception;

/**
 * 
 * Exception class which shall wrap the exceptions.
 * 
 * GafServiceException
 * 
 */
public class EvServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public EvServiceException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public EvServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public EvServiceException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public EvServiceException(Throwable cause) {
		super(cause);
	}

}
