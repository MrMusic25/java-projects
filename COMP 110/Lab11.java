public class Lab11 {
   public static void main(String args[]) {
      int size = input.nextInt(); // Ask for size
      int list[] = new int[size];
      createList(list);
      printList(list);
      int freq[] = frequency(list);
      printFrequency(freq);
      printChart(freq); 
   }
}