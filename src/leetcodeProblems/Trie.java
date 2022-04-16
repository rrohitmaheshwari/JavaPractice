/*
208. Implement Trie (Prefix Tree)
https://leetcode.com/problems/implement-trie-prefix-tree/
O(m)
O(1)  --> O(26) hashmap is O(1)
*/

class Trie {
    HashMap<Character,Trie> hm;
    boolean isEnd;
    public Trie() {
        hm = new HashMap<>();      
    }
    
    public void insert(String word) 
    {
        Trie n = this;
        for(int i=0;i<word.length();i++)
        {
            if(n.hm.containsKey(word.charAt(i)))
            {
                
            }
            else
            {
                n.hm.put(word.charAt(i),new Trie());
            }
            n = n.hm.get(word.charAt(i));
        }
        
        n.isEnd = true;
        
    }
    
    public boolean search(String word) {
        Trie n = this;
        for(int i=0;i<word.length();i++)
        {
           if(n.hm.containsKey(word.charAt(i)))
            {
                 n = n.hm.get(word.charAt(i));
            }
            else
            {
               return false;
            }
        }
        return n.isEnd;      
    }
    
    public boolean startsWith(String prefix) {
              Trie n = this;
        for(int i=0;i<prefix.length();i++)
        {
           if(n.hm.containsKey(prefix.charAt(i)))
            {
                 n = n.hm.get(prefix.charAt(i));
            }
            else
            {
               return false;
            }
        }
        return true; 
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */