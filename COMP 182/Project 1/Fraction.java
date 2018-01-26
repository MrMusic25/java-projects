/*
	Name: Kyle Krattiger
	Class: COMP 182
*/

public class Fraction {
	private char format;                           // Indicates input format of Fraction. i=integer, d=double, f=fraction, m=mixed fraction
	private double num/*erator*/, den/*ominator*/; // Everything stored as double, format from above indicates output at the end of processing
	private String input;                          // Location of the cleaned input string
	
	// Default constructor
	public Fraction (String in) {
		input = sanitizeInput(in); // Store value before working with it
		
		// Make sure String is not empty, ergo no numeric input
		if (input.isEmpty()) {
			System.out.println("ERROR: Input was not recognized!");
			System.exit(1);
		}
		int i = 0;
		while ( i < input.length() ) {
			if (isDigit(input.charAt(i)))
				continue;
			else
				i++;
		}
		
		format = determineFormat(input);
	}
	
	// Based on string input, determine which format number is stored in
	private char determineFormat(String in) {
		// Check in following order: mixed -> fraction -> decimal -> int
		if (( isPresent(in,' ') )
			return 'm';
		else if ( isPresent(in,'/') )
			return 'f';
		else if ( isPresent(in,'.') )
			return 'd';
		else
			// Assume int. Sanitization would have kept it from getting this far
			return 'i';
	}
	
	// Returns true if the char is present in the string. Make sure to sanitize input, or this will return false positive!
	private boolean isPresent(String in, char c) {
		for (int i = 0; i < in.length(); i++) 
			if (in.charAt(i) == c) return true;
		return false;
	}
	
	// Makes sure only characters present are the ones in allowed[]
	private String sanitizeInput(String in) {
		StringBuilder rtn = new StringBuilder(in.trim());   // Create a StringBuilder with the orignal string, minus whitespace
		char allowed[] = { '/', '\\', '.', ' ' };           // List of allowed characters
		
		// Get rid of leading/trailing "bad characters"
		int l = rtn.length(); // Needs to be dynamic, as characters will be deleted
		for (int i = 0; i < l; ) {
			if ( (isDigit(rtn.charAt(i))) ) 
				i++; // Continue
			for (int j = 0; j < allowed.length; j++) {
				if ( rtn.charAt(i) == allowed[j] ) {
					i++;
					continue;
				}
				if ( j == allowed.length - 1) {
					rtn.delete(i);
					l--; // Otherwise we would get an out of bounds error
				}
			}
		}
		return rtn.toString();
	}
}