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

/*
recursion approach
O(log N)
O(log N) 
*/

class Solution {
    public double myPow(double x, int n) {
        long N = n;  //casting it to long just to be safe -n -> n fails when n is MIN_INT
        
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        return helperPow(x,N);
    }
    
    double helperPow(double x,Long n)  // space O(log N) stacks (could also be reduced to O(1) if we follow iterative approach)
    {
        if(n==0L)
            return 1D;
        if(n==1L)
            return x;
        
        double ans = helperPow(x,n/2);  // time complexity O(log N)
        ans = ans *ans;
        if(n%2 == 1)
            ans = ans * x;
        
        return ans;    
    }
    
}