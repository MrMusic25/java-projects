public class Lab10_02 {
   public static void main(String args[]) { 
      int arraySize = 100, max = 9 /*0-9, 10 digits*/, min = 0; // Variables to make the program more dynamic
      int numbers[] = new int[arraySize];
      
      for (int i = 0; i < numbers.length; i++) {
         numbers[i] = randomInt(max,min);
      }
      int numCount[] = new int[max+1];
      countInt(numbers,numCount);
      outputCounts(numCount);
   }
   
   public static int randomInt(int max, int min) {
      return (int)((Math.random() * (max + 1)) + min);
   }
   
   public static void countInt(int input[], int output[]) {
      for (int a = 0; a < input.length; a++)
         output[input[a]]++;
   }
   
   public static void outputCounts(int nums[]) {
      System.out.println(" Interger   |   Count");
      for (int x = 0; x < nums.length; x++)
         System.out.println("     " + x + "      |    " + nums[x]);
   }
}