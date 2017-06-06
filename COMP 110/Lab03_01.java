import java.util.Scanner;
public class Lab03_01 {
   public static void main (String args[]) {
      // Declare variables
      String name;
      double hours, rate, totalPay;
      
      // Ask for input
      // Name
      Scanner nameInput = new Scanner(System.in);
      System.out.printf("Enter employee name: ");
      name = nameInput.next();
      
      // Hours
      Scanner hoursInput = new Scanner(System.in);
      System.out.printf("Enter hours worked: ");
      hours = hoursInput.nextDouble();
      
      // Pay rate
      Scanner rateInput = new Scanner(System.in);
      System.out.printf("Enter pay rate: ");
      rate = rateInput.nextDouble();
      
      // Now, do the calculation
      if (hours <= 40.0)
         totalPay = hours * rate;
      else { // Overtime, get time and a half
         double overtime = hours % 40.0;
         
   }
}