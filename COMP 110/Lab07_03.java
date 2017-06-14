import java.util.Scanner;
public class Lab07_03 {
   public static void main(String args[]) {
      // Ask user for string
      String test;
      Scanner input = new Scanner(System.in);
      System.out.printf("Enter a string: ");
      test = input.nextLine();
      
      int count = 0;
      for (int i = 0; i <= (test.length() - 1); i++) {
         if (test.charAt(i) >= 'A' && test.charAt(i) <= 'Z')
            count++;
      }
      System.out.println("The number of uppercase letters is: " + count);
   }
}