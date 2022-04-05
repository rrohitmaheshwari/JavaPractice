/*
325. Maximum Size Subarray Sum Equals k
https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
O(N)
O(N)
*/

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int prefixsum=0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        int res=0;
        
        for(int i=0;i<nums.length;i++)
        {
            prefixsum += nums[i];
            
            if(prefixsum == k)
            {
                res = i+1; // no neeed for Max as this will always be max
            }
            
            if(hm.containsKey(prefixsum - k))
            {
                res = Math.max(res, i-hm.get(prefixsum - k));
            }
            
            //store current index if not found
            if(!hm.containsKey(prefixsum))
            {
                hm.put(prefixsum,i);
            }
        }
        
        return res;
    }
}