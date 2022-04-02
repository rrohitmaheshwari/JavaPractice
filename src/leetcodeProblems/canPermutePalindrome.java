/*
266. Palindrome Permutation
https://leetcode.com/problems/palindrome-permutation/
O(N)
*/

class Solution {
    public boolean canPermutePalindrome(String s) {
        
        boolean b[]=new boolean[26];
        char ch;
        
        for(int i=0;i<s.length();i++)
        {
            ch= s.charAt(i);
            b[ch-'a'] = !b[ch-'a'];
        }
        
        int cntTrues=0;
        for(int i=0;i<26;i++)
        {
            if(b[i])
                cntTrues++;
        }
        
        return cntTrues<=1;
            
        
    }
}