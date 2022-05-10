/*
1423. Maximum Points You Can Obtain from Cards
https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

Sliding window

O(N)
O(N)
*/

class Solution {
     public int maxScore(int[] cardPoints, int k) 
     {
        int n = cardPoints.length, lSum = 0;
         
        for(int i = 0; i < k; ++i)
        {
            lSum += cardPoints[i];
        }
         
         //edge case
        if(n==k)
            return lSum;
         
        int max = lSum;
         
        for(int rSum = 0, i = 0; i < k; ++i)
        {
            rSum += cardPoints[n-1-i];
            lSum -= cardPoints[k-1-i];
            max = Math.max(max,lSum+rSum);
        }
         
        return max;
    }
}
