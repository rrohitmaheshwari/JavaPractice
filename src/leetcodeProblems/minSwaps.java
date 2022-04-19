/*
1151. Minimum Swaps to Group All 1's Together
https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/
O(N)
O(1)
*/

class Solution {
    public int minSwaps(int[] data) {
        
        int window_size  = 0;
        
        
        // count number of ones that will become window
        for(int i:data)
        {
            
            window_size = window_size+ i;
        }
        
        // check count in 1st window
        int cnt_ones = 0;
        for(int i=0;i<window_size;i++)
        {
            if(data[i] == 1)
                cnt_ones++;
        }
        
        // move window to find max count
        int max_ones = cnt_ones;
        for(int i = window_size; i<data.length; i++)
        {
            if(data[i] == 1)
            {
                cnt_ones++;
            }
            
            if(data[i-window_size] == 1)
            {
                 cnt_ones--; 
            }
            
            max_ones = Math.max(max_ones,cnt_ones);
        }
        
        return window_size-max_ones;
        
    }
}