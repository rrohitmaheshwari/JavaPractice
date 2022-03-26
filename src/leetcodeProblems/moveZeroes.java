/*
283. Move Zeroes
https://leetcode.com/problems/move-zeroes/
O(N)
O(1)
*/

class Solution {
    public void moveZeroes(int[] nums) {
        int pos = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] != 0)
            {
                nums[pos++]= nums[i];
            }
            
        }
        
        while(pos<nums.length)
        {
            nums[pos++] = 0;
        }
        
    }
}