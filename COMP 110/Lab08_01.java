import java.util.Scanner;
public class Lab08_01 {
   public static void main(String args[]) {
      // Input number to be checked
      Scanner input = new Scanner(System.in);
      System.out.printf("Enter an integer to be summed: ");
      long l = input.nextLong();
      
      System.out.println("Sum of the digits of " + l + " is: " + sumDigits(l));
   }
   
   public static long sumDigits(long n){
      long temp = n, sum = 0;
      while (temp != 0) {
         sum += (temp%10);
         temp /= 10;
      }
      return sum;
   }
}