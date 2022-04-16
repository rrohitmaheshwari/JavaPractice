/*
211. Design Add and Search Words Data Structure
https://leetcode.com/problems/design-add-and-search-words-data-structure/
O(N) - N is len of word
O(1)  - HM is constant as max would be 26
*/
class WordDictionary {
    class TrieNode
    {
        Map<Character,TrieNode> hm = new HashMap<>();
        boolean word = false;
        public TrieNode(){}
    }

    TrieNode trie;
    public WordDictionary() {
        trie = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode n = trie;
        for(int i=0;i<word.length();i++)
        {
            if(!n.hm.containsKey(word.charAt(i)))
            {
                n.hm.put(word.charAt(i),new TrieNode());
            }
            n = n.hm.get(word.charAt(i));
        }
        n.word = true;
    }
      public boolean search(String word) 
      {
        return searchInNode(word, trie);
    }
    
    public boolean searchInNode(String word, TrieNode n) 
    {
        for (int i = 0; i < word.length(); i++) 
        {
            char ch = word.charAt(i);
            if (!n.hm.containsKey(ch)) 
            {
                if (ch != '.') 
                {
                    return false;
                }

                // handle '.' cases
                for(Map.Entry<Character,TrieNode> e:n.hm.entrySet())
                {
                   if(searchInNode(word.substring(i+1),e.getValue()))
                   {
                       return true;
                   }
                }
                
                return false;
                
            }
            else
            {
                 n = n.hm.get(ch);
            }
        }
        
        return n.word;
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */