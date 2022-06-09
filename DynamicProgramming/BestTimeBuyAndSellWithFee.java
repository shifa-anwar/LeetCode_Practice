/*
Best Time to Buy and Sell Stock with Transaction Fee
*/
class Solution {
    public int maxProfit(int[] prices, int fee) {
      int buy = -prices[0],sell = 0;
        for(int i=1;i<prices.length;i++)
        {
         sell =Math.max(sell,buy-fee+prices[i]);       
         buy = Math.max(buy,sell-prices[i]); 
        }
        return sell;
    }
}