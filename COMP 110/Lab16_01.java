import java.io.*;
import java.util.*;
public class Lab16_01 {
   public static void main(String args[]) throws Exception {
      // First, make sure args are valid and file is accessible
      if (args.length != 3) {
         System.out.println("ERROR: Not enough arguments to run! Please fix and run again!");
         System.out.println("Usage: java Lab16_01 <inputFile> <oldString> <newString>");
         System.exit(1);
      }
      File inFile = new File(args[0]);
      if (!inFile.exists()) {
         System.out.println("ERROR: File " + args[0] + " could not be found! Exiting...");
         System.exit(1);
      }
      
      // File exists and is ready to be read from; read it into an array
      Scanner input = new Scanner(inFile);
      StringBuilder contents = new StringBuilder();
      String tmp, newString;
      
      boolean firstLine = true;
      while (input.hasNext()) {
         tmp = input.nextLine();
         newString = tmp.replaceAll(args[1],args[2]);
         if (firstLine) {
            contents.append(newString);
            firstLine = false;
         }
         else
            contents.append("\r\n" + newString);
      }
      
      input.close();
      
      // Now, write to same file
      PrintWriter output = new PrintWriter(inFile);
      output.println(contents.toString());
      output.close();
   }
}