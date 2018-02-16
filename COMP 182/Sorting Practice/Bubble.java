/* 
   Name: Kyle Krattiger
   
   Function: A class that utilizes the bubble sort algorithm
*/
public class Bubble extends ArraySort {
	/*                *
	 *  Constructors  *
	 *                */
	public Bubble() {
		this.name = "Bubble Sort";
		this.input = "";
		this.arr = new Integer[]{0,1,2}; // Default constructor won't be used much, just assign it to an int
	}
	
	public Bubble(String s) {
		this.name = "Bubble Sort";
		this.input = s;
		sanitizeInput();
	}
	
	public Bubble(Object[] o) {
		this.name = "Bubble Sort";
		this.input = "";
		this.arr = o;
	}
	
	/*                              *
	 *  Completed abstract methods  *
	 *                              */
	public String toString() {
		
	}
	
	public void sortIncr() {
		
	}
	
	public void sortDecr() {
		
	}
	
	/*                      *
	 *  Additional methods  *
	 *                      */
	protected void sanitizeInput() {
		this.input = input.trim(); // Remove leading/trailing spaces first
		StringBuilder s = new StringBuilder(input);
		int l = s.length(); // l is length of array, which will change
		
		for (int i = 0; i < l; i++) {
			// If char is a space, reduce it to only one
			if (s.charAt(i) == ' ') {
				while ((!Character.isDigit(s.charAt(i+1))) && i+1 < l) { // Only runs while next char is not a digit, leaving only one space behind.
					s.deleteCharAt(i+1);
					l--;
				}
			}
			else if ((!Character.isDigit(s.charAt(i))) && s.charAt(i) != '-') { 
				s.deleteCharAt(i); // Delete char if it is not a number or a '-'. Spaces handled above, this allows for negative numbers
				l--;
			}
		}
		
		// By this point, only the numbers, seperated by a space, will remain
		this.input = s.toString();
	}
	
	protected void sToObj() {
		int num = charCount(' '); // Number of digits, using space as delimiter
	
	}
	
	// Checks if char is present in this.input. Only one instance must be present for true return
	protected boolean isPresent(char c) {
		for (int i = 0; i < this.input.length(); i++) 
			if ( this.input.charAt(i) == c )
				return true;
		return false;
	}
	
	// Adds an object to this.arr
	protected void add(Object a) {
		
	}
	
	protected int charCount(char c) {
		int rtn = 0;
		for (int i = 0; i < input.length(); i++)
			if (this.input.charAt(i) == c)
				rtn++;
		return rtn;
	}			
}