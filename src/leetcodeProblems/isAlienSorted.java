/*
953. Verifying an Alien Dictionary
https://leetcode.com/problems/verifying-an-alien-dictionary/
O(N + M) - M is number of char
O(26) -> O(1) we should use array hashmap instead.
*/

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<order.length();i++)
        {
            hm.put(order.charAt(i),i);
        }
        
        
        for(int i=0;i<words.length-1;i++)
        {
            
            for(int j=0;j<words[i].length();j++)
            {
            
                if(j>=words[i+1].length())  // apple, app
                    return false; 
                
                // in case not equal check for order
                if(words[i].charAt(j) != words[i+1].charAt(j))
                {
                    
                    if(hm.get(words[i].charAt(j)) > hm.get(words[i+1].charAt(j)))
                        return false;
                    else
                        break;
                }
                
            }
        }
        
        return true;
    }
}