/*
935. Knight Dialer
https://leetcode.com/problems/knight-dialer/
O(N)
O(1)
*/

class Solution {
    public int knightDialer(int n) {
        long oldDp[]=new long[10];
        
        Arrays.fill(oldDp,1);
        
        while(n-->1)
        {
            long dp[]=new long[10];
            dp[0] += (oldDp[4]+oldDp[6])% 1000000007;
            dp[1] += (oldDp[6]+oldDp[8])% 1000000007;
            dp[2] += (oldDp[7]+oldDp[9])% 1000000007;
            dp[3] += (oldDp[8]+oldDp[4])% 1000000007;
            dp[4] += (oldDp[3]+oldDp[9]+oldDp[0])% 1000000007;
            // dp[5] += 0;
            dp[6] += (oldDp[1]+oldDp[7]+oldDp[0])% 1000000007;
            dp[7] += (oldDp[2]+oldDp[6])% 1000000007;
            dp[8] += (oldDp[1]+oldDp[3])% 1000000007;
            dp[9] += (oldDp[4]+oldDp[2])% 1000000007;
            oldDp=dp;
        }
        
        long sum =0 ;
        for(long i:oldDp)
        {
            // System.out.println(i% 1000000007);
           sum+=(i);
            // sum = sum % 1000000007;
        }
        return (int)(sum % 1000000007);
        
        
        
    }
}