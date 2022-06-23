1.Brute Force
class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n!=original.length)
        {
          return new int[0][0];  
        }
     int arr[][]= new int[m][n];
      int k=0;  
     for(int i=0;i<arr.length;i++)
     {
      for(int j=0;j<arr[0].length;j++)
      {
       arr[i][j]=original[k++];   
      }
     }
       return arr; 
    }
}
Time Complexity:O(n^2)
Space Complexity:O(m*n)

2.One pass
class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n!=original.length)
        {
          return new int[0][0];  
        }
     int arr[][]= new int[m][n];
      int row=0,col=0;  
      for(int i=0;i<original.length;i++)
      {
       if(col==n)
       {
        row++;  
        col=0;  
       }    
      arr[row][col++]=original[i];    
      }   
       return arr; 
    }
}
Time Complexity:O(n)
Space Complexity:O(m*n)