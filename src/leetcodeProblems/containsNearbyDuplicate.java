/*
219. Contains Duplicate II
https://leetcode.com/problems/contains-duplicate-ii/
O(N)
O(N) - or we could user set as sliding window that will give us O(k)
*/

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k==0)
            return false;
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
        {
            if(hm.containsKey(nums[i]) && i-hm.get(nums[i]) <=k)
            {
                return true;
            }
            hm.put(nums[i],i);
        }
        return false;
    }
}