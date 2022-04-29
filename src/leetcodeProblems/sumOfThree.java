/*
2177. Find Three Consecutive Integers That Sum to a Given Number
https://leetcode.com/problems/find-three-consecutive-integers-that-sum-to-a-given-number/
O(1)
O(1)
*/

class Solution {
    public long[] sumOfThree(long num) {
        
        if(num%3 != 0)
            return new long[]{};
        
        long mid = num/3;
        
        return new long[]{mid-1,mid,mid+1};
        
    }
}