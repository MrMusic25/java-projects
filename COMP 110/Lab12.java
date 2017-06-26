import java.util.Scanner;
public class Lab12 {
   public static void main(String args[]) {
      // Input the number
      int number = 0;
      
      Scanner input = new Scanner(System.in);
      System.out.printf("Enter an integer between 0 and 511: ");
      number = input.nextInt();
      
      // Process the number
      if (number > 511) {
         System.out.println("ERROR: Number is greater than 511, exiting");
         System.exit(1);
      }   
      else if (number < 0) {
         System.out.println("ERROR: Number is less than 0, exiting");
         System.exit(1);
      }
      
      // At this point, number is in correct range; ready for output
      int table[] = new int[9];
      intToBinary(number, table);
      outputTable(table);
   }
   
   public static void intToBinary(int input, int output[]) {
      int num = input, max = output.length, divisor = 0, i;
      for (i = max; i >= 0; i--) {
         divisor = ((int)Math.pow(2,i));
         if (divisor == 0)
            break;
         if (num >= divisor) {
            output[i] = 1; // LIFO, remember for later
            num -= divisor;
         }   
      }
      if (i == 1)
         output[0] = 1; // For odd numbers
   }
   
   public static void outputTable(int number[]) {
      for (int x = 8; x >=0; x--) {
         if (number[x] == 0)
            System.out.printf("H ");
         else
            System.out.printf("T ");
         
         if (x % 3 == 0)
            System.out.printf("\n");      
      }
   }
}