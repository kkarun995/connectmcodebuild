package com.vecv.core;

public class EvConstants {

	public enum EV_STATUS_CODE {
		SUCCESS("0000"), WARNING("3333"), ERROR("4444"), DANGER("5555");

		private String code;

		EV_STATUS_CODE(String code) {
			this.code = code;
		}

		public String getCode() {
			return this.code;
		}
	}

	public enum EV_STATUS {
		SUCCESS("success"), DANGER("danger"), WARNING("warning"), INFO("info");

		private String status;

		EV_STATUS(String status) {
			this.status = status;
		}

		public String getStatus() {
			return this.status;
		}
	}

	public enum ROLE_TYPE {
		PILOT, SITE_MANAGER
	}

	public enum COGNITO_API_MESSAGE {
		INVALID_PARAMETERS_ERROR_MSG("Invalid parameters"),
		CODE_MISMATCH_ERROR_MSG("Incorrect code. Please try again or request a new code."),
		LINK_EXPIRED_ERROR_MSG("Link has been expired. Please try again"),
		USERNAME_ALREADY_EXIST_ERROR_MSG("Username already exists."), USER_NOT_FOUND("User not found"),
		INVALID_PASSWORD("Invalid password"), INCORRECT_OLD_PASSWORD("Incorrect old password");

		private String message;

		COGNITO_API_MESSAGE(String message) {
			this.message = message;
		}

		public String getMessage() {
			return this.message;
		}
	}

	public enum INVITATION_TYPE {
		CUSTOMER_VERIFICATION, DEVICE_VERIFICATION, FORGOT_PASSWORD
	}

	public enum LOGIN_TYPE {
		WITH_PASSWORD, WITH_OTP
	}

	public enum TRIP_STATUS {
		UPCOMING, ONGOING, COMPLETED
	}

	public enum USER_GENDER {
		MALE("Male"), FEMALE("Female");

		private String gender;

		USER_GENDER(String gender) {
			this.gender = gender;
		}

		public String getGender() {
			return this.gender;
		}
	}

	public enum TEMPLATE_NAME {
//		ADD_CONSUMER_INVITATION_TEMPLATE("KeenHomeCleanComfortSignupInvitationTemplate"),

		ADD_CONSUMER_INVITATION_TEMPLATE("CustomerEmailVerificationTemplate"),
		DELETE_CONSUMER_INVITATION_TEMPLATE("DeleteCustomerTemplate"), CONSUMER_OTP_TEMPLATE("CustomerOtpTemplate"),
		ADD_DEVICE_INVITATION_TEMPLATE("DeviceVerificationTemplate"),
		EXISTING_DEVICE_INVITATION_TEMPLATE("ExistingDeviceVerificationTemplate"),
		OTA_UPDATE_PASS_TEMPLATE("FirmwareUpdatePassTemplate"), OTA_UPDATE_FAIL_TEMPLATE("FirmwareUpdateFailTemplate");

		private String template;

		TEMPLATE_NAME(String template) {
			this.template = template;
		}

		public String getTemplate() {
			return this.template;
		}
	}

	public enum EV_PHONE_TYPE {
		OFFICE("office"), HOME("home"), MOBILE("mobile");

		private String type;

		EV_PHONE_TYPE(String type) {
			this.type = type;
		}

		public String getType() {
			return this.type;
		}
	}

	public enum EV_EMAIL_TYPE {
		PRIMARY("primary"), SECONDARY("secondary"), OFFICE("office");

		private String type;

		EV_EMAIL_TYPE(String type) {
			this.type = type;
		}

		public String getType() {
			return this.type;
		}
	}

	public enum JOB_OTA_STATUS {
		COMMAND_FAILED_TO_RECEIVE("0"), COMMAND_SUCCESSFULLY_RECEIVED("1"), DOWNLOAD_FW_FILE_STARTED("2"),
		DOWNLOAD_FW_FAILED("3"), OTA_STARTED("4"), OTA_IN_PROGRESS("5"), OTA_COMPLETED("6"), OTA_CANCELLED("7"),
		OTA_SCHEDULED("8"), OTA_ABORT("9");

		private String status;

		JOB_OTA_STATUS(String status) {
			this.status = status;
		}

		public String getStatus() {
			return this.status;
		}
	}

}