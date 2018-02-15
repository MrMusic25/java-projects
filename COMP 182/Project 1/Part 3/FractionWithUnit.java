public class FractionWithUnit extends Fraction {
	protected double feet, inches; // Default units for FWU
	
	// Constructors
	public FractionWithUnit() {
		super(); // Must be first call in constructor
		this.feet = 1.0;
		this.inches = 1.0;
	}
	
	public double getFeet() { return this.feet; }
	public double getInches() { return this.inches; }
	public double getTotalInches() { return this.inches + (12.0 * this.feet); }
}