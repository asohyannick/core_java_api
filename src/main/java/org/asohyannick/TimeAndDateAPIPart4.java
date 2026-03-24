package org.asohyannick;

import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * ZonedDateTime, ZoneId, ZoneOffset
 * PART 4 — ZoneId — Timezone Identifier
 * ZoneId represents a timezone by name. This is the modern replacement for java.util.TimeZone:
 */
public class TimeAndDateAPIPart4 {
public static void main ( String[] args ) {
	ZoneId systemZone = ZoneId.systemDefault ( );
	System.out.println ( systemZone ); // e.g Africa/Douala
	
	// Create specific timezone by name
	ZoneId douala = ZoneId.of ( "Africa/Douala" );
	ZoneId london = ZoneId.of ( "Europe/London" );
	ZoneId newYork = ZoneId.of ( "America/New_York" );
	ZoneId tokyo = ZoneId.of ( "Asia/Tokyo" );
	ZoneId utc = ZoneId.of ( "UTC" );
	
	System.out.println ( douala );
	System.out.println ( london );
	System.out.println ( newYork );
	System.out.println ( tokyo );
	System.out.println ( utc );
	
	ZoneId.getAvailableZoneIds ( ).stream ( ).sorted ( ).limit ( 10 ).forEach ( System.out::println );
	
	ZoneOffset utc1 = ZoneOffset.UTC; // +00:00
	ZoneOffset plus1 = ZoneOffset.of ( "+01:00" );  // Africa/Douala offset
	ZoneOffset minus5 = ZoneOffset.of ( "-05:00" );  // Eastern US offset
	ZoneOffset plus5_30 = ZoneOffset.of ( "+05:30" );  // India offset
	
	System.out.println ( utc1 );      // Z
	System.out.println ( plus1 );    // +01:00
	System.out.println ( minus5 );   // -05:00
	System.out.println ( plus5_30 ); // +05:30
	
}
}
