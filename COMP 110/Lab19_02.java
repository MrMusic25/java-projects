import java.util.*;

public class Lab19_02 {
    public static void main(String[] args) {
       // TODO code application logic here
       // input a word (max 6 characters)
       Scanner in = new Scanner(System.in);
       String word = "";
       do {
          System.out.printf("Enter a word (max 6 chars): ");
          word = in.nextLine();
       } while (word.length() > 6);
       
       System.out.printf("Time to generate same word is: ");
       long startTime = System.currentTimeMillis();
       String s = "";
       // generate the initial String based on length of word 
       for (int a = 0; a < word.length(); a++)
         s += generate();   
       
       while ( !s.equals(word))
       {
         // Reinitialize s
         s = s.substring(1); // Delete first char, then add a new one
         s += generate(); 
       }
                  
       long endTime = System.currentTimeMillis();
       long time =  (endTime - startTime)/1000;
       System.out.printf(time + " seconds\n");
    }
   
    // generate a random lowercase character
    public static char generate(){
      int max = (int)'z', min = (int)'a'; 
      int value = (int)((Math.random() * (max + 1 - min)) + min);
      return (char)value;
    }
}