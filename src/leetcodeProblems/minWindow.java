/*
76. Minimum Window Substring
https://leetcode.com/explore/interview/card/google/59/array-and-strings/345/
*/

class Solution {
    public String minWindow(String s, String t) {
        // create frequency hashmap for saving count for t
        Map<Character,Integer> tmap = new HashMap<>();
        int uniqueTletters = 0;
        
        // window frequency hashmap
        Map<Character,Integer> window = new HashMap<>();
        int releventSletters = 0;
        
        //local pointer
        int lo,hi;
        
        //solution pointer
        int sollo=0,solhi=s.length()-1;
        
        // is any solution found?
        boolean found = false;
        
        for(int i=0;i<t.length();i++)
        {
                tmap.put(t.charAt(i),tmap.getOrDefault(t.charAt(i),0)+1);
        }
        
        uniqueTletters = tmap.size();
        
       for(lo=0,hi=0;hi<s.length();hi++)
       {
           // expand hi till we find solution
           
           char ch = s.charAt(hi);
  
           if(tmap.containsKey(ch))
           {
            window.put(ch,window.getOrDefault(ch,0)+1);
               
            if(window.get(ch).intValue() == tmap.get(ch).intValue())
                   {
                       releventSletters++;
                   }
           }
           
           // if solution found then reduce window
           while(uniqueTletters == releventSletters && lo<=hi)
           {
                 char chlo = s.charAt(lo);
               
               if(!found || hi-lo+1 < solhi-sollo+1)
               {
                   found = true;
                   sollo=lo;
                   solhi=hi;
               }            
               
                if(tmap.containsKey(chlo))
                {
                  window.put(chlo,window.get(chlo)-1);
                    
                    if(window.get(chlo).intValue() < tmap.get(chlo).intValue())
                    {
                       releventSletters--; 
                    }
                 
                }
               lo++;
           }
           
       }

        return found?s.substring(sollo,solhi+1):"";

    }
}
