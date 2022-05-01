/*
1406. Stone Game III
https://leetcode.com/problems/stone-game-iii/
O(N)
O(N)
*/


class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int dp[] = new int[stoneValue.length];
        
        Arrays.fill(dp,Integer.MIN_VALUE);
        
         int res = helper(0,stoneValue.length,stoneValue,dp);
        
        if(res > 0)
        {
            return "Alice";
        }
        else if(res < 0)
        {
            return "Bob";
        }
        else 
            return "Tie";
    }
    
    int helper(int l,int len, int stoneValue[],int dp[])
    {
        if(l>=len)
            return 0;
        if(dp[l]!=Integer.MIN_VALUE)
        {
            return dp[l];
        }
        int l1=0,l2=0,l3=0;
        l1= stoneValue[l] - helper(l+1,len,stoneValue,dp);
        dp[l] =  l1;
        if(l+1<len)
        {
            l2= stoneValue[l]+stoneValue[l+1] - helper(l+2,len,stoneValue,dp);
            dp[l] =  Math.max(dp[l],l2);
        }
        if(l+2<len)
            {
            l3 = stoneValue[l]+stoneValue[l+1]+stoneValue[l+2] - helper(l+3,len,stoneValue,dp);
            dp[l] =  Math.max(dp[l],l3);
        }
        
        return dp[l];
    }
}


/*
Solution 2: Bottom up DP

Let dp[i] denote the maximum difference in the score of the current player against the opponent in the ith turn.
There are 3 options for the current player to choose:
Take A[i], diff1 = take - dp[i+1]
Take A[i] + A[i+1], diff2 = take - dp[i+2]
Take A[i] + A[i+1] + A[i+2], diff3 = take - dp[i+3]
We want to maximize difference in the score of the current player against the opponent, so dp[i] = max(diff1, diff2, diff3)
*/
 
class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int take = 0;
            dp[i] = Integer.MIN_VALUE;
            for (int j = i; j < Math.min(n, i + 3); j++) {
                take += stoneValue[j];
                dp[i] = Math.max(dp[i], take - dp[j + 1]);
            }
        }
        int diff = dp[0]; // Alice goes first, starting from the first stone
        if (diff > 0) return "Alice";
        if (diff < 0) return "Bob";
        return "Tie";
    }
}