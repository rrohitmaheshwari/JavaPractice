/*
743. Network Delay Time
https://leetcode.com/problems/network-delay-time/
Time complexity: O(N+ElogN)   -> logN is becuase of Queue operations
Space: O(N+E)

Dijkstra's algorithm

Ref: https://www.youtube.com/watch?v=EaphyqKU4PQ&t=0s
for diagram at timestamp: 12:23 
*/

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer,List<Pair<Integer,Integer>>> adj = new HashMap();
        // node-> [->neighbour_node, ->weight]
        
        // create adj list
        for(int t[]:times)
        {
            if(!adj.containsKey(t[0]))
            {
                adj.put(t[0],new ArrayList<>());
            }
            adj.get(t[0]).add(new Pair(t[1],t[2]));
        }
        
        // // pq of -> weight, node
        
        
     PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((a,b)->{
                return Integer.compare(a.getKey(),b.getKey());
        });
        
        pq.add(new Pair(0,k)); //weight, node
        
        int res = 0;
        HashSet<Integer> visited = new HashSet<>();
        
        while(!pq.isEmpty())
        {
            Pair<Integer,Integer> curr = pq.poll(); //weight, node
            
            if(visited.contains(curr.getValue()))
                continue;
            
            visited.add(curr.getValue());
                
            res = Math.max(res,curr.getKey());
            
            if(!adj.containsKey(curr.getValue()))  // no neigbours
            { 
                continue;
            }
            
            List<Pair<Integer,Integer>> neighbors = adj.get(curr.getValue());
            
            for(Pair<Integer,Integer> nb: neighbors)  //nb ->neighbour_node, ->weight
            {
                if(visited.contains(nb.getKey()))
                    continue;
                
                pq.add(new Pair(nb.getValue()+curr.getKey(),nb.getKey()));   //weight, node
            }           
        }
        
        // System.out.println(visited.size());
        
        return visited.size() == n? res:-1;
        
    }
}