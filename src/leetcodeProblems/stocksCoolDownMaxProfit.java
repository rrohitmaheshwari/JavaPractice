/*
309. Best Time to Buy and Sell Stock with Cooldown
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

O(N) - N*2 of cache is what the time complexity will be
O(N) - cache & mem stack

Ref:https://www.youtube.com/watch?v=I7j0F7AHpb8
Figure at time stamp: 8:47
*/

class Solution {
    Map<Pair<Integer,Boolean>,Integer> cache;
    public int maxProfit(int[] prices) {
        cache= new HashMap<>();
        return helperMaxProfit(0,true,prices);
        
    }
    
    int helperMaxProfit(int index, boolean canBuy, int[] prices)
    {
        if(index>=prices.length)
            return 0;
        Pair key = new Pair(index,canBuy);
        if( cache.containsKey(key) )
        {
            return cache.get(key);
        }
        int cooldown = helperMaxProfit(index+1,canBuy,prices);
        if(canBuy) // can buy or cooldown
        {
            int bought = -prices[index]+helperMaxProfit(index+1,false,prices);
            cache.put(key,Math.max(bought,cooldown));
            // return Math.max(bought,cooldown);
        }
        else  // can sell or cooldown
        {
            int sold = prices[index]+helperMaxProfit(index+2,true,prices); // index+2 as next will always be cooldown
            cache.put(key,Math.max(sold,cooldown));
            // return Math.max(sold,cooldown);
        }
        
        return cache.get(key);
    }
}