/*
191. Number of 1 Bits
https://leetcode.com/problems/number-of-1-bits/
O(N)
O(1)
*/

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0, mask = 1 ;
        while(n!=0)
        {
            ans+= n&mask;
            n=n>>>1;            
        }
        
        return ans;
        
    }
}