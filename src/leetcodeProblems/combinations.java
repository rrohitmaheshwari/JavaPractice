/*
77. Combinations
https://leetcode.com/problems/combinations/
O(k  *  Combination(N,k))
O(Combination(N,k))  -> to keep combination in output
*/

class Solution {
    List<List<Integer>> res;
    
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        helper(1,n,k,new ArrayList<>());
        return res;
    }
    
     void helper(int start,int n,int k,List<Integer> list)
    {
        if(list.size()==k)
        {
            res.add(new ArrayList<>(list));
        }
        
        for(int i=start;i<=n;i++)
        {
            list.add(i);
            helper(i+1,n,k,list); 
            list.remove(list.size()-1);
        }
    }
}