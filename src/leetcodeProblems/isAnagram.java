/*
242. Valid Anagram
https://leetcode.com/problems/valid-anagram/
O(n)
O(1) --> O(26) -> O(1)
*/

class Solution {
    public boolean isAnagram(String s, String t) 
    {
        if(s.length()!=t.length())
        {
            return false;
        }
        
        int cnt[]=new int[26];
        for(int i=0;i<s.length();i++)
        {
            cnt[s.charAt(i)-'a']++;
            cnt[t.charAt(i)-'a']--;
        }
        
        for(int i:cnt)
        {
            if(i!=0)
            {
                return false;
            }
        }
        
        return true;
    }
}