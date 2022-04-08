/*
1268. Search Suggestions System
https://leetcode.com/problems/search-suggestions-system/
O(NM)
O(N)
*/

class Solution {
    
    class Node
    {
        char ch;
        boolean isWord;
        TreeMap<Character,Node> child;
        
        Node(char ch)
        {
            this.ch= ch;
            child = new TreeMap<>();
        }
    }
    
    class Trie
    {
        Node root;
        List<String> res;
            
        Trie()
        {
            root = new Node(' ');
            res = new ArrayList<>();
        }
        
        void insert(String s)
        {
            Node curr = root;
            for(char ch:s.toCharArray())
            {
                if(!curr.child.containsKey(ch))
                {
                    curr.child.put(ch,new Node(ch));
                }
                curr = curr.child.get(ch);
            }
            curr.isWord = true;
        }
        
        List<String> dfs(String s)
        {
            List<String> r = new ArrayList<>();
            Node curr = root;
            
            // reach till search node
            for(char c : s.toCharArray())
            {
                
                if(curr.child.containsKey(c))
                    curr = curr.child.get(c);
                else
                    return r;
            }
            dfsHelper(curr,r,s);
  
            return r;
            
        }
        
        void dfsHelper(Node curr,List<String> r,String word)
        {
         if(r.size()==3)
         {
             return;
         }
          if(curr.isWord)
              r.add(word);
            
            //itereate over child 
            for(Map.Entry<Character,Node> e: curr.child.entrySet())
            {
                dfsHelper(e.getValue(),r,word+e.getKey());
            }
              
        }

        
    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        Arrays.sort(products);
        List<List<String>> res = new ArrayList<>();
        Trie T = new Trie();
        
        for(String s:products)
        {
            T.insert(s);    
        }
        
        for(int i=1;i<=searchWord.length();i++)
        {
            String s = searchWord.substring(0,i);
            // System.out.println(s);
            
            res.add(T.dfs(s));
            
        }
        
        return res;
        
    }
}