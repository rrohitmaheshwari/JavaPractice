/*
69. Sqrt(x)
https://leetcode.com/problems/sqrtx/
O(logN)
O(1)
*/
class Solution {
    public int mySqrt(int x) {
        if(x<=1)
            return x;
        
        long l=1;
        long r=x;
        long ans=l;
        
        while(l<=r)
        {
            long mid = (r-l)/2+l;
            
            
            if(mid*mid <= x)
            {
                ans = mid;
                l=mid+1;
            }
            else
            {
                r=mid-1;
            }
            System.out.println("ans: "+ans+" mid:"+mid);
        }
        
        return (int)ans;
        
    }
}