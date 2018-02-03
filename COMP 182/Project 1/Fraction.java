/*
	Name: Kyle Krattiger
	Class: COMP 182
	Part 1: f3afecf
	
	Function: Create a Fraction object
*/

public class Fraction {
	private char format;                           // Indicates input format of Fraction. i=integer, d=double, f=fraction
	private char numFormat = 'i', denFormat = 'i'; // For use with actual fractions only. For cases like 2.2/7 or 9.736/4.443. n indicates non-use
	private double num/*erator*/, den/*ominator*/; // Everything stored as double, format from above indicates output at the end of processing
	private String input;                          // Location of the cleaned input string
	
	// Default constructor
	public Fraction () {
		this.format = 'n';
		this.num = 1.0;
		this.den = 1.0;
		this.input = "NULL";
	}
	
	// 4 constructors, and I use all of 'em...
	public Fraction (String in) {
		this.input = sanitizeInput(in); // Store value before working with it
		
		// Make sure String is not empty, ergo no numeric input
		if (this.input.isEmpty()) {
			System.out.println("ERROR: Input was not recognized!");
			System.exit(1);
		}
		//int i = 0;
		//char c;
		
		/* No idea what this section is supposed to accomplish, and it won't compile. Commenting out.
		while ( i < this.input.length() ) {
			c = this.input.charAt(i);
			if (isDigit(c))
				continue;
			else
				i++;
		}
		*/
		//System.out.println("Input string after sanitize: " + this.input);
		this.format = determineFormat(this.input);
		//System.out.println("Format at this point: " + this.format);
		switch (this.format) {
			case 'i':
				this.num = (double)(Integer.parseInt(this.input)); // Could have used toDouble() here, but this will provide more accurate results
				this.den = 1.0;
				break;
			case 'd':
				this.num = Double.parseDouble(this.input);
				this.numFormat = 'd';
				this.den = 1.0;
				break;
			case 'f':
				//System.out.println("Parsing as a fraction");
				int index = this.input.indexOf("/"); // Location of divisor
				String nums = this.input.substring(0,index), dens = this.input.substring(index+1,this.input.length());
				//System.out.println("Nums: " + nums + ", Dens: " + dens);
				if ( isPresent(nums,'.') ) {     // Numerator is a double
					this.numFormat = 'd';
					this.num = Double.parseDouble(nums);
				}
				else {                                             // Else, it is an integer
					this.numFormat = 'i';
					this.num = (double)(Integer.parseInt(nums));
				}
				// Now do the same for denominator
				if ( isPresent(dens,'.') ) {     // Numerator is a double
					this.denFormat = 'd';
					this.den = Double.parseDouble(dens);
				}
				else {                                             // Else, it is an integer
					this.denFormat = 'i';
					this.den = (double)(Integer.parseInt(dens));
				}
				//System.out.println("Format at this point: " + this.format);
				break;
		}
		reduce();
		//System.out.println(input + " is now: format = " + this.format + " num = " + this.num + ", den = " + this.den);
	}
	
	// Constructor for combining two fractions
	public Fraction (Fraction a, Fraction b) {
		//System.out.println("a: num = " + a.getNum() + ", den = " + a.getDen());
		//System.out.println("b: num = " + b.getNum() + ", den = " + b.getDen());
		this.format = decideFormat(a.getFormat(),b.getFormat());
		if (this.format == 'f') {
			this.numFormat = decideFormat(a.getNumFormat(),b.getNumFormat());
			this.denFormat = decideFormat(a.getDenFormat(),b.getDenFormat());
			if (a.getDen() == b.getDen()) {
				this.den = a.getDen(); // They are equal in this instance, no worries
				this.num = a.getNum() + b.getNum();
			}
			else {
				this.num = (a.getNum() * b.getDen()) + (a.getDen() * b.getNum()); // Cross multiply
				this.den = a.getDen() * b.getDen(); // Reducing fractions will be done later
			}
		}
		else {
			this.num = a.getNum() + b.getNum();
			this.den = 1.0; // Ints and doubles get same treatment here
		}
		this.input = "NULL"; // Gotta set all those variables. This one won't be needed though
		reduce();
	}
	
	// Copies old Fraction to a new one
	public Fraction (Fraction f) {
		this.format = f.getFormat();
		this.numFormat = f.getNumFormat();
		this.denFormat = f.getDenFormat();
		this.num = f.getNum();
		this.den = f.getDen();
		this.input = "NULL";
	}
	
	// Based on string input, determine which format number is stored in
	private char determineFormat(String in) {
		// Check in following order: fraction -> decimal -> int
		if ( isPresent(in,'/') ) {
			return 'f';
		}
		else if ( isPresent(in,'.') )
			return 'd';
		else
			// Assume int. Sanitization would have kept it from getting this far
			//System.out.println("Assuming int...");
			return 'i';
	}
	
