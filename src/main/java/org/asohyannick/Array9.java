package org.asohyannick;

import java.util.HashMap;
import java.util.Map;

public class Array9 {
public static void main ( String[] args ) {
	/**
	 The Map interface stores key-value pairs. Keys must be unique but values can be duplicated
	 */
	
	Map < Integer, String > persons = new HashMap <> ( );
	persons.put ( 0 , "John Smith" );
	persons.put ( 1 , "John Smith" );
	persons.put ( 2 , "John Paul" );
	persons.put ( 3 , "Jane Mary" );
	persons.put ( 4 , "Jane Peace" );
	persons.put ( 5 , "Jane Coder" );
	persons.put ( 0 , "Peter Java" );
	System.out.println ( persons );
	
	// ── Reading ───────────────────────────────────────────────────
	System.out.println ( persons.get ( 0 ) );
	System.out.println ( persons.get ( 1 ) );
	System.out.println ( persons.get ( 2 ) );
	System.out.println ( persons.get ( "Unknown" ) );
	System.out.println ( persons.getOrDefault ( "Unknown" , "Keeper of Peace" ) );
	
	// ── Checking ──────────────────────────────────────────────────
	
	System.out.println ( persons.containsKey ( 0 ) );
	System.out.println ( persons.containsValue ( "Jane Mary" ) );
	System.out.println ( persons.size ( ) );
	
	// ── Removing ──────────────────────────────────────────────────
	
	persons.remove ( 0 );
	System.out.println ( persons );
	
	// ── Iterating ─────────────────────────────────────────────────
	
	// Iterate keys only
	
	for ( Integer key : persons.keySet ( ) ) {
		System.out.println ( "Key: " + key );
	}
	
	// Iterate values only
	for ( String value : persons.values ( ) ) {
		System.out.println ( "Value: " + value );
	}
	
	// Iterate both key and value — most useful
	for ( Map.Entry < Integer, String > entry : persons.entrySet ( ) ) {
		System.out.println ( entry.getKey ( ) + ": " + entry.getValue ( ) );
	}
}
}
