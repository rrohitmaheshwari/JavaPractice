/*
153. Find Minimum in Rotated Sorted Array
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
O(log N)
O(N)
*/

class Solution {
    public int findMin(int[] nums) {
        
        if(nums[0]<=nums[nums.length-1])
        {
            return nums[0];
        }
        
        int l = 0;
        int r = nums.length-1;
        int ans = l;
        
        while(l<=r)
        {
            int mid = (r-l)/2 +l; //prevent overflow
            
            if(nums[mid]>nums[nums.length-1])
            {
                ans = mid+1;
                l = mid+1;
            }
            else
            {
                r = mid-1;
            }
        }
        
        return nums[ans];
        
    }
}