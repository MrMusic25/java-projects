import java.util.Scanner;
public class Lab09_02 {
   public static void main(String args[]) {
      // Input the intergers
      int list[] = new int[10];
      
      Scanner input = new Scanner(System.in);
      System.out.printf("Enter 10 intergers: ");
      for (int i = 0; i < list.length; i++)
         list[i] = input.nextInt();
         
      int revList[] = new int[10];
      rev(list, revList);
      
      System.out.printf("The array reversed is: ");
      for (int a = 0; a < revList.length; a++)
         System.out.printf(revList[a] + " ");
      System.out.printf("\n");      
   }
   
   public static void rev(int input[], int output[]) {
      int y = input.length - 1;
      for (int x = 0; x < input.length; x++) {
         output[y] = input[x];
         y--;
      }
   }
}