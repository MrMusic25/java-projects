public class Lab08_02 {
   public static void main(String args[]) {
      // No input, just output the given table
      System.out.println("i                                    m(i)  ");
      System.out.println("-------------------------------------------");
      System.out.println(1 + "                                    " + findPi(1)); // Needed a custom line
      
      for (int x = 101; x <= (int)(Math.pow(2,32) / 2 - 1); x += 100) {
      System.out.println(x + "                                  " + findPi(x));
      }
   }
   
   public static double findPi(int i) {
      // Find pi up until integer given
      double sum = 0.0;
      for (int j = i; j != 0; j--) {
         sum += (Math.pow(-1,j+1)) / (2 * j - 1);
      }
      return 4.0 * sum;
   }
}