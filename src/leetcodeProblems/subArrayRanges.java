/*
2104. Sum of Subarray Ranges
https://leetcode.com/problems/sum-of-subarray-ranges/
O(N^2)
O(N)

There is also monotonic stack way to solve this
*/

class Solution {
    public long subArrayRanges(int[] nums) {
       
        long ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++)
        {
            int mx = nums[i], mn = nums[i];
            for (int j = i + 1; j < n; j++)
            {
                mx = Math.max(mx, nums[j]);
                mn = Math.min(mn, nums[j]);

                ans += (mx - mn);
            }
        }
        return ans;
        
    }
}