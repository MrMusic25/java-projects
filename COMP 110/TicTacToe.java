import java.util.Scanner;
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
         if(checkWin(board,'O'))
        {
            displayBoard(board);
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
      } while (!spotIsEmpty(spot - 1,board)||spot>9||spot<1);
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
      int j = 0, k;
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
        setSpot(checkForWinOpportunity(board),'X',board);    
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
   
   public static int checkForWinOpportunity(char board[][]){
       
       boolean firstRound=true;
       int[] sums = new int[8];
       int[][] value = new int[3][3];
       for(int i=0;i<3;i++)//we assign a value in each box
         for(int j=0;j<3;++j)
            if(board[i][j]=='O'){//-3 if it has an O
                value[i][j]=-3;
                firstRound=false;
            }else if(board[i][j]=='X'){//1 id it has an X
                value[i][j]=1;
                firstRound=false;
            }else value[i][j]=0;//0 if it is empty
       int max=0;//max(0-8) is the int that tells the computer which box it should pick
       if(firstRound){//if it is the first round computer picks a spot at random
           max=(int) Math.floor(Math.random() * 9);
       }else {//we calculate the sum of every row,column and diagonal
       //the higher the sum, the more Xs are already there
       //so it is better for the computer to place its X in that row/column/diagonal
       sums[0]=value[0][0]+value[0][1]+value[0][2];
       sums[1]=value[1][0]+value[1][1]+value[1][2];
       sums[2]=value[2][0]+value[2][1]+value[2][2];
       sums[3]=value[0][0]+value[1][0]+value[2][0];
       sums[4]=value[0][1]+value[1][1]+value[2][1];
       sums[5]=value[0][2]+value[1][2]+value[2][2];
       sums[6]=value[0][0]+value[1][1]+value[2][2];
       sums[7]=value[0][2]+value[1][1]+value[2][0];
       
       int i=1;
       while(i<8){
           if(sums[i]>=sums[max]) max=i;
           i++;
       }//max now has the row/column/diagonal id, but each of those has three boxes
       max=Choose(max,board);
       if(max==-1){//if there were no empty remaning boxes we pick one at random
           do{
               max=(int) Math.floor(Math.random() * 9);
           }while(!spotIsEmpty(max,board));
       }
       }
       return max;
   }   
   
   //Choose helps us find the specific box that the computer should pick
   public static int Choose(int max, char board[][]){
        int[][] array = new int[3][2];
       switch (max)//max is the "id" of the row/column/diagonal that we have chosen
      {//array holds the id of each box contained in the row/column/diagonal
           //each row is two numbers that indicate that
         case 0:
            array[0][0]=0;
            array[0][1]=0;//e.g. array's first row =0 0 ->box id =0 => the first box 
            array[1][0]=0;
            array[1][1]=1;
            array[2][0]=0;
            array[2][1]=2;
            break;   
         case 1:
            array[0][0]=1;
            array[0][1]=0;
            array[1][0]=1;
            array[1][1]=1;
            array[2][0]=1;
            array[2][1]=2;
            break; 
         case 2:
            array[0][0]=2;
            array[0][1]=0;
            array[1][0]=2;
            array[1][1]=1;
            array[2][0]=2;
            array[2][1]=2;
            break; 
         case 3:
            array[0][0]=0;
            array[0][1]=0;
            array[1][0]=1;
            array[1][1]=0;
            array[2][0]=2;
            array[2][1]=0;
            break; 
         case 4:
            array[0][0]=0;
            array[0][1]=1;
            array[1][0]=1;
            array[1][1]=1;
            array[2][0]=2;
            array[2][1]=1;
            break; 
         case 5:
            array[0][0]=0;
            array[0][1]=2;
            array[1][0]=1;
            array[1][1]=2;
            array[2][0]=2;
            array[2][1]=2;
            break; 
         case 6:
            array[0][0]=0;
            array[0][1]=0;
            array[1][0]=1;
            array[1][1]=1;
            array[2][0]=2;
            array[2][1]=2;
            break; 
         case 7:
            array[0][0]=0;
            array[0][1]=2;
            array[1][0]=1;
            array[1][1]=1;
            array[2][0]=2;
            array[2][1]=0;
            break; 
      }
       boolean error=true;//error will indicate if there are no empty boxes left where we looked
       int[] choice={0,0};
       for (int i=0; i<3;i++){
           if(board[array[i][0]][array[i][1]]==' ') {
               choice[0]=array[i][0];
               choice[1]=array[i][1];
               error=false;//if we find at least one empty box we have avoided the error
           }
       }       
       int box;
       if(error){
           box=-1;//we use a negative number because such box id does not exist
       }else{box = choice[0]*3+choice[1];}
       //we translate the choice array to an actual number which is the id of the box 
       return box;
   }
}
