/*
896. Monotonic Array
https://leetcode.com/problems/monotonic-array/
O(N)
O(1)
*/
class Solution {
    public boolean isMonotonic(int[] nums) {
        
        if(nums.length == 1)
            return true;
        
        int l = 0,r =nums.length -1;
        boolean monotoneInc = false;
        if(nums[l] <= nums[r])
            monotoneInc=true;
        
        for(l=0;l<r;l++)
        {
            if(monotoneInc)
            {
                if(nums[l+1]<nums[l])
                {
                    return false;
                }
            }
            else
            {
                if(nums[l+1]>nums[l])
                {
                    return false;
                }
            }
        }
        
        return true;
    }
}