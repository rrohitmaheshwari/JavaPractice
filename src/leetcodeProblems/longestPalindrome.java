/*
5. Longest Palindromic Substring
https://leetcode.com/problems/longest-palindromic-substring/
O(N*N) 
O(1)

Approach 5: Manacher's Algorithm O(N) tbd
*/

class Solution {
    public String longestPalindrome(String s) {
        // corner cases
        if(s==null || s.length()<1)
        {
            return "";
        }
        
        int startIndex = 0,endIndex=0;
        
        for(int i=0;i<s.length();i++)
        {
            int len1=searchPalindrome(s,i,i+1);
            int len2=searchPalindrome(s,i,i);
            int len = Math.max(len1,len2);
            if(len>endIndex-startIndex)
            {
                startIndex = i-(len-1)/2;
                endIndex = i+len/2;
            }
        }
        
        return  s.substring(startIndex, endIndex + 1);
    }
    
    //return len of palindrome
    int searchPalindrome(String s,int L,int R)
    {
        while(L>=0 && R<s.length() && s.charAt(L) == s.charAt(R))
        {
            L--;
            R++;
        }
        return R-L-1;
    }
}