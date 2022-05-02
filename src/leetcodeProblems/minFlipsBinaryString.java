/*
1888. Minimum Number of Flips to Make the Binary String Alternating
https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/
O(N)
O(N)

Ref:
https://www.youtube.com/watch?v=MOeuK6gaC2A

TimeStamp: 10:12 for image
*/

class Solution {
    public int minFlips(String s) 
    {
       int n = s.length();
        char s1[] = new char[n*2];
        char s2[] = new char[n*2];
        s += s;
        
        
        // creating strings like 1010101 & 0101010
        for(int i = 0; i < n*2; i++) {
            s1[i] = (i % 2 == 0) ? '0' : '1';
            s2[i] = (i % 2 == 0) ? '1' : '0';
        }
        
        int ans1 = 0, ans2 = 0, ans = Integer.MAX_VALUE;
        
        for(int i = 0; i < n*2; i++) {
            
            if(s1[i] != s.charAt(i)) 
                ++ans1;
            if(s2[i] != s.charAt(i)) 
                ++ans2;
            
            if(i >= n) { //the most left element is outside of sliding window, we need to subtract the ans if we did `flip` before.
                if(s1[i-n] != s.charAt(i - n)) 
                    --ans1;
                if(s2[i-n] != s.charAt(i - n)) 
                    --ans2;
            }
            
            if(i >= n - 1)
            {
                ans = Math.min(ans,ans1);
                ans = Math.min(ans,ans2);
            }
                
        
        }
        return ans;
        
    }
}