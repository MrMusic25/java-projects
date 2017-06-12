import java.util.Scanner;
public class Lab06_01 {
   public static void main(String args[]) {
      // Initialize variables
      double numerator, denominator, remainder;
      
      // Ask for input
      Scanner numIn = new Scanner(System.in);
      System.out.printf("Enter a numerator: ");
      numerator = numIn.nextDouble();
      
      Scanner denIn = new Scanner(System.in);
      System.out.printf("Enter a denominator: ");
      denominator = denIn.nextDouble();
      
      // Next, check if fraction is improper
      if (numerator > denominator) {
         remainder = numerator / denominator;
      }   
   }
}