/*
1929. Concatenation of Array
https://leetcode.com/problems/concatenation-of-array/
O(N)
O(1)
*/

class Solution {
    public int[] getConcatenation(int[] nums) 
    {
        int len = nums.length;
        int ans[]= new int[len*2];
        
        for(int i=0;i<len;i++)
        {
            ans[i] = ans[i+len] = nums[i];
        }
        
        return ans;      
    }
}