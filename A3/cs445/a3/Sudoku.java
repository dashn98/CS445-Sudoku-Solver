
package cs445.a3;
import java.util.List;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.lang.*;
public class Sudoku {
     private static int r;
     private static int c;
    static boolean isFullSolution(int[][] board) {
        boolean correct = true;
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] == 0)
                {
                    correct = false;
                    i = board.length;
                    j = board[0].length;
                }
            }
        }
        return correct;
    }

    static boolean checkRow(int[]board)
    {
        boolean reject = false;
        int rowEmpty = 0;
        int row1 = 0;
        int row2 = 0;
        int row3 = 0;
        int row4 = 0;
        int row5 = 0;
        int row6 = 0;
        int row7 = 0;
        int row8 = 0;
        int row9 = 0;
        for(int i = 0; i < board.length; i++)
        {
            if(board[i] == 0)
            {
                rowEmpty++;
            }
             else if(board[i] == 1)
            {
                row1++;
            }
            else if(board[i] == 2)
            {
                row2++;
            }
            else if(board[i] == 3)
            {
                row3++;
            }
             else if(board[i] == 4)
            {
                row4++;
            }
            else if(board[i] == 5)
            {
                row5++;
            }
             else if(board[i] == 6)
            {
                row6++;
            }
            else if(board[i] == 7)
            {
                row7++;
            }
             else if(board[i] == 8)
            {
                row8++;
            }
            else if(board[i] == 9)
            {
                row9++;
            }
            else
            {
                reject = true;
            }
        }
        if(row1 > 1 || row2 > 1 || row3 > 1 || row4 > 1 || row5> 1 || row6 > 1 || row7>1 || row8 > 1 || row9> 1)
        {
            reject = true;
        }
        return reject;
    }
    static boolean checkCol(int col, int[][]board)
    {
        boolean reject = false;
        int colEmpty = 0;
        int col1 = 0;
        int col2 = 0;
        int col3 = 0;
        int col4 = 0;
        int col5 = 0;
        int col6 = 0;
        int col7 = 0;
        int col8 = 0;
        int col9 = 0;
        for(int i = 0; i < board.length; i++)
        {
            if(board[i][col] == 0)
            {   
                colEmpty++;
            }
            else if(board[i][col] == 1)
            {
                col1++;
            }
            else if(board[i][col] == 2)
            {
                col2++;
            }
            else if(board[i][col] == 3)
            {
                col3++;
            }
             else if(board[i][col] == 4)
            {
                col4++;
            }
            else if(board[i][col] == 5)
            {
                col5++;
            }
             else if(board[i][col] == 6)
            {
                col6++;
            }
            else if(board[i][col] == 7)
            {
                col7++;
            }
             else if(board[i][col] == 8)
            {
                col8++;
            }
            else if(board[i][col] == 9)
            {
                col9++;
            }
            else
            {
                reject = true;
            }
        }
          if(col1 > 1 || col2 > 1 || col3 > 1 || col4 > 1 || col5> 1 || col6 > 1 || col7>1 || col8 > 1 || col9> 1)
        {
            reject = true;
        }
        return reject;
    }
    static boolean checkBox(int row, int col, int[][] board)
    {
        boolean reject = false;
        int boxEmpty = 0;
        int box1 = 0;
        int box2 = 0;
        int box3 = 0;
        int box4 = 0;
        int box5 = 0;
        int box6 = 0;
        int box7 = 0;
        int box8 = 0;
        int box9 = 0;
        int i = 0;
        int j = 0;
        i = (row/3) * 3;
        j = (col/3) * 3;
        for(int k = 0; k < 3; k++)
        {
            for(int m = 0; m < 3; m++)
            {    
                if(board[k+i][m+j]==0)
                {   
                    boxEmpty++;
                }
                else if(board[k+i][m+j] == 1)
                {
                    box1++;
                }
                else if(board[k+i][m+j] == 2)
                {
                    box2++;
                }
                else if(board[k+i][m+j] == 3)
                {
                    box3++;
                }
                else if(board[k+i][m+j] == 4)
                {
                    box4++;
                }   
                else if(board[k+i][m+j] == 5)
                {
                    box5++;
                }
                else if(board[k+i][m+j] == 6)
                {
                    box6++;
                }
                else if(board[k+i][m+j] == 7)
                {
                    box7++;
                }
                else if(board[k+i][m+j] == 8)
                {
                    box8++;
                }
                else if(board[k+i][m+j] == 9)
                {
                    box9++;
                }
                else
                {
                    reject = true;
                }
            }
        }
           if(box1 > 1 || box2 > 1 || box3 > 1 || box4 > 1 || box5> 1 || box6 > 1 || box7>1 || box8 > 1 || box9> 1)
        {
            reject = true;
        }
        return reject;
    }
    static boolean reject(int[][] board)
    {
        boolean reject = false;
        for(int i = 0; i < board.length; i++)
        {
            if(checkRow(board[i]) == true)
            {
               reject = true;
            }
        }
        for(int j = 0; j < board[0].length; j++)
        {
            if (checkCol(j, board) == true)
            {
                    reject = true;
            }
        }
        for(int i = 0; i < 9; i+=3)
        {
            for(int j = 0; j < 9; j+=3)
            {
                if (checkBox(i, j, board) == true)
                {
                    reject = true;
                }
            }
        }  
        return reject;
    }
    
    static int[][] extend(int[][] board) {
        int [][] newBoard = new int[board.length][board[0].length];     
        int counter = 0;
        for(int i = 0; i < board.length; i++)
        {
           for(int j = 0; j < board[0].length; j++)
           {
               newBoard[i][j] = board[i][j];
           }
        }
           for(int i = 0; i < board.length; i++)
        {
           for(int j = 0; j < board[0].length; j++)
           {
               if(newBoard[i][j] != 0)
               {
                   counter++;
                }
           }
        }
        if(counter == 81)
        {
            return null;
        }
        for(int i = 0; i < board.length; i++)
        {
           for(int j = 0; j < board[0].length; j++)
           {
               if( board[i][j] == 0 )
               {
                   newBoard[i][j] = 1;
                   r = i;
                   c = j;
                   i = board.length;
                   j = board[0].length;
               }
            }
        }
        return newBoard;
    }

    static int[][] next(int[][] board, int rLocal, int cLocal) {
     int [][] newBoard = new int [9][9];
     for(int i = 0; i < board.length; i++)
     {
       for(int j = 0; j < board[0].length; j++)
       {
               newBoard[i][j] = board[i][j];
       }
     }
     if(newBoard[rLocal][cLocal] < 9)
     {
            newBoard[rLocal][cLocal] += 1 ;  
     }
     else
     {
            return null;
     }  
        return newBoard;
    }

    static void testIsFullSolution() {
         int[][] testOne =  {{1,2,3, 4, 5, 6 ,7, 8, 9},
                              {0,0,0, 0, 0, 0, 0, 0, 0},
                              {0,0,0, 0, 0, 0, 0, 0, 0},
                              {0,0,0, 0, 0, 0, 0, 0, 0},
                              {0,0,0, 0, 0, 0, 0, 0, 0},
                              {0,0,0, 0, 0, 0, 0, 0, 0},
                              {0,0,0, 0, 0, 0, 0, 0, 0},
                              {0,0,0, 0, 0, 0, 0, 0, 0},
                              {0,0,0, 0, 0, 0, 0, 0, 0}}; //Only one row filled
         int[][] testTwo =  {{2,9,6, 3, 1, 8 ,5, 7, 4}, 
                             {5,8,4, 9, 7, 2, 6, 1, 3},
                             {7, 1, 3, 6, 4, 5, 2, 8, 9},
                             {6, 2, 5, 8, 9, 7, 3, 4, 1},
                             {9, 3, 1, 4, 2, 6, 8, 5, 7},
                             {4, 7, 8, 5, 3, 1, 9, 2, 6},
                             {1, 6, 7, 2, 5, 3, 4, 9, 8},
                             {8,  5, 9, 7, 6, 4, 1, 3, 2},
                             {3, 4, 2, 1, 8, 9, 7, 6, 0}}; //Missing only one element
         int[][] testThree =  {{2,0,6, 3, 1, 8 ,5, 7, 4}, 
                              {5,8,4, 9, 7, 2, 6, 1, 3},
                              {7, 1, 3, 6, 4, 5, 2, 8, 9},
                              {6, 2, 5, 8, 9, 7, 3, 4, 1}, 
                              {9, 3, 1, 4, 2, 6, 8, 5, 7},
                              {4, 7, 8, 5, 3, 1, 9, 2, 6},
                              {1, 6, 7, 2, 5, 3, 4, 9, 8},
                              {8,  5, 9, 7, 6, 4, 1, 3, 2},
                              {3, 4, 2, 1, 8, 9, 7, 6, 0}}; //mising two scattered elements
          
         int[][] testFour =  {{0,0,0, 0, 0, 0 ,0, 0, 0},
                             {0,0,0, 0, 0, 0, 0, 0, 0},
                             {0,0,0, 0, 0, 0, 0, 0, 0},
                             {0,0,0, 0, 0, 0, 0, 0, 0},
                             {0,0,0, 0, 0, 0, 0, 0, 0},
                             {0,0,0, 0, 0, 0, 0, 0, 0},
                             {0,0,0, 0, 0, 0, 0, 0, 0},
                             {0,0,0, 0, 0, 0, 0, 0, 0},
                             {0,0,0, 0, 0, 0, 0, 0, 0}}; //empty board
         int[][] testFive = {{2,9,6, 3, 1, 8 ,5, 7, 4}, 
                             {5,8,4, 9, 7, 2, 6, 1, 3},
                             {7, 1, 3, 6, 4, 5, 2, 8, 9},
                             {6, 2, 5, 8, 9, 7, 3, 4, 1},
                             {9, 3, 1, 0, 2, 6, 8, 5, 7},
                             {4, 7, 8, 5, 3, 1, 9, 2, 6},
                             {1, 6, 7, 2, 5, 3, 4, 9, 8},
                             {8,  5, 9, 7, 6, 4, 1, 3, 2},
                             {3, 4, 2, 1, 8, 9, 7, 6, 5}};//missing only one element
         int[][] trivial = {{3, 0, 0, 7, 9, 4, 2, 5, 0},
                            {2, 0, 0, 5, 6, 0, 1, 9, 7},
                            {7, 9, 0, 8, 2, 0, 4, 0, 3},
                            {0, 2, 0, 0, 7, 8, 0, 4, 1},
                            {5, 7, 0, 1, 0, 6, 0, 8, 2},
                            {1, 4, 8, 3, 0, 2, 9, 7, 6},
                            {9, 0, 7, 0, 8, 5, 6, 0, 4},
                            {4, 5, 2, 6, 0, 7, 8, 3, 9},
                            {0, 1, 6, 4, 3, 9, 7, 0, 5}};
         int[][] easy = {{0, 0, 2, 6, 8, 0, 3, 4, 7},
                        {6, 0, 0, 0, 0, 0, 5, 0, 0},
                        {4, 0, 9, 0, 0, 0, 0, 8, 0},
                        {0, 0, 0, 0, 9, 3, 7, 6, 0},
                        {0, 5, 0, 1, 0, 6, 0, 9, 0},
                        {0, 9, 6, 8, 7, 0, 0, 0, 0},
                        {0, 8, 0, 0, 0, 0, 9, 0, 3},
                        {0, 0, 7, 0, 0, 0, 0, 0, 4},
                        {3, 6, 5, 0, 1, 4, 2, 0, 0}};
         int[][] medium = {{4, 0, 0, 0, 0, 2, 8, 0, 0},
                           {0, 0, 0, 0, 9, 8, 0, 0, 1},
                           {3, 0, 0, 7, 0, 0, 0, 2, 6},
                           {0, 4, 9, 5, 0, 3, 0, 0, 8},
                           {0, 0, 0, 0, 2, 0, 0, 0, 0},
                           {6, 0, 0, 8, 0, 1, 9, 3, 0},
                           {5, 7, 0, 0, 0, 9, 0, 0, 2},
                           {9, 0, 0, 1, 6, 0, 0, 0, 0},
                           {0, 0, 6, 2, 0, 0, 0, 0, 9}};
         int[][] hard = {{0, 1, 0, 0, 0, 0, 0, 7, 0},
                         {0, 4, 6, 0, 0, 5, 2, 0, 0},
                         {0, 8, 0, 1, 0, 0, 0, 0, 3},
                         {0, 0, 0, 0, 1, 3, 4, 0, 6},
                         {0, 0, 0, 0, 7, 0, 0, 0, 0},
                         {1, 0, 4, 9, 5, 0, 0, 0, 0},
                         {3, 0, 0, 0, 0, 8, 0, 4, 0},
                         {0, 0, 8, 7, 0, 0, 1, 2, 0},
                         {0, 7, 0, 0, 0, 0, 0, 9, 0}};
         int[][] evil = {{4, 0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 6, 0, 2, 3, 8, 0},
                         {0, 0, 2, 0, 0, 8, 0, 5, 0},
                         {2, 0, 0, 0, 0, 0, 5, 4, 0},
                         {0, 0, 5, 0, 7, 0, 6, 0, 0},
                         {0, 3, 9, 0, 0, 0, 0, 0, 1},
                         {0, 6, 0, 8, 0, 0, 2, 0, 0},
                         {0, 7, 4, 9, 0, 6, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0, 5}};
 
       System.out.println("isFullSolution tests that should return false: ");
       System.out.println("Test 1 " + isFullSolution(testOne));
       System.out.println("Test 2 " + isFullSolution(testTwo));
       System.out.println("Test 3 " + isFullSolution(testThree));
       System.out.println("Test 4 " + isFullSolution(testFour));
       System.out.println("Test 5 " + isFullSolution(testFive));
       System.out.println("Trivial Test: " + isFullSolution(trivial));
       System.out.println("Easy Test: " + isFullSolution(easy));
       System.out.println("Medium Test: " + isFullSolution(medium));
       System.out.println("Hard Test: " + isFullSolution(hard));
       System.out.println("Evil Test: " + isFullSolution(evil));
       int[][] testSix = {{2,9,6, 3, 1, 8 ,5, 7, 4}, 
                           {5,8,4, 9, 7, 2, 6, 1, 3},
                           {7, 1, 3, 6, 4, 5, 2, 8, 9},
                           {6, 2, 5, 8, 9, 7, 3, 4, 1},
                           {9, 3, 1, 4, 2, 6, 8, 5, 7},
                           {4, 7, 8, 5, 3, 1, 9, 2, 6},
                           {1, 6, 7, 2, 5, 3, 4, 9, 8},
                           {8,  5, 9, 7, 6, 4, 1, 3, 2},
                           {3, 4, 2, 1, 8, 9, 7, 6, 5}}; //full board
       int[][]testSeven = {{5, 1, 2, 6, 8, 9, 3, 4, 7}, 
                         {6, 7, 8, 4, 3, 1, 5, 2, 9}, 
                         {4, 3, 9, 5, 2, 7, 1, 8, 6}, 
                         {8, 4, 1, 2, 9, 3, 7, 6, 5},
                         {7, 5, 3, 1, 4, 6, 8, 9, 2}, 
                         {2, 9, 6, 8, 7, 5, 4, 3, 1}, 
                         {1, 8, 4, 7, 6, 2, 9, 5, 3}, 
                         {9, 2, 7, 3, 5, 8, 6, 1, 4}, 
                         {3, 6, 5, 9, 1, 4, 2, 7, 8}}; //full board
       int[][]testEight =  {{1, 1, 1, 1, 1, 1, 1, 1, 1}, 
                          {1, 1, 1, 1, 1, 1, 1, 1, 1},
                          {1, 1, 1, 1, 1, 1, 1, 1, 1},
                          {1, 1, 1, 1, 1, 1, 1, 1, 1},
                          {1, 1, 1, 1, 1, 1, 1, 1, 1},
                          {1, 1, 1, 1, 1, 1, 1, 1, 1},
                          {1, 1, 1, 1, 1, 1, 1, 1, 1},
                          {1, 1, 1, 1, 1, 1, 1, 1, 1},
                          {1, 1, 1, 1, 1, 1, 1, 1, 1}};//full board w/ duplicates
       System.out.println("isFullSolution tests that should return true: ");
       System.out.println("Test 6 " + isFullSolution(testSix));
       System.out.println("Test 7 " + isFullSolution(testSeven));
       System.out.println("Test 8 " + isFullSolution(testEight));
       System.out.println();
       int[][]random = new int[9][9];
       for(int i = 0; i < random.length; i++)
       {
           for(int j = 0; j < random[0].length; j++)
           {
               random[i][j] = (int)(Math.random()*9.0);
           }
       }
       printBoard(random);
       System.out.println("Random Test " + isFullSolution(random));
    }

    static void testReject() {
       int[][] testOne =  {{1,2,3, 4, 5, 6 ,7, 8,9}, 
                           {0,0,0, 0, 0, 0, 0, 0, 0},
                           {0,0,0, 0, 0, 0, 0, 0, 0},
                           {0,0,0, 0, 0, 0, 0, 0, 0}, 
                           {0,0,0, 0, 0, 0, 0, 0, 0},
                           {0,0,0, 0, 0, 0, 0, 0, 0},
                           {0,0,0, 0, 0, 0, 0, 0, 0},
                           {0,0,0, 0, 0, 0, 0, 0, 0},
                           {0,0,0, 0, 0, 0, 0, 0, 0}}; //One row filled, no duplicates
       int[][] testTwo = {{5, 1, 2, 6, 8, 9, 3, 4, 7}, 
                         {6, 7, 8, 4, 3, 1, 5, 2, 9}, 
                         {4, 3, 9, 5, 2, 7, 1, 8, 6}, 
                         {8, 4, 1, 2, 9, 3, 7, 6, 5},
                         {7, 5, 3, 1, 4, 6, 8, 9, 2}, 
                         {2, 9, 6, 8, 7, 5, 4, 3, 1}, 
                         {1, 8, 4, 7, 6, 2, 9, 5, 3}, 
                         {9, 2, 7, 3, 5, 8, 6, 1, 4}, 
                         {3, 6, 5, 9, 1, 4, 2, 7, 8}};//Full board no duplicates
       int[][] testThree = {{8, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 3, 6, 0, 0, 0, 0, 0},
                            {0, 7, 0, 0, 9, 0, 2, 0, 0},
                            {0, 5, 0, 0, 0, 7, 0, 0, 0},
                            {0, 0, 0, 0, 4, 5, 7, 0, 0},
                            {0, 0, 0, 1, 0, 0, 0, 3, 0},
                            {0, 0, 1, 0, 0, 0, 0, 6, 8},
                            {0, 0, 8, 5, 0, 0, 0, 1, 0},
                            {0, 9, 0, 0, 0, 0, 4, 0, 0}};//Solvable board no dups
       int[][] trivial = {{3, 0, 0, 7, 9, 4, 2, 5, 0},
                            {2, 0, 0, 5, 6, 0, 1, 9, 7},
                            {7, 9, 0, 8, 2, 0, 4, 0, 3},
                            {0, 2, 0, 0, 7, 8, 0, 4, 1},
                            {5, 7, 0, 1, 0, 6, 0, 8, 2},
                            {1, 4, 8, 3, 0, 2, 9, 7, 6},
                            {9, 0, 7, 0, 8, 5, 6, 0, 4},
                            {4, 5, 2, 6, 0, 7, 8, 3, 9},
                            {0, 1, 6, 4, 3, 9, 7, 0, 5}};
         int[][] easy = {{0, 0, 2, 6, 8, 0, 3, 4, 7},
                        {6, 0, 0, 0, 0, 0, 5, 0, 0},
                        {4, 0, 9, 0, 0, 0, 0, 8, 0},
                        {0, 0, 0, 0, 9, 3, 7, 6, 0},
                        {0, 5, 0, 1, 0, 6, 0, 9, 0},
                        {0, 9, 6, 8, 7, 0, 0, 0, 0},
                        {0, 8, 0, 0, 0, 0, 9, 0, 3},
                        {0, 0, 7, 0, 0, 0, 0, 0, 4},
                        {3, 6, 5, 0, 1, 4, 2, 0, 0}};
         int[][] medium = {{4, 0, 0, 0, 0, 2, 8, 0, 0},
                           {0, 0, 0, 0, 9, 8, 0, 0, 1},
                           {3, 0, 0, 7, 0, 0, 0, 2, 6},
                           {0, 4, 9, 5, 0, 3, 0, 0, 8},
                           {0, 0, 0, 0, 2, 0, 0, 0, 0},
                           {6, 0, 0, 8, 0, 1, 9, 3, 0},
                           {5, 7, 0, 0, 0, 9, 0, 0, 2},
                           {9, 0, 0, 1, 6, 0, 0, 0, 0},
                           {0, 0, 6, 2, 0, 0, 0, 0, 9}};
         int[][] hard = {{0, 1, 0, 0, 0, 0, 0, 7, 0},
                         {0, 4, 6, 0, 0, 5, 2, 0, 0},
                         {0, 8, 0, 1, 0, 0, 0, 0, 3},
                         {0, 0, 0, 0, 1, 3, 4, 0, 6},
                         {0, 0, 0, 0, 7, 0, 0, 0, 0},
                         {1, 0, 4, 9, 5, 0, 0, 0, 0},
                         {3, 0, 0, 0, 0, 8, 0, 4, 0},
                         {0, 0, 8, 7, 0, 0, 1, 2, 0},
                         {0, 7, 0, 0, 0, 0, 0, 9, 0}};
         int[][] evil = {{4, 0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 6, 0, 2, 3, 8, 0},
                         {0, 0, 2, 0, 0, 8, 0, 5, 0},
                         {2, 0, 0, 0, 0, 0, 5, 4, 0},
                         {0, 0, 5, 0, 7, 0, 6, 0, 0},
                         {0, 3, 9, 0, 0, 0, 0, 0, 1},
                         {0, 6, 0, 8, 0, 0, 2, 0, 0},
                         {0, 7, 4, 9, 0, 6, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0, 5}};
       System.out.println("Reject tests that should return false: ");
       System.out.println("Test 1: " + reject(testOne));
       System.out.println("Test 2: " + reject(testTwo));
       System.out.println("Test 3: " + reject(testThree));
       System.out.println("Trivial Test: " + reject(trivial));
       System.out.println("Easy Test: " + reject(easy));
       System.out.println("Medium Test: " + reject(medium));
       System.out.println("Hard Test: " + reject(hard));
       System.out.println("Evil Test: " + reject(evil));
       int[][] testFour =  {{1,1,3, 4, 5, 6 ,7, 8,9}, 
                           {0,0,0, 0, 0, 0, 0, 0, 0},
                           {0,0,0, 0, 0, 0, 0, 0, 0},
                           {0,0,0, 0, 0, 0, 0, 0, 0}, 
                           {0,0,0, 0, 0, 0, 0, 0, 0},
                           {0,0,0, 0, 0, 0, 0, 0, 0},
                           {0,0,0, 0, 0, 0, 0, 0, 0},
                           {0,0,0, 0, 0, 0, 0, 0, 0},
                           {0,0,0, 0, 0, 0, 0, 0, 0}}; //Two ones in first row
             
       int[][] testFive =  {{1,2,3, 4, 5, 6 ,7, 8,9}, 
                            {0,0,0, 0, 0, 0, 0, 0, 9},
                            {0,0,0, 0, 0, 0, 0, 0, 0},
                            {0,0,0, 0, 0, 0, 0, 0, 0}, 
                            {0,0,0, 0, 0, 0, 0, 0, 0},
                            {0,0,0, 0, 0, 0, 0, 0, 0},
                            {0,0,0, 0, 0, 0, 0, 0, 0},
                            {0,0,0, 0, 0, 0, 0, 0, 0},
                            {0,0,0, 0, 0, 0, 0, 0, 0}}; //Two nines in last column
       int[][] testSix = {{5, 1, 2, 6, 8, 9, 5, 4, 7}, 
                         {6, 7, 8, 4, 3, 1, 5, 2, 9}, 
                         {4, 3, 9, 5, 2, 7, 1, 8, 6}, 
                         {8, 4, 1, 2, 9, 3, 7, 6, 5},
                         {7, 5, 3, 1, 4, 6, 8, 9, 2}, 
                         {2, 9, 6, 8, 7, 5, 4, 3, 1}, 
                         {1, 8, 4, 7, 6, 2, 9, 5, 3}, 
                         {9, 2, 7, 3, 5, 8, 6, 1, 4}, 
                         {3, 6, 5, 9, 1, 4, 2, 7, 8}}; //Full board, duplicate in 7th column
       int[][]testSeven ={{5, 1, 2, 6, 8, 9, 5, 4, 7}, 
                         {6, 7, 8, 4, 3, 1, 5, 2, 9}, 
                         {4, 3, 9, 5, 2, 7, 1, 8, 6}, 
                         {8, 4, 1, 2, 9, 3, 7, 6, 5},
                         {7, 5, 3, 1, 5, 6, 8, 9, 2}, 
                         {2, 9, 6, 8, 7, 5, 4, 3, 1}, 
                         {1, 8, 4, 7, 6, 2, 9, 5, 3}, 
                         {9, 2, 7, 3, 5, 8, 6, 1, 4}, 
                         {3, 6, 5, 9, 1, 4, 2, 7, 8}};//Full board duplicate in 4th row
       System.out.println("Reject tests that should return true: ");
       System.out.println("Test 4: " + reject(testFour));
       System.out.println("Test 5: " + reject(testFive));
       System.out.println("Test 6: " + reject(testSix));
       System.out.println("Test 7: " + reject(testSeven));
        System.out.println();
         int[][]random = new int[9][9];
       for(int i = 0; i < random.length; i++)
       {
           for(int j = 0; j < random[0].length; j++)
           {
               random[i][j] = (int)(Math.random()*9.0);
           }
       }
       printBoard(random);
       System.out.println("Random Test " + reject(random));
    }

    static void testExtend() {
      int[][] testOne =  {{1,2,3, 4, 5, 6 ,7, 8,9}, 
                          {0,0,0, 0, 0, 0, 0, 0, 0},
                          {0,0,0, 0, 0, 0, 0, 0, 0},
                          {0,0,0, 0, 0, 0, 0, 0, 0}, 
                          {0,0,0, 0, 0, 0, 0, 0, 0},
                          {0,0,0, 0, 0, 0, 0, 0, 0},
                          {0,0,0, 0, 0, 0, 0, 0, 0},
                          {0,0,0, 0, 0, 0, 0, 0, 0},
                          {0,0,0, 0, 0, 0, 0, 0, 0}}; //first row filled
      int[][] testTwo =  {{0,0,0, 0, 0, 0, 0, 0, 0}, 
                          {0,0,0, 0, 0, 0, 0, 0, 0},
                          {0,0,0, 0, 0, 0, 0, 0, 0},
                          {0,0,0, 0, 0, 0, 0, 0, 0}, 
                          {0,0,0, 0, 0, 0, 0, 0, 0},
                          {0,0,0, 0, 0, 0, 0, 0, 0},
                          {0,0,0, 0, 0, 0, 0, 0, 0},
                          {0,0,0, 0, 0, 0, 0, 0, 0},
                          {0,0,0, 0, 0, 0, 0, 0, 0}};//empty board    
       int[][] testThree = {{2, 9, 6, 3, 1, 8 ,5, 7, 4}, 
                          {5, 8, 4, 9, 7, 2, 6, 1, 3},
                          {7, 1, 3, 6, 4, 5, 2, 8, 9},
                          {6, 2, 5, 8, 9, 7, 3, 4, 1},
                          {9, 3, 1, 4, 2, 6, 8, 5, 7},
                          {4, 7, 8, 5, 3, 1, 9, 2, 6},
                          {1, 6, 7, 2, 5, 3, 4, 9, 8},
                          {8,  5, 9, 7, 6, 4, 1, 3, 2},
                          {3, 4, 2, 1, 8, 9, 7, 6, 0}};//only one possible extension
       int[][] testFour = {{2, 9, 6, 3, 1, 8 ,5, 7, 4}, 
                          {5, 0, 4, 9, 7, 2, 6, 1, 3},
                          {7, 1, 3, 6, 4, 5, 2, 8, 9},
                          {6, 2, 5, 8, 9, 7, 3, 4, 1},
                          {9, 3, 1, 0, 2, 6, 8, 5, 7},
                          {4, 7, 8, 5, 3, 0, 9, 2, 6},
                          {1, 6, 0, 2, 5, 3, 4, 9, 8},
                          {8,  5, 9, 7, 6, 4, 1, 3, 2},
                          {3, 4, 2, 1, 8, 9, 7, 6, 0}};//multiple places to extend
      int[][]testFive = {{8, 0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 3, 6, 0, 0, 0, 0, 0},
                         {0, 7, 0, 0, 9, 0, 2, 0, 0},
                         {0, 5, 0, 0, 0, 7, 0, 0, 0},
                         {0, 0, 0, 0, 4, 5, 7, 0, 0},
                         {0, 0, 0, 1, 0, 0, 0, 3, 0},
                         {0, 0, 1, 0, 0, 0, 0, 6, 8},
                         {0, 0, 8, 5, 0, 0, 0, 1, 0},
                         {0, 9, 0, 0, 0, 0, 4, 0, 0}};//multiple empty spots
      int[][]testSix = {{2, 9, 6, 3, 1, 8 ,5, 7, 4}, 
                        {5, 8, 4, 9, 7, 2, 6, 1, 3},
                        {7, 1, 3, 6, 4, 5, 2, 8, 9},
                        {6, 2, 5, 8, 9, 7, 3, 4, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0}};//half empty
      int[][] trivial = {{3, 0, 0, 7, 9, 4, 2, 5, 0},
                         {2, 0, 0, 5, 6, 0, 1, 9, 7},
                         {7, 9, 0, 8, 2, 0, 4, 0, 3},
                         {0, 2, 0, 0, 7, 8, 0, 4, 1},
                         {5, 7, 0, 1, 0, 6, 0, 8, 2},
                         {1, 4, 8, 3, 0, 2, 9, 7, 6},
                         {9, 0, 7, 0, 8, 5, 6, 0, 4},
                         {4, 5, 2, 6, 0, 7, 8, 3, 9},
                         {0, 1, 6, 4, 3, 9, 7, 0, 5}};
         int[][] easy = {{0, 0, 2, 6, 8, 0, 3, 4, 7},
                        {6, 0, 0, 0, 0, 0, 5, 0, 0},
                        {4, 0, 9, 0, 0, 0, 0, 8, 0},
                        {0, 0, 0, 0, 9, 3, 7, 6, 0},
                        {0, 5, 0, 1, 0, 6, 0, 9, 0},
                        {0, 9, 6, 8, 7, 0, 0, 0, 0},
                        {0, 8, 0, 0, 0, 0, 9, 0, 3},
                        {0, 0, 7, 0, 0, 0, 0, 0, 4},
                        {3, 6, 5, 0, 1, 4, 2, 0, 0}};
         int[][] medium = {{4, 0, 0, 0, 0, 2, 8, 0, 0},
                           {0, 0, 0, 0, 9, 8, 0, 0, 1},
                           {3, 0, 0, 7, 0, 0, 0, 2, 6},
                           {0, 4, 9, 5, 0, 3, 0, 0, 8},
                           {0, 0, 0, 0, 2, 0, 0, 0, 0},
                           {6, 0, 0, 8, 0, 1, 9, 3, 0},
                           {5, 7, 0, 0, 0, 9, 0, 0, 2},
                           {9, 0, 0, 1, 6, 0, 0, 0, 0},
                           {0, 0, 6, 2, 0, 0, 0, 0, 9}};
         int[][] hard = {{0, 1, 0, 0, 0, 0, 0, 7, 0},
                         {0, 4, 6, 0, 0, 5, 2, 0, 0},
                         {0, 8, 0, 1, 0, 0, 0, 0, 3},
                         {0, 0, 0, 0, 1, 3, 4, 0, 6},
                         {0, 0, 0, 0, 7, 0, 0, 0, 0},
                         {1, 0, 4, 9, 5, 0, 0, 0, 0},
                         {3, 0, 0, 0, 0, 8, 0, 4, 0},
                         {0, 0, 8, 7, 0, 0, 1, 2, 0},
                         {0, 7, 0, 0, 0, 0, 0, 9, 0}};
         int[][] evil = {{4, 0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 6, 0, 2, 3, 8, 0},
                         {0, 0, 2, 0, 0, 8, 0, 5, 0},
                         {2, 0, 0, 0, 0, 0, 5, 4, 0},
                         {0, 0, 5, 0, 7, 0, 6, 0, 0},
                         {0, 3, 9, 0, 0, 0, 0, 0, 1},
                         {0, 6, 0, 8, 0, 0, 2, 0, 0},
                         {0, 7, 4, 9, 0, 6, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0, 5}};
       System.out.println("Boards that can extend: ");
       System.out.println("Test 1: ");
       printBoard(extend(testOne));
       System.out.println("Test 2: ");
       printBoard(extend(testTwo));
       System.out.println("Test 3: ");
       printBoard(extend(testThree));
       System.out.println("Test 4: ");
       printBoard(extend(testFour));
       System.out.println("Test 5: ");
       printBoard(extend(testFive));
       System.out.println("Test 6: ");
       printBoard(extend(testSix));
       System.out.println("Trivial Test: ");
       printBoard(extend(trivial));
       System.out.println("Easy Test ");
       printBoard(extend(easy));
       System.out.println("Medium Test: ");
       printBoard(extend(medium));
       System.out.println("Hard Test: ");
       printBoard(extend(hard));
       System.out.println("Evil Test: ");
       printBoard(extend(evil));
       System.out.println();
       int[][]testSeven =  {{2, 9, 6, 3, 1, 8 ,5, 7, 4}, 
                          {5, 8, 4, 9, 7, 2, 6, 1, 3},
                          {7, 1, 3, 6, 4, 5, 2, 8, 9},
                          {6, 2, 5, 8, 9, 7, 3, 4, 1},
                          {9, 3, 1, 4, 2, 6, 8, 5, 7},
                          {4, 7, 8, 5, 3, 1, 9, 2, 6},
                          {1, 6, 7, 2, 5, 3, 4, 9, 8},
                          {8,  5, 9, 7, 6, 4, 1, 3, 2},
                          {3, 4, 2, 1, 8, 9, 7, 6, 5}}; //full board  
       int[][]testEight =  {{1, 1, 1, 1, 1, 1, 1, 1, 1}, 
                          {1, 1, 1, 1, 1, 1, 1, 1, 1},
                          {1, 1, 1, 1, 1, 1, 1, 1, 1},
                          {1, 1, 1, 1, 1, 1, 1, 1, 1},
                          {1, 1, 1, 1, 1, 1, 1, 1, 1},
                          {1, 1, 1, 1, 1, 1, 1, 1, 1},
                          {1, 1, 1, 1, 1, 1, 1, 1, 1},
                          {1, 1, 1, 1, 1, 1, 1, 1, 1},
                          {1, 1, 1, 1, 1, 1, 1, 1, 1}};//full board w/ duplicates
       System.out.println("Boards that are full and cannot extend: ");
       System.out.println("Test 7: ");
       printBoard(extend(testSeven));
       System.out.println("Test 8: ");
       printBoard(extend(testEight));
        System.out.println();
        int[][]random = new int[9][9];
       for(int i = 0; i < random.length; i++)
       {
           for(int j = 0; j < random[0].length; j++)
           {
               random[i][j] = (int)(Math.random()*9.0);
           }
       }
       printBoard(random);
       System.out.println("Random Test " );
       printBoard(extend(random));
    }

    static void testNext() {
       int[][] testOne = {{1,2,3, 4, 5, 6 ,7, 8,9}, 
                          {0,0,0, 0, 0, 0, 0, 0, 0},
                          {0,0,0, 0, 0, 0, 0, 0, 0},
                          {0,0,0, 0, 0, 0, 0, 0, 0}, 
                          {0,0,0, 0, 0, 0, 0, 0, 0},
                          {0,0,0, 0, 0, 0, 0, 0, 0},
                          {0,0,0, 0, 0, 0, 0, 0, 0},
                          {0,0,0, 0, 0, 0, 0, 0, 0},
                          {0,0,0, 0, 0, 0, 0, 0, 0}}; //first row filled
       int[][] testTwo = {{2, 9, 6, 3, 1, 8 ,5, 7, 4}, 
                          {5, 8, 4, 9, 7, 2, 6, 1, 3},
                          {7, 1, 3, 6, 4, 5, 2, 8, 9},
                          {6, 2, 5, 8, 9, 7, 3, 4, 1},
                          {9, 3, 1, 4, 2, 6, 8, 5, 7},
                          {4, 7, 8, 5, 3, 1, 9, 2, 6},
                          {1, 6, 7, 2, 5, 3, 4, 9, 8},
                          {8,  5, 9, 7, 6, 4, 1, 3, 2},
                          {3, 4, 2, 1, 8, 9, 7, 6, 0}};//one spot open
       int[][] testThree = {{0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                          {0,0,0, 0, 0, 0, 0, 0, 0},
                          {0,0,0, 0, 0, 0, 0, 0, 0},
                          {0,0,0, 0, 0, 0, 0, 0, 0}, 
                          {0,0,0, 0, 0, 0, 0, 0, 0},
                          {0,0,0, 0, 0, 0, 0, 0, 0},
                          {0,0,0, 0, 0, 0, 0, 0, 0},
                          {0,0,0, 0, 0, 0, 0, 0, 0},
                          {0,0,0, 0, 0, 0, 0, 0, 0}};//empty board
       int[][] testFour = {{2, 9, 6, 3, 1, 8 ,5, 7, 4}, 
                          {5, 0, 4, 9, 7, 2, 0, 1, 3},
                          {7, 1, 3, 6, 4, 5, 2, 8, 9},
                          {6, 2, 5, 0, 9, 7, 0, 4, 1},
                          {9, 3, 1, 4, 2, 6, 8, 5, 7},
                          {4, 7, 8, 5, 0, 1, 9, 2, 6},
                          {1, 6, 7, 2, 5, 3, 4, 9, 8},
                          {8,  5, 9, 7, 6, 0, 1, 3, 2},
                          {3, 4, 0, 1, 8, 9, 7, 6, 0}};//scattered solvable
       int[][] testFive = {{6,0,0, 0, 0, 8 ,9, 4, 0}, 
                           {9, 0, 0, 0, 0, 6, 1, 0, 0},
                           {0, 7, 0, 0, 4, 0, 0, 0, 0},
                           {2, 0, 0, 6, 1, 0, 0, 0, 0}, 
                           {0, 0, 0, 0, 0, 0, 2, 0, 0},
                           {0, 8, 9, 0, 0, 2, 0, 0, 0},
                           {0, 0, 0, 0, 6, 0, 0, 0, 5},
                           {0,  0, 0, 0, 0, 0, 0, 3, 0},
                           {8, 0, 0, 0, 0, 1, 6, 0, 0}}; //scattered solvable
       int[][] trivial = {{3, 0, 0, 7, 9, 4, 2, 5, 0},
                            {2, 0, 0, 5, 6, 0, 1, 9, 7},
                            {7, 9, 0, 8, 2, 0, 4, 0, 3},
                            {0, 2, 0, 0, 7, 8, 0, 4, 1},
                            {5, 7, 0, 1, 0, 6, 0, 8, 2},
                            {1, 4, 8, 3, 0, 2, 9, 7, 6},
                            {9, 0, 7, 0, 8, 5, 6, 0, 4},
                            {4, 5, 2, 6, 0, 7, 8, 3, 9},
                            {0, 1, 6, 4, 3, 9, 7, 0, 5}};
         int[][] easy = {{0, 0, 2, 6, 8, 0, 3, 4, 7},
                        {6, 0, 0, 0, 0, 0, 5, 0, 0},
                        {4, 0, 9, 0, 0, 0, 0, 8, 0},
                        {0, 0, 0, 0, 9, 3, 7, 6, 0},
                        {0, 5, 0, 1, 0, 6, 0, 9, 0},
                        {0, 9, 6, 8, 7, 0, 0, 0, 0},
                        {0, 8, 0, 0, 0, 0, 9, 0, 3},
                        {0, 0, 7, 0, 0, 0, 0, 0, 4},
                        {3, 6, 5, 0, 1, 4, 2, 0, 0}};
         int[][] medium = {{4, 0, 0, 0, 0, 2, 8, 0, 0},
                           {0, 0, 0, 0, 9, 8, 0, 0, 1},
                           {3, 0, 0, 7, 0, 0, 0, 2, 6},
                           {0, 4, 9, 5, 0, 3, 0, 0, 8},
                           {0, 0, 0, 0, 2, 0, 0, 0, 0},
                           {6, 0, 0, 8, 0, 1, 9, 3, 0},
                           {5, 7, 0, 0, 0, 9, 0, 0, 2},
                           {9, 0, 0, 1, 6, 0, 0, 0, 0},
                           {0, 0, 6, 2, 0, 0, 0, 0, 9}};
         int[][] hard = {{0, 1, 0, 0, 0, 0, 0, 7, 0},
                         {0, 4, 6, 0, 0, 5, 2, 0, 0},
                         {0, 8, 0, 1, 0, 0, 0, 0, 3},
                         {0, 0, 0, 0, 1, 3, 4, 0, 6},
                         {0, 0, 0, 0, 7, 0, 0, 0, 0},
                         {1, 0, 4, 9, 5, 0, 0, 0, 0},
                         {3, 0, 0, 0, 0, 8, 0, 4, 0},
                         {0, 0, 8, 7, 0, 0, 1, 2, 0},
                         {0, 7, 0, 0, 0, 0, 0, 9, 0}};
         int[][] evil = {{4, 0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 6, 0, 2, 3, 8, 0},
                         {0, 0, 2, 0, 0, 8, 0, 5, 0},
                         {2, 0, 0, 0, 0, 0, 5, 4, 0},
                         {0, 0, 5, 0, 7, 0, 6, 0, 0},
                         {0, 3, 9, 0, 0, 0, 0, 0, 1},
                         {0, 6, 0, 8, 0, 0, 2, 0, 0},
                         {0, 7, 4, 9, 0, 6, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0, 5}};
       System.out.println("Board that can call next ");
       System.out.println("Test 1: ");
       printBoard(next(extend(testOne), 1 , 0));
       System.out.println("Test 2: ");
       printBoard(next(extend(testTwo), 8, 8));
       System.out.println("Test 3: ");
       printBoard(next(extend(testThree),0, 0)); 
       System.out.println("Test 4: ");
       printBoard(next(extend(testFour), 1, 1));
       System.out.println("Test 5: ");
       printBoard(next(extend(testFive), 0, 1));
       System.out.println("Trivial Test: ");
       printBoard(next(extend(trivial), 0, 1));
       System.out.println("Easy Test: ");
       printBoard(next(extend(easy), 0, 0));
       System.out.println("Medium Test: ");
       printBoard(next(extend(medium), 0, 1));
       System.out.println("Hard Test ");
       printBoard(next(extend(hard), 0, 0));
       System.out.println("Evil Test ");
       printBoard(next(extend(evil), 0, 1));
       System.out.println();

    }

    static void printBoard(int[][] board) {
        if (board == null) {
            System.out.println("No assignment");
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (i == 3 || i == 6) {
                System.out.println("----+-----+----");
            }
            for (int j = 0; j < 9; j++) {
                if (j == 2 || j == 5) {
                    System.out.print(board[i][j] + " | ");
                } else {
                    System.out.print(board[i][j]);
                }
            }
            System.out.print("\n");
        }
    }

    static int[][] readBoard(String filename) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(filename), Charset.defaultCharset());
        } catch (IOException e) {
            return null;
        }
        int[][] board = new int[9][9];
        int val = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                try {
                    val = Integer.parseInt(Character.toString(lines.get(i).charAt(j)));
                } catch (Exception e) {
                    val = 0;
                }
                board[i][j] = val;
            }
        }
        return board;
    }

    static int[][] solve(int[][] board) {
        if (reject(board)) return null;
        if (isFullSolution(board)) return board;
        int[][] attempt = extend(board);
        int rLocal = r;
        int cLocal = c;
        while (attempt != null ) {
            int[][] solution = solve(attempt); 
            if (solution != null){
                return solution;
            }
            attempt = next(attempt, rLocal, cLocal);
        }
        return null;
    }

    public static void main(String[] args) {
        if (args[0].equals("-t")) {
            testIsFullSolution();
            testReject();
            testExtend();
            testNext();
            System.out.println("Unsolvable Test:");
            int[][]unsolvable = {{6,0,0, 0, 0, 8 ,9, 4, 0}, 
                              {9, 0, 0, 0, 0, 6, 1, 0, 0},
                              {0, 7, 0, 0, 4, 0, 0, 0, 0},
                              {2, 0, 0, 6, 1, 0, 0, 0, 0}, 
                              {0, 0, 0, 0, 0, 0, 2, 0, 0},
                              {0, 8, 9, 0, 0, 2, 0, 0, 0},
                              {0, 0, 0, 0, 6, 0, 0, 0, 5},
                              {0,  0, 0, 0, 0, 0, 0, 3, 0},
                              {8, 0, 0, 0, 0, 1, 6, 0, 5}}; 
           
            
           int[][] solved = solve(unsolvable);
            if(solved == null)
           {
               System.out.println("This Board is Unsolvable");
            }
            else
            {
                printBoard(solved);
            }
           
        } else {
            int[][] board = readBoard(args[0]);
            System.out.println("Original Board: ");
            printBoard(board);
            System.out.println();
            System.out.println("Solved Board: ");
           int[][] solved = solve(board);
           if(solved == null)
           {
               System.out.println("Unsolvable");
            }
            else
            {
                printBoard(solved);
            }
        }
    }
}
