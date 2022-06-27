/*
Unique Path
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

 

Example 1:


Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
 

Constraints:

1 <= m, n <= 100
*/
1.Recursive soln
/*
class Solution {
    public int uniquePaths(int m, int n) {
        if(m==1||n==1)
        {
         return 1;  
        }
        return uniquePaths(m-1,n)+uniquePaths(m,n-1);
    }
}

*/
class Solution {
    int count=0;
    public int uniquePaths(int m, int n) {
        countWays(0,0,m,n);
        return count;
    }
    public void countWays(int row,int col,int m,int n)
    {
     if(row==m||col==n)
     {
       return;  
     }
      if(row==m-1&&col==n-1)
      {
       count++;   
      }
        countWays(row+1,col,m,n);
        countWays(row,col+1,m,n);
    }
}
Time Complexity:O(2^n)
Space Complexity:O(n) 

2.Tabulation Method 
class Solution {
    public int uniquePaths(int m, int n) {
        int arr[][]=new int[m+1][n+1];
       for (int[] row : arr)
            Arrays.fill(row, 1);
        for(int i=1;i<arr.length;i++)
        {
            for(int j=1;j<arr[0].length;j++)
            {
                arr[i][j]=arr[i-1][j]+arr[i][j-1];
            }
        }
        return arr[m-1][n-1];
    }
}
