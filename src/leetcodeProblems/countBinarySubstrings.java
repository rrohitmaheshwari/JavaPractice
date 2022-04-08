/*
696. Count Binary Substrings
https://leetcode.com/problems/count-binary-substrings/
O(N)
O(N) - group
*/

class Solution {
    public int countBinarySubstrings(String s) {
        
        int grp[]=new int[s.length()];
        grp[0]=1;
        int t=0;
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)!=s.charAt(i-1))
            {
                t++; // move ahead
                grp[t]=1;
            }
            else
            {
                grp[t]++;
            }
        }
        
        int ans = 0;
        for(int i=1;i<=t;i++)
        {
                 ans += Math.min(grp[i-1], grp[i]);  
        }
        
        return ans;
        
    }
}