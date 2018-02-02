abstract class Shape {
	// Object variables
	String name;
	
	// Constructor
	public Shape() {
		this.name = "unknown";
	}
	
	// Public methods
	abstract void display(); // Output dimensions of shape
	abstract void calculateArea(); // Output area of shape
}