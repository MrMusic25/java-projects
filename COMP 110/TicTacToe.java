import java.util.*;
public class TicTacToe
{
   //static Scanner in = new Scanner(System.in);
   public static void main(String[] args)
   {
      //Scanner in = new Scanner(System.in);
      // Never actually used this line, no harm in commenting it out
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
            System.out.println("Computer Wins");
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
      int spot = -1;
      Scanner input;
      do
      {
        input = new Scanner(System.in);
        System.out.printf("Enter an empty spot to place your move(1-9): ");
        spot = input.nextInt();
      } while (!spotIsEmpty(spot - 1,board));
      setSpot(spot - 1,'O',board);
   }

   // Check by row, column, and diagonals
   public static boolean checkWin(char[][] board,char ch)
   {
      if ( (board[0][0] == ch && board[1][0] == ch && board[2][0] == ch) ||
           (board[0][1] == ch && board[1][1] == ch && board[2][1] == ch) ||
           (board[0][2] == ch && board[1][2] == ch && board[2][2] == ch) || /* Vertical*/
           (board[0][0] == ch && board[0][1] == ch && board[0][2] == ch) ||
           (board[1][0] == ch && board[1][1] == ch && board[1][2] == ch) ||
           (board[2][0] == ch && board[2][1] == ch && board[2][2] == ch) || /* Horizontal */
           (board[0][0] == ch && board[1][1] == ch && board[2][2] == ch) ||
           (board[0][2] == ch && board[1][1] == ch && board[2][0] == ch) )  /* Diagonals */
           return true; // I hope I never have to write something like this again
      else
         return false;     
   }
    
   // check for tie. If there no  empty cells, then it is a tie
   public static boolean checkTie(char[][] board)
   {
      for (int i = 0; i < 3; i++)
      {
         for (int j = 0; j < 3; j++)
         {
            if (board[i][j] == ' ')
               return false; 
         }
      }
      return true;
   }

     
    // Display the board
   public static void displayBoard(char[][] board)
   {
      System.out.printf("\n  -------------------\n");
      // Loop i controls formatting, j and k control output
      int j = 0, k = 0;
      for(int i = 0; i < 3; i++)
      {
         System.out.printf("  |" + (1+(i*3)) + "    |" + (2+(i*3)) + "    |" + (3+(i*3)) + "    |\n  |");
         for(k = 0; k < 3; k++)
         {
            System.out.printf("  " + board[j][k] + "  |");
         }
         System.out.printf("\n  |     |     |     |\n  -------------------\n");
         j++;
      }
      System.out.printf("\n");
   }
  
  // Continue generating random values for row and col until an 
  // empty cell selected. Set the cell to 'X'
   public static void computerPlay(char[][]board)
   {
      int choice;
      do {
         choice = (int)(Math.random() * 9); // 0-8, each has a corresponding board piece
         if (spotIsEmpty(choice,board))
            break;
      } while(true);
      setSpot(choice,'X',board);    
   }
   
   public static boolean spotIsEmpty(int num, char board[][])
   {
      switch (num)
      {
         case 0:
            if (board[0][0] != ' ')
               return false;
            break;   
         case 1:
            if (board[0][1] != ' ')
               return false;
            break;
         case 2:
            if (board[0][2] != ' ')
               return false;
            break;
         case 3:
            if (board[1][0] != ' ')
               return false;
            break;
         case 4:
            if (board[1][1] != ' ')
               return false;
            break;
         case 5:
            if (board[1][2] != ' ')
               return false;
            break;
         case 6:
            if (board[2][0] != ' ')
               return false;
            break;
         case 7:
            if (board[2][1] != ' ')
               return false;
            break;
         case 8:
            if (board[2][2] != ' ')
               return false;
      }
      return true; // Only if spot is empty
   }
   
   // Makes my life easier
   public static void setSpot(int num, char spot, char board[][])
   {
      switch (num)
      {
         case 0:
            board[0][0] = spot;
            break;   
         case 1:
            board[0][1] = spot;
            break; 
         case 2:
            board[0][2] = spot;
            break; 
         case 3:
            board[1][0] = spot;
            break; 
         case 4:
            board[1][1] = spot;
            break; 
         case 5:
            board[1][2] = spot;
            break; 
         case 6:
            board[2][0] = spot;
            break; 
         case 7:
            board[2][1] = spot;
            break; 
         case 8:
            board[2][2] = spot; 
      }
   }
}
