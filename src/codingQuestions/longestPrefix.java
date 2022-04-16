/*
1392. Longest Happy Prefix
https://leetcode.com/problems/longest-happy-prefix/
O(N)
O(1)

// Rolling hash solution
*/
class Solution {
    public String longestPrefix(String s) 
    {
           long h1 = 0, h2 = 0, mul = 1, len = 0, mod = 1000000007;
        
    for (int i = 0, j = s.length() - 1; j > 0; ++i, --j) 
    {
        int first = s.charAt(i) - 'a'
            , last = s.charAt(j) - 'a';
        
        h1 = (h1 * 26 + first) % mod;
        h2 = (h2 + mul * last) % mod;
        
        mul = mul * 26 % mod;
        
        if (h1 == h2)
            len = i + 1;
    }
    return s.substring(0, (int)len);  \
          
    }
}