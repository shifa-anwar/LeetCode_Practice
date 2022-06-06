/*
Paint House - Many colours
*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
     Scanner sc = new Scanner(System.in);
     int r = sc.nextInt();
     int c = sc.nextInt();
     int arr[][]= new int[r][c];
     for(int i=0;i<r;i++){
     for(int j=0;j<c;j++){
       arr[i][j]=sc.nextInt();     
     } 
     }
     int dp[][]=new int[r][c];
     for(int j=0;j<arr[0].length;j++)
     {
      dp[0][j]=arr[0][j];     
     }
     for(int i=1;i<arr.length;i++)
     {
     for(int j=0;j<arr[0].length;j++)
     {
         int min = Integer.MAX_VALUE;
      for(int k=0;k<arr[0].length;k++)
      {
        if(j!=k)
        {
        if(dp[i-1][k]<min)
        {
        min = dp[i-1][k];    
        }
        }
      }
        dp[i][j]=min+arr[i][j];
     }
     }
     int min = Integer.MAX_VALUE;
     for(int j=0;j<dp[0].length;j++)
    {
    if(min>dp[r-1][j]) 
    {
    min = dp[r-1][j];    
    }
    }
     System.out.println(min);
    }
}

Time complexity:O(n3)
space :O(n2)

2.
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
     Scanner sc = new Scanner(System.in);
     int r = sc.nextInt();
     int c = sc.nextInt();
     int arr[][]= new int[r][c];
     for(int i=0;i<r;i++)
     {
     for(int j=0;j<c;j++)
     {
       arr[i][j]=sc.nextInt();     
     } 
     }
     
     int dp[][]=new int[r][c];
     int least = Integer.MAX_VALUE,sleast = Integer.MAX_VALUE;
     for(int j=0;j<arr[0].length;j++)
     {
      dp[0][j]=arr[0][j]; 
      if(arr[0][j]<=least)
      {
        sleast=least;  
        least = arr[0][j]; 
      }
      else if(arr[0][j]<=sleast)
      {
      sleast = arr[0][j];  
      }
     }
     
     for(int i=1;i<arr.length;i++)
     {
     int nleast = Integer.MAX_VALUE,nsleast =Integer.MAX_VALUE;     
     for(int j=0;j<arr[0].length;j++)
     {
      if(least ==dp[i-1][j])
      {
      dp[i][j]=sleast+arr[i][j];      
      }
      else
      {
       dp[i][j]= least+arr[i][j];      
      }
       if(dp[i][j]<=nleast)
      {
        nsleast=nleast;  
        nleast = dp[i][j]; 
      }
      else if(dp[i][j]<=nsleast)
      {
      nsleast = dp[i][j];  
      }
     }
     least = nleast;
     sleast = nsleast;
     }
     
     System.out.println(least);
    }
}
Time complexity:O(n2)
space complexity:O(n2)