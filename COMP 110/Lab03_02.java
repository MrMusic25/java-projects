import java.util.Scanner;
public class Lab03_02 {
   public static void main(String args[]) {
      // Initialize variables
      double a, b, c, discriminant, s1, s2;
      String output;
      
      // Input a, b, and c
      Scanner input = new Scanner(System.in);
      System.out.printf("Enter a, b, c: ");
      a = input.nextDouble();
      b = input.nextDouble();
      c = input.nextDouble();
      
      // Next, find discriminant, used to determine number of solutions
      discriminant = Math.pow(b,2) - 4 * a * c;
      
      // Then, find solutions and print them based on discriminant value
      if(discriminant > 1.0){
         // Positive, two solutions
         s1 = ((-1 * b) + Math.pow(discriminant,0.5)) / (2 * a);
         s2 = ((-1 * b) - Math.pow(discriminant,0.5)) / (2 * a);
         output = "The equation has two roots " + s1 + " and " + s2;
         System.out.println(output);
      }
      else if(discriminant == 0.0) {
         // 0, one solution
         s1 = (-1 * b) / (2 * a);
         output = "The equation has one real root " + s1;
         System.out.println(output);
      }
      else {
         // Negative, no solutions
         System.out.println("The equation has no real roots.");
      }
   }
}