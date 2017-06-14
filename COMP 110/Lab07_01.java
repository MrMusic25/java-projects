import java.util.Scanner;
public class Lab07_01 {
   public static void main(String args[]) {
      // Input the number to check
      int originalNum;
      
      Scanner input = new Scanner(System.in);
      System.out.printf("Please enter an integer: ");
      originalNum = input.nextInt();
      
      // Find factors of integer
      int num = originalNum, halfVal; // Needed a second number to work with
      if (num % 2 == 0)
         halfVal = num / 2; // Even number
      else
         halfVal = (num + 1) / 2; // Odd number
      System.out.printf("Factors of " + originalNum + " are: ");      
      for (int factor = 2; factor < halfVal; factor++) {
         // Nested loop to test if factor is prime
         boolean flag = true; // Used to exit loop
         
         for (int i = 2; i < (int)Math.floor(num / 2); i++) {
            if (factor % i == 0) {
               flag = false; // Number is not prime, exit loop
               break;
            }      
         }
         if (!flag)
            continue;
            
         // Factor is prime, now see if it is a factor
         while (num % factor == 0) {
            // While loops identifies multiple factors
            System.out.printf(factor + " ");
            num /= factor;
         }
      }
      System.out.println("\n");
   }
}