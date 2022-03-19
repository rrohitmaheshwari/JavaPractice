/*
973. K Closest Points to Origin
https://leetcode.com/explore/interview/card/google/59/array-and-strings/3062/
https://leetcode.com/problems/k-closest-points-to-origin/
*/
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->{
            return b[0]-a[0];
        });
            
            for(int i=0;i<points.length;i++)
            {
                     int[] entry = {distance(points[i]), i};
                if(pq.size()<k)
                {
                    pq.add(entry);
                }
                else
                {
                    if(entry[0]<pq.peek()[0])
                    {
                        pq.poll();
                        pq.add(entry);
                    }
                }
            }
        
        int res[][]=new int[pq.size()][2];
        int i=0;
        
        while(!pq.isEmpty())
        {
            res[i] = points[pq.poll()[1]];
            i++;
        }
        
        return res;
    }
    
    private int distance(int a[])
    {
        return a[0]*a[0] + a[1]*a[1];
    }

    /* OR

     public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->{
            return (int)((b[0]*b[0] + b[1]*b[1])-(a[0]*a[0] + a[1]*a[1]));
        });
            
            for(int i=0;i<points.length;i++)
            {
                if(pq.size()<k)
                {
                    pq.add(points[i]);
                }
                else
                {
                    if(distance(pq.peek())>distance(points[i]))
                    {
                        pq.poll();
                        pq.add(points[i]);
                    }
                }
            }
        
        int res[][]=new int[pq.size()][2];
        return pq.toArray(res);
    } */
}