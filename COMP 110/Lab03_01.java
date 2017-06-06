import java.util.Scanner;
public class Lab03_01 {
   public static void main (String args[]) {
      // Declare variables
      String name;
      double hours, rate, totalPay, overtime;
      
      // Ask for input
      // Name
      Scanner nameInput = new Scanner(System.in);
      System.out.printf("Enter employee name: ");
      name = nameInput.nextLine();
      
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
      // Overtime
      else {
         overtime = hours % 40.0;
         if (hours > 54.0)
            overtime *= 2; // Double rate if >54 hours
         else
            overtime *= 1.5; // 1.5x rate is <54 hours
         totalPay = (40.0 * rate) + (overtime * rate);
      }
      
      // Finally, output the results
      String output = name + " worked " + hours + " with pay rate of $" + rate + ". ";
      output = output + "The gross pay for " + name + " is $" + (int)(totalPay) + "." + (int)(totalPay * 100) % 100 + ".";
      System.out.println(output);
   }
}