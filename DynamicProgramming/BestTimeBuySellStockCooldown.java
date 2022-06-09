/*
Best Time to Buy and Sell Stock with Cooldown
*/
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==1)
       return 0; 
        int buy = -prices[0],sell=0,cool=0;
        for(int i=1;i<prices.length;i++)
        {    
         buy=Math.max(buy,cool-prices[i]);
         cool=Math.max(cool,sell);        
         sell=Math.max(sell,buy+prices[i]);
        }
        return sell;
    }
}