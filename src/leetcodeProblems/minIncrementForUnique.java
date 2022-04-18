/*
945. Minimum Increment to Make Array Unique
https://leetcode.com/problems/minimum-increment-to-make-array-unique/
O(NLogN)
O(1)
--------
alternate solutions
https://leetcode.com/problems/minimum-increment-to-make-array-unique/discuss/197687/JavaC%2B%2BPython-Straight-Forward
*/


class Solution {
    public int minIncrementForUnique(int[] nums) 
    {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int max = nums[0];
        int ans = 0;
        
        for(int i=0;i<nums.length;i++)
        {
            ans = ans+ max-nums[i];
            nums[i] = max;
            if(i+1<nums.length)
            {
                max = Math.max(nums[i+1],max+1);          
            }
        }
        
        return ans;
    }
}