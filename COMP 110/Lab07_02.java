public class Lab07_02 {
   public static void main(String args[]) {
      double result = 0.0;
      for (int i = 1; i <= 9; i += 2) {
         double j = (double)i;
         result += j / (j + 2);
      }
      System.out.println("1/3 + 3/5 + 5/7 + 7/9 + 9/11 = " + result);
   }
}