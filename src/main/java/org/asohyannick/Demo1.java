package org.asohyannick;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {
public static void main ( String[] args ) {
	String s1 = "Hello World"; // String literal — uses String Pool
	String s2 = "Hello Yannick"; // Explicit object — goes straight to Heap
	System.out.println ( s1 );
	System.out.println ( s2 );
	String name = "Java";
	name = name + "Programming";
	System.out.println ( name );
	List < String > countries = new ArrayList <> ( );
	for ( int i = 0 ; i < 1_000_000 ; i++ ) {
		countries.add ( "Java" );
	}
	
	StringBuilder stringBuilder = new StringBuilder ( "Hello World" );
	stringBuilder.append ( "Java Programming" );
	stringBuilder.insert ( 5 , "" );
	stringBuilder.replace ( 7 , 12 , "Java" );
	stringBuilder.reverse ( );
	stringBuilder.delete ( 0 , 5 );
	System.out.println ( stringBuilder );
}
}
