package org.asohyannick;

import java.util.*;

public class Array8 {
public static void main ( String[] args ) {
	List < Integer > withDuplicates = new ArrayList <> (
			Arrays.asList ( 3 , 4 , 1 , 1 , 5 , 5 , 11 , 11 , 10 ) // allow duplicate -> [3, 4, 1, 1, 5, 5, 11, 11, 10]
	);
	System.out.println ( withDuplicates );
	
	// Fastest way to remove duplicates
	
	Set < Integer > uniqueNumbers = new LinkedHashSet <> ( withDuplicates );
	System.out.println ( uniqueNumbers ); // does allow duplicate [3, 4, 1, 5, 11, 10]
}
}
