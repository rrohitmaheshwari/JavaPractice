/*
1048. Longest String Chain
https://leetcode.com/problems/longest-string-chain/

O(N*M) - word list * avg size
O(N)
DFS copied solution


Another sol could be sort and then form bucket from size l to size l+1 then form graph
*/

class Solution {
    
    HashSet<String> set = new HashSet<>();
    
    HashMap<String, Integer> memo = new HashMap<>();
    
    public int longestStrChain(String[] words) 
    {
        for (String word : words) {
            set.add(word);
        }
        
        int res = Integer.MIN_VALUE;
        for (String word : words) {
            res = Math.max(res, 1 + dfs(word));
        }
        return res;
    }
    
    public int dfs(String sb) {
        
        if (sb.length() == 0) 
        {
            return 0;
        }
        
        if (memo.containsKey(sb)) 
            return memo.get(sb);
        
        int max = 0;
        
        // remove char for each index and check
        for (int i = 0; i < sb.length(); i++) 
        {
            StringBuilder tmp = new StringBuilder(sb);
            tmp.deleteCharAt(i);
            
            int res = 0;
            
            if (set.contains(tmp.toString()))  // found some string
            {
                res += 1 + dfs(tmp.toString());
            }
            
            max = Math.max(max, res);
        }
        
        memo.put(sb, max);
        
        return max;
    }
}