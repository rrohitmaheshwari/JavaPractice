/*
1209. Remove All Adjacent Duplicates in String II
https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
O(N)
O(N)
*/

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character,Integer>> st = new Stack();
        
        StringBuilder res = new StringBuilder();
        
        for(int i=0;i<s.length();i++)
        {
             
            if(st.isEmpty() || st.peek().getKey()!=s.charAt(i))
            {
                st.push(new Pair(s.charAt(i),1));
            }
            else
            {
                Pair<Character,Integer> p = st.pop();
                int val = Integer.valueOf(p.getValue());
                if(val == k-1)
                    continue;
                st.push(new Pair(s.charAt(i),val+1));
            }
  
        }
        
        while(!st.isEmpty())
        {
            Pair<Character,Integer> p = st.pop();
            for(int i=0;i<Integer.valueOf(p.getValue());i++)
            {
                res.append(p.getKey());
            }
        }
        
        return res.reverse().toString();
        
    }
}