/*
Number of Islands
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
*/
1. we are checking top,left,right,down using dfs
class Solution {
    public int numIslands(char[][] grid) {  
     int count=0;    
    for(int i=0;i<grid.length;i++)
    {
     for(int j=0;j<grid[0].length;j++)
     {
      if(grid[i][j]=='1')
      {
      dfs(grid,i,j); 
      count+=1;   
     }
     }
    }
     return count;   
    }
    public void dfs(char grid[][],int row,int col)
    {
     if(row>=grid.length||col>=grid[0].length||row<0||col<0||grid[row][col]=='#'||grid[row][col]=='0')
     {
       return ;  
     }
        grid[row][col]='#';
        dfs(grid,row-1,col);//top
        dfs(grid,row,col-1);//left
        dfs(grid,row+1,col);//down
        dfs(grid,row,col+1);//right
    }
}
Time : 
Space:O(1)
3.In case when we have to check diagonally also(gfg Ques)
class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
    int count=0;
    for(int row=0;row<grid.length;row++)
    {
    for(int col=0;col<grid[0].length;col++)
    {
     if(grid[row][col]=='1')
     {
       dfs(grid,row,col);
       count+=1; 
     }
    }
    }
    return count;
    }
    public void dfs(char[][]grid,int row,int col)
    {
    if(row<0||col<0||row>=grid.length||col>=grid[0].length||grid[row][col]=='2'||grid[row][col]=='0')
    {
     return;   
    }
    if(grid[row][col]=='1')
    {
    grid[row][col]='2';
    dfs(grid,row-1,col);//top
    dfs(grid,row,col-1);//left
    dfs(grid,row+1,col);//down
    dfs(grid,row,col+1);//right
    dfs(grid,row+1,col+1);//down right
    dfs(grid,row-1,col-1);//upper left
    dfs(grid,row+1,col-1);//down left
    dfs(grid,row-1,col+1);//upper right
    }
    }
}