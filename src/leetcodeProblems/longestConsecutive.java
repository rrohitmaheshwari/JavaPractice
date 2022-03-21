/*
128. Longest Consecutive Sequence
https://leetcode.com/problems/longest-consecutive-sequence/

O(N) 
O(N)
*/

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        int max_sq=0;
        for(int n:nums)
        {
            s.add(n);
        }
        
        for(int n:nums)
        {
            if(!s.contains(n-1)) // to check if n is starting point in series.
            {
                int sq=0;
                while(s.contains(n))
                {
                    sq++;
                    n++;
                }
                
                max_sq=Math.max(max_sq,sq);
            }
        }
        
        return max_sq;
    }
}