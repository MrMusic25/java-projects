// Lab 13
public class Length {
   private int feet;
   private int inches;
   
   public void Length() {
      this.feet = 0;
      this.inches = 0;
   }
   
   public void Length(int newFeet, int newInches) {
      this.feet = newFeet;
      this.inches = newInches;
      while (newInches >= 12) {
         this.feet++;
         this.inches -= 12;
      }
   }
   
   public int getFeet() {
      return this.feet;
   }
   
   public void setFeet(int newFeet) {
      this.feet = newFeet;
   }   
   
   public int getInches() {
      return this.inches;
   }
   
   public void setInches(int newInches) {
      this.inches = newInches;
      while (newInches >= 12) {
         this.feet++;
         inches -= 12;
      }
   }
   
   public Length add(Length otherLength) {
      int tmpFeet = this.feet + otherLength.getFeet();
      int tmpInches = this.inches + otherLength.getInches();
      Length newLength = new Length();
      /* newLength = new Length(tmpFeet, tmpInches);
         ^-- Above line kept giving me compiler error, couldn't find overloaded method
      */
      
      newLength.setFeet(tmpFeet);
      newLength.setInches(tmpInches); // Method automatically takes care of >=12 cases
      return newLength;
   }
   
   public Length subtract(Length otherLength) {
      Length newLength = new Length();
      if (this.feet <= otherLength.getFeet()) { // -ge because of below code --v
         if (!(this.feet - otherLength.getFeet() == 0 && this.inches >= otherLength.getInches())) { // This allows for 0,0 and inches-only calc
            newLength.setFeet(-1);
            newLength.setInches(-1); // Indicates error, cannot subtract
            return newLength;
         }   
      }
      
      // Above error checking should cover all use cases
      // Subtraction can be assumed to be successful now, moving on!
      int tmpFeet = this.feet - otherLength.getFeet();
      int tmpInches = this.inches;
      if (this.inches < otherLength.getInches()) {
         tmpFeet--;
         tmpInches += 12;
      }
      tmpInches -= otherLength.getInches();
      newLength.setFeet(tmpFeet);
      newLength.setInches(tmpInches);
      return newLength;   
   }
   
   public String toString() {
      String output = this.feet + "' " + this.inches + "\"";
      return output;
   }   
}