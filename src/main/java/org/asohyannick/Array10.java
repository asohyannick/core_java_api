package org.asohyannick;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Array10 {
/**
 * There are three main implementation of the hashMap mainly;
 * 1. HashMap
 * 2.LinkedHashMap
 * 3.Treemap
 */
public static void main ( String[] args ) {
	// HashMap — no order, fastest O(1)
	Map < Integer, String > countries = new HashMap <> ( );
	countries.put ( 0 , "USA" );
	countries.put ( 1 , "France" );
	countries.put ( 2 , "USA" );
	countries.put ( 3 , "France" );
	countries.put ( 4 , "USA" );
	countries.put ( 5 , "Britain" );
	System.out.println ( countries );
	
	// LinkedHashMap -> maintain insertion order
	Map < Integer, String > persons = new LinkedHashMap <> ( );
	persons.put ( 3 , "Francisca" );
	persons.put ( 0 , "Peter" );
	persons.put ( 1 , "Mary" );
	persons.put ( 2 , "James" );
	System.out.println ( persons );
	
	// TreeMap — maintains sorted key order
	Map < Integer, String > fruits = new TreeMap <> ( );
	fruits.put ( 0 , "Banana" );
	fruits.put ( 0 , "Apple" );
	fruits.put ( 1 , "Melon" );
	fruits.put ( 1 , "Pineapple" );
	fruits.put ( 2 , "Pears" );
	fruits.put ( 2 , "Strawberry" );
	System.out.println ( fruits );
	
	String sentence = "the cat sat on the mat the cat";
	
	String[] words = sentence.split ( " " );
	
	Map < String, Integer > frequency = new HashMap <> ( );
	for ( String word : words ) {
		frequency.put ( word , frequency.getOrDefault ( word , 0 ) + 1 );
	}
	System.out.println ( frequency );
	
	
}
}
