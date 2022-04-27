/*
2158. Amount of New Area Painted Each Day
https://leetcode.com/problems/amount-of-new-area-painted-each-day/
O(N*M) -> N is number of paint | M is the painting portion
O(N)
*/

class Solution {
    public int[] amountPainted(int[][] paint) 
    {
            if (paint == null || paint.length == 0) 
                return new int[0];

            int[] lines = new int[100001]; 
            int[] ans = new int[paint.length];

            for (int i=0; i<paint.length; i++) 
            {
                // extract start and end point
                int start = paint[i][0];
                int end = paint[i][1];
                
                // System.out.format("OUTER-------->start:%d end:%d\n",start,end);  
                
                while (start < end) 
                {
                    // System.out.format("start:%d end:%d\n",start,end);  
                    // for(int l:lines)
                    // {
                    //    System.out.format("%d ",l);  
                    // }
                    // System.out.println("");
                    
                    int jump = Math.max(start + 1, lines[start]);  // either jump would be +1 or it would be super jump based on index
                    
                    ans[i] += lines[start] == 0 ? 1 : 0;  // should we consider count or not
                    
                    lines[start] = Math.max(lines[start], end); // update the current spot to point to next free point
                    
                    start = jump; //jump to next available spot
                }
            }
            return ans;
        }
}