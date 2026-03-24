package org.asohyannick;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeAndDateAPIPart5 {
public static void main ( String[] args ) {
	
	ZonedDateTime now = ZonedDateTime.now ( );
	System.out.println ( now );
	
	ZonedDateTime inTokyo = ZonedDateTime.now ( ZoneId.of ( "Asia/Tokyo" ) );
	ZonedDateTime inNewYork = ZonedDateTime.now ( ZoneId.of ( "America/New_York" ) );
	ZonedDateTime inLondon = ZonedDateTime.now ( ZoneId.of ( "Europe/London" ) );
	
	System.out.println ( inTokyo );
	System.out.println ( inNewYork );
	System.out.println ( inLondon );
	
	ZonedDateTime doualaTime = ZonedDateTime.of (
			LocalDateTime.of ( 2024 , 6 , 15 , 10 , 0 ) ,
			ZoneId.of ( "Africa/Douala" )
	);
	
	ZonedDateTime londonTime = doualaTime.withZoneSameInstant ( ZoneId.of ( "Europe/London" ) );
	ZonedDateTime newYorkTime = doualaTime.withZoneSameInstant ( ZoneId.of ( "America/New_York" ) );
	ZonedDateTime tokyoTime = doualaTime.withZoneSameInstant ( ZoneId.of ( "Asia/Tokyo" ) );
	
	System.out.println ( "Douala  : " + doualaTime.toLocalTime ( ) );
	System.out.println ( "London  : " + londonTime.toLocalTime ( ) );
	System.out.println ( "New York: " + newYorkTime.toLocalTime ( ) );
	System.out.println ( "Tokyo   : " + tokyoTime.toLocalTime ( ) );
	
	ZonedDateTime meeting = ZonedDateTime.of (
			LocalDateTime.of ( 2024 , 6 , 15 , 14 , 0 ) ,
			ZoneId.of ( "Africa/Douala" )
	);
	
	printMeetingTime ( meeting , new String[] {
			"Africa/Douala" ,
			"Europe/London" ,
			"America/New_York" ,
			"Asia/Tokyo" ,
			"Australia/Sydney"
	} );
}

public static void printMeetingTime ( ZonedDateTime hostTime , String[] zones ) {
	System.out.println ( "Meeting Time Across Timezones:" );
	System.out.println ( "─────────────────────────────────────" );
	
	for ( String zone : zones ) {
		ZonedDateTime converted = hostTime.withZoneSameInstant ( ZoneId.of ( zone ) );
		System.out.printf ( "%-30s %s%n" ,
				zone ,
				converted.toLocalDateTime ( )
		);
	}
}
}