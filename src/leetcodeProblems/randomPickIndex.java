/*
398. Random Pick Index
https://leetcode.com/problems/random-pick-index/
O(N)
O(N)
*/

class Solution {
Map<Integer,List<Integer>> m;
    public Solution(int[] nums) {
        m = new HashMap<>();
        int index =0;
        for(int i:nums)
        {
            List<Integer> l = m.getOrDefault(i,new ArrayList<>());
            l.add(index++);
           m.put(i,l);
        }
    }
    
    public int pick(int target) {
        return m.get(target).get((int)(Math.random()*m.get(target).size()));  
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */