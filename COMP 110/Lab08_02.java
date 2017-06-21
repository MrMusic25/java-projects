public class Lab08_02 {
   public static void main(String args[]) {
      // No input, just output the given table
      System.out.println("i                                    m(i)  ");
      System.out.println("-------------------------------------------");
      System.out.println(1 + "                                    " + findPi(1)); // Needed a custom line
      
      for (long x = 100000; x <= (long)(Math.pow(2,63) / 2 - 1); x += 100000) {
      System.out.println(x + "                                  " + findPi(x));
      }
   }
   
   public static double findPi(long i) {
      // Find pi up until integer given
      double sum = 0.0;
      for (long j = i; j != 0; j--) {
         sum += (Math.pow(-1,j+1)) / (2 * j - 1);
      }
      return 4.0 * sum;
   }
}