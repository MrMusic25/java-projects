public class LabExam {
   public static void main(String args[]) {
      int list[] = new int[10];
      fillWithRandomNumbers(list);
      
      System.out.println("Original array looks like:");
      printArray(list);
      
      System.out.println("Average of array is: " + computeAverage(list));
      
      list = foldArray(list);
      System.out.println("\nFolded array looks like:");
      printArray(list);
   }
   
   public static void fillWithRandomNumbers(int list[]) {
      int max = 50, min = 10;
      for (int i = 0; i < list.length; i++)
         list[i] = (int)((Math.random() * (max - min + 1)) + min);
   }
   
   public static void printArray(int list[]) {
      for (int i = 1; i <= list.length; i++) {
         System.out.printf(list[i-1] + " ");
         if (i % 5 == 0)
            System.out.printf("\n"); 
      }      
      System.out.printf("\n");   
   }
   
   public static double computeAverage(int list[]) {
      double sum = 0.0;
      for (int x = 0; x < list.length; x++)
         sum += list[x];
      return sum / list.length;   
   }
   
   public static int[] foldArray(int list[]) {
      int remainder = list.length, index = 0, firstIndex = 0, lastIndex = list.length - 1;
      int tmpArray[] = new int[remainder/2];
      
      while (remainder > 1) {
         tmpArray[index] = list[firstIndex] + list[lastIndex];
         index++;
         remainder -= 2;
         lastIndex--;
         firstIndex++;
         
         if (remainder == 1)
            tmpArray[index] = list[firstIndex]; // So that the last value does not get lost
      }
      
      return tmpArray;
   }
}