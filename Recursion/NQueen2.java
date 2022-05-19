/*
N Queens-2
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
Given an integer n, return the number of distinct solutions to the n-queens puzzle.
Example 1:
Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.

Example 2:
Input: n = 1
Output: 1
 
Constraints:
1 <= n <= 9
*/
class Solution {
   int count = 0;
    public int totalNQueens(int n) {
    boolean arr[][]= new boolean[n][n];   
    nQueens(arr,0); //calling function
    return count;    
    }
    public void nQueens(boolean arr[][],int row)
    {
      if(row == arr.length)
      {  
       count++;
      }
        else
        {
        for(int col=0;col<arr.length;col++)
        {
         if(isSafePlace(arr,row,col))   
         {
          arr[row][col]=true;
          nQueens(arr,row+1);  
          arr[row][col]=false; 
         }
        }
        }
    }
    public boolean isSafePlace(boolean arr[][],int row,int col)
    {
       for(int i =row-1,j=col;i>=0;i--)
       {
          if(arr[i][j])
          {return false;}   
       }
        for(int i =row-1,j=col+1;j<arr.length&&i>=0;i--,j++)
        {
          if(arr[i][j])
          {return false;}   
        }   
        for(int i = row-1,j=col-1;i>=0&&j>=0;i--,j--)
        {
          if(arr[i][j])
          {
            return false;  
          }
        }
        return true;
    }
}