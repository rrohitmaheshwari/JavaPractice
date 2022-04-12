/*
1. Two Sum
https://leetcode.com/problems/two-sum/
O(N)
O(N) - Hashmap
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer,Integer> hm = new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
        {
            int tempDiff = target - nums[i];
            if(hm.containsKey(tempDiff))
            {
               // found ans
                return new int[]{hm.get(tempDiff),i};
            }
            else
            {
                hm.put(nums[i],i);
            }
            // System.out.println(hm);
        }
        
        return new int[2];
        
    }
}