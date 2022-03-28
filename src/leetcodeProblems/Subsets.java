/*
78. Subsets
https://leetcode.com/problems/subsets/
O(N*2^N)

*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
         List<List<Integer>> results = new ArrayList<>();
        if(nums == null){
            return results;
        }
          dfs(nums,0, new ArrayList<>(), results);
        return results;
        
    }
        public void dfs(int[] nums,int start, List<Integer> permutation, List<List<Integer>> results){
            if(start==nums.length)
            {
                results.add(new ArrayList<Integer>(permutation));
                return;
            }
            
            permutation.add(nums[start]);
             dfs(nums,start+1, permutation, results); // taking num
             permutation.remove(permutation.size() - 1);
            
             dfs(nums,start+1, permutation, results); // not taking num
        
        }
}