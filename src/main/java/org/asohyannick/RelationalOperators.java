package org.asohyannick;

public class RelationalOperators {
public static void main ( String[] args ) {
	int a = 10;
	int b = 20;
	int c = 10;
	
	// ─────────────────────────────────────────
	// STANDARD COMPARISONS
	// ─────────────────────────────────────────
	
	System.out.println ( a == c );  // true  — equal to
	System.out.println ( a == b );  // false
	System.out.println ( a != b );  // true  — not equal to
	System.out.println ( a != c );  // false
	System.out.println ( a < b );   // true  — less than
	System.out.println ( a > b );   // false — greater than
	System.out.println ( a <= c );  // true  — less than or equal
	System.out.println ( a >= c );  // true  — greater than or equal
	
	// For PRIMITIVES — == compares VALUES (correct behavior)
	int x = 100;
	int y = 100;
	System.out.println ( "Primitive == : " + ( x == y ) ); // true — compares values
	
	// For REFERENCE TYPES — == compares MEMORY ADDRESSES (almost always wrong)
	String s1 = "hello";
	String s2 = "hello";
	System.out.println ( "Reference == : " + ( s1 == s2 ) );      // false — different objects!
	System.out.println ( "Reference equals: " + s1.equals ( s2 ) ); // true  — same content
	
	// String pool exception — literals may share the same object
	String literal1 = "hello";
	String literal2 = "hello";
	System.out.println ( "Literal == : " + ( literal1 == literal2 ) ); // true — same pool object
	// BUT: don't rely on this behavior! Always use equals() for Strings
	
	var intVal = 10;
	var valValue = 100;
	var valInput = 100.0D;
	System.out.println ( intVal == valValue );
	System.out.println ( valInput == valValue );
	System.out.println ( valInput == intVal );
	
	// Floating point comparison gotcha
	double result = 0.1 + 0.2;
	System.out.println ( result == 0.3 );        // false! Floating point imprecision
	System.out.println ( java.lang.Math.abs ( result - 0.3 ) < 1e-10 ); // true — correct way
	
	double result2 = 0.1 + 0.2;
	System.out.println ( result2 == 0.3 );
	System.out.println ( java.lang.Math.abs ( result2 - 0.3 ) < 1e-10 );
	
	// ─────────────────────────────────────────
	// CHAINING COMPARISONS — Java vs JavaScript
	// ─────────────────────────────────────────
	
	// In JavaScript you can write: 1 < x < 10 (but it doesn't work as expected)
	// In Java this also doesn't work as you'd expect:
	// 1 < x < 10 — COMPILATION ERROR in Java (can't compare boolean < int)
	
	// The CORRECT way in Java — use logical AND
	
	int age = 25;
	boolean newAge = ( age > 18 && age <= 65 );
	System.out.println ( "You're an adult who is qualify to work: " + newAge );
	
	// ─────────────────────────────────────────
	// REAL BACKEND USE CASES
	// ─────────────────────────────────────────
	
	// HTTP status code checking
	
	var statusCode = 404;
	
	boolean isSuccess = ( statusCode >= 200 && statusCode <= 300 );
	boolean reDirect = ( statusCode >= 300 && statusCode <= 400 );
	boolean isClientError = ( statusCode >= 400 && statusCode <= 500 );
	boolean isServerError = ( statusCode >= 500 && statusCode <= 600 );
	System.out.println ( isSuccess );
	System.out.println ( reDirect );
	System.out.println ( isClientError );
	System.out.println ( isServerError );
	
	var page = 1;
	var pageSize = 20;
	
	var maxPageSize = 100;
	
	boolean isValidPage = ( page >= 1 );
	boolean isValidPageSize = ( pageSize >= 1 && pageSize >= maxPageSize );
	if ( !isValidPage || !isValidPageSize ) {
		System.out.println ( "400 Bad Request — invalid pagination params" );
	} else {
		int offset = ( page - 1 ) * pageSize;
		System.out.println ( "Fetching " + pageSize + " records starting at offset " + offset );
	}
	
	// Password validation
	var password = "SecurePassword123!!!";
	boolean hasMinPassword = password.length ( ) >= 8;
	boolean hasMaxPassword = password.length ( ) >= 128;
	boolean isValidPassword = hasMinPassword && hasMaxPassword;
	System.out.println ( "Valid password length: " + isValidPassword );
	
}
}
