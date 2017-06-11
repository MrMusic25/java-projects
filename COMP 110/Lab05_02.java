import java.util.Scanner;
public class Lab05_02 {
   public static void main(String args[]) {
      // Initialize the variables needed
      // Input variables
      double hours, rate, federalTax, stateTax;
      String name;
      
      // Time for all the input
      // Name
      Scanner nameInput = new Scanner(System.in);
      System.out.printf("Enter employee's name: ");
      name = nameInput.nextLine();
      
      // Hours
      Scanner hoursInput = new Scanner(System.in);
      System.out.printf("Enter number of hours worked per week: ");
      hours = hoursInput.nextDouble();
      
      // Pay rate
      Scanner rateInput = new Scanner(System.in);
      System.out.printf("Enter hourly pay rate: ");
      rate = rateInput.nextDouble();
      
      // Federal tax
      Scanner fedInput = new Scanner(System.in);
      System.out.printf("Enter federal tax withholding rate: ");
      federalTax = fedInput.nextDouble();
      
      // Lastly, the state tax
      Scanner stateInput = new Scanner(System.in);
      System.out.printf("Enter state tax withholding rate: ");
      stateTax = stateInput.nextDouble();
      
      // Now, do the computations
      double grossPay = hours * rate, fedWithheld = grossPay * federalTax, stateWithheld = grossPay * stateTax;
      double totalWithheld = fedWithheld + stateWithheld, netPay = grossPay - totalWithheld;
      
      // Finally, output everything
      System.out.println("Employee Name: " + name);
      System.out.println("Hours worked: " + hours);
      System.out.println("Pay rate: $" + rate);
      System.out.println("Gross pay: $" + grossPay);
      System.out.println(" ");
      System.out.println("Deductions:");
      System.out.println("  Federal Withholding (" + (federalTax * 100) + "%): $" + fedWithheld);
      System.out.println("  State Withholding (" + (stateTax * 100) + "%): $" + stateWithheld);
      System.out.println("Total Deductions: $" + totalWithheld);
      System.out.println(" ");
      System.out.println("Net Pay: $" + netPay);
   }
}