/*
	Name: Kyle Krattiger
	Class: COMP 182
*/

public class Fraction {
	private char format;                           // Indicates input format of Fraction. i=integer, d=double, f=fraction
	private char numFormat = 'n', denFormat = 'n'; // For use with actual fractions only. For cases like 2.2/7 or 9.736/4.443. n indicates non-use
	private double num/*erator*/, den/*ominator*/; // Everything stored as double, format from above indicates output at the end of processing
	private String input;                          // Location of the cleaned input string
	
	// Default constructor
	public Fraction (String in) {
		this.input = sanitizeInput(in); // Store value before working with it
		
		// Make sure String is not empty, ergo no numeric input
		if (this.input.isEmpty()) {
			System.out.println("ERROR: Input was not recognized!");
			System.exit(1);
		}
		int i = 0;
		while ( i < this.input.length() ) {
			if (isDigit(this.input.charAt(i)))
				continue;
			else
				i++;
		}
		
		this.format = determineFormat(input);
		switch (this.format) {
			case 'i':
				this.num = (double)this.input.toInt(); // Could have used toDouble() here, but this will provide more accurate results
				this.den = 1.0;
				break;
			case 'd':
				this.num = this.input.toDouble();
				this.den = 1.0;
				break;
			case 'f':
				int index = this.input.indexOf('/'); // Location of divisor
				if ( isPresent(this.input,'.') ) {     // Numerator is a double
					this.numFormat = 'd';
					this.num = this.input.substring(0,index-1).toDouble();
				}
				else {                                             // Else, it is an integer
					this.numFormat = 'i';
					this.num = (double)this.input.substring(0,index-1).toInt();
				}
				// Now do the same for denominator
				if ( isPresent(this.input,'.') ) {     // Numerator is a double
					this.denFormat = 'd';
					this.den = this.input.substring(index+1).toDouble();
				}
				else {                                             // Else, it is an integer
					this.denFormat = 'i';
					this.den = (double)this.input.substring(index+1).toInt();
				}
				break;
		}
	}
	
	// Based on string input, determine which format number is stored in
	private char determineFormat(String in) {
		// Check in following order: mixed -> fraction -> decimal -> int
		if ( isPresent(in,'/') )
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
		char allowed[] = { '/', '.', '-' };                 // List of allowed characters
		
		// Get rid of leading/trailing "bad characters"
		int l = rtn.length(); // Needs to be dynamic, as characters will be deleted
		for (int i = 0; i < l; ) {
			if ( (isDigit(rtn.charAt(i))) ) 
				i++;
				continue;
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
	
	// Now for the public methods
	public char getFormat() { return this.format; }
	public double getNum() { return this.den; }
	public double getDen() { return this.den; }
	public char getNumFormat() { return this.numFormat; }
	public char getDenFormat() { return this.denFormat; }
	public String toString() {
		StringBuilder b;
		switch (this.format) {
			case 'i':
				b.append((int)(this.num/this.den));
				break;
			case 'd':
				b.append(this.num/this.den);
				break;
			case 'f':
				
		}
	}
}