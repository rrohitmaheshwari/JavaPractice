/*
210. Course Schedule II
https://leetcode.com/problems/course-schedule-ii/solution/
https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/3070/
*/

class Solution {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) 
    {
        // adjacency list
        Map<Integer,List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];
        int[] res = new int[numCourses];
        
        int src,des;
        for(int i = 0;i<prerequisites.length;i++)
        {
            // reversing direction so that depency comes first in solution
            des= prerequisites[i][0];
            src = prerequisites[i][1];
            List<Integer> temp = graph.getOrDefault(src,new ArrayList<Integer>());
            temp.add(des);
            graph.put(src,temp);
            
            // update indegree(to be used in tological sort)
            inDegree[des]++;
        }
        
        // Do topological sort
        Queue<Integer> q = new LinkedList<Integer>();
        
        // put all nodes which has indegree 0
        for(int i=0;i<inDegree.length;i++)
        {
            if(inDegree[i]==0)
            {
                q.add(i);
            }
        }
        
        int i=0;
        
        // Execute till q has value
        while(!q.isEmpty())
        {
            int node=q.poll();
            res[i++]=node;
            if(graph.containsKey(node))
            {
                for(Integer n:graph.get(node))
                {
                    inDegree[n]--;
                    //
                    if(inDegree[n] == 0)
                    {
                        q.add(n);
                    }
                }
            }
        }
        
        // check for valid sol
        if(i == numCourses)
        {
            return res;
        }
        
        return new int[0];
    }
}