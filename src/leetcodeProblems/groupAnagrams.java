/*
49. Group Anagrams
https://leetcode.com/problems/group-anagrams/
O(Nk) k is length of max string
O(NK) - hash map,ans store
*/


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hm = new HashMap<>();
        List<List<String>> res= new ArrayList<>();
        
        for(String str:strs)
        {
            String s = getGenericString(str);
            
            if(!hm.containsKey(s))
            {
                hm.put(s,new ArrayList<String>());
            }
            hm.get(s).add(str);

        }
        
        for(Map.Entry<String,List<String>> entry:hm.entrySet())
        {
            res.add(entry.getValue());
        }
        
        return res;
        
    }
    
    String getGenericString(String s)
    {
        int[] ch= new int[26]; // default everything is 0
        //or
        Arrays.fill(ch,0);
        
        StringBuilder sb= new StringBuilder();
        
        for(int i=0;i<s.length();i++)
        {
            ch[(int)(s.charAt(i) - 'a')]++;
        }
        
        for(int i=0;i<26;i++)
        {
            if(ch[i]>0)
            {
                sb.append((char)('a'+i));
                sb.append((char)(ch[i]+'0'));
                sb.append('#');
            }
        }
        
        return sb.toString();
        
    }
}