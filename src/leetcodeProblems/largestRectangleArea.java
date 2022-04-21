/*
84. Largest Rectangle in Histogram
https://leetcode.com/problems/largest-rectangle-in-histogram/
O(N)
O(N)
https://www.youtube.com/watch?v=zx5Sw9130L0

2,1,5,6,2,3


*/

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Pair<Integer,Integer>> s = new Stack<>();
        
        int max = 0;
        for(int i=0;i<heights.length;i++)
        {
            int height = heights[i];
            int start = i;
            
            while(!s.isEmpty() && s.peek().getValue()>height)  //drop of height
            {
                Pair<Integer,Integer> p = s.pop();
                start = p.getKey();
                max = Math.max(max, p.getValue() * (i-start));  
            }
          
            // push in stack
            s.add(new Pair(start,height));
            
        }
        
        while(!s.isEmpty())
        {
             Pair<Integer,Integer> p = s.pop();
             max = Math.max(max, p.getValue() * (heights.length-p.getKey()));  
        }
        
        return max;
    }
}