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
      Length newLength;
      newLength = new Length(tmpFeet, tmpInches);
      
      return newLength;
   }
}