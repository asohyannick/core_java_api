package org.asohyannick;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

private static final DateTimeFormatter DISPLAY_DATE =
		DateTimeFormatter.ofPattern ( "dd MMM yyyy" );

private static final DateTimeFormatter DISPLAY_DATETIME =
		DateTimeFormatter.ofPattern ( "dd MMM yyyy, HH:mm" );

private static final DateTimeFormatter DB_FORMAT =
		DateTimeFormatter.ofPattern ( "yyyy-MM-dd HH:mm:ss" );

private static final DateTimeFormatter API_FORMAT =
		DateTimeFormatter.ISO_LOCAL_DATE_TIME;

public static String toDisplayDate ( LocalDate date ) {
	return date.format ( DISPLAY_DATE );
}

public static String toDisplayDateTime ( LocalDateTime dt ) {
	return dt.format ( DISPLAY_DATETIME );
}

public static String toDbFormat ( LocalDateTime dt ) {
	return dt.format ( DB_FORMAT );
}

public static String toApiFormat ( LocalDateTime dt ) {
	return dt.format ( API_FORMAT );
}

public static LocalDate parseDisplayDate ( String dateStr ) {
	return LocalDate.parse ( dateStr , DISPLAY_DATE );
}
}