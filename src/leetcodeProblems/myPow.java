/*
50. Pow(x, n)
https://leetcode.com/problems/powx-n/
O(log N)
O(1)
*/

class Solution {
    public double myPow(double x, int n) {

        long m = n > 0 ? n : -(long)n;
            
    double ans = 1.0;
        
    while (m != 0) 
    {
        if ((m % 2) == 1)
            ans *= x;
        x *= x;
        m =m/2;
    }
        
      return n >= 0 ? ans : 1 / ans;
    }
}