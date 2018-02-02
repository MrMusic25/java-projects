public class Rectangle extends Shape {
	// Private variables
	int length, width;
	
	// Constructors
	public Rectangle() {
		this.length = 0;
		this.width = 0;
		this.name = "rectangle";
	}
	
	public Rectangle(int l, int w) {
		this.length = l;
		this.width = w;
		this.name = "rectangle";
	}
	
	// Public methods
	public void display() {
		System.out.println(this.name + " has dimensions " + this.length + " by " + this.width);
	}
	
	public void calculateArea() {
		System.out.println("Area of " + this.name + " is " + (this.length * this.width));
	}
}