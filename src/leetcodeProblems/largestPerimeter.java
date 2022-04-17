/*
976. Largest Perimeter Triangle
https://leetcode.com/problems/largest-perimeter-triangle/
O(N)
O(1)
*/

class Solution {
    public int largestPerimeter(int[] nums) {
        
        Arrays.sort(nums);
        
        for(int i=nums.length-1 ; i>=2 ;i--)
        {
            if(nums[i]<nums[i-1]+nums[i-2])  //valid triangle condition
            {
                return nums[i]+nums[i-1]+nums[i-2];
            }
        }
        
        return 0;
    }
}