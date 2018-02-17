/* 
   Name: Kyle Krattiger
   
   Function: Main class to use the various sorting functions
*/

public class Test {
	public static void main(String args[]) {
		String s = "12 456 9 3";
		String[] arr = s.split(" ");
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Item " + i + ": " + arr[i]);
		}
		/*
		int oldIndex = 0; // Used to indicate where to start search for new substring
		int newIndex, nextIndex;
		int num = charCount(s,' ');
		for (int i = 0; i < num; i++) {
			newIndex = s.indexOf(' ',oldIndex);
			nextIndex = s.indexOf(' ',newIndex);
			System.out.println("Substring " + i + ": \'" + s.substring(newIndex,nextIndex) + "\'");
			oldIndex = newIndex;
		}
		*/
	}
	
	protected static int charCount(String s, char c) {
		int rtn = 0;
		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i) == c)
				rtn++;
		return rtn;
	}
}