import java.io.*;
import java.util.*;
public class Lab16_02 {
   public static void main(String args[]) throws Exception {
      // Check number and validity of args
      if (args.length != 1) {
         System.out.println("ERROR: Invalid numer of arguments (" + args.length + ")! Please fix and re-run!");
         System.out.println("Usage: java Lab16_02 <inputFile>");
         System.exit(1);
      }
      
      String filename = args[0];
      File inFile = new File(filename);
      if (!inFile.exists()) {
         System.out.println("File " + filename + " could not be found! Exiting...");
         System.exit(1);
      }
      
      // File is available, read it into an array
      Scanner input = new Scanner(inFile);
      int charCount = 0, wordCount = 0, lineCount = 0;
      String tmp, whiteSpace[];
      
      while (input.hasNext()) {
         tmp = input.nextLine();
         charCount += tmp.length();
         whiteSpace = tmp.split("\\s");
         wordCount += whiteSpace.length;
         lineCount++;
      }
      
      input.close();
      
      System.out.println("File " + filename + " has:");
      System.out.println("  " + charCount + " characters");
      System.out.println("  " + wordCount + " words");
      System.out.println("  " + lineCount + " lines");
   }
}