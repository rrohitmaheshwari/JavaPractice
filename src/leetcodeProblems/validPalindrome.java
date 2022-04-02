/*
680. Valid Palindrome II
https://leetcode.com/problems/valid-palindrome-ii/
O(N)
O(1)
*/

class Solution {
    public boolean validPalindrome(String s) 
    {
        int l =0,r=s.length()-1;
        
        while(l<r)
        {
			if(s.charAt(l) == s.charAt(r))
			{
				l++;
				r--;
			}
			else
			{
				break;
			}
        }
        
        
        if(l==r)
        {
            return true; // already palindrome
        }
        else
        {
            return isPalindrome(s,l+1,r)||isPalindrome(s,l,r-1);
        }
    }
    
    boolean isPalindrome(String s,int i,int j)
    {
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}