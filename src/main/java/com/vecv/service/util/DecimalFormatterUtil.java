package com.vecv.service.util;

import java.text.DecimalFormat;

public class DecimalFormatterUtil {
	private static final DecimalFormat decimalFormat = new DecimalFormat("#.##");

	private DecimalFormatterUtil() {
	}
	
	public static String format(double value) {
		return decimalFormat.format(value);
	}
}
