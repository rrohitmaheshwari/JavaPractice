/*
332. Reconstruct Itinerary
https://leetcode.com/problems/reconstruct-itinerary/
O(E^2 + ElogE) -> DFS (E) and backtacking (E^2)
O(E) -> to hold adj
*/

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) 
    {
        List<String> res= new ArrayList<>();
        
        // sort list based on key then value so that our adj will lead to lexical order sol
        Collections.sort(tickets,(lhs,rhs)->
                         {
                             if(lhs.get(0).equals(rhs.get(0)))
                             {
                                 return lhs.get(1).compareTo(rhs.get(1));
                             }
                             else
                             {
                                 return lhs.get(0).compareTo(rhs.get(0));
                             }
                             
                         });
        
        
        HashMap<String,List<String>> adj  = new HashMap<>();
        
        for(List<String> t:tickets)
        {
            if(!adj.containsKey(t.get(0)))
            {
                adj.put(t.get(0),new ArrayList<>());
            }
            adj.get(t.get(0)).add(t.get(1));
            
            if(!adj.containsKey(t.get(1)))
            {
                adj.put(t.get(1),new ArrayList<>());
            }
        }
        
        res.add("JFK");
        
        dfs("JFK",adj,res,tickets.size()+1);
        
        return res;
    }
    
    boolean dfs(String src,HashMap<String,List<String>> adj, List<String> res,int target_size) 
    {
        if(res.size()==target_size)
        {
            return true;
        }
        
        if(adj.get(src).size()==0)
        {
            return false;
        }
        
        // make copy of array list since we will be updating our adj on go
        List<String> tempAdj = new ArrayList<String>(adj.get(src));
        
        // backtrack
        for(int i=0;i<tempAdj.size();i++)
        {
            String s = tempAdj.get(i);
            
            // remove node
            adj.get(src).remove(i);
            res.add(s);
            
            if(dfs(s,adj,res,target_size))
                return true;
            
            // add node
            adj.get(src).add(i,s);
            res.remove(res.size()-1);    
        }
             
        return false;
    }
}