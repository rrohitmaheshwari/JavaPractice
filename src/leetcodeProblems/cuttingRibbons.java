/*
1891. Cutting Ribbons
https://leetcode.com/problems/cutting-ribbons/
O(NLogN + N) => O(NLogN). ->. We are calucalting sum so we have N multiplier
O(1)
*/


class Solution {
    public int maxLength(int[] ribbons, int k) {
     int sum = 0, r = 0, l = 1, ans = 0;
        
        for(int ribbon : ribbons) { //Getting our last value of the search space
            r = Math.max(ribbon, r);
        }
        
        while(l <= r) { //Binary Search
            int mid = l + (r-l)/2; //Our current length in the search space
            sum = 0;
            for(int ribbon : ribbons) { //The number of segments obtained with mid length
                sum += ribbon/mid;
            }
            if(sum >= k) { //Maybe there's a better answer, move to the right
                ans = mid;
                l = mid+1;
            } else  { //No way to obtain k segments, move to the left to reduce cut len
                r = mid-1; 
            }
        }
        return ans;
    }
    
}