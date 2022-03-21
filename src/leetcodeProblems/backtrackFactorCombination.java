/*
254. Factor Combinations
https://leetcode.com/problems/factor-combinations/
https://leetcode.com/explore/interview/card/linkedin/337/recursion-and-backtracking/1964/
*/

class Solution {
    List<List<Integer>> res= new ArrayList<>();
    public List<List<Integer>> getFactors(int n) {
        
        backtrack(n,new LinkedList<Integer>(),2);
            return res;
    }
    private void backtrack(int n,LinkedList<Integer> comb,int start)
    {
        if(n == 1 && comb.size()>1)
        {
            // deep copy
           res.add(new LinkedList<Integer>(comb)); 
            return;
        }
        // instead of this for loop we could iterate over list of factors to save time
        for(int i=start;i<=n;i++)
        {
            if(n%i == 0)
            {
                comb.add(i);
                backtrack(n/i,comb,i);
                comb.removeLast();
            }
        }
        
    }
}