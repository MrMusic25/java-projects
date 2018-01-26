/*
	Name: Kyle Krattiger
	Class: COMP 182
*/

public class Fraction {
	char format;                           // Indicates input format of Fraction. i=integer, d=double, f=fraction, m=mixed fraction
	double num/*erator*/, den/*ominator*/; // Everything stored as double, format from above indicates output at the end of processing
	String orig;                           // Store the location of the original input, in case it is needed again
	
	// Default constructor
	Fraction (String in) {
		orig = in; // Store value before working with it
		format = determineFormat(in);
	}
	
	// Based on string input, determine which format number is stored in
	char determineFormat(String in) {
		
	}
}