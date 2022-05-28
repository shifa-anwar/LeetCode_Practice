/*
Word Search
Given an m x n grid of characters board and a string word, return 
true if word exists in the grid.The word can be constructed from 
letters of sequentially adjacent cells, where adjacent cells are 
horizontally or vertically neighboring. The same letter cell may 
not be used more than once.
Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 
Constraints:
m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
*/
//using boolean array to check visited path
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean visit[][]=new boolean[board.length][board[0].length];
        int index=0;
        for(int i=0;i<board.length;i++)
        {
         for(int j=0;j<board[0].length;j++)
         {
          //checking for first alphabet match and dfs function 
          if(board[i][j]==word.charAt(0)&&dfs(board,i,j,0,visit,word))
            return true;  
         }    
        }
        return false;
    }
    public boolean dfs(char[][]board,int r,int c,int idx,boolean visit[][],String word)
    {
      if(idx==word.length())
      {
          return true;
      }
      
      if(r<0||c<0||r>=board.length||c>=board[0].length||visit[r][c]==true)
      {
        return false;  
      }
     if(board[r][c]!=word.charAt(idx))
     {
        return false; 
     }
     visit[r][c]=true;   
boolean find=dfs(board,r+1,c,idx+1,visit,word)||dfs(board,r,c+1,idx+1,visit,word)||dfs(board,r-1,c,idx+1,visit,word)||dfs(board,r,c-1,idx+1,visit,word);
     visit[r][c]=false;   
     if(find)
      return true;
    return false;    
}
}

//changing grid value to show visited path
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean visit[][]=new boolean[board.length][board[0].length];
        int index=0;
        for(int i=0;i<board.length;i++)
        {
         for(int j=0;j<board[0].length;j++)
         {
          //checking for first alphabet match and dfs function 
          if(board[i][j]==word.charAt(0)&&dfs(board,i,j,0,visit,word))
            return true;  
         }    
        }
        return false;
    }
    public boolean dfs(char[][]board,int r,int c,int idx,boolean visit[][],String word)
    {
      if(idx==word.length())
      {
          return true;
      }
      
      if(r<0||c<0||r>=board.length||c>=board[0].length||visit[r][c]==true||!checkAlphabet(board[r][c]))
      {
        return false;  
      }
     if(board[r][c]!=word.charAt(idx))//checking for every character
     {
        return false; 
     }
    char temp = board[r][c];
    board[r][c]='*';    
boolean find=dfs(board,r+1,c,idx+1,visit,word)||dfs(board,r,c+1,idx+1,visit,word)||dfs(board,r-1,c,idx+1,visit,word)||dfs(board,r,c-1,idx+1,visit,word);
       board[r][c]=temp;
     if(find)
      return true;
    return false;    
}
    public boolean checkAlphabet(char c)
    {/
        if(c>='A'&&c<='Z'||(c>='a'&&c<='z'))
         return true;
        return false;
    }
}