	// Returns true if the char is present in the string. Make sure to sanitize input, or this will return false positive!
	private boolean isPresent(String in, char c) {
		for (int i = 0; i < in.length(); i++) {
			if (in.charAt(i) == c) {
				//System.out.println(c + " was found in " + in);
				return true;
			}
		}
		return false;
	}
	
	// Makes sure only characters present are the ones in allowed[]
	private String sanitizeInput(String in) {
		StringBuilder rtn = new StringBuilder(in.trim());   // Create a StringBuilder with the orignal string, minus whitespace
		char allowed[] = { '/', '.', '-' };                 // List of allowed characters
		
		//System.out.println("Sanitizing... Input is " + rtn.toString() + "...");
		// Get rid of leading/trailing "bad characters"
		int l = rtn.length(); // Needs to be dynamic, as characters will be deleted
		for (int i = 0; i < l; ) {
			if ( Character.isDigit(rtn.charAt(i)) ) { // Why couldn't they just use Char? Ugh...
				i++;
				continue;
			}
			
			for (int j = 0; j < allowed.length; j++) {
				if ( rtn.charAt(i) == allowed[j] ) {
					//System.out.println("Found allowed char: " + allowed[j] + " at pos: " + j);
					i++;
					continue;
				}
				if ( j == allowed.length - 1) {
					rtn = rtn.delete(i,i);
					l--; // Otherwise we would get an out of bounds error
				}
			}
		}
		return rtn.toString();
	}
	
	// Returns greatest common factor of numerator and denominator, for reducing factors
	private double getGCF() {
		double a = Math.abs(this.num), b = Math.abs(this.den);
		//System.out.println("Entering GCF while loop");
		while (a != b) {
			if ( a > b ) a -= b;
			else b -= a;
		}
		return a; // Both should be the same value at this point
	}
	
	// Given two formats (char), decide which format new number should be.
	private char decideFormat(char a, char b) {
		if (a == b)
			return a;
		else if ( a == 'd' || b == 'd' )
			return 'd';
		else
			return 'i';
	}
	
	// Reduces the Fraction to the lowest number
	private void reduce() {
		if (/*this.format == 'f' ||*/ this.den == 1.0) {
			this.numFormat = this.format;
		}
		if ( this.den < 0 ) { // Allows proper outputting of negative sign in case of negative denominator
			this.num *= -1.0;
			this.den *= -1.0;
		}
		if (this.format != 'f')
			return; // Leave if not an actual fraction. Creates endless loop otherwise
		double gcf = getGCF();
		this.num /= gcf;
		this.den /= gcf;
	}
	
	// Returns true if both Fractions have the same format
	private boolean isSameFormat(Fraction f) { return this.format == f.getFormat(); }
	private boolean isSameFormat(Fraction a, Fraction b) { return a.getFormat() == b.getFormat(); }
	
	// Now for the public methods
	public char getFormat() { return this.format; }
	public double getNum() { return this.num; }
	public double getDen() { return this.den; }
	public char getNumFormat() { return this.numFormat; }
	public char getDenFormat() { return this.denFormat; }
	public String toString() {
		StringBuilder b = new StringBuilder();
		//b.append( this.format + " " ); // For debugging
		switch (this.format) {
			case 'i':
				b.append((int)(this.num/this.den));
				break;
			case 'd':
				b.append(this.num/this.den);
				break;
			case 'f':
				// Deal with numerator first
				switch (this.numFormat) {
					case 'i':
					case 'n': // Just in case the program messed up, default to integer
						b.append((int)(this.num));
						break;
					case 'd':
						b.append(this.num);
						break;
				}
				
				// Now, for the denominator
				if (this.den != 1.0) { // Don't attach denominator if a fraction
					b.append('/');
					switch (this.denFormat) {
						case 'i':
						case 'n': // Just in case the program messed up, default to integer
							b.append((int)(this.den));
							break;
						case 'd':
							b.append(this.den);
							break;
					}
				}
				break; // Best practice
		}
		return b.toString();
	}
	
	// Returns true if fraction is a fraction AND is improper; false in all other cases
	public boolean isImproper() { return ( this.format == 'f' && this.num >= this.den ); }
	
	// Gets rid of improper fraction, and returns value taken away from fraction
	public double reduceImproperFraction() {
		double value = this.num / this.den;
		this.num -= value * this.den;
		return value;
	}

	// Adds a double value to the numerator, to go with the previous method
	public void addValue(double d) {
		this.num += d;
	}
}