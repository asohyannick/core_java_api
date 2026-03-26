package org.asohyannick;

import java.util.Scanner;

public class InputExample {

public static void main ( String[] args ) {
	Scanner scanner = new Scanner ( System.in );
	
	System.out.println ( "Enter your name" );
	String name = scanner.nextLine ( );
	
	System.out.println ( "Enter your age: " );
	int age = scanner.nextInt ( );
	
	System.out.println ( "Enter your GPA: " );
	double gpa = scanner.nextDouble ( );
	
	System.out.printf ( "Hello %s! Age: %d, GPA: %.2f%n" , name , age , gpa );
	scanner.close ( );
}
}
