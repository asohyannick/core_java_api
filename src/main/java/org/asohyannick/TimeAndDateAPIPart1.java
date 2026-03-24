package org.asohyannick;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class TimeAndDateAPIPart1 {
public static void main ( String[] args ) {
	// Current date from system clock
	LocalDate today = LocalDate.now ( );
	System.out.println ( today );
	// Specific date — of(year, month, day)
	
	LocalDate birthday = LocalDate.of ( 1997 , 8 , 25 );
	LocalDate christmas = LocalDate.of ( 2024 , Month.AUGUST , 25 );
	LocalDate newYear = LocalDate.of ( 2025 , 1 , 1 );
	System.out.println ( "My birthday is on  the day:" + birthday );
	System.out.println ( "The people of the world celebrate X-Mas on the : " + christmas );
	System.out.println ( "THE NEW Year season this year fell on the :" + newYear );
	
	// Parsing from String — must match ISO format yyyy-MM-dd by default
	
	LocalDate parsed = LocalDate.parse ( "2026-03-24" );
	System.out.println ( parsed );
	
	LocalDate date1 = LocalDate.ofYearDay ( 2026 , 10 ); // 100th day of 2024
	System.out.println ( date1 ); // 2024-04-09
	
	LocalDate date = LocalDate.of ( 2026 , 3 , 24 );
	System.out.println ( date.getYear ( ) );
	System.out.println ( date.getMonth ( ) );
	System.out.println ( date.getMonthValue ( ) );
	System.out.println ( date.getDayOfMonth ( ) );
	System.out.println ( date.getDayOfYear ( ) );
	System.out.println ( date.lengthOfMonth ( ) );
	System.out.println ( date.lengthOfYear ( ) );
	System.out.println ( date.isLeapYear ( ) );
	
	// Adding
	System.out.println ( date.plusDays ( 10 ) );
	System.out.println ( date.plusWeeks ( 4 ) );
	System.out.println ( date.plusMonths ( 3 ) );
	System.out.println ( date.plusYears ( 1 ) );
	
	// Subtracting
	System.out.println ( date.minusDays ( 5 ) );    // 2024-03-10
	System.out.println ( date.minusMonths ( 1 ) );  // 2024-02-15
	System.out.println ( date.minusYears ( 2 ) );   // 2022-03-15
	
	// Adjusting specific fields
	System.out.println ( date.withDayOfMonth ( 1 ) );  // 2024-03-01 — first of month
	System.out.println ( date.withMonth ( 12 ) );      // 2024-12-15
	System.out.println ( date.withYear ( 2000 ) );     // 2000-03-15
	
	
	// Comparing LocalDates:
	LocalDate date2 = LocalDate.of ( 2024 , 1 , 15 );
	LocalDate date3 = LocalDate.of ( 2024 , 6 , 20 );
	
	System.out.println ( date2.isBefore ( date3 ) ); // true
	System.out.println ( date2.isAfter ( date3 ) ); // false
	System.out.println ( date2.isEqual ( date3 ) ); // false
	System.out.println ( date2.compareTo ( date3 ) ); // negative
	
	LocalDate toDay = LocalDate.now ( );
	System.out.println ( toDay.isEqual ( LocalDate.now ( ) ) );
	
	LocalDate dob = LocalDate.of ( 1995 , 8 , 15 );
	System.out.println ( "Age: " + calculateAge ( dob ) );
}

public static int calculateAge ( LocalDate birthDate ) {
	LocalDate today = LocalDate.now ( );
	return today.getYear ( ) - birthDate.getYear ( ) - ( today.getDayOfYear ( ) < birthDate.getDayOfYear ( ) ? 1 : 0 );
}

public static int calculateAgePrecise ( LocalDate birthDate ) {
	return Period.between ( birthDate , LocalDate.now ( ) ).getYears ( );
}
}
