/*
   Name: Kyle Krattiger
   
   Function: An abstrac class to be used for sorting algorithm classes
   
*/
public abstract class ArraySort {
	public String name; // Name of the sorting algorithm
	public String input; // The original input from the user or program
	public Object arr[]; // Array of objects to be sorted
	
	// Constructors
	public ArraySort() {
		name = "Unknown";
		input = "";
	}
	
	public ArraySort(String s) {
		name = "Unknown";
		input = s;
	}
	
	// Abstract methods
	public abstract String toString(); // As name implies, return string of the sorted object
	public abstract void sortIncr(); // Sort from low->high
	public abstract void sortDecr(); // Sort from high->low
}