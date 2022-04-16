/*
647. Palindromic Substrings
https://leetcode.com/problems/palindromic-substrings/
O(N*N)
O(1)
*/
class Solution {
    public int countSubstrings(String s) 
    {
        int res=0;
        
        for(int i=0;i<s.length();i++)
        {
            res += helper(i,i,s) + helper(i,i+1,s);
        }
        
        return res;
    }
    
    int helper(int l,int r, String s)
    {
        int total=0;
        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r))
        {
            total++;
            l--;
            r++;
        }
        return total;
    }
}