/*
496. Next Greater Element I
https://leetcode.com/problems/next-greater-element-i/
O(N +N + M) -> O(N)
O(N) - hashmap
*/

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int[] res = new int[nums1.length];
        Stack<Integer> s = new Stack<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i=0;i<nums2.length;i++)
        {
            while(!s.isEmpty() && nums2[i]>s.peek())
            {
               hm.put(s.pop(),nums2[i]); 
            }
            s.push(nums2[i]);
        }
        
        // Remaining stack elemet no max
        while (!s.empty())
        {
            hm.put(s.pop(), -1);
        }
        
         for (int i = 0; i < nums1.length; i++) {
            res[i] = hm.get(nums1[i]);
        }
        
        return res;
        
    }
}