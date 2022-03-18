/*

159. Longest Substring with At Most Two Distinct Characters

https://leetcode.com/explore/interview/card/google/59/array-and-strings/3054/
https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/submissions/
*/

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) 
    {
        
        int n = s.length();
        
        //corner case
        if (n < 3) 
        {
          return n;  
        }
        
        // can be optimized
        Map<Character,Integer> m = new HashMap<>();
        int l=0,r=0;
        char ch;
        char lastseen=' ';
        int len=2;
        
        while(r<n)
        {
            // save last visited index
            m.put(s.charAt(r),r);
            
            //exceeded window
            if(m.size()==3)
            {
 
                int min=n;
                
                // delete the right most element of non recent char
                for(Map.Entry<Character,Integer> e:m.entrySet())
                {
                    min = Math.min(min,e.getValue());
                    if(min == e.getValue())
                    {
                       lastseen = e.getKey(); 
                    }
                }
                m.remove(lastseen);
                
                //set new l as deleted item index + 1
                l=min+1;
                
            }
            
            // calculate max len
            len = Math.max(len,r-l+1);
             r++;
        }
        return len;
    }
}