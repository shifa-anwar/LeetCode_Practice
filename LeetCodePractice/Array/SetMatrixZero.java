/*Set Matrix zeroes
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

 

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
 

Follow up:

A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/

1.Brute force approach
class Solution {
    public void setZeroes(int[][] matrix) {
        int r=matrix.length,c=matrix[0].length;
        int arr[][]= new int[r][c];
        for(int i=0;i<r;i++)
        {
        for(int j=0;j<c;j++)
        {
          arr[i][j]=matrix[i][j];  
        }   
        }
        for(int i=0;i<matrix.length;i++){
        for(int j=0;j<matrix[0].length;j++)
        {
         if(matrix[i][j]==0)
         {
          for(int col=0;col<matrix[0].length;col++)
          {
            arr[i][col]=0;  
          }
          for(int row=0;row<matrix.length;row++)
          {
           arr[row][j]=0;   
          }
         }
        }
        }
        for(int i=0;i<r;i++)
        {
        for(int j=0;j<c;j++)
        {
         matrix[i][j]=arr[i][j];  
        }   
        }
    }
    
}
Time complexity: O((m*n)+(m*n)(n+m)+(m*n))
space :O(n2)

2.using dummy array

class Solution {
    public void setZeroes(int[][] matrix) {
        int dummy1[]= new int[matrix.length];//taking two dummy array
        int dummy2[]= new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++)
        {
        for(int j=0;j<matrix[0].length;j++)
        {
         if(matrix[i][j]==0)
         {
          dummy1[i]=1;//seting them as 1 so that we can use them later
          dummy2[j]=1;   
         }
        }    
        }
        for(int i=0;i<matrix.length;i++)
        {
        for(int j=0;j<matrix[0].length;j++)
        {
           if(dummy1[i]==1||dummy2[j]==1) 
           {
             matrix[i][j]=0;  
           }
            
        }
        }
}

Time complexity:O(m*n+m*n)
}