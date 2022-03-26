/*
136. Single Number
https://leetcode.com/problems/single-number/

O(N)
O(N)
Note: Most optimized solution is O(N),O(1) where you XOR all numbers
*/

class Solution {
    public int singleNumber(int[] nums) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i:nums)
        {
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        
        for ( Map.Entry<Integer,Integer> entry : hm.entrySet() )
        {
        if(entry.getValue()==1)
        {
            return entry.getKey();
        }
        }
        
        return -1;
    }
}