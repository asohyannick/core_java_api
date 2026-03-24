package org.asohyannick;

import java.time.LocalTime;

public class TimeAndDateAPIPart2 {
public static void main ( String[] args ) {
	LocalTime now = LocalTime.now ( );
	System.out.println ( now );
	
	// Specific time
	
	LocalTime morning = LocalTime.of ( 8 , 30 );
	LocalTime afternoon = LocalTime.of ( 14 , 30 , 45 );
	LocalTime precise = LocalTime.of ( 10 , 15 , 30 , 500_000_000 );
	
	// Constants
	System.out.println ( LocalTime.MIDNIGHT );
	System.out.println ( LocalTime.NOON );
	System.out.println ( LocalTime.MIN );
	System.out.println ( LocalTime.MAX );
	
	// Parsing
	LocalTime parsed = LocalTime.parse ( "14:30:30" );
	System.out.println ( parsed );
	
	LocalTime time = LocalTime.of ( 14 , 30 , 45 );
	System.out.println ( time.getHour ( ) );
	System.out.println ( time.getMinute ( ) );
	System.out.println ( time.getSecond ( ) );
	System.out.println ( time.getNano ( ) );
	
	// Manipulating
	
	System.out.println ( time.plusHours ( 3 ) );
	System.out.println ( time.plusMinutes ( 45 ) );
	System.out.println ( time.minusHours ( 2 ) );
	System.out.println ( time.withHour ( 9 ) );
	
	// Comparing
	LocalTime t1 = LocalTime.of ( 9 , 0 );
	LocalTime t2 = LocalTime.of ( 17 , 0 );
	System.out.println ( t1.isBefore ( t2 ) );
	System.out.println ( t1.isAfter ( t2 ) );
	
	System.out.println ( isBusinessHours ( LocalTime.of ( 10 , 30 ) ) );
	System.out.println ( isBusinessHours ( LocalTime.of ( 7 , 45 ) ) );
	System.out.println ( isBusinessHours ( LocalTime.of ( 18 , 0 ) ) );
}

public static boolean isBusinessHours ( LocalTime time ) {
	LocalTime open = LocalTime.of ( 8 , 0 );
	LocalTime close = LocalTime.of ( 17 , 0 );
	return !time.isBefore ( open ) && !time.isAfter ( close );
}
}
