import java.util.Scanner;
public class Lab09_01 {
   public static void main(String args[]) {
      // Have user input string, then char
      String inString;
      char inChar;
      
      Scanner stringInput = new Scanner(System.in);
      System.out.printf("Enter a string to be checked: ");
      inString = stringInput.nextLine();
      
      Scanner charInput = new Scanner(System.in);
      System.out.printf("Enter a char to be checked: ");
      inChar = charInput.next().charAt(0);
      
      System.out.println("The char " + inChar + " occurs " + count(inString, inChar) + " times in the string " + inString);
   }
   
   public static int count(String str, char a) {
      int count = 0;
      for (int i = 0; i < str.length(); i++)
         if (str.charAt(i) == a) 
            count++;
      return count;
   }
}