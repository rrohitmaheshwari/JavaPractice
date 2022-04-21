/*
491. Increasing Subsequences
https://leetcode.com/problems/increasing-subsequences/
O(2^N) -> backtrack
O(N) -> call stack
*/

class Solution {
    Set <List<Integer>> ans = new HashSet<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        backTrackHelper(nums,0,Integer.MIN_VALUE,new ArrayList<Integer>());
        return new ArrayList<List<Integer>>(ans);        
    }
    
    void backTrackHelper(int[] nums,int idx,int min, List<Integer> l)
    {
        if(l.size()>1)
        {
            ans.add(new ArrayList<>(l));
        }
        
        for(int i=idx;i<nums.length;i++)
        {
            if(nums[i]>=min)
            {
                l.add(nums[i]);
                backTrackHelper(nums,i+1,nums[i],l);
                l.remove(l.size()-1);
            }
        }
        
    }
}