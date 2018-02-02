/*
	Name: Kyle Krattiger
	Class: COMP 182
*/
import java.util.*;

public class Test {
	public static void main (String args[]) {
		// Input strings
		String input1, input2;
		Scanner input = new Scanner(System.in);
		System.out.printf("Enter the first number and press [Enter]: ");
		input1 = input.nextLine();
		input1 = input1.trim();
		Fraction a, b, c;
		
		if (processString(input1) == 'm') {
			// Mixed fraction
			int x = input1.indexOf(' '); // Stores index of the space
			a = { new Fraction(input1.substring(0,x)), new Fraction(input1.substring(x)) };
		}
		else {
			a = new Fraction(input1);
		}
		
		// Repeat the process for second input
		System.out.printf("Enter the second number and press [Enter]: ");
		input2 = input.nextLine();
		input2 = input2.trim();
		
		if (processString(input2) == 'm') {
			// Mixed fraction
			int x = input2.indexOf(' '); // Stores index of the space
			b = { new Fraction(input2.substring(0,x)), new Fraction(input2.substring(x)) };
		}
		else {
			b = new Fraction(input2);
		}
		
		// Now, add the two fractions together
		// Cases tested in order: M+M, M+F, F+M; All others are easy
		if ( isArray(a) && isArray(b) ) {
			c = { new Fraction(a[0],b[0]), new Fraction(a[1],b[1]) }; // M+M
		}
		else if ( a.isArray() && ( !b.isArray() && b.getFormat() == 'f' ) ) { // M+F
			c = { a[0], new Fraction(a[1],b) };
		}
		else if ( b.isArray() && ( !a.isArray() && a.getFormat() == 'f' ) ) { // F+M
			c = { b[0], new Fraction(b[1],a) };
		}
		else {
			c = new Fraction(a,b);
		}
		
		if (c.isArray() && c[1].isImproper()) {
			double d = c[1].reduceImproperFraction();
			c[0].addValue(d);
		}
		
		StringBuilder s = new StringBuilder(); // Never had to use this many 'new' statements in C++...
		if ( c.isArray() ) 
			s.append(c[0].toString() + " " + c[1].toString());
		else
			s.append(c.toString());
		System.out.println(s.toString());
		System.exit(0); // Success!
	}
	
	// Returns type of value found in string
	// Same as Fraction, but m = mixed fraction, which will require an array
	public static char processString(String s) {
		// Order to check: m(ixed) -> f(raction) -> d(ouble) -> i(nteger)
		if (isPresent(s,' ') && (isPresent(s,'/') || isPresent(s,'\\')))
			return 'm';
		else if (isPresent(s,'/') || isPresent(s,'\\'))
			return 'f';
		else if (isPresent(s,'.'))
			return 'd';
		else
			return 'i';
	}
	
	// Copied from Fraction class because it suited my purposes
	public static boolean isPresent(String in, char c) { 
		for (int i = 0; i < in.length(); i++) 
			if (in.charAt(i) == c) return true;
		return false;
	}
	
	public static boolean isArray(Fraction f) {
		Class cls = f.getClass();
		boolean arr = cls.isArray();
		return arr;
	}
}