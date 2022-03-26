/*
217. Contains Duplicate
https://leetcode.com/problems/contains-duplicate/
O(N)
O(N)

Note: We can also solve this in T: O(NLogN) , S: O(1) if we use sorting.
*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        HashSet<Integer> s = new HashSet<>();
        for(int i:nums)
        {
            if(s.contains(i))
                return true;
            s.add(i);
        }
        
        return false;
        
    }
}