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

3.Space Efficient approach
class Solution {
  public void setZeroes(int[][] matrix) {
    Boolean isCol = false;
    int R = matrix.length;
    int C = matrix[0].length;

    for (int i = 0; i < R; i++) {

      // Since first cell for both first row and first column is the same i.e. matrix[0][0]
      // We can use an additional variable for either the first row/column.
      // For this solution we are using an additional variable for the first column
      // and using matrix[0][0] for the first row.
      if (matrix[i][0] == 0) {
        isCol = true;
      }

      for (int j = 1; j < C; j++) {
        // If an element is zero, we set the first element of the corresponding row and column to 0
        if (matrix[i][j] == 0) {
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }

    // Iterate over the array once again and using the first row and first column, update the elements.
    for (int i = 1; i < R; i++) {
      for (int j = 1; j < C; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    // See if the first row needs to be set to zero as well
    if (matrix[0][0] == 0) {
      for (int j = 0; j < C; j++) {
        matrix[0][j] = 0;
      }
    }

    // See if the first column needs to be set to zero as well
    if (isCol) {
      for (int i = 0; i < R; i++) {
        matrix[i][0] = 0;
      }
    }
    time complexity:O(n2)
    space complexity:O(1)
