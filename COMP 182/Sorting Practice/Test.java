/* 
   Name: Kyle Krattiger
   
   Function: Main class to use the various sorting functions
*/

public class Test {
	public static void main(String args[]) {
		String input = " 18  7  69  2 9 40 3   41 6 ";
		Heap b = new Heap(input);
		
		System.out.println("Original array: '" + input + "'");
		System.out.println("Cleaned input: '" + b.input + "'");
		
		b.sortIncr();
		System.out.println("Sorted output (increasing): '" + b.toString() + "'");
		
		//b.sortDecr();
		//System.out.println("Sorted output (decreasing): '" + b.toString() + "'");
	}
}