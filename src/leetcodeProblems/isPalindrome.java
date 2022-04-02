/*
125. Valid Palindrome
https://leetcode.com/problems/valid-palindrome/
O(N)
O(1)
*/

class Solution {
    public boolean isPalindrome(String s) {
        int l=0,r=s.length()-1;
        while(l<r)
        {
            // ignore invalid char
             while (l < r && !Character.isLetterOrDigit(s.charAt(l))) 
              {
                l++;
              }
              while (l < r && !Character.isLetterOrDigit(s.charAt(r))) 
              {
                r--;
              }
            
             if (Character.toLowerCase(s.charAt(l)) 
                 != Character.toLowerCase(s.charAt(r)))
             {
                return false;
             }
            l++;
            r--;
            
        }
            return true;
    }
}