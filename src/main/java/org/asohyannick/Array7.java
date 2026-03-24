package org.asohyannick;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Array7 {
public static void main ( String[] args ) {
	// LinkedHashSet — maintains INSERTION order
	Set < String > fruits = new LinkedHashSet <> ( );
	fruits.add ( "Mangoes" );
	fruits.add ( "Apples" );
	fruits.add ( "Bananas" );
	fruits.add ( "Oranges" );
	System.out.println ( fruits ); // [Mangoes, Apples, Bananas, Oranges] ✅ insertion order
	
	// TreeSet — maintains SORTED order
	Set < String > favoriteFruits = new TreeSet <> ( );
	favoriteFruits.add ( "Apples" );
	favoriteFruits.add ( "Bananas" );
	favoriteFruits.add ( "Oranges" );
	System.out.println ( favoriteFruits ); // [Apples, Bananas, Oranges] ✅ sorted
}
}
