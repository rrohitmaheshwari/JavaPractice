/*
238. Product of Array Except Self
https://leetcode.com/problems/product-of-array-except-self/
O(N)
O(N)
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int  N= nums.length;
        int left[] = new int[N];
        int right[] = new int[N];
        int res[] = new int[N];
        
        left[0]=nums[0];
        for(int i=1;i<N;i++)
        {
            if(nums[i] == 0)
                break;
            left[i] = left[i-1] * nums[i];
        }
        
          right[N-1]=nums[N-1];
        for(int i=N-2;i>=0;i--)
        {
            if(nums[i] == 0)
                break;
            right[i] = right[i+1] * nums[i];
        }
        
        res[0] = right[1];
        res[N-1] = left[N-2];
        for(int i=1;i<N-1;i++)
        {
            res[i] = left[i-1] * right[i+1];
        }
        
        return res;
        
    }
}