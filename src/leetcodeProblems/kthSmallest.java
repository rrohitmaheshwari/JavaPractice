/*
378. Kth Smallest Element in a Sorted Matrix
https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
O( X + KlogX).  - let X=min(K,N);
O(X)
*/

class Solution {
    class MNode
    {
        int r;
        int c;
        int val;
        MNode(int r,int c,int val)
        {
            this.r=r;
            this.c=c;
            this.val=val;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        
        // min heap to find min value
        PriorityQueue<MNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        
        for(int i=0;i<Math.min(matrix.length,k);i++)
        {
         pq.add(new MNode(i,0,matrix[i][0]));   
        }
        MNode n = pq.peek();
        while(k-- > 0)
        {
             n = pq.poll(); // probable and
                  int r = n.r, c = n.c;
            
            if(c<matrix.length -1)
            {
                pq.add(new MNode(r,c+1,matrix[r][c+1]));
            }
        }
        
        return n.val;
        
    }
}