/*
833. Find And Replace in String
https://leetcode.com/problems/find-and-replace-in-string/
https://leetcode.com/explore/interview/card/google/59/array-and-strings/3057/
*/

class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
         
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int j = 0; j < indices.length; j++) 
        {
            if (s.startsWith(sources[j], indices[j])) 
            {
               map.put(indices[j], j); 
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) 
        {
            if (map.containsKey(i)) 
            {
                sb.append(targets[map.get(i)]);
                i += sources[map.get(i)].length()-1;
            } else 
            {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}