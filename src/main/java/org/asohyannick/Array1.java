package org.asohyannick;

import java.util.Arrays;

public class Array1 {
public static void main ( String[] args ) {
	int[] scores = { 10 , 20 , 25 , 30 };
	String[] persons = { "James" , "Peter" , "John" };
	String[] friends = { "Lobe" , "Marius" , "Our Brother" };
	int[] numbers = new int[ 5 ];
	numbers[ 0 ] = 100;
	numbers[ 1 ] = 200;
	numbers[ 2 ] = 300;
	numbers[ 3 ] = 400;
	numbers[ 4 ] = 500;
	double[] prices = new double[ 3 ];
	prices[ 0 ] = 0.0;
	prices[ 1 ] = 0.0;
	prices[ 2 ] = 0.0;
	boolean[] flags = new boolean[ 3 ];
	flags[ 0 ] = true;
	flags[ 1 ] = true;
	flags[ 2 ] = false;
	String[] names = new String[ 3 ];
	names[ 0 ] = "James";
	names[ 1 ] = "Peter";
	names[ 2 ] = "John";
	System.out.println ( Arrays.toString ( numbers ) );
	System.out.println ( Arrays.toString ( prices ) );
	System.out.println ( Arrays.toString ( flags ) );
	System.out.println ( Arrays.toString ( names ) );
	
	
	System.out.println ( Arrays.toString ( scores ) );
	System.out.println ( Arrays.toString ( persons ) );
	
	System.out.println ( Arrays.toString ( friends ) );
	
	for ( int score : scores ) {
		System.out.println ( score );
	}
	
	for ( String friend : friends ) {
		System.out.println ( friend );
	}
	
	for ( int number : numbers ) {
		System.out.println ( number );
	}
	
	for ( String name : names ) {
		System.out.println ( name );
	}
	
	for ( double price : prices ) {
		System.out.println ( price );
	}
	
	// Method two - Array Literal(declare + initialise together)
	
	int[] grades = { 95 , 87 , 92 , 88 };
	String[] fruits = { "Mango" , "Apples" , "Pineapple" };
	double[] temp = { 1.0 , 0.0 , 36.1 };
	boolean[] answers = { true , false , true , true };
	System.out.println ( Arrays.toString ( grades ) );
	System.out.println ( Arrays.toString ( fruits ) );
	System.out.println ( Arrays.toString ( temp ) );
	System.out.println ( Arrays.toString ( answers ) );
	
	for ( boolean answer : answers ) {
		System.out.println ( answer );
	}
	
	// new keyword with values
	
	int[] assessment = new int[] { 10 , 50 , 60 , 70 , 90 };
	String[] favoriteFruits = new String[] { "Mangoes" , "Pears" , "Bananas" };
	System.out.println ( Arrays.toString ( assessment ) );
	System.out.println ( Arrays.toString ( favoriteFruits ) );
	System.out.println ( assessment[ 0 ] );
	System.out.println ( assessment[ 1 ] );
	System.out.println ( assessment[ 2 ] );
	System.out.println ( assessment[ 3 ] );
	System.out.println ( assessment[ 4 ] );
	System.out.println ( assessment.length );
	assessment[ 2 ] = 500;
	System.out.println ( "New Element:" + Arrays.toString ( assessment ) );
	
	for ( int i = 0 ; i < assessment.length ; i++ ) {
		System.out.println ( "Index:" + i + " Value:" + assessment[ i ] );
	}
	
	for ( int score : scores ) {
		System.out.println ( score );
	}
	
	for ( int i = scores.length - 1 ; i >= 0 ; i-- ) {
		System.out.println ( scores[ i ] );
	}
}
}
