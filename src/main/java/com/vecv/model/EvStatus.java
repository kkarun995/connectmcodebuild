package com.vecv.model;

public class EvStatus {

	private EvStatus() {
	}

	/**
	 * @param successResponse
	 * @return success status and code
	 */
	public static final EvResponse setSuccessStatusReponse(EvResponse successResponse, String message) {
		successResponse.setStatusCode("0000");
		successResponse.setStatusMessage("SUCCESS");
		successResponse.setStatusInfo(message);
		return successResponse;
	}

	/**
	 * @param warningResponse
	 * @return warning status and code
	 */
	public static final EvResponse setWarningStatusReponse(EvResponse warningResponse, String message) {
		warningResponse.setStatusCode("3333");
		warningResponse.setStatusMessage("WARNING");
		warningResponse.setStatusInfo(message);
		return warningResponse;
	}

	/**
	 * @param errorResponse
	 * @return error status and code
	 */
	public static final EvResponse setErrorStatusReponse(EvResponse errorResponse, String message) {
		errorResponse.setStatusCode("4444");
		errorResponse.setStatusMessage("ERROR");
		errorResponse.setStatusInfo(message);
		return errorResponse;
	}

	/**
	 * @param dangerResponse
	 * @return danger status and code
	 */
	public static final EvResponse setDangerStatusReponse(EvResponse dangerResponse, String message) {
		dangerResponse.setStatusCode("5555");
		dangerResponse.setStatusMessage("DANGER");
		dangerResponse.setStatusInfo(message);
		return dangerResponse;
	}

}
