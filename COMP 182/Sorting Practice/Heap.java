/* 
   Name: Kyle Krattiger
   
   Function: A class that utilizes the heap sort algorithm
*/
public class Heap extends ArraySort {
	/*             *
	 *  Variables  *
	 *             */
	protected char type = 'i'; // Indicates the type of the objects being used. f = fraction, d = double, i = int (default)
	
	/*                *
	 *  Constructors  *
	 *                */
	public Heap() {
		this.name = "Heap Sort";
		this.input = "";
		this.arr = new Integer[]{0,1,2}; // Default constructor won't be used much, just assign it to an int
	}
	
	public Heap(String s) {
		this.name = "Heap Sort";
		this.input = s;
		sanitizeInput();
		sToObj();
	}
	
	public Heap(Object[] o) {
		this.name = "Heap Sort";
		this.arr = o;
		this.input = toString();
	}
	
	/*                              *
	 *  Completed abstract methods  *
	 *                              */
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		for (int i = 0; i < this.arr.length; i++) {
			s.append(this.arr[i].toString() + " "); // Was worried this might not compile, but it works fine!
		}
		s.deleteCharAt(s.length()-1); // Gets rid of final space
		
		return s.toString();
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
		int num = charCount(' ') + 1; // Number of digits, using space as delimiter
		char type; // i for int, d for double, f for fraction
		
		// Decide type of object being used
		if (isPresent('/'))
			type = 'f';
		else if (isPresent('.'))
			type = 'd';
		else
			type = 'i';
		
		// Make new array with decided data type
		switch (type) {
			case 'f':
				this.arr = new Fraction[num];
				break;
			case 'd':
				this.arr = new Double[num];
				break;
			case 'i':
				this.arr = new Integer[num];
				break;
		}
		
		// Now, split string and store in array
		String[] temp = this.input.split(" ");
		for (int i = 0; i < temp.length; i++) {
			switch (type) {
				case 'f':
					this.arr[i] = new Fraction(temp[i]);
					break;
				case 'd':
					this.arr[i] = Double.parseDouble(temp[i]);
					break;
				case 'i':
					this.arr[i] = Integer.parseInt(temp[i]);
					break;
			}
		}
		// arr[] is now filled with selected object type, ready for sorting
	}
	
	// Checks if char is present in this.input. Only one instance must be present for true return
	protected boolean isPresent(char c) {
		for (int i = 0; i < this.input.length(); i++) 
			if ( this.input.charAt(i) == c )
				return true;
		return false;
	}
	
	protected int charCount(char c) {
		int rtn = 0;
		for (int i = 0; i < input.length(); i++)
			if (this.input.charAt(i) == c)
				rtn++;
		return rtn;
	}		
					
	protected void swap(int a, int b) {
		Object tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}