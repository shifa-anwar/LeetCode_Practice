/*
Minimum Path Sum
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.
Example 1:
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Example 2:
Input: grid = [[1,2,3],[4,5,6]]
Output: 12

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 100
*/
class Solution {
    public int minPathSum(int[][] grid) { //using tabulation method
        int r = grid.length;
        int c = grid[0].length;
        int arr[][]= new int[r][c];
        arr[0][0]=grid[0][0];
       for(int i=0,j=1;j<c;j++) //storing first row element as they dont have any min path on left or upside
       {
        arr[i][j]=arr[i][j-1]+grid[i][j];   
       }
       for(int i=1,j=0;i<r;i++)//storing first col element as they dont have any min path on left or upside
       {
        arr[i][j]=arr[i-1][j]+grid[i][j];   
       }
       for(int i=1;i<r;i++)
       {
        for(int j=1;j<c;j++)  
        {
        arr[i][j]= Math.min(arr[i][j-1],arr[i-1][j])+grid[i][j];//take the min of upward path and left path    
        }
       }   
        return arr[r-1][c-1];
       }
}
