/*
46. Permutations
https://leetcode.com/problems/permutations/
O(P(NR)) - Permutation
O(N!) to keep N! solutions
*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null){
            return results;
        }
        
        //a visited boolean mirroring nums[i], make sure the same number didnt use twice in a permutation
        boolean[] visited = new boolean[nums.length];
        // dfs helper function
        dfs(nums, visited, new ArrayList<>(), results);
        return results;
        
    }
    
    public void dfs(int[] nums, boolean[] visited, List<Integer> permutation, List<List<Integer>> results){
        //exist the loop when permutation size match the numslength, means we got all 3 numbers from [1, 2, 3]
        if(nums.length == permutation.size()){
            //add all permutation to results, using deep copy
            results.add(new ArrayList<Integer>(permutation));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(visited[i]){
                continue;
            }
            //add nums[i]
            permutation.add(nums[i]);
            //set nums[i] visited is true
            visited[i] = true;
            //do dfs again
            dfs(nums, visited, permutation, results);
            //reset visited to false
            visited[i] = false;
            //remove nums[i]
            permutation.remove(permutation.size() - 1);
        }
    }
}