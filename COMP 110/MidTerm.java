public class MidTerm {
   public static void main(String args[]) {
      double result = 0.0;
      for (int i = 1; i <= 624; i++) {
         result += 1 / (Math.sqrt(i) + Math.sqrt(i + 1));
      }
      System.out.println("Value is: " + result);   
   }
}