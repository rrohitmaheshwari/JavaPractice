/*
425. Word Squares
https://leetcode.com/problems/word-squares/
https://leetcode.com/explore/interview/card/google/62/recursion-4/370/
O(N26^L)
O(NL)
*/

class Solution {
    public List<List<String>> wordSquares(String[] words) {
        HashMap<String,List<String>> hm = new HashMap<>();
        List<List<String>> res= new ArrayList<>();
        
        buildmap(hm,words);

        for(String word:words)
        {
            LinkedList<String> combination = new LinkedList<String>();
            combination.addLast(word);
            backtrack(1,combination,hm,res,words,words[0].length());
        }
        
        return res;
    }
    
    void backtrack(int step,LinkedList<String> combination,HashMap<String,List<String>> hm,List<List<String>> res,String[] words,int N)
    {
        if(step==N) //found result
        {
            res.add((LinkedList<String>) combination.clone());
            return;
        }

        StringBuilder prefix = new StringBuilder();
        for (String word : combination) 
        {
          prefix.append(word.charAt(step));
        }
        
        List<String> l= hm.get(prefix.toString());
        
        if(l!=null)
        {   
            for (String candidate : hm.get(prefix.toString())) 
            {
              combination.addLast(candidate);
              backtrack(step + 1, combination,hm,res,words,N);
              combination.removeLast();
            }  
        }
        
    }
    
    void buildmap(HashMap<String,List<String>> hm,String[] words)
    {
        for(String word:words)
        {
            for(int i=1;i<word.length();i++)
            {
                 String prefix = word.substring(0, i);
                if(!hm.containsKey(prefix))
                {
                   hm.put(prefix,new ArrayList<>()); 
                }
                hm.get(prefix).add(word);
            }
        }
    }
}