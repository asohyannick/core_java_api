package org.asohyannick;

import java.util.Arrays;

public class Array4 {
public static void main ( String[] args ) {
	int[][][] cube = new int[ 3 ][ 3 ][ 3 ]; // 3 layers of 3x3 grids
	for ( int[][] layer : cube ) {
		for ( int[] row : layer ) {
			System.out.println ( Arrays.toString ( row ) );
		}
		System.out.println ( "---" );
	}
}
}
