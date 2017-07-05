import java.util.Scanner;
public class Lab18_02 {
   public static void main(String args[]) {
      // Have user input interger
      Scanner input = new Scanner(System.in);
      System.out.printf("Please enter an interger: ");
      long n = input.nextLong();
      
      System.out.println("Sum of digits of " + n + " is: " + sumDigits(n));
   }
   
   public static int sumDigits(long n) {
      if ( n <= 0 )
         return 0;
      int divisor = 1; // This allows it to return a single digit
      while (n / divisor > 0)
         divisor *= 10; // This will get us the highest divisor that yields a digit
         
      int x = (int)(n / (divisor/10));
      return x + sumDigits(n-(x*(divisor/10)));      
   }
}