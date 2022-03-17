class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
      ArrayList<Integer> list = new ArrayList<Integer>();  
     int row=matrix.length,col=matrix[0].length;
     int total=row*col,count=0;
     int minrow=0,maxrow=matrix.length-1,mincol=0,maxcol=matrix[0].length-1;
     while(count<total)
     {
         for(int i=minrow,j=mincol;j<=maxcol&&count<total;j++)
        {
          list.add(matrix[i][j]);
          count++;
        }
        minrow++;
        for(int i=minrow,j=maxcol;i<=maxrow&&count<total;i++)
        {
           list.add(matrix[i][j]);
            count++;
        }
        maxcol--;
        for(int i=maxrow,j=maxcol;j>=mincol&&count<total;j--)
        {
           list.add(matrix[i][j]);
            count++;
        }
        maxrow--;
        for(int i=maxrow,j=mincol;i>=minrow&&count<total;i--)
        {
        list.add(matrix[i][j]);
         count++;
        }
        mincol++; 
     }
        return list;
    }
}