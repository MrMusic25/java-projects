//import Length;
public class TestLength {
   public static void main(String args[]) {
      Length length1 = new Length(10,5);
      Length length2 = new Length(5,10);
      outputLength(1,length1);
      outputLength(2,length2);
      
      Length length3 = length1.add(length2);
      outputLength(3,length3);
      
      Length length4 = length1.subtract(length2);
      outputLength(4,length4);
   }
   
   public static void outputLength(int num, Length obj) {
      System.out.println("length" + num + " has dimensions: " + obj.toString());
   }
}