/*
974. Subarray Sums Divisible by K
https://leetcode.com/problems/subarray-sums-divisible-by-k/
O(N)
O(N)
*/

class Solution {
    public int subarraysDivByK(int[] nums, int k) 
    {
        int sum = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1); // value:0 count:1
        int count = 0;
        
        for(int i=0;i<nums.length;i++)
        {
            sum = (sum+nums[i]) % k;
            if(sum<0)
            {
                sum = sum+k;
            }
            count += hm.getOrDefault(sum, 0);
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}