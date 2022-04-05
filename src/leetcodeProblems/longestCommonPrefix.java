/*
14. Longest Common Prefix
https://leetcode.com/problems/longest-common-prefix/
O(S) - S is the sum of all characters in all strings.
O(1)
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res= new StringBuilder();
        for(int i=0;i<strs[0].length();i++)
        {
            char c = strs[0].charAt(i);
            for(int j=0;j<strs.length;j++)
            {
                if(strs[j].length() == i || strs[j].charAt(i) !=c)
                    return res.toString();
            }
            res.append(c);
        }
        return res.toString();
    }
}
