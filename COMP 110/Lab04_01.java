import java.util.Scanner;
public class Lab04_01 {
   public static void main(String args[]){
      // Variables
      int month, year, days = -1;
      String monthString = "NULL", output;
      
      // Have user input month and year
      Scanner input = new Scanner(System.in);
      System.out.printf("Please enter the month number followed by the year: ");
      month = input.nextInt();
      year = input.nextInt();
      
      // Now, determine the number of days in the month, and assign the string
      switch(month) {
      case 1:
         days=31;
         monthString = "January";
         break;
      case 2:
         if(year%4 == 0)
            days=29;
         else
            days=28;
         monthString = "February";
         break;
      case 3:
         days=31;
         monthString = "March";   
         break;
      case 4:
         days=30;
         monthString = "April";
         break;
      case 5:
         days=31;
         monthString = "May";
         break;   
      case 6:
         days=30;
         monthString = "June";
         break;
      case 7:
         days=31;
         monthString = "July";
         break;
      case 8:
         days=31;
         monthString = "August";
         break;      
      case 9:
         days=30;
         monthString = "September";
         break;
      case 10:
         days=31;
         monthString = "October";
         break;      
      case 11:
         days=30;
         monthString = "November";
         break;
      case 12:
         days=31;
         monthString = "December";
         break;   
      default:
         System.out.println("Invalid month number!");
         System.exit(1);
      };
      // Now, output the results
      output = monthString + " " + year + " had " + days + " days.";
      System.out.println(output);            
   }
}