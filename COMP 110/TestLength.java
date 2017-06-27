//import Length;
public class TestLength {
   public static void main(String args[]) {
      // Everything can be done with one for loop
      Length lengths[] = new Length[4];
      for (int i = 0; i < lengths.length /* lol */; i++) {
         switch (i) {
            case 0:
               lengths[i] = new Length();
               lengths[i].setFeet(10);
               lengths[i].setInches(5);
               break;
            case 1:
               lengths[i] = new Length();
               lengths[i].setFeet(5);
               lengths[i].setInches(10);
               outputLength(i-1,lengths[i-1]);
               outputLength(i,lengths[i]);
               break;
            case 2:
               //lengths[i].setFeet(lengths[0].getFeet());
               //lengths[i].setInches(lengths[0].getInches());
               Length lengths2 = lengths[0].add(lengths[1]);
               outputLength(i,lengths2);
               break;
            case 3:
               //lengths[i].setFeet(lengths[0].getFeet());
               //lengths[i].setInches(lengths[0].getInches());
               Length lengths3 = lengths[1].subtract(lengths[0]);
               outputLength(i,lengths3);
         }
      }

   }
   
   public static void outputLength(int num, Length obj) {
      System.out.println("length" + num + " has dimensions: " + obj.toString());
   }
}