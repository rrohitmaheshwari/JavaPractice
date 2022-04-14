/*
1584. Min Cost to Connect All Points
https://leetcode.com/problems/min-cost-to-connect-all-points/
PRIMS algorithm
O(N*N*Log N)
O(N*N + N)
*/

class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        int n = points.length;
        
        // Min-heap to store minimum weight edge at top.
        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> (a.getKey() - b.getKey()));;
        
         // Track nodes which are included in MST.
        boolean[] inMST = new boolean[n];
        
        
        //  0 weight with 0 as starting point
        heap.add(new Pair(0, 0));
        int mstCost = 0;
        int edgesUsed = 0;
        
         while (edgesUsed < n) 
         {
            Pair<Integer, Integer> topElement = heap.poll();
            
             int weight = topElement.getKey();
             int currNode = topElement.getValue();
            
             // If node was already included in MST we will discard this edge.
             if (inMST[currNode]) 
             {
                 continue;
             }

             inMST[currNode] = true;
             mstCost += weight;
             edgesUsed++;
             
             for (int nextNode = 0; nextNode < n; ++nextNode)
             {
                  if (!inMST[nextNode]) 
                  {
                    int nextWeight = Math.abs(points[currNode][0] - points[nextNode][0]) + 
                                     Math.abs(points[currNode][1] - points[nextNode][1]);
        
                    heap.add(new Pair(nextWeight, nextNode));
                }
             }
         }
        return mstCost;
    }
}