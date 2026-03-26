package org.asohyannick;

import java.util.Arrays;

public class Array2 {
public static void main ( String[] args ) {
	int[] numbers = { 5 , 8 , 10 , 12 , 25 };
	int[] scores = new int[ 5 ];
	scores[ 0 ] = 5;
	scores[ 1 ] = 8;
	scores[ 2 ] = 10;
	scores[ 3 ] = 12;
	scores[ 4 ] = 25;
	String[] names = new String[] { "A" , "B" , "C" , "D" };
	
	// ── Sorting ──────────────────────────────────────────────────
	Arrays.sort ( numbers );
	System.out.println ( Arrays.toString ( numbers ) );
	
	// ── Searching (array MUST be sorted first) ───────────────────
	int index = Arrays.binarySearch ( numbers , 8 );
	System.out.println ( index );
	
	// ── Filling ──────────────────────────────────────────────────
	int[] filled = new int[ 5 ];
	Arrays.fill ( filled , 7 );
	System.out.println ( Arrays.toString ( filled ) );
	
	// ── Comparing ────────────────────────────────────────────────
	
	int[] a = { 1 , 2 , 3 };
	int[] b = { 1 , 2 , 3 };
	System.out.println ( a == b ); // false ❌ compares addresses
	System.out.println ( Arrays.equals ( a , b ) );  // true  ✅ compares content
	
	// ── Printing ─────────────────────────────────────────────────
	
	System.out.println ( numbers ); // [I@6b884d57 ❌ useless
	System.out.println ( Arrays.toString ( numbers ) ); // [1, 2, 3, 5, 8, 9] ✅
	
	// ── Copying ──────────────────────────────────────────────────
	
	int[] copy = Arrays.copyOf ( numbers , numbers.length );
	int[] part = Arrays.copyOfRange ( numbers , 1 , 4 );
	System.out.println ( Arrays.toString ( part ) );
	
	// cloning arrays
	
	int[] alias = numbers;
	
	alias[ 0 ] = 99;
	System.out.println ( numbers[ 0 ] );
	
	int[] original = { 10 , 25 , 40 , 100 };
	int[] cloned = original.clone ( );
	
	cloned[ 0 ] = 200;
	System.out.println ( original[ 0 ] );
	System.out.println ( cloned[ 0 ] );
	
	String[][] grid = { { "A" , "B" } , { "C" , "D" } };
	String[][] copied = grid.clone ( );
	
	copied[ 0 ][ 0 ] = "z";
	System.out.println ( grid[ 0 ][ 0 ] );
	
	String[][] deepCopy = new String[ grid.length ][];
	
	for ( int i = 0 ; i < grid.length ; i++ ) {
		deepCopy[ i ] = grid[ i ].clone ( );
	}
	
	deepCopy[ 0 ][ 0 ] = "z";
	System.out.println ( grid[ 0 ][ 0 ] );
	
	int[][] matrix = new int[ 3 ][ 4 ];
	
	int[][] grid1 = {
			{ 1 , 2 , 3 } ,
			{ 4 , 5 , 6 } ,
			{ 7 , 8 , 9 } ,
			{ 10 , 17 , 20 }
	};
	
	System.out.println ( grid1[ 0 ][ 0 ] );
	System.out.println ( grid1[ 1 ][ 2 ] );
	System.out.println ( grid1[ 2 ][ 2 ] );
	System.out.println ( grid1[ 2 ][ 2 ] );
}
}
