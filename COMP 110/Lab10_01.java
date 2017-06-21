import java.util.Scanner;
public class Lab10_01 {
   public static void main(String args[]) {
      // Input number of students
      Scanner numIn = new Scanner(System.in);
      System.out.printf("Enter the number of students: ");
      int numStudents = numIn.nextInt();
      int studentGrades[] = new int[numStudents];
      
      // Now get grades
      Scanner gradesIn = new Scanner(System.in);
      System.out.printf("Enter " + numStudents + " grades: ");
      for (int i = 0; i < studentGrades.length; i++)
         studentGrades[i] = gradesIn.nextInt();
      printGrades(studentGrades);   
   }
   
   public static void printGrades(int grades[]) {
      int best = grades[findHighestValue(grades)];
      
      for (int j = 0; j < grades.length; j++) {
         
      }
   }
   
   public static int findHighestIndex(int a[]) {
      int index = 0;
      for (int x = 0; x < a.length; x++)
         if (a[x] > a[index])
            index = x;
      return index;      
   }
}