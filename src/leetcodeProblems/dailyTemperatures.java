/*
739. Daily Temperatures
https://leetcode.com/problems/daily-temperatures/
O(N)
O(N) - stack
Monotonic decreasing order
*/

class Solution {
    public int[] dailyTemperatures(int[] temperatures) 
    {
        Stack<Pair<Integer,Integer>> s = new Stack<>(); // hold index, temparature
        int res[] = new int[temperatures.length];
        
        for(int i=0; i<temperatures.length; i++)
        {
            while(!s.isEmpty() && s.peek().getValue()<temperatures[i])
            {
                // pop
                Pair<Integer,Integer> p = s.pop();
                // update res
                res[p.getKey()] = i - p.getKey();
            }
            s.add(new Pair(i,temperatures[i]));
        }
        
        return res;
    }
}