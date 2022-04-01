/*
152. Maximum Product Subarray
https://leetcode.com/problems/maximum-product-subarray/
O(N)
O(1)
*/

class Solution {
    public int maxProduct(int[] nums) {
        
        int min=nums[0];
        int max=nums[0];
        int ans = nums[0];
        
        for(int i=1;i<nums.length;i++)
        {
            int prodwithMin = nums[i]*min;
            int prodwithMax = nums[i]*max;
            min = Math.min(nums[i],Math.min(prodwithMin,prodwithMax));
            max = Math.max(nums[i],Math.max(prodwithMin,prodwithMax));
            ans=Math.max(ans,max);
        }
        
        return ans;
    }
}