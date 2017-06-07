public class Lab04_02 {
   public static void main(String args[]){
      // First, generate a random number
      int number = (int)(Math.random() * 16); // 16 because n-1, giving us 0-15
      char output = 'x';
      
      // Now, decide what to assign to the char
      switch (number) {
         case 10:
            output = 'A';
            break;
         case 11:
            output = 'B';
            break;
         case 12:
            output = 'C';
            break;
         case 13:
            output = 'D';
            break;
         case 14:
            output = 'E';
            break;
         case 15:
            output = 'F';
            break;
         case 0:
            output = '0'; // 0 doesn't output properly
            break;  
         default:
            output = (char)(number); // Static casting!         
      }
      // Now, output the results
      String result = "Generated decimal value is: " + number;
      System.out.println(result);
      result = "The hex value is " + output;
      System.out.println(result);
   }
}