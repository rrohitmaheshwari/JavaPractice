/*
1046. Last Stone Weight
https://leetcode.com/problems/last-stone-weight/solution/
O(NlogN)
O(N)
*/

class Solution {
    public int lastStoneWeight(int[] stones) {
        
        // create Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.valueOf(b)-Integer.valueOf(a));
        
        for(int st:stones)
        {
            pq.add(st);
        }

        while(!pq.isEmpty())
        {
            if(pq.size()==1)
            {
                return pq.poll();
            }
            
            int a=pq.poll();
            int b=pq.poll();
            
            if(a-b!=0)
            {
              pq.add(a-b);  
            }
        }
        
        return 0;
        
    }
}