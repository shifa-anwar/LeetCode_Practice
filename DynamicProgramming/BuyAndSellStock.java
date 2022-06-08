/*
Buy and sell stock
*/
class Solution {
    public int maxProfit(int[] prices) {
      int leastPrice=Integer.MAX_VALUE,maxProfit=0,todayProfit=0;
        for(int i=0;i<prices.length;i++)
        {
            if(prices[i]<leastPrice)
            {
               leastPrice = prices[i];//calculating the least price
            }
            todayProfit = prices[i]-leastPrice;//calculating each day profit considering that what will be the profit if we'll sold today

            if(maxProfit<todayProfit)
            {
              maxProfit = todayProfit;  //store the max one of every day profit
            }
        }
        return maxProfit;
    }
}