package org.asohyannick;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class TimeAndDateAPIPart8 {
public static void main ( String[] args ) {
	Period oneYear = Period.ofYears ( 1 );
	Period sixMonths = Period.ofMonths ( 6 );
	Period tenDays = Period.ofDays ( 10 );
	Period oneYearSix = Period.of ( 1 , 6 , 0 ); // 1 year, 6 months, 0 days
	
	// Parsing ISO-8601 period format
	Period parsed = Period.parse ( "P1Y2M3D" ); // 1 year, 2 months, 3 days
	System.out.println ( parsed ); // P1Y2M3D
	
	// Between two dates — the most common use
	LocalDate start = LocalDate.of ( 1995 , 8 , 15 );
	LocalDate end = LocalDate.now ( );
	Period age = Period.between ( start , end );
	
	System.out.println ( "Age: " + age.getYears ( ) + " years, "
			                     + age.getMonths ( ) + " months, "
			                     + age.getDays ( ) + " days" );
// Age: 30 years, 7 months, 9 days
	
	Period p1 = Period.of ( 2 , 3 , 10 );  // 2 years, 3 months, 10 days
	
	System.out.println ( p1.getYears ( ) );   // 2
	System.out.println ( p1.getMonths ( ) );  // 3
	System.out.println ( p1.getDays ( ) );    // 10

// Adding period to a date
	LocalDate date = LocalDate.of ( 2024 , 1 , 15 );
	System.out.println ( date.plus ( Period.ofMonths ( 3 ) ) );  // 2024-04-15
	System.out.println ( date.plus ( Period.ofYears ( 1 ) ) );   // 2025-01-15
	
	Period subscription = Period.ofMonths ( 6 );
	LocalDate subscriptionStart = LocalDate.now ( );
	LocalDate subscriptionEnd = subscriptionStart.plus ( subscription );
	System.out.println ( "Expires: " + subscriptionEnd );
	
	// Duration — for time differences (hours, minutes, seconds)
	LocalTime clockIn = LocalTime.of ( 9 , 0 );
	LocalTime clockOut = LocalTime.of ( 17 , 30 );
	Duration worked = Duration.between ( clockIn , clockOut );
	System.out.println ( "Hours worked: " + worked.toHours ( ) ); // 8

// Period — for date differences (years, months, days)
	LocalDate hired = LocalDate.of ( 2018 , 4 , 10 );
	LocalDate today = LocalDate.now ( );
	Period tenure = Period.between ( hired , today );
	System.out.println ( "Tenure: " + tenure.getYears ( ) + " years "
			                     + tenure.getMonths ( ) + " months" );
}
}
