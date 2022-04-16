/*
1405. Longest Happy String
https://leetcode.com/problems/longest-happy-string/
O(N)  - PQ complexit is log(3) -> linear
O(1) - PQ space is 3 so linear
*/
class Solution {
    public String longestDiverseString(int a, int b, int c) 
    {
        // max heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((lhs,rhs)->(rhs[1]-lhs[1]));
        
        StringBuilder res= new StringBuilder();
        
        if(a!=0)
        {
            pq.add(new int[]{(int)'a',a});
        }
        if(b!=0)
        {
            pq.add(new int[]{(int)'b',b});   
        }
        if(c!=0)
        {
            pq.add(new int[]{(int)'c',c});   
        }

        while(!pq.isEmpty())
        {
            int val1[]=pq.poll();
            
            if(res.length() > 1 
               && res.charAt(res.length()-1) == (char)val1[0] 
               && res.charAt(res.length()-2) == (char)val1[0] )
            {
                // no element remaining
                if(pq.isEmpty())
                {
                    break;
                }
                
                //pop 2nd element 
                int val2[]=pq.poll();
                res.append((char)val2[0]);
                val2[1]--;
                
                // only add if relevant
                if(val2[1]!=0)
                {
                    pq.add(val2);
                }
            }
            else
            {
                res.append((char)val1[0]);
                val1[1]--;
            }
            
            // only add if relevant
            if(val1[1]!=0)
            {
                pq.add(val1);
            }         
        }
        
        return res.toString();
    }
}