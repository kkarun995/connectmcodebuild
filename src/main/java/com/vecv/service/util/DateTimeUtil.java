package com.vecv.service.util;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateTimeUtil {
	private static final DateTimeFormatter customDateTimeFormatter = DateTimeFormatter
			.ofPattern("E MMM dd HH:mm:ss z yyyy");
	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	private static final SimpleDateFormat DAY_FORMAT = new SimpleDateFormat("EEEE");

	private DateTimeUtil() {
	}

	public static LocalDateTime parseTextWithDefaultDateTimeFormat(String text) {
		return LocalDateTime.parse(text, dateTimeFormatter);
	}

	public static String parseText(Date dt, String pattern) {
		String status = "";
		try {
			if (dt != null) {
				final SimpleDateFormat format = new SimpleDateFormat(pattern);
				status = format.format(dt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

//	public static String parseText(LocalDateTime ldt, String pattern) {
//		final DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
//		return format.format(ldt);
//	}

	public static long getDifferenceBetweenTwoDatesInHours(LocalDateTime fromTime, LocalDateTime toTime) {
		Date fromDate = Date.from(fromTime.atZone(ZoneId.systemDefault()).toInstant());
		Date toDate = Date.from(toTime.atZone(ZoneId.systemDefault()).toInstant());
		return (toDate.getTime() - fromDate.getTime()) / (60 * 60 * 1000);
	}

	public static long getDifferenceBetweenTwoDatesInMins(LocalDateTime fromTime, LocalDateTime toTime) {
		Date fromDate = Date.from(fromTime.atZone(ZoneId.systemDefault()).toInstant());
		Date toDate = Date.from(toTime.atZone(ZoneId.systemDefault()).toInstant());
		return (toDate.getTime() - fromDate.getTime()) / (60 * 1000);
	}

	public static long getDifferenceBetweenTwoDatesInHours(Date fromDate, Date toDate) {
		return (toDate.getTime() - fromDate.getTime()) / (60 * 60 * 1000);
	}

	public static long getDifferenceBetweenTwoDatesInMins(Date fromDate, Date toDate) {
		return (toDate.getTime() - fromDate.getTime()) / (60 * 1000);
	}

	public static long getDifferenceBetweenTwoDatesInSeconds(Date fromDate, Date toDate) {
		return (toDate.getTime() - fromDate.getTime()) / (1000);
	}

	public static String formatElapsedTime(long seconds) {

		long hours = TimeUnit.SECONDS.toHours(seconds);
		seconds -= TimeUnit.HOURS.toSeconds(hours);

		long minutes = TimeUnit.SECONDS.toMinutes(seconds);
		seconds -= TimeUnit.MINUTES.toSeconds(minutes);

		return String.format("%dHrs, %dMin", hours, minutes, seconds);
	}

	public static String formatElapsedTimeInHoursMinuteSeconds(long seconds) {

		long hours = TimeUnit.SECONDS.toHours(seconds);
		seconds -= TimeUnit.HOURS.toSeconds(hours);

		long minutes = TimeUnit.SECONDS.toMinutes(seconds);
		seconds -= TimeUnit.MINUTES.toSeconds(minutes);

		return String.format("%d:%d:%d Hrs", hours, minutes, seconds);
	}

	public static String getCurrentDayName() {
		// displaying full-day name
		return DAY_FORMAT.format(new Date());
	}

	public static String parseText(LocalDateTime localDateTime, String pattern) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
		return localDateTime.format(dateTimeFormatter);
	}

	public static String getCheckInDuration(Date checkedInTime, Date checkedoutTime) {
		String duration = null;
		try {
			if (checkedInTime == null)
				return "";
			if (checkedoutTime == null)
				checkedoutTime = new Date();

			long durationInMillis = DateTimeUtil.getDifferenceBetweenTwoDatesInSeconds(checkedInTime, checkedoutTime);

			duration = formatElapsedTimeInHoursAndMins(durationInMillis);
			System.out.println("String formattedText : " + duration);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return duration;
	}

	public static String formatElapsedTimeInHoursAndMins(long seconds) {

		long hours = TimeUnit.SECONDS.toHours(seconds);
		seconds -= TimeUnit.HOURS.toSeconds(hours);

		long minutes = TimeUnit.SECONDS.toMinutes(seconds);
		seconds -= TimeUnit.MINUTES.toSeconds(minutes);

//		return String.format("%dhr:%dmin:%dsec", hours, minutes, seconds);
		return String.format("%d Hr %d Min", hours, minutes);
	}

	public static String formatDate(LocalDateTime dateTime, String pattern) {
		String formatText = "";
		try {
			if (dateTime != null) {
				formatText = dateTime.format(DateTimeFormatter.ofPattern(pattern));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formatText;
	}

	public static LocalDateTime parseTextWithTodayDate(String dateTime) {
		LocalDateTime formattedDateTime = null;
		try {
			if (dateTime != null && !dateTime.isEmpty()) {
				formattedDateTime = LocalDateTime.of(LocalDate.now(),
						parseTextWithDefaultDateTimeFormat(dateTime).toLocalTime());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return formattedDateTime;
	}

	public static LocalDateTime parseTextWithTodayDate(Time time) {
		LocalDateTime formattedDateTime = null;
		try {
			if (time != null) {
//				formattedDateTime = LocalDateTime.of(LocalDate.now(),
//						parseTextWithDefaultDateTimeFormat(time).toLocalTime());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return formattedDateTime;
	}

	public static String getCurrentTimeInISTTimezone() {
		final ZonedDateTime currentTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));

		String formattedTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(currentTime);

		System.out.println("currentTime: " + currentTime + " formattedTime: " + formattedTime);
		return formattedTime;
	}

	public static Date getCurrentDateInISTTimezone() {
		return Date.from(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).toInstant());
	}

//	public static void main(String[] args) {
//		getCurrentTimeInISTTimezone();
//
//		System.out.println(Date.from(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).toInstant()));
//	}

}
