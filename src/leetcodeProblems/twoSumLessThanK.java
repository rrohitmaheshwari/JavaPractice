/*
1099. Two Sum Less Than K
https://leetcode.com/problems/two-sum-less-than-k/
O(NLogN)
O(N) - sort

if input is limited we can also do it in O(N) as for sorting we can use count sort
*/

class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums); //n log n
        
        int l = 0;
        int r = nums.length -1;
        int ans = -1;
        
        // two pointer
        while(l<=r)
        {
            int sum = nums[l]+nums[r];
            if(sum<k)
            {
                ans = Math.max(sum,ans);
                l++;
            }
            else
            {
                r--;
            }
        }
        
        return ans;   
    }
}