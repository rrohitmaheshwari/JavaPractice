/*
1647. Minimum Deletions to Make Character Frequencies Unique
https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
O(N+ 26*Log26)
O(26)
*/

class Solution {
    public int minDeletions(String s) 
    {
        int delCount = 0;
        int[] frequency = new int[26];
    
        for (int i = 0; i < s.length(); i++) 
        {
            frequency[s.charAt(i) - 'a']++;
        }
        
        // we do not care about the characters, we just need numbers
        Arrays.sort(frequency);
        
        int maxAllowedFreq = s.length();
        
        for(int i=25;i >= 0 && frequency[i] > 0; i--)
        {
            if(frequency[i] > maxAllowedFreq)
            {
                delCount = delCount + (frequency[i] - maxAllowedFreq);
                frequency[i] = maxAllowedFreq;
            }
            
            maxAllowedFreq = Math.max(frequency[i] - 1,0);
        }
        
        return delCount;
    }
}