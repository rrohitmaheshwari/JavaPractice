/*
424. Longest Repeating Character Replacement
https://leetcode.com/problems/longest-repeating-character-replacement/
O(N)  ->  getMax is O(26) -> O(1)
O(1)  -> hm of 26 it O(1)

Further optimization is no need to calculate max everytime as we calculate when we do  hmap[s.charAt(r)-'A']++;
For same max ans will remain same.
*/

class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int hmap[]=new int[26];
        int l=0,r=0;
        
        while(r!=s.length())
        {
            hmap[s.charAt(r)-'A']++;
            
            //check validity of window and slide
            while(l<=r && (r-l+1 - getMax(hmap) >k))
            {
                hmap[s.charAt(l)-'A']--;
                l++;
            }
            
            res=Math.max(res,r-l+1);
            r++;
        }

        return res;
        
    }
    int getMax(int hmap[])
    {
        int max=0;
        
        for(int i:hmap)
        {
            max = Math.max(max,i);
        }
        
        return max;
    }
}