/*
40. Combination Sum II
https://leetcode.com/problems/combination-sum-ii/
O(2^N * N)
O(N)
*/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        
        Arrays.sort(candidates);
        
            //index,target,temp List,result List, candidate
        backtrack(-1,target,new LinkedList<>(),res,candidates);
        
        return res;
        
    }
    
    void backtrack(int index, int target, LinkedList<Integer> runList, List<List<Integer>> res,int[] candidates)
    {
        
        if(index>=candidates.length || target<0)
            return;
        
        if(0 == target)
        {
            res.add(new ArrayList<>(runList));
            return; // we dont have negative number ahead or even 0
        }

        
        index++;
        
        for(int i=index;i<candidates.length;i++)
        {
            if(i>index && candidates[i] == candidates[i-1])
                continue;
            runList.add(candidates[i]);
            backtrack(i,target-candidates[i],runList,res,candidates);
            runList.removeLast();
        }
        
    }
}