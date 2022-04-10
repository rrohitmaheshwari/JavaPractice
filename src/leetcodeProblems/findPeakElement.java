/*
162. Find Peak Element
https://leetcode.com/problems/find-peak-element/
*/
class Solution {
    public int findPeakElement(int[] nums) {
               int l = 0, r = nums.length - 1;
        int ans=l;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mid+1<nums.length && nums[mid] <= nums[mid + 1])
            {
                ans = mid+1;
                l = mid+1;
            }  
            else
            {
                 r = mid - 1;
            }   
        }
        return ans;
        
    }
}