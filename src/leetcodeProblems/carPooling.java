/*
1094. Car Pooling
https://leetcode.com/problems/car-pooling/
O(NlogN) - sort and (loop + pq)
O(N) - worst case save everything in PQ

Ref: https://www.youtube.com/watch?v=08sn_w4LWEE
*/

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        Arrays.sort(trips,(lhs,rhs)->{
            return Integer.valueOf(lhs[1]) -  Integer.valueOf(rhs[1]); 
        });
        
        // min heap <time,capacity>
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((lhs,rhs)->{
             return Integer.valueOf(lhs.getKey()) -  Integer.valueOf(rhs.getKey()); 
        });
        
        int cap = 0;
        for(int t[]:trips)
        {
            while(!pq.isEmpty() && pq.peek().getKey()<=t[1])
            {
                cap = cap - pq.poll().getValue();
            }
            
           pq.add(new Pair(t[2],t[0])); 
           cap = cap + t[0]; 
            
            if(cap>capacity)
            {
                return false;
            }
        }
        
        return true;
        
    }
}