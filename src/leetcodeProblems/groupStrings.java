/*
249. Group Shifted Strings
https://leetcode.com/problems/group-shifted-strings/
O(N*H) - H is for calculating hash 
O(N*H)
*/

class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String,List<String>> hm = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        
        for(String s:strings)
        {
            String reducedString = reduced(s);
            
            if(!hm.containsKey(reducedString))
            {
               hm.put(reducedString,new ArrayList<String>()); 
            }
            hm.get(reducedString).add(s);
        }
        
        for(Map.Entry<String,List<String>> entry:hm.entrySet())
        {
          res.add(entry.getValue());  
        }
        
        return res;
    }
    
    String reduced(String s)
    {
        StringBuilder res = new StringBuilder();
        if(s.length()==1)
        {
            return "##";
        }
        
        int diff=0;
        for(int i=0;i<s.length()-1;i++)
        {
            diff = (s.charAt(i+1)-s.charAt(i) + 26)%26;
            res.append((diff));
            res.append('#');
        }
        
        return res.toString();
    }
}