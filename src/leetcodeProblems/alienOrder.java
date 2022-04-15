/*
269. Alien Dictionary
https://leetcode.com/problems/alien-dictionary/
O(C) -> visit every edge
O(U) -> adj of every vertice   ---> c an be O(1) as it cannot be greater than 26*26
*/

class Solution {
    Map<Character,List<Character>> adj = new HashMap<>();
    Map<Character, Boolean> seen = new HashMap<>();
    StringBuilder output = new StringBuilder();
    
    public String alienOrder(String[] words) 
    {
        
        //create adj list
        for(String word:words)
        {
            for(char c:word.toCharArray())
            {
                adj.putIfAbsent(c,new ArrayList<>());
            }
        }
        
        // create graph
        
        for(int i=0;i<words.length -1;i++)
        {
            String w1=words[i];
            String w2=words[i+1];
            
            //edge case  ["abcd" ,"abc"...] not correclty ordered
            if(w1.length() > w2.length() && w1.startsWith(w2))
            {
               return ""; 
            }
            
            for(int j=0;j<Math.min(w1.length(),w2.length());j++)
            {
                if(w1.charAt(j)!=w2.charAt(j))
                {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }
        
        // DFS
        for(Character c: adj.keySet())
        {
            if(!dfs(c))
            {
                return "";
            }
        }
        
        if(output.length()<adj.size())
        {
             return "";
        }
        
        return output.reverse().toString();
        
    }
    
    
    boolean dfs(Character c) {
        if (seen.containsKey(c)) 
        {
            // If this node was grey (false), a cycle was detected.
            return seen.get(c); 
        }
        seen.put(c, false);  // current dfs is handling this node so it reprents that its in path
        for (Character next : adj.get(c)) 
        {
            if (!dfs(next)) 
            {
                 return false;
            }
        }
        seen.put(c, true);  // now this node is visted and processed
        output.append(c);
        return true;
    }    
    
}