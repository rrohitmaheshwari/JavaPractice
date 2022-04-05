/*
977. Squares of a Sorted Array
https://leetcode.com/problems/squares-of-a-sorted-array/
O(N)
O(1)
*/

class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int l=0,r=nums.length-1;
        int index=r;
        int result[]=new int[r+1];
        
        while(l<=r)
        {
            if(Math.abs(nums[l])>Math.abs(nums[r]))
            {
                result[index--] = nums[l]*nums[l]; 
                l++;
            }
            else
            {
                result[index--] = nums[r]*nums[r];
                r--;
            }
        }
        
        return result;
        
    }
}