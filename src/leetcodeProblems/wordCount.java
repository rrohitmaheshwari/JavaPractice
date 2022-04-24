/*
2135. Count Words Obtained After Adding a Letter
https://leetcode.com/problems/count-words-obtained-after-adding-a-letter/

Denote S = startWords.length and T = targetWords.length. Let m and n be the average sizes of the words in startWords and targetWords respectively, then,

Time & space: O(S * m + T * n).

*/
class Solution {
   public int wordCount(String[] startWords, String[] targetWords) 
   {
        Map<Integer, Set<String>> groups = new HashMap<>();
       
        for (String w : startWords) 
        {
            char[] ca = getHash(w);
            groups.computeIfAbsent(w.length(), s -> new HashSet<>()).add(String.valueOf(ca));
        }
       
        int cnt = 0;
       
        outer:
        for (String w : targetWords) 
        {
            int sz = w.length() - 1;
            
            if (groups.containsKey(sz)) 
            {
                char[] ca = getHash(w);
                
                for (char c : w.toCharArray()) 
                {
                    --ca[c - 'a'];
                    if (groups.get(sz).contains(String.valueOf(ca))) {
                        ++cnt;
                        break;
                    }
                    ++ca[c - 'a'];
                }
            }
        }
        return cnt;
    }
    private char[] getHash(String w) {
        char[] ca = new char[26];
        for (char c : w.toCharArray()) {
            ++ca[c - 'a'];
        }
        return ca;
    }
}