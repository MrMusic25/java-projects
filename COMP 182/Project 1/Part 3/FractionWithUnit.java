public class FractionWithUnit extends Fraction {
	protected double feet, inches; // Default units for FWU
	
	// Constructors
	public FractionWithUnit() {
		this.feet = 1.0;
		this.inches = 1.0;
	}
	
	public double getFeet() { return this.feet; }
	public double getInches() { return this.inches; }
}