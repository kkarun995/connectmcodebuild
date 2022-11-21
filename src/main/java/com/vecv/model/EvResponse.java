package com.vecv.model;

import com.vecv.core.EvConstants.EV_STATUS;
import com.vecv.core.EvConstants.EV_STATUS_CODE;

public class EvResponse {
	private String statusCode = EV_STATUS_CODE.SUCCESS.getCode();
	private String statusMessage = EV_STATUS.SUCCESS.toString();
	private Object statusInfo = null;
	private Object responseData;
	private Object requestData;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public Object getStatusInfo() {
		return statusInfo;
	}

	public void setStatusInfo(Object statusInfo) {
		this.statusInfo = statusInfo;
	}

	public Object getResponseData() {
		return responseData;
	}

	public void setResponseData(Object responseData) {
		this.responseData = responseData;
	}

	public Object getRequestData() {
		return requestData;
	}

	public void setRequestData(Object requestData) {
		this.requestData = requestData;
	}

}
