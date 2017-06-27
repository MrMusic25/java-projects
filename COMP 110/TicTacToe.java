import java.util.*;
public class TicTacToe
{
   static Scanner in = new Scanner(System.in);
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      char[][] board = new char[3][3];
      for(int i=0;i<3;i++)
         for(int j=0;j<3;++j)
            board[i][j]=' ';
      while (true)
      {
         computerPlay(board);
         displayBoard(board);
         if(checkWin(board,'X'))
         {
            System.out.println("COmputer Wins");
            System.exit(0);
         }
         if(checkTie(board))
         {
            System.out.println("Tie game");
            System.exit(0);
         }
         playerPlays(board);
         displayBoard(board);
         if(checkWin(board,'O'))
        {
            System.out.println("Player Wins");
            System.exit(0);
         }
         if(checkTie(board))
         {
            System.out.println("Tie game");
            System.exit(0);
         }
      
         
        
      }
         
   }
  
 
   // Prompt the user for row & column index. Continue asking 
   // until an empty cell is selected. set the cell to 'O'
   public static void playerPlays(char[][] board)
   {
      
   }

   // Check by row, column, and diagonals
   public static boolean checkWin(char[][] board,char ch)
   {
   }
    
   // check for tie. If there no  empty cells, then it is a tie
   public static boolean checkTie(char[][] board)
   {
   }

     
    // Display the board
   public static void displayBoard(char[][] board)
   {
   }
  
  // Continue generating random values for row and col until an 
  // empty cell selected. Set the cell to 'X'
   public static void computerPlay(char[][]board)
   {
      
   }
}
