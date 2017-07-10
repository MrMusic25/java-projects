import java.util.*;
import java.io.*;
public class WordHistogram {
   public static void main(String args[]) throws Exception {
      // Make sure there are two arguments
      String usage = "Usage: WordHistogram <inFile.txt> <outFile.txt>";
      if (args.length < 2) {
         System.out.printf("ERROR: missing arguments!\n" + usage + "\n");
         System.exit(1);
      }
      String inFilename = args[0], outFilename = args[1];
      
      // Now, check to see if inFile exists
      File inFile = new File(inFilename);
      if (!inFile.exists()) {
         System.out.printf("ERROR: Input file was not found!\n" + usage + "\n");
         System.exit(1);
      }
      
      // Input file exists, read it into an StringBuilder
      StringBuilder input = new StringBuilder();
      Scanner inFileReader = new Scanner(inFile);
      while (inFileReader.hasNext()) {
         input.append(inFileReader.nextLine() + "\n");
      }
      inFileReader.close();
      
      // Now, convert all non-alphabet chars to '\n'
      int newlineCount = 0;
      for (int i = 0; i < input.length(); i++) {
         if ( !(input.charAt(i) >= 'a' && input.charAt(i) <= 'z') &&
              !(input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') ) {
              input.setCharAt(i,'\n');
              newlineCount++;
         }
         //else
           // input.setCharAt(i,input.charAt(i).toLowerCase());     
      }        
      String processedInput = input.toString();
      
      // Ready to create arrays and count occurences
      String words[] = new String[newlineCount];
      int wordCount[] = new int[newlineCount];
      for (int x = 0; x < newlineCount; x++) { // Initialize both arrays
         words[x] = "";
         wordCount[x] = 0;
      }
      
      // Everything else is done with methods
      processWords(words,wordCount,processedInput);
      outputData(words,wordCount,outFilename);     
   }
   
   // Returns location of word if it exists, -1 if it was not found
   public static int wordExists(String database[], String word) {
      //if (database.length <= 0) return -1;
      for (int a = 0; a < database.length; a++)
         if (database[a].equals(word))
            return a;
         else if (database[a].equals(""))
            return -1;   
      return -1;      
   }
   
   public static void processWords(String database[], int wordCount[], String fileInput) {
      Scanner input = new Scanner(fileInput);
      String word = "";
      int rvalue = 0; // Return value
      
      while (input.hasNext()) {
         word = input.next();
         word = word.toLowerCase();
         rvalue = wordExists(database,word);
         if (rvalue == -1) {
            int location = nextOpenSpot(database);
            database[location] = word;
            wordCount[location] = 1;
         }
         else
            wordCount[rvalue]++;
      }
   }
   
   public static int nextOpenSpot(String database[]) {
      for (int j = 0; j < database.length; j++)
         if (database[j] == "")
            return j;
      return database.length;      
   }
   
   public static void outputData(String database[], int wordCount[], String outFile) throws Exception {
      StringBuilder output = new StringBuilder();
      int index = 0, max = maxLength(database), spaces = 0;
      
      while (database[index] != "" && index < database.length) {
         if (database[index].length() == max)
            output.append("  " + database[index] + " : " + wordCount[index] + "\r\n");
         else {
            spaces = max - database[index].length();
            for (int i = 0; i <= spaces; i++)
               output.append(" ");
            output.append(" " + database[index] + " : " + wordCount[index] + "\r\n");
         }   
         index++;      
      }
      
      PrintWriter outputFile = new PrintWriter(outFile);
      outputFile.println(output.toString());
      outputFile.close();
   }
   
   // Returns the length of the longest substring
   public static int maxLength(String input[]) {
      int max = 0;
      for (int i = 0; i < input.length; i++) {
         if (input[i] == "")
            return max;
         if (max < input[i].length())
            max = input[i].length();   
      }
      return max;
   }
}