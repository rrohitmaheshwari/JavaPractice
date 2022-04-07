/*
1337. The K Weakest Rows in a Matrix
https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
O(mn+mlogk) ----> can be improved O(mlogn+mlogk) if we use binary search
O(k+1) - pq size
*/
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((a,b)->{
            if(a.getValue()>b.getValue())
            {
                return -1;  // no change
            }
            else if(a.getValue()<b.getValue())
            {
                return 1; // change
            }
            else
            {
                return b.getKey()-a.getKey();
            }
        });
        
        int index=0;
        for(int m[]:mat)
        {
            int cnt = 0;
            for(int i:m)
            {
                if(i==1)
                    cnt++;
            }
            pq.add(new Pair<Integer,Integer>(index,cnt));
            if(pq.size()>k)
            {
                pq.poll();
            }
            index++;
        }
        
        int res[] = new int[k];
        index=k-1;
        while(!pq.isEmpty())
        {
            res[index--] = pq.poll().getKey();
        }
        
        return res;
        
    }
}