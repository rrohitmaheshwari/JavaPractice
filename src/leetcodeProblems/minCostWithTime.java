/*
1928. Minimum Cost to Reach Destination in Time
https://leetcode.com/problems/minimum-cost-to-reach-destination-in-time/

*/

class Solution {
    List<int []> [] graph;
    
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length; // this is number of nodes
        graph = new List [n]; //adj list
        
        // to store the reaching time(Dijkstra's distances)
        int [] minTime = new int [n];
        
        // initial all set to infinity
        Arrays.fill(minTime, Integer.MAX_VALUE);
        
        for (int i = 0; i < n; ++i){
            graph[i] = new ArrayList<>();
        }
        
        for (int [] edge : edges){
            graph[edge[0]].add(new int [] {edge[1], edge[2] });
            graph[edge[1]].add(new int [] {edge[0], edge[2] });
        }
        
        PriorityQueue<int []> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        queue.add(new int [] {0, passingFees[0], 0});  // node, fee, time spent
        
        // node, fee, time spent
        int [] current;
        
        int time, score;
        
        while (!queue.isEmpty()){
            current = queue.poll();
            int currNode = current[0];
            int currPassingFee = current[1];
            int currtimeSpent = current[2];
            
            if (currtimeSpent >= minTime[current[0]])
                continue;
            
            // update the reaching time of current node
            minTime[currNode] = currtimeSpent;
            
            if (currNode == n - 1) // desination
                return currPassingFee;
            
            for (int [] next : graph[current[0]]){
                time = currtimeSpent + next[1];  // new time if taken the edge
                score = currPassingFee + passingFees[next[0]];  // new score if taken the edge
                
                if (time > maxTime)   
                    continue;
                else if (time > minTime[next[0]])
                    continue;
                
                // add the new edge
                queue.add(new int [] { next[0], score, time });
            }
        }
        
        return -1;
    }
}