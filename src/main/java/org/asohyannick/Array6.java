package org.asohyannick;

import java.util.HashSet;
import java.util.Set;

public class Array6 {
public static void main ( String[] args ) {
	// There are three main type of set interface in Java mainly;
	/**
	 1.HashSet  -> insertion order doesn't matter here
	 2.LinkedHashSet -> insertion order matters here and doesn't allow duplicates
	 3.TreeSet
	 
	 */
	Set < String > countries = new HashSet <> ( );
	// ── Adding ────────────────────────────────────────────────────
	countries.add ( "Cameroon" );
	countries.add ( "Nigeria" );
	countries.add ( "Ghana" );
	countries.add ( "Cameroon" ); // duplicate -> silently ignored!
	System.out.println ( countries.size ( ) ); // 3 <- not 4
	System.out.println ( countries ); // [Cameroon, Ghana, Nigeria] -> order not guarantee
	
	// ── Checking ──────────────────────────────────────────────────
	
	System.out.println ( countries.contains ( "Cameroon" ) ); // true
	System.out.println ( countries.contains ( "Kenya" ) ); // false
	
	// ── Removing ──────────────────────────────────────────────────
	
	countries.remove ( "Cameroon" );
	System.out.println ( countries ); // [Ghana, Nigeria]
	
	// ── Iterating ─────────────────────────────────────────────────
	for ( String country : countries ) {
		System.out.println ( country ); // order not guaranteed
	}
	
	// HashSet — no order guarantee, fastest O(1)
	Set < String > fruits = new HashSet <> ( );
	fruits.add ( "Mangoes" );
	fruits.add ( "Apples" );
	fruits.add ( "Bananas" );
	fruits.add ( "Oranges" );   // [Apples, Bananas, Mangoes, Oranges] — random order
	System.out.println ( fruits );
	
}
}
