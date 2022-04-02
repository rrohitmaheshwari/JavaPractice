/*
921. Minimum Add to Make Parentheses Valid
https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
O(N)
O(1)
*/

class Solution {
    public int minAddToMakeValid(String S) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            bal += S.charAt(i) == '(' ? 1 : -1;
            // It is guaranteed bal >= -1
            if (bal == -1) {  // violation so this needs be be handled at end
                ans++;
                bal++;  //fixing bal count as we will handle violation in end
            }
        }

        return ans+bal; // we need to add bal to close the remaining active (
    }
}