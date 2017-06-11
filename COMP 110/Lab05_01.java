import java.util.Scanner;
public class Lab05_01 {
   public static void main(String args[]) {
      // Initialize variables
      String s1 = "NULL", s2 = "NULL"; // Didn't compile last time with no value
      int index;
      
      // Ask for input
      Scanner input1 = new Scanner(System.in);
      System.out.printf("Enter string s1: ");
      s1 = input1.nextLine();
      
      Scanner input2 = new Scanner(System.in);
      System.out.printf("Enter string s2: ");
      s2 = input2.nextLine();
      
      // Now compare strings
      index = s1.indexOf(s2);
      
      // Print output based on results
      if ( index == -1 )
         System.out.println(s2 + " is not a substring of " + s1);
      else  
         System.out.println(s2 + " is a substring of " + s1 + ", starting at index " + index);   
   }
}