package org.asohyannick;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeAndDateAPIPart7 {
public static void main ( String[] args ) {
	
	Duration fiveSeconds = Duration.ofSeconds ( 5 );
	Duration twoHours = Duration.ofHours ( 2 );
	Duration tenMinutes = Duration.ofMinutes ( 10 );
	Duration threeMillis = Duration.ofMillis ( 300 );
	Duration halfDay = Duration.ofHours ( 12 );
	
	// Parsing ISO-8601 duration format
	Duration parsed = Duration.parse ( "PT5H30M" );
	System.out.println ( parsed );
	
	// Between two time points
	LocalTime start = LocalTime.of ( 9 , 0 );
	LocalTime end = LocalTime.of ( 17 , 30 );
	Duration workDay = Duration.between ( start , end );
	System.out.println ( workDay.toHours ( ) );
	System.out.println ( workDay.toMinutes ( ) );
	System.out.println ( workDay.toSeconds ( ) );
	LocalDateTime departure = LocalDateTime.of ( 2024 , 6 , 15 , 8 , 0 );
	LocalDateTime arrival = LocalDateTime.of ( 2024 , 6 , 15 , 14 , 35 );
	Duration flightTime = Duration.between ( departure , arrival );
	System.out.println ( "Flight time: " + flightTime.toHours ( ) + "h "
			                     + ( flightTime.toMinutesPart ( ) ) + "m" ); // 6h 35m
	Duration d1 = Duration.ofHours ( 3 );
	Duration d2 = Duration.ofMinutes ( 90 );
	
	System.out.println ( d1.plus ( d2 ) );       // PT4H30M
	System.out.println ( d1.minus ( d2 ) );      // PT1H30M
	System.out.println ( d1.multipliedBy ( 2 ) );// PT6H
	System.out.println ( d1.dividedBy ( 2 ) );   // PT1H30M
	System.out.println ( d1.negated ( ) );      // PT-3H
	System.out.println ( d1.isNegative ( ) );   // false
	System.out.println ( d1.isZero ( ) );       // false
	
	// Extracting parts (Java 9+)
	Duration complex = Duration.ofHours ( 25 ).plusMinutes ( 35 ).plusSeconds ( 45 );
	System.out.println ( complex.toDaysPart ( ) );    // 1
	System.out.println ( complex.toHoursPart ( ) );   // 1
	System.out.println ( complex.toMinutesPart ( ) ); // 35
	System.out.println ( complex.toSecondsPart ( ) ); // 45
}
}
