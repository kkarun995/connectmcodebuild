package com.vecv.core.exception;

public class EvValidationException extends Exception {
	
	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
	
	private Object validationResponseAssetObject;
	
	public EvValidationException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public EvValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public EvValidationException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public EvValidationException(Throwable cause) {
		super(cause);
	}

	/**
	 * @return the validationResponseAssetObject
	 */
	public Object getValidationResponseAssetObject() {
		return validationResponseAssetObject;
	}

	/**
	 * @param validationResponseAssetObject the validationResponseAssetObject to set
	 */
	public void setValidationResponseAssetObject(Object validationResponseAssetObject) {
		this.validationResponseAssetObject = validationResponseAssetObject;
	}

	

}
