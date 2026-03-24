package org.asohyannick;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class TimeAndDateAPIPart9 {
public static void main ( String[] args ) {
	LocalDateTime dt = LocalDateTime.of ( 2024 , 3 , 15 , 14 , 30 , 45 );
	// ISO standard formatters (built-in)
	System.out.println ( dt.format ( DateTimeFormatter.ISO_LOCAL_DATE ) );
	System.out.println ( dt.format ( DateTimeFormatter.ISO_LOCAL_DATE_TIME ) );
	System.out.println ( dt.format ( DateTimeFormatter.ISO_ORDINAL_DATE ) );
	System.out.println ( dt.format ( DateTimeFormatter.ISO_TIME ) );
	
	LocalDate date = LocalDate.of ( 2024 , 3 , 15 );
	System.out.println ( date.format ( DateTimeFormatter.ISO_DATE ) );           // 2024-03-15
	System.out.println ( date.format ( DateTimeFormatter.BASIC_ISO_DATE ) );
	
	DateTimeFormatter f1 = DateTimeFormatter.ofPattern ( "dd/MM/yyyy" );
	DateTimeFormatter f2 = DateTimeFormatter.ofPattern ( "MM-dd-yyyy" );
	DateTimeFormatter f3 = DateTimeFormatter.ofPattern ( "dd MMM yyyy" );
	DateTimeFormatter f4 = DateTimeFormatter.ofPattern ( "EEEE, dd MMMM yyyy" );
	DateTimeFormatter f5 = DateTimeFormatter.ofPattern ( "dd/MM/yyyy HH:mm:ss" );
	DateTimeFormatter f6 = DateTimeFormatter.ofPattern ( "yyyy-MM-dd hh:mm a" );
	
	System.out.println ( dt.format ( f1 ) ); // 15/03/2024
	System.out.println ( dt.format ( f2 ) ); // 03-15-2024
	System.out.println ( dt.format ( f3 ) ); // 15 Mar 2024
	System.out.println ( dt.format ( f4 ) ); // Friday, 15 March 2024
	System.out.println ( dt.format ( f5 ) ); // 15/03/2024 14:30:45
	System.out.println ( dt.format ( f6 ) ); // 2024-03-15 02:30 PM
	
	// Parsing with default ISO format
	LocalDate d1 = LocalDate.parse ( "2024-03-15" );
	LocalTime t1 = LocalTime.parse ( "14:30:00" );
	LocalDateTime dt1 = LocalDateTime.parse ( "2024-03-15T14:30:00" );

// Parsing with custom format
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern ( "dd/MM/yyyy" );
	LocalDate d2 = LocalDate.parse ( "15/03/2024" , fmt );
	System.out.println ( d2 ); // 2024-03-15
	
	DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern ( "dd MMM yyyy HH:mm" );
	LocalDateTime dt2 = LocalDateTime.parse ( "15 Mar 2024 14:30" , fmt2 );
	System.out.println ( dt2 ); // 2024-03-15T14:30


// Format for different locales
	DateTimeFormatter french = DateTimeFormatter.ofLocalizedDate ( FormatStyle.FULL )
			                           .withLocale ( Locale.FRENCH );
	DateTimeFormatter english = DateTimeFormatter.ofLocalizedDate ( FormatStyle.FULL )
			                            .withLocale ( Locale.ENGLISH );
	DateTimeFormatter german = DateTimeFormatter.ofLocalizedDate ( FormatStyle.FULL )
			                           .withLocale ( Locale.GERMAN );
	
	System.out.println ( dt.format ( french ) );  // vendredi 15 mars 2024
	System.out.println ( dt.format ( english ) ); // Friday, March 15, 2024
	System.out.println ( dt.format ( german ) );  // Freitag, 15. März 2024
	
	LocalDateTime now = LocalDateTime.now ( );
	
	System.out.println ( DateUtils.toDisplayDate ( now.toLocalDate ( ) ) );
	System.out.println ( DateUtils.toDisplayDateTime ( now ) );
	System.out.println ( DateUtils.toDbFormat ( now ) );
	System.out.println ( DateUtils.toApiFormat ( now ) );
}
}
