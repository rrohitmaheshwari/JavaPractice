/*
39. Combination Sum
https://leetcode.com/problems/combination-sum/
https://leetcode.com/explore/interview/card/linkedin/337/recursion-and-backtracking/1962/
*/

class Solution {
 List<List<Integer>> results ;
    protected void backtrack(
            int remain,
            LinkedList<Integer> comb,
            int start,
            int[] candidates) {

        if (remain == 0) {
            // make a deep copy of the current combination
            results.add(new ArrayList<Integer>(comb));
            return;
            
        } else if (remain < 0) {
            // exceed the scope, stop exploration.
            return;
        }

        for (int i = start; i < candidates.length; ++i) {
            // add the number into the combination
            comb.add(candidates[i]);
            this.backtrack(remain - candidates[i], comb, i, candidates);
            // backtrack, remove the number from the combination
            comb.removeLast();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        results = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<Integer>();

        this.backtrack(target, comb, 0, candidates);
        return results;
    }
}