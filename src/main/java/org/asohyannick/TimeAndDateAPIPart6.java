package org.asohyannick;

import java.lang.Math;
import java.time.*;
import java.util.Arrays;

/**
 * Instant — Machine Timestamp
 * Instant represents a single point on the global timeline — expressed as the number of seconds and nanoseconds since
 * the Unix epoch (January 1, 1970, 00:00:00 UTC).
 * This is the machine's view of time — no timezone, no human-readable date structure, just a precise point in time.
 */

public class TimeAndDateAPIPart6 {
public static void main ( String[] args ) {
	// Current moment in UTC
	Instant now = Instant.now ( );
	System.out.println ( now ); // 2026-03-24T12:54:03.585335800Z
	
	// From epoch seconds
	Instant fromEpoch = Instant.ofEpochSecond ( 0 );
	System.out.println ( fromEpoch ); // 1970-01-01T00:00:00Z
	
	Instant specificTime = Instant.ofEpochSecond ( 1_000_000_000L );
	System.out.println ( specificTime ); // 2001-09-09T01:46:40Z
	
	// From epoch milliseconds (common in JavaScript interop)
	
	Instant fromMillis = Instant.ofEpochMilli ( 1_700_000_000L );
	System.out.println ( specificTime ); // 2001-09-09T01:46:40Z
	
	Instant instant = Instant.now ( );
	System.out.println ( instant.getEpochSecond ( ) ); // seconds since epoch
	System.out.println ( instant.toEpochMilli ( ) );   // milliseconds since epoch
	System.out.println ( instant.getNano ( ) );         // nanosecond adjustment
	
	Instant start = Instant.now ( );
	
	Instant end = Instant.now ( );
	
	// Duration between two instants
	Duration duration = Duration.between ( start , end );
	System.out.println ( "Elapsed: " + duration.toMillis ( ) + "ms" );
	
	// Adding and subtracting
	Instant future = Instant.now ( ).plusSeconds ( 3600 );
	Instant past = Instant.now ( ).minusSeconds ( 86400 );
	System.out.println ( start.isBefore ( end ) );
	System.out.println ( start.isAfter ( end ) );
	
	Instant instant1 = Instant.now ( );
	ZonedDateTime zdt = instant1.atZone ( ZoneId.of ( "Africa/Douala" ) );
	System.out.println ( zdt ); // 2026-03-24T14:07:43.664704500+01:00[Africa/Douala]
	
	// ZonedDateTime → Instant (strip timezone for machine storage)
	ZonedDateTime meeting = ZonedDateTime.of (
			LocalDateTime.of ( 2024 , 6 , 15 , 14 , 0 ) ,
			ZoneId.of ( "Africa/Douala" )
	);
	
	Instant meetingInstant = meeting.toInstant ( );
	System.out.println ( meetingInstant );
	
	benchmark ( "Array sort 100k" , ( ) -> {
		int[] arr = new int[ 100_000 ];
		for ( int i = 0 ; i < arr.length ; i++ ) arr[ i ] = ( int ) ( Math.random ( ) * 1000 );
		Arrays.sort ( arr );
	} );
	
}

public static < T > void benchmark ( String taskName , Runnable task ) {
	Instant start = Instant.now ( );
	task.run ( );
	Instant end = Instant.now ( );
	
	long ms = Duration.between ( start , end ).toMillis ( );
	System.out.printf ( "%-20s completed in %dms%n" , taskName , ms );
}
}
