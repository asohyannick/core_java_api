package org.asohyannick;

import java.util.*;

public class Array11 {
public static void main ( String[] args ) {
	// Array to List
	String[] arrays = { "Alice" , "Bob" , "Charlie" };
	System.out.println ( Arrays.toString ( arrays ) );
	for ( String array : arrays ) {
		System.out.println ( array );
	}
	
	List < String > persons = new ArrayList <> ( Arrays.asList ( arrays ) );
	System.out.println ( persons );
	// List → Set (removes duplicates)
	List < Integer > numbers = Arrays.asList ( 1 , 1 , 2 , 2 , 3 , 3 , 4 , 4 );
	Set < Integer > nums = new HashSet <> ( numbers );
	System.out.println ( nums );
	
	List < String > names = Arrays.asList ( "Alice" , "Alice" , "Charlie" , "Charlie" , "Paul" , "Paul" );
	
	Set < String > myFriends = new LinkedHashSet <> ( names );
	System.out.println ( myFriends );
	
	List < String > newFriends = new ArrayList <> ( myFriends );
	System.out.println ( newFriends );
}
}
