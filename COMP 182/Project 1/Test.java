/*
	Name: Kyle Krattiger
	Class: COMP 182
*/
import java.util.*;

public class Test {
	public static void main (String args[]) {
		// Input strings
		String input1, input2;
		Fraction a, b, c, d, e, f; // Hopefully no one will see this during an interview... I swear I've improved my habits since writing this! I was very tired that night!
		StringBuilder s = new StringBuilder(); // Will contain the output
		char i1 = 'n', i2 = 'n'; // Lets program know whether to use array or normal var
		Scanner input = new Scanner(System.in);
		System.out.printf("Enter the first number and press [Enter]: ");
		input1 = input.nextLine();
		input1 = input1.trim();
		
		if (processString(input1) == 'm') {
			// Mixed fraction
			int x = input1.indexOf(' '); // Stores index of the space
			a = new Fraction(input1.substring(0,x));
			b = new Fraction(input1.substring(x));
			i1 = 'm';
		}
		else {
			a = new Fraction(input1);
			b = new Fraction();
		}
		
		// Repeat the process for second input
		input = new Scanner(System.in);
		System.out.printf("Enter the second number and press [Enter]: ");
		input2 = input.nextLine();
		input2 = input2.trim();
		
		if (processString(input2) == 'm') {
			// Mixed fraction
			int y = input1.indexOf(' '); // Stores index of the space
			c = new Fraction(input2.substring(0,y));
			d = new Fraction(input2.substring(y));
			i2 = 'm';
		}
		else {
			c = new Fraction(input2);
			d = new Fraction();
		}
		
		// Test order: M+M, M+F, F+M, {everything else}
		if ( i1 == 'm' && i2 == 'm') {
			e = new Fraction(a,c);
			f = new Fraction(b,d);
			if (f.isImproper())
				e.addValue(f.reduceImproperFraction());
			s.append(e.toString() + " " + f.toString());
		}
		else if ( i1 == 'm' && i2 == 'f') {
			e = new Fraction(a); 
			f = new Fraction(b,c);
			if (f.isImproper())
				e.addValue(f.reduceImproperFraction());
			s.append(e.toString() + " " + f.toString());
		}
		else if ( i1 == 'f' && i2 == 'm') {
			e = new Fraction(c); 
			f = new Fraction(a,d);
			if (f.isImproper())
				e.addValue(f.reduceImproperFraction());
			s.append(e.toString() + " " + f.toString());
		}
		else {
			e = new Fraction(a,c);
			s.append(e.toString());
		}
		
		System.out.println(s.toString());
		System.exit(0);
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