package org.asohyannick;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * LocalDateTime — Date AND Time, No Timezone
 * LocalDateTime combines LocalDate and LocalTime into one object. No timezone.
 * Perfect for logging events, scheduling, and timestamps where timezone context is not needed.
 */
public class TimeAndDateAPIPart3 {
public static void main ( String[] args ) {
	// Current date and time
	LocalDateTime now = LocalDateTime.now ( );
	System.out.println ( now ); // 2026-03-24T14:35:22.123
	
	// Specific date and time
	LocalDateTime dt1 = LocalDateTime.of ( 2024 , 3 , 15 , 14 , 30 , 0 );
	LocalDateTime dt2 = LocalDateTime.of ( 2024 , Month.JUNE , 20 , 9 , 0 );
	
	System.out.println ( dt1 );
	System.out.println ( dt2 );
	
	// Combining LocalDate and LocalTime
	LocalDate date = LocalDate.of ( 2024 , 3 , 15 );
	LocalTime time = LocalTime.of ( 14 , 30 );
	LocalDateTime combined = LocalDateTime.of ( date , time );
	System.out.println ( combined );
	
	LocalDateTime dt = LocalDateTime.of ( 2024 , 3 , 15 , 14 , 30 , 45 );
	System.out.println ( dt.getYear ( ) );        // 2024
	System.out.println ( dt.getMonth ( ) );       // MARCH
	System.out.println ( dt.getDayOfMonth ( ) );  // 15
	System.out.println ( dt.getHour ( ) );        // 14
	System.out.println ( dt.getMinute ( ) );      // 30
	System.out.println ( dt.getSecond ( ) );      // 45
	
	// Extracting parts
	LocalDate datePart = dt.toLocalDate ( ); // 2024-03-15
	LocalTime timePart = dt.toLocalTime ( ); // 14:30:45
	
	// Manipulating
	System.out.println ( dt.plusDays ( 5 ) );         // 2024-03-20T14:30:45
	System.out.println ( dt.plusHours ( 3 ) );        // 2024-03-15T17:30:45
	System.out.println ( dt.minusMonths ( 1 ) );      // 2024-02-15T14:30:45
	System.out.println ( dt.withYear ( 2025 ) );      // 2025-03-15T14:30:45
	System.out.println ( dt.withHour ( 9 ) );         // 2024-03-15T09:30:45
	
}
}
