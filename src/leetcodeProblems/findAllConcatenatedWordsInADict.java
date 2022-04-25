/*
472. Concatenated Words
https://leetcode.com/problems/concatenated-words/
O(N*M)
O(N*M)
*/

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) 
    {
        List<String> ans = new ArrayList<>();
        
        HashSet<String> wordSet = new HashSet<>(Arrays.asList(words));
        HashSet<String> cache = new HashSet<>();
        
        for (String word : words) 
        {
          if (dfs(word, wordSet, cache)) 
            {
                ans.add(word); 
            }  
        }
            
        return ans;
    }
    boolean dfs(String word, HashSet<String> wordSet, HashSet<String> cache) {
        if (cache.contains(word)) 
            return true;
        for (int i = 1; i < word.length(); i++) 
        {
            if (wordSet.contains(word.substring(0, i)))  // checking left portion
            {
                String suffix = word.substring(i); // now check right portion
                if (wordSet.contains(suffix) || dfs(suffix, wordSet, cache)) 
                {
                    cache.add(word);
                    return true;
                }
            }
        }
        return false;
    }
}