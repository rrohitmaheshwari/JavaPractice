/*
560. Subarray Sum Equals K
https://leetcode.com/problems/subarray-sum-equals-k/
O(N) - hashmap search and insert is O(1)
O(N) - hashmap
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        // sub array is not sorted
      
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);  // sum:0 count:1
        
        int sum=0,resultCount=0;
        
        for(int i=0;i<nums.length;i++)
        {
           sum = sum + nums[i];
            if(hm.containsKey(sum-k))
            {
                resultCount+= hm.get(sum-k); //increase by count of back indexes found
            }
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        
        return resultCount;
        
    }
    
    
}