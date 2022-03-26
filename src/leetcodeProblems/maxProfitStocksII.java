/*
122. Best Time to Buy and Sell Stock II
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
O(N)
O(1)
*/

class Solution {
    public int maxProfit(int[] prices) {
        int len= prices.length;
        if(len == 1) // one element no profit
        {
            return 0;
        }
        
        int boughtIndex = -1;
        boolean doesCartHasItem=false;
        int profit=0;
        
        for(int i=0;i<len-1;i++)
        {
            if(prices[i]<prices[i+1] && !doesCartHasItem)
            {
                boughtIndex = i;
                doesCartHasItem = true;
            }
            if(prices[i]>prices[i+1] && doesCartHasItem)
            {
                // selling
                profit+=prices[i]-prices[boughtIndex];
                doesCartHasItem=false;
            }
        }
        
        if(doesCartHasItem) 
        {
             profit+=prices[len-1]-prices[boughtIndex];
        }
        
        return profit;
        
    }
}