//import Length;
public class TestLength {
   public static void main(String args[]) {
      /* Length length1 = new Length(10,5);
      Length length2 = new Length(5,10);
      outputLength(1,length1);
      outputLength(2,length2);
      
      Length length3 = length1.add(length2);
      outputLength(3,length3);
      
      Length length4 = length1.subtract(length2);
      outputLength(4,length4); */
      // ^-- Previous version of the program, for Lab13.
      // Below is Lab15
      
     Length[] list = generateList(15);  // a method that generates an array of 15 length objects;
     System.out.println("Unsorted list of Length objects:");
     printList(list);                           // a method that prints length objects, 10 per line
     selectionSort(list);            // selctionSort method to sort length objects in ascending order
     System.out.println("Sorted list of Length objects:");
     printList(list);
     System.out.println("The sum of Length objects is: "+sum(list));  // sum method 

   }
   
   public static void outputLength(int num, Length obj) {
      System.out.println("length" + num + " has dimensions: " + obj.toString());
   }
   
   public static Length[] generateList(int num) {
      int feetMax = 30, feetMin = 1;
      int inchMax = 11, inchMin = 0;
      int tmpFeet, tmpInch;
      
      Length tmpList[] = new Length[num];
      
      for (int i = 0; i < num; i++) {
         tmpFeet = (int)(Math.random() * (feetMax + (1 - feetMin))) + feetMin; // Might as well make everything easily upgradeable, right?
         tmpInch = (int)(Math.random() * (inchMax + (1 - inchMin))) + inchMin;
         tmpList[i] = new Length(tmpFeet,tmpInch);
      }
      return tmpList;
   }
   
   public static void printList(Length list[]) {
      for (int x = 1 /* Easier newlines */; x <= list.length; x++) {
         System.out.printf(list[x-1].toString() + ", ");
         if (x % 10 == 0)
            System.out.printf("\n");
      }
      System.out.printf("\n\n");
   }
   
   public static void selectionSort(Length list[]) {
      int a, b, newHigh;
      Length tmp;
      for (a = 0; a < list.length; a++) {
         newHigh = a; // Current index
         
         for (b = a; b < list.length; b++)
            if (list[b].compareTo(list[newHigh]) == 1)
               newHigh = b;
         
         tmp = list[a];
         list[a] = list[newHigh];
         list[newHigh] = tmp;
      }
   }
   
   public static String sum(Length list[]) {
      int totalInches = 0;
      for (int i = 0; i < list.length; i++)
         totalInches += list[i].allInches();  
      Length tmp = new Length(0,totalInches);
      return tmp.toString();   
   }
}