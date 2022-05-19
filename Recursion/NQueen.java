/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens
attack each other.Given an integer n, return all distinct solutions to the n-queens puzzle. You may 
return the answer in any order.Each solution contains a distinct board configuration of the n-queens'
placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

Example 1:
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

Example 2:
Input: n = 1
Output: [["Q"]]
*/

class Solution {
    public List<List<String>> solveNQueens(int n) {
       boolean arr[][]= new boolean[n][n];
     return nQueen(arr,0); 
    }
    public static List<List<String>> nQueen(boolean arr[][],int row)
    {
    if(row==arr.length)
    {
     List<List<String>> l = new ArrayList<>();
     l.add(display(arr));
     return l;   
    }
     List<List<String>> li = new ArrayList<>();   
     for(int col = 0;col<arr.length;col++)
     {
       if(isSafePlace(arr,row,col))
       {
         arr[row][col] = true;
         li.addAll(nQueen(arr,row+1));  
         arr[row][col] = false; 
       }
     }
     return li;   
    }
    public static List<String> display(boolean arr[][])
    {
      List<String> li = new ArrayList<>();
      String p = "";
       for(boolean i[]:arr)
       {
        for(boolean j:i)
        {
          if(j == true)
              p+="Q";
            else
                p+=".";
        }
           li.add(p);
           p="";
       }
        return li;
    }
    public static boolean isSafePlace(boolean arr[][],int row ,int col)
    {
     for(int i = row,j = col;i>=0;i--)//vertical
     {
       if(arr[i][j])
       {return false;}
     }
     for(int i = row-1,j=col-1;i>=0&&j>=0;i--,j--)//diagonal
     {
       if(arr[i][j])
       {return false;}
     }
     for(int i = row-1,j=col+1;i>=0&&j<arr.length;i--,j++)//horizontal
     {
       if(arr[i][j])
       {return false;}    
     }    
     return true;   
    }
}
/*
N-Queens Problem
Approach :
We have to keep in mind the following 4 conditions:
No 2 Queens can be in the same row
No 2 Queens can be in the same column
No 2 Queens can be in the left diagonal
No 2 Queens can be in the right diagonal

Analysis

Time Complexity :
This code is exponential in nature, and it's time complexity will turn out to be O(n!). 
It is better than the brute force/naive approach which has O(n^n) time complexity.
Mathematical Proof of Time Complexity
Let us assume that the run-time for nrows is T(n). Hence, for n-1 rows, the run-time 
will be T(n-1).Since, we are making at max n calls, (for n columns) to the recursive 
function with n-1 rows left, hence: T(n) = n * T(n-1) + O(Checking if the configuration
is valid) For the first row {T(n)}, we will have 0 previous rows to check, for the 2nd 
row, we will have 1 previous row to check and so on, until the last row for which we 
need to check for (n-1) previous rows.

SPACE COMPLEXITY :
The maximum number of recursive calls can be equal to the number of rows. Hence the recursion stack call will take atmax O(n) space.
However, we are not using any extra data structure, hence O(1) auxiliary space.
*/
import java.io.*;
import java.util.*;

public class Main 
{

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] chess = new int[n][n];
        printNQueens(chess,"",0);
    }

    public static void printNQueens(int[][] chess, String qsf, int row)
    {
        if(row == chess.length)
        {
        System.out.println(qsf+".");
        return;
        }
        for(int col=0;col<chess.length;col++)
        {
            if(safePlaceForQueen(chess,row,col))
            {
              chess[row][col]=1;
              printNQueens(chess,qsf + row + "-" + col +", ",row+1);
              chess[row][col]=0;
            }
        }
    }
    public static boolean safePlaceForQueen(int[][]arr,int row ,int col)
    {
        for(int i =row-1,j=col;i>=0;i--)
        {
            if(arr[i][j]==1)
            {
            return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--)
        {
            if(arr[i][j]==1)
            {
            return false;    
            }
        }
        for(int i = row-1,j=col+1;i>=0&&j<arr.length;i--,j++)
        {
         if(arr[i][j]==1)
         {
            return false; 
         }
        }
        return true;
    }
}