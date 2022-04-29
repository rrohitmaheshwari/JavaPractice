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


// DP solution
class Solution {
    
    public int rob(int[] nums) {
        
        int N = nums.length;
        
        // Special handling for empty array case.
        if (N == 0) {
            return 0;
        }
        
        int[] maxRobbedAmount = new int[nums.length + 1];
        
        // Base case initializations.
        maxRobbedAmount[N] = 0;
        maxRobbedAmount[N - 1] = nums[N - 1];
        
        // DP table calculations.
        for (int i = N - 2; i >= 0; --i) {
            
            // Same as the recursive solution.
            maxRobbedAmount[i] = Math.max(maxRobbedAmount[i + 1], maxRobbedAmount[i + 2] + nums[i]);
        }
        
        return maxRobbedAmount[0];
    }
}