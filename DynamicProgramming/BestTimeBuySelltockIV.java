/*
188. Best Time to Buy and Sell Stock IV
You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 

Constraints:

0 <= k <= 100
0 <= prices.length <= 1000
0 <= prices[i] <= 1000
*/
class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length==0)
         return 0;   
        int dp[][] = new int[k+1][prices.length];
        for(int t=1;t<=k;t++){
        for(int j=1;j<prices.length;j++){
         int max = dp[t][j-1];
         for(int d=0;d<j;d++)
         {
          int current = dp[t-1][d];   
          int gap = prices[j]-prices[d];
          if(gap+current>max)
          {
           max = gap+current;   
          }
         }
           dp[t][j]= max; 
        }    
        }
        return dp[k][prices.length-1];
    }
}

2.class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length==0)
         return 0;   
        int dp[][] = new int[k+1][prices.length];
        for(int t=1;t<=k;t++){
         int max = Integer.MIN_VALUE;
         for(int d=1;d<prices.length;d++)
         {
          if(dp[t-1][d-1]-prices[d-1]>max)
          {
              max = dp[t-1][d-1]-prices[d-1];
          }
          if(max+prices[d]>dp[t][d-1])
          {
              dp[t][d]= max+prices[d];
          }
             else
             {
                dp[t][d]=dp[t][d-1]; 
             }
         }
        }
        return dp[k][prices.length-1];
}
}