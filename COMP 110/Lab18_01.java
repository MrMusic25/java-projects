import java.util.Scanner;
public class Lab18_01 {
   public static void main(String args[]) {
      // User inputs a string, then the char to be counted
      Scanner strIn = new Scanner(System.in);
      System.out.printf("Input a string: ");
      String str = strIn.nextLine();
      
      Scanner charIn = new Scanner(System.in);
      System.out.printf("Input a char to be counted: ");
      char e = charIn.nextLine().charAt(0);
      
      System.out.println(e + " occurs " + count(str,e,str.length()-1) + " times in the given string.");
   }
   
   public static int count(String str, char e, int pos) {
      if ( pos < 0 )
         return 0;
      return charEquals(str.charAt(pos),e) + count(str,e,pos-1); // Thought this would create an infinite loop, but it didn't.... Cool.
   }
   
   public static int charEquals(char a, char b) {
      if ( a == b )
         return 1;
      else
         return 0;   
   }
}