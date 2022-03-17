class Solution {
    public int[][] generateMatrix(int n) {
     int arr[][]=new int[n][n];  
     int minrow=0,mincol=0,maxrow=arr.length-1,maxcol=arr[0].length-1,count=1;
     int size=n*n;
     while(count-1<size)
     {
     for(int i=minrow,j=mincol;j<=maxcol&&(count-1)<size;j++)
     {
         arr[i][j]=count;
         count++;
     }   
      minrow++;
     for(int i=minrow,j=maxcol;i<=maxrow&&(count-1)<size;i++)
     {
        arr[i][j]=count;
        count++; 
     }
     maxcol--;
     for(int i=maxrow,j=maxcol;j>=mincol&&(count-1)<size;j--)
     {
        arr[i][j]=count; 
        count++; 
     }
      maxrow--;
      for(int i=maxrow,j=mincol;i>=minrow&&(count-1)<size;i--)
      {
       arr[i][j]=count;
       count++;   
      }
      mincol++;   
    }
        return arr;
    }
}