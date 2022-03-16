/*
Longest Substring Without Repeating Characters
https://leetcode.com/explore/interview/card/google/59/array-and-strings/3047/
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        char ch;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [startIndex, currentIndex]
        for (int currentIndex = 0, startIndex = 0;  currentIndex < n; currentIndex++) {
            ch = s.charAt(currentIndex);
            // if we find repetative index update startIndex
            if (map.containsKey(ch)) {
                startIndex = Math.max(map.get(ch) + 1, startIndex);
            }
            ans = Math.max(ans, currentIndex - startIndex + 1);
            
            // update currentIndex 
            map.put(ch, currentIndex);
        }
        return ans;
    } 
}
