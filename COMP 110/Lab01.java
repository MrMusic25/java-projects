import java.util.Scanner;
public class Lab01 {
   public static void main(String args[]){
      // Declare variables
      double length, width, totalArea, seconds;
      final double mowRate = 2.3; // Req from the Lab01 document
      
      // Get the length
      Scanner lengthInput = new Scanner(System.in);
      System.out.print("Please enter the length of the lawn, in meters: ");
      length = lengthInput.nextDouble();
      
      // Now, for the width
      Scanner widthInput = new Scanner(System.in);
      System.out.print("Please enter the width of the lawn, in meters: ");
      width = widthInput.nextDouble();
      
      // Do the math, and output the result
      totalArea = length * width;
      seconds = totalArea / mowRate;
      String finalString = "At a rate of " + mowRate + " meters per second, you will mow the entire lawn in " + seconds + " seconds.";
      System.out.println(finalString);
   }
}