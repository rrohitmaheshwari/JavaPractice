/*
70. Climbing Stairs
https://leetcode.com/problems/climbing-stairs/
O(N)
O(N)
*/

class Solution {
    public int climbStairs(int n) {
        int memo[]=new int[n+1];
        return helper(0,n,memo);
    }
    int helper(int currstep, int target,int memo[])
    {
        if(currstep>target)
            return 0;
        
        if(currstep == target)
            return 1;
        
        if(memo[currstep] > 0)
        {
            return memo[currstep];
        }
        
        memo[currstep] = helper(currstep+1,target,memo)+ helper(currstep+2,target,memo);
        
        return memo[currstep];
    }
}

//Actual DP solution with O(1) memory
class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }

        int prev1 = 1;
        int prev2 = 2;

        for (int i = 3; i <= n; i++) {
            int newValue = prev1 + prev2;
            prev1 = prev2;
            prev2 = newValue;
        }

        return prev2;
    }
}