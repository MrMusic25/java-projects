public class Lab19_01 {
   public static void main(String args[]) {
      int numStudents = 100; // Only purpose here is to change the number of lockers. Dynamic.
      boolean lockers[] = new boolean[100];
      
      for (int i = 0; i < lockers.length; i++)
         lockers[i] = false; // They all start closed, initially
         
      // Array is initialized, now process it
      for (int j = 0; j < lockers.length; j++)
         processLockers(j,lockers);
       
      // Array is ready for printing
      for (int k = 0; k < lockers.length; k++) {
         System.out.printf("Locker " + (k + 1) + " is ");
         if (lockers[k])
            System.out.printf("open\n");
         else
            System.out.printf("closed\n");   
      }   
   }
   
   public static void processLockers(int studentNum, boolean lockers[]) {
      for (int x = 0; x < lockers.length; x++) {
         if ((x + 1) % (studentNum + 1) == 0) {
            lockers[x] = !lockers[x]; // Flip the value from open to closed
         }
      }
   }
}