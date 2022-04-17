/*
1239. Maximum Length of a Concatenated String with Unique Characters
https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
O(2^N)
O(N) stack
*/

class Solution {
    int max_len=0;
    public int maxLength(List<String> arr) {
        backtrack(arr,0,"");
        return max_len;
    }
    
    void backtrack(List<String> arr,int index,String curr)
    {
        Set<Character> s = new HashSet<>();
        
        for(char ch:curr.toCharArray())
        {
            s.add(ch);
        }
        
        if(curr.length() == s.size())
        {
            max_len = Math.max(max_len,curr.length());
        }
        else
        {
            return; // path doesnt have unique characters anymore
        }
         if(index>=arr.size())
        {
            return;
        }
        
        // consider current
        backtrack(arr,index+1,curr+arr.get(index));
        
        //do not coside current
        backtrack(arr,index+1,curr);
        
    }
}