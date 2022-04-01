/*
678. Valid Parenthesis String
https://leetcode.com/problems/valid-parenthesis-string/
O(N)
O(1)
*/

class Solution {
    public boolean checkValidString(String s) {
               int lo = 0, hi = 0;
       for (char c: s.toCharArray()) {
           lo += c == '(' ? 1 : -1;
           hi += (c == '(' || c == '*')  ? 1 : -1;
           if (hi < 0) break; // hi cannot be nagative as it leads to unbalanced
           lo = Math.max(lo, 0); // if lo<0 then make it 0
       }
       return lo == 0;
    }
}