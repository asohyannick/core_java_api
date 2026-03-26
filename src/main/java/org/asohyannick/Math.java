package org.asohyannick;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Math {
public static void main ( String[] args ) {
	java.lang.Math.sqrt ( 16 );
	System.out.println ( java.lang.Math.PI );
	System.out.println ( java.lang.Math.E );
	System.out.println ( java.lang.Math.abs ( -42 ) );
	System.out.println ( java.lang.Math.abs ( 0 ) );
	
	// double version
	System.out.println ( java.lang.Math.abs ( -3.14 ) ); //  3.14
	System.out.println ( java.lang.Math.abs ( 3.14 ) );  //  3.14
	
	// long version
	System.out.println ( java.lang.Math.abs ( -9_999_999_999L ) ); // 9999999999
	System.out.println ( java.lang.Math.pow ( 2 , 10 ) );  // 1024.0  — 2¹⁰
	System.out.println ( java.lang.Math.pow ( 3 , 3 ) );   // 27.0    — 3³ (cube)
	System.out.println ( java.lang.Math.pow ( 5 , 2 ) );   // 25.0    — 5² (square)
	System.out.println ( java.lang.Math.pow ( 16 , 0.5 ) );// 4.0     — square root (same as sqrt)
	System.out.println ( java.lang.Math.pow ( 27 , 1.0 / 3 ) ); // 3.0  — cube root
	System.out.println ( java.lang.Math.pow ( 2 , -3 ) );  // 0.125   — negative exponent = fraction
	System.out.println ( java.lang.Math.pow ( 7 , 0 ) );   // 1.0     — anything to power 0 = 1
	System.out.println ( java.lang.Math.pow ( 0 , 0 ) );   // 1.0     — special case in Java
	
	System.out.println ( java.lang.Math.sqrt ( 16 ) );   // 4.0
	System.out.println ( java.lang.Math.sqrt ( 25 ) );   // 5.0
	System.out.println ( java.lang.Math.sqrt ( 2 ) );    // 1.4142135623730951
	System.out.println ( java.lang.Math.sqrt ( 0 ) );    // 0.0
	System.out.println ( java.lang.Math.sqrt ( -1 ) );   // NaN — negative has no real square root
	System.out.println ( java.lang.Math.sqrt ( 144 ) );  // 12.0
	
	// Always returns double — cast if needed
	int root = ( int ) java.lang.Math.sqrt ( 49 );
	System.out.println ( root ); // 7
	
	// Math.min()
	System.out.println ( java.lang.Math.min ( 10 , 20 ) );     // 10
	System.out.println ( java.lang.Math.min ( -5 , -10 ) );    // -10
	System.out.println ( java.lang.Math.min ( 3.14 , 2.71 ) ); // 2.71
	System.out.println ( java.lang.Math.min ( 5 , 5 ) );       // 5  — equal values
	
	// Math.max()
	System.out.println ( java.lang.Math.max ( 10 , 20 ) );     // 20
	System.out.println ( java.lang.Math.max ( -5 , -10 ) );    // -5
	System.out.println ( java.lang.Math.max ( 3.14 , 2.71 ) ); // 3.14
	
	
	System.out.println ( clamp ( 150 , 0 , 100 ) );  // 100 — above max, clamped to max
	System.out.println ( clamp ( -50 , 0 , 100 ) );  //   0 — below min, clamped to min
	System.out.println ( clamp ( 75 , 0 , 100 ) );  //  75 — within range, unchanged
	int userAge = -5;  // invalid input
	int safeAge = java.lang.Math.max ( 0 , userAge );  // 0 — never goes negative
	System.out.println ( safeAge ); // 0
	
	// Use Case 2 — finding the highest score in an array
	int[] scores = { 85 , 92 , 78 , 96 , 88 };
	int highest = scores[ 0 ];
	for ( int score : scores ) {
		highest = java.lang.Math.max ( highest , score );
	}
	System.out.println ( "Highest: " + highest ); // 96
	
	// Use Case 3 — finding the lowest score in an array
	int lowest = scores[ 0 ];
	for ( int score : scores ) {
		lowest = java.lang.Math.min ( lowest , score );
	}
	System.out.println ( "Lowest: " + lowest ); // 78
	
	// Use Case 4 — responsive layout calculation
	int screenWidth = 1200;
	int maxContentWidth = 960;
	int contentWidth = java.lang.Math.min ( screenWidth , maxContentWidth );
	System.out.println ( "Content width: " + contentWidth ); // 960
	
	System.out.println ( java.lang.Math.random ( ) ); // e.g. 0.7234891023
	System.out.println ( java.lang.Math.random ( ) ); // e.g. 0.1823749302
	System.out.println ( java.lang.Math.random ( ) ); // e.g. 0.9912038471
	
	// Random int 0-9
	int zeroToNine = ( int ) ( java.lang.Math.random ( ) * 10 );

// Random int 1-10
	int oneToTen = ( int ) ( java.lang.Math.random ( ) * 10 ) + 1;

// Random int 1-6 (dice roll)
	int dice = ( int ) ( java.lang.Math.random ( ) * 6 ) + 1;
	System.out.println ( "Dice: " + dice ); // 1, 2, 3, 4, 5, or 6

// Random int between any min and max
	int min = 50, max = 100;
	int randomInRange = ( int ) ( java.lang.Math.random ( ) * ( max - min + 1 ) ) + min;
	System.out.println ( randomInRange ); // 50 to 100 inclusive
	
	List < String > names = Arrays.asList ( "Bob" , null , "Alice" , "Charlie" );
	
	List < String > validNames = names.stream ( ).filter ( Objects::nonNull ).collect ( Collectors.toList ( ) );
	System.out.println ( validNames );
	
}

// Clamp a value between a minimum and maximum bound
public static int clamp ( int value , int min , int max ) {
	return java.lang.Math.max ( min , java.lang.Math.min ( value , max ) );
}
}
