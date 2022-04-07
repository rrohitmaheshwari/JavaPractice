/*
1642. Furthest Building You Can Reach
https://leetcode.com/problems/furthest-building-you-can-reach/
O(NlogN)
O(N) - heap
*/

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) 
    {
        // max heap for brinks
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.valueOf(b)-Integer.valueOf(a));
  
        for(int i=0;i<heights.length-1;i++)
        {
            int climb = heights[i+1]-heights[i];
            
            if(climb<=0) //fall
            {
                continue;
            }
            
            pq.add(climb);
            bricks-=climb;
            
            // if ladder and brick are over then break
            if(bricks<0 && ladders==0)
            {
                return i;
            }
            
            if(bricks<0) //bricks over then allocate ladder
            {
                bricks+=pq.poll();
                ladders--;
            }
        }        
        
           return heights.length - 1;    
    }
}