package org.asohyannick;

import java.util.Arrays;

public class Array3 {
public static void main ( String[] args ) {
	int[][] grids = {
			{ 1 , 2 , 3 } ,
			{ 4 , 5 , 6 } ,
			{ 7 , 8 , 9 }
	};
	
	// Nested for loop
	for ( int row = 0 ; row < grids.length ; row++ ) {
		for ( int col = 0 ; col < grids[ row ].length ; col++ ) {
			System.out.printf ( "%3d " , grids[ row ][ col ] );
		}
		System.out.println ( );
	}
	
	// Enhanced for loop
	
	for ( int[] row : grids ) {
		for ( int val : row ) {
			System.out.printf ( "%3d" , val );
		}
		System.out.println ( );
	}
	
	System.out.println ( Arrays.deepToString ( grids ) );
	
	int[][] jagged = new int[ 3 ][];
	
	jagged[ 0 ] = new int[] { 1 };
	jagged[ 1 ] = new int[] { 2 , 3 };
	jagged[ 2 ] = new int[] { 4 , 5 , 6 };
	for ( int[] row : jagged ) {
		System.out.println ( Arrays.toString ( row ) );
	}
}
}
