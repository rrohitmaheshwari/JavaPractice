/*
205. Isomorphic Strings
https://leetcode.com/problems/isomorphic-strings/
https://leetcode.com/explore/interview/card/linkedin/339/array-and-strings/1999/

O(N)
O(M). ----> can be O(1) is we use hashmap,hashset as array of fixed inputs(ASCII) 
*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> m = new HashMap<>();
       Set<Character> seen = new HashSet<>();
        for(int i=0;i<s.length();i++)
        {
            if(m.containsKey(s.charAt(i)))
            {
                if(m.get(s.charAt(i)) != t.charAt(i))
                {
                    return false;
                }
            }
            else
            {
                // should map to unique value
                if(seen.contains(t.charAt(i)))
                {
                    return false;
                }
                m.put(s.charAt(i),t.charAt(i));
                seen.add(t.charAt(i));
            }
        }
        return true;
            
    }
}