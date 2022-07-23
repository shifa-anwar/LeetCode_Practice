/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 

Example 1:


Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Example 2:

Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.
*/
1.
class Solution {
    public boolean isValidSudoku(char[][] board) {
      for(int i=0;i<board.length;i++)
      {
       for(int j=0;j<board.length;j++)
       {
        if(board[i][j]=='.')
            continue;
        else
        {
           if(isSafe(board,i,j,board[i][j])==false)
            return false;
        }
       }
      }
       return true; 
    }
    public boolean isSafe(char[][]board,int i,int j,char val)
    {
     for(int row=0;row<board.length;row++)//check row
     {
         if(row==i)
          continue;   
      if(board[row][j]==val)
          return false;
     }
     for(int col=0;col<board[0].length;col++)//check col
     {
        if(col==j)
        continue;
         if(board[i][col]==val)
           return false;
     }
      int x = i/3*3,y = j/3*3;
      for(int row=0;row<3;row++) //check subarray of 3x3
      {
      for(int col=0;col<3;col++)
      {
         if(row+x==i&&col+y==j)
          continue;   
         if(board[row+x][col+y]==val)
             return false;
      }
      }
        return true;
    }
}
2.Using HashSet
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> s = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    String forRow = "Row Is " + i + " Value Is " + c;
                    String forCol = "Col Is " + j + "Value Is " + c;
                    String forBlock = "For Value "+ c + "Block Is " + i / 3 + " - " + j / 3;
					
                    if (s.contains(forBlock) || s.contains(forRow) || s.contains(forCol)) {
                        return false;
                    } else {
                        s.add(forBlock);
                        s.add(forCol);
                        s.add(forRow);
                    }

                }
            }
        }
        return true; 
    }
}