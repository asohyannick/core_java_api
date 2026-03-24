package org.asohyannick;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Array5 {
public static void main ( String[] args ) {
	// ── Adding ────────────────────────────────────────────────────
	List < String > fruits = new ArrayList <> ( );
	fruits.add ( "Apples" );
	fruits.add ( "Pears" );
	fruits.add ( "Oranges" );
	fruits.add ( "Peach" );
	fruits.add ( "Strawberry" );
	fruits.add ( 1 , "Watermelon" );  // inserts at index 1
	System.out.println ( fruits );
	for ( String fruit : fruits ) {
		System.out.println ( "Fruit : " + fruit );
	}
	System.out.println ( fruits.get ( 0 ) );
	System.out.println ( fruits.size ( ) ); // 6 <- size(), Not length
	System.out.println ( fruits.isEmpty ( ) ); // false
	System.out.println ( fruits.contains ( "Pears" ) );
	
	// ── Modifying ─────────────────────────────────────────────────
	
	fruits.set ( 2 , "Bananas" );
	System.out.println ( fruits );
	
	// ── Removing ──────────────────────────────────────────────────
	
	fruits.remove ( "Bananas" ); // remove by value
	fruits.remove ( 0 ); // remove by index
	System.out.println ( fruits ); // [Grape, Orange]
	
	// ── Iterating ─────────────────────────────────────────────────
	
	for ( String fruit : fruits ) {
		System.out.println ( fruit );
	}
	
	// ── Searching ─────────────────────────────────────────────────
	
	System.out.println ( fruits.indexOf ( "Pears" ) ); // 1
	
	// ── Sorting ───────────────────────────────────────────────────
	
	Collections.sort ( fruits );
	System.out.println ( fruits ); // [Oranges, Peach, Strawberry, Watermelon] — sorting alphabetically
	
	// ArrayList — backed by an array
	// ✅ Fast random access:  get(index) → O(1)
	// ❌ Slow insert/delete in middle → O(n) (shifts elements)
	List < String > arrayList = new ArrayList <> ( );
	
	// LinkedList — backed by doubly linked nodes
	// ❌ Slow random access: get(index) → O(n) (traverses nodes)
	// ✅ Fast insert/delete at ends → O(1)
	
	List < String > linkedList = new LinkedList <> ( );
	// Use ArrayList for most cases
	// Use LinkedList only when you frequently add/remove from the frontend
}
}
