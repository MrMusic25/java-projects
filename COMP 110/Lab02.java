import java.util.Scanner;
public class Lab02 {
   public static void main(String args[]){
      // Declare variables and constants
      double futureInvestmentValue, investmentAmount, monthlyInterestRate;
      int numberOfYears;
      
      // Ask for the input values
      // investmentAmount
      Scanner investmentInput = new Scanner(System.in);
      System.out.print("Enter investment amount: ");
      investmentAmount = investmentInput.nextDouble();
      
      // monthlyInterestRate
      Scanner interestInput = new Scanner(System.in);
      System.out.print("Enter annual interest rate in percentage: ");
      monthlyInterestRate = interestInput.nextDouble();
      
      // numberOfYears
      Scanner yearsInput = new Scanner(System.in);
      System.out.print("Enter number of years: ");
      numberOfYears = yearsInput.nextInt();
      
      // Now, do the math
      monthlyInterestRate = (monthlyInterestRate / 100) + 1.0;
      double multiplier = Math.pow(monthlyInterestRate,numberOfYears);
      futureInvestmentValue = investmentAmount * multiplier;
     
      // Finally, output the final calculation
      futureInvestmentValue = (((int)(futureInvestmentValue * 100.0)) + 0.5) / 100;
      String output = "Accumulated value is $" + futureInvestmentValue;
      System.out.println(output);
   }
}