/*
47. Permutations II
https://leetcode.com/problems/permutations-ii/
https://leetcode.com/explore/interview/card/linkedin/337/recursion-and-backtracking/1963/

*/
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer,Integer> counter = new HashMap<>();
        for(int n:nums)
        {
            counter.put(n,counter.getOrDefault(n,0)+1);
        }
        
        LinkedList<Integer> comb = new LinkedList<>();
        backtrack(comb,nums.length,counter);
        return res;
    }
    
    public void backtrack(LinkedList<Integer> comb,Integer N,Map<Integer,Integer> counter)
    {
        // break condition
        if(comb.size() == N)
        {
            // deep copy
            res.add(new ArrayList<Integer>(comb));
            return;
        }
        
        for(Map.Entry<Integer,Integer> entry: counter.entrySet())
        {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            
            if(count==0)
                continue;
            counter.put(num,count-1);
            comb.addLast(num);
            
            //backtrack
            backtrack(comb,N,counter);
            
            comb.removeLast();
            counter.put(num,count);
            
        }
        
        
    }
}