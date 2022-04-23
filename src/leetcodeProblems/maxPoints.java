/*
1937. Maximum Number of Points with Cost
https://leetcode.com/problems/maximum-number-of-points-with-cost/
O(MN)
O(N) - 3 arrays

Taken from: https://leetcode.com/problems/maximum-number-of-points-with-cost/discuss/1344908/C%2B%2BJavaPython-3-DP-Explanation-with-pictures-O(MN)-Time-O(N)-Space

Images in above link
*/

class Solution {
   public long maxPoints(int[][] P) 
   {
        int m = P.length, n = P[0].length; // row & col
       
        long[] pre = new long[n];  // stores max at each level
       
        for (int i = 0; i < n; ++i) // compute 1st line as it is
            pre[i] = P[0][i];
       
       // starting from next line
        for (int i = 1; i < m; ++i)
        {
            // declare 3 arrays left_max,right_max & cur(this will become pre)
            long[] lft = new long[n]
                , rgt = new long[n]
                , cur = new long[n];
            
            // left and right corner max
            lft[0] = pre[0];
            rgt[n - 1] = pre[n - 1];
            
            
            // left
            for (int j = 1; j < n; ++j)
                lft[j] = Math.max(lft[j - 1] - 1, pre[j]);
            
            //right
            for (int j = n - 2; j >= 0; --j)
                rgt[j] = Math.max(rgt[j + 1] - 1, pre[j]);
            
            // current level
            for (int j = 0; j < n; ++j)
                cur[j] = P[i][j] + Math.max(lft[j], rgt[j]);
            
            // change pointer
            pre = cur;
        }
       
        long ans = Integer.MIN_VALUE;
       
        for (int i = 0; i < n; ++i)
            ans = Math.max(ans, pre[i]);
       
        return ans;
    }
}