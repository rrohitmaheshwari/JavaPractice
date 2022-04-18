/*
349. Intersection of Two Arrays
https://leetcode.com/problems/intersection-of-two-arrays/
O(N)
O(N)

Can be further optimized to create set of array with lesser size
*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        
        List<Integer> res = new ArrayList<>();
        
        for(int n:nums1)
        {
            s1.add(n);
        }
        
        for(int n:nums2)
        {
            if(s1.contains(n))
            {
                res.add(n);
                s1.remove(n);
            }
        }
        
        return res.stream().mapToInt(i->i).toArray();
        
    }
}