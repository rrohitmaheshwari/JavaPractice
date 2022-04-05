/*
724. Find Pivot Index
https://leetcode.com/problems/find-pivot-index/
O(N)
O(1)
*/
class Solution {
    public int pivotIndex(int[] nums) {
        
        int sum = 0, leftsum = 0;
        
        for (int x: nums) 
        {
            sum += x;
        }
        
        for (int i = 0; i < nums.length; ++i) 
        {
            if (leftsum == sum - leftsum - nums[i]) 
            {
                return i;
            }
            leftsum += nums[i];
        }
        
        return -1;
    }
}