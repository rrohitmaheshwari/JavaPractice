/*
216. Combination Sum III
https://leetcode.com/problems/combination-sum-iii/submissions/
O(P(9,K))  9!/((9-k)!)
O(k)
*/

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        helper(1,n,k,new ArrayList<>(),0);
        return res;
            
    }
    
    void helper(int start,int n,int k,List<Integer> list, int runningSum)
    {
        if(runningSum>n)
            return;
        if(list.size()==k && runningSum==n)
        {
            res.add(new ArrayList<>(list));
        }
        
        for(int i=start;i<=9;i++)
        {
            list.add(i);
            helper(i+1,n,k,list,runningSum + i); 
            list.remove(list.size()-1);
        }
    }
}