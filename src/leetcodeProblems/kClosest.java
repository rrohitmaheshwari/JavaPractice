/*
973. K Closest Points to Origin
https://leetcode.com/explore/interview/card/google/59/array-and-strings/3062/
https://leetcode.com/problems/k-closest-points-to-origin/
*/
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->{
            return (distance(b)-distance(a));
        });
            
            for(int i=0;i<points.length;i++)
            {
                pq.add(points[i]);
                if(pq.size()>k)
                {
                       pq.poll();
                }
            }
        
        int res[][]=new int[pq.size()][2];
        return pq.toArray(res);
    }
    
    private int distance(int a[])
    {
        return a[0]*a[0] + a[1]*a[1];
    }
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