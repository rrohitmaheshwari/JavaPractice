/*
121. Best Time to Buy and Sell Stock
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
O(N)
O(N)
*/
class Solution {
    public int maxProfit(int[] prices) {
        
        int min = prices[0];
        int ans=0;
        
        for(int i=0;i<prices.length;i++)
        {
            min = Math.min(prices[i],min);
            ans = Math.max(ans,prices[i]-min);
        }
        
        return ans;
        
    }
}