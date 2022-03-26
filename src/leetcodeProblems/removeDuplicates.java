/*
26. Remove Duplicates from Sorted Array
https://leetcode.com/problems/remove-duplicates-from-sorted-array/
O(N)
O(1)
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        
        if(nums.length == 1)
        {
            return nums.length;
        }
        int l=0,r=0;
        
        while(r<nums.length)
        {
            
            while(r+1<nums.length && nums[r] == nums[r+1])
            {
                r++;
            }
            nums[l++] = nums[r];
            r++;
        }
        
        return l;
        
    }
}
