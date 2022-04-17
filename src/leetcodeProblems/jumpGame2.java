/*
45. Jump Game II
https://leetcode.com/problems/jump-game-ii/
O(N)
O(1)

Greedy approach similar to BFS
*/

class Solution {
    public int jump(int[] nums) 
    {
        int res=0;
        int l=0,r=0;
        int max;
        
        while(r<nums.length-1)
        {
            max = 0;
            for(int i=l;i<=r;i++)
            {
                max = Math.max(max,i+nums[i]);
            }
            
            l = r+1;
            r=max;
            res++;
        }
        
        return res;
        
    }
}