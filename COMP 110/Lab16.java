import java.io.*;
import java.util.*;
public class Lab16 {
   public static void main(String args[]) throws Exception {
      // First, make sure args are valid and file is accessible
      if (args.length != 3) {
         System.out.prinln("ERROR: Not enough arguments to run! Please fix and run again!");
         System.out.prinln("Usage: java Lab16 <file> <oldString> <newString>");
         System.exit(1);
      }
      File inFile = new File(args[0]);
      if (!inFile.exists()) {
         System.out.println("ERROR: File " + args[1] + " could not be found! Exiting...");
         System.exit(1);
      }
      
      
   }
}