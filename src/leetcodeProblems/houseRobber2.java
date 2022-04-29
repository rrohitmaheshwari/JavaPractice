/*
213. House Robber II
https://leetcode.com/problems/house-robber-ii/
O(N)
O(N)
*/

class Solution {
    
    private int[] memo;
    
    public int rob(int[] nums) {
        
        this.memo = new int[100];
        
        // Fill with sentinel value representing not-calculated recursions.
        Arrays.fill(this.memo, -1);
        
        int l = this.robFrom(0, nums,1);
        
        // this.memo = new int[100];
        Arrays.fill(this.memo, -1);
        int r = this.robFrom(1, nums,0);
        return Math.max(nums[0],Math.max(l,r));
    }
    
    private int robFrom(int curr, int[] nums,int i) {
        
        // No more houses left to examine.
        // do not rob last house
        if (curr >= nums.length-i) {
            return 0;
        }
        
        // Return cached value.
        if (this.memo[curr] > -1) {
            return this.memo[curr];
        }
        
        // Recursive relation evaluation to get the optimal answer.
        int ans = Math.max(this.robFrom(curr + 1, nums,i), this.robFrom(curr + 2, nums,i) + nums[curr]);
        
        // Cache for future use.
        this.memo[curr] = ans;
        return ans;
    }
}