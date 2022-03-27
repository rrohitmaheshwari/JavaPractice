/*
198. House Robber
https://leetcode.com/problems/house-robber/
O(N)
O(N) - memonization
*/

class Solution {
    
    private int[] memo;
    
    public int rob(int[] nums) {
        
        this.memo = new int[100];
        
        // Fill with sentinel value representing not-calculated recursions.
        Arrays.fill(this.memo, -1);
        
        return this.robFrom(0, nums);
    }
    
    private int robFrom(int curr, int[] nums) {
        
        // No more houses left to examine.
        if (curr >= nums.length) {
            return 0;
        }
        
        // Return cached value.
        if (this.memo[curr] > -1) {
            return this.memo[curr];
        }
        
        // Recursive relation evaluation to get the optimal answer.
        int ans = Math.max(this.robFrom(curr + 1, nums), this.robFrom(curr + 2, nums) + nums[curr]);
        
        // Cache for future use.
        this.memo[curr] = ans;
        return ans;
    }
}