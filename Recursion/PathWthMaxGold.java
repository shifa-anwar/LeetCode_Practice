/*
Path with Maximum Gold
In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.

Return the maximum amount of gold you can collect under the conditions:

Every time you are located in a cell you will collect all the gold in that cell.
From your position, you can walk one step to the left, right, up, or down.
You can't visit the same cell more than once.
Never visit a cell with 0 gold.
You can start and stop collecting gold from any position in the grid that has some gold.
 

Example 1:

Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
Output: 24
Explanation:
[[0,6,0],
 [5,8,7],
 [0,9,0]]
Path to get the maximum gold, 9 -> 8 -> 7.
Example 2:

Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
Output: 28
Explanation:
[[1,0,7],
 [2,0,6],
 [3,4,5],
 [0,3,0],
 [9,0,20]]
Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 15
0 <= grid[i][j] <= 100
There are at most 25 cells containing gold.
*/
class Solution {
    public int getMaximumGold(int[][] grid) {
    int max =0;
    for(int i=0;i<grid.length;i++)//it will check path for every grid
    {
    for(int j=0;j<grid[0].length;j++)
    {
     if(grid[i][j]>0)
     {
       max = Math.max(max,dfs(grid,i,j)); //store the max path 
     }
    }    
    }
    return max;    
    }
    public int dfs(int arr[][],int r,int c)
    {
      if(r<0||c<0||r>=arr.length||c>=arr[0].length||arr[r][c]==0)
      {
        return 0;  
      }
        int temp = arr[r][c];//store the value temporarily to use after visiting the cell
        arr[r][c]=0;//can't go to cell with value 0 so we will assign zero here
        int top=dfs(arr,r-1,c);//call top
        int left=dfs(arr,r,c-1);//left
        int down =dfs(arr,r+1,c);//down
        int right=dfs(arr,r,c+1);//right
        arr[r][c]=temp;//again assign original value
        return temp+Math.max(Math.max(Math.max(top,left),down),right);//add the max of all four side with previous max path
    }
}

/*
Time complexity :  N * M * (3 (N * M)),
we have to do the dfs operation from every cell , so it is  N * M ,
then each dfs call will go to mostly 3 direction (because one direction
is already used , as the call will come from that direction , so it will be 3 , 
not 4 ) and in worst case it will visit all the N * M cells , so each dfs call will be 3 ^(N*M) ,
*/
