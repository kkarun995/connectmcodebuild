package com.vecv.service.util;

import java.security.SecureRandom;

public class GenerateRandomStringUtil {
	private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
	private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
	private static final String NUMBER = "0123456789";

	private GenerateRandomStringUtil() {
	}

	public static String generateRandomString(int length) {
		final String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
		SecureRandom random = new SecureRandom();

		if (length < 1)
			throw new IllegalArgumentException();

		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			// 0-62 (exclusive), random returns 0-61
			int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
			char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);

			sb.append(rndChar);
		}

		return sb.toString();
	}

	public static String generateRandomStringChars(int length) {
		SecureRandom random = new SecureRandom();

		if (length < 1)
			throw new IllegalArgumentException();

		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			int rndCharAt = random.nextInt(CHAR_UPPER.length());
			char rndChar = CHAR_UPPER.charAt(rndCharAt);

			sb.append(rndChar);
		}
		return sb.toString();
	}

	public static String generateRandomStringInteger(int length) {
		SecureRandom random = new SecureRandom();

		if (length < 1)
			throw new IllegalArgumentException();

		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			int rndCharAt = random.nextInt(NUMBER.length());
			char rndChar = NUMBER.charAt(rndCharAt);

			sb.append(rndChar);
		}
		return sb.toString();
	}

}
