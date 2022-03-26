/*
350. Intersection of Two Arrays II
https://leetcode.com/problems/intersection-of-two-arrays-ii/
*/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        List<Integer> l = new ArrayList<>();
        
        for(int i=0;i<nums1.length ;i++)
        {
            hm.put(nums1[i],hm.getOrDefault(nums1[i],0)+1);
        }
     
        for(int j=0;j<nums2.length ;j++)
        {
            if(hm.containsKey(nums2[j]) && hm.get(nums2[j]) !=0)
            {
                l.add(nums2[j]);
                hm.put(nums2[j],hm.get(nums2[j])-1);   
            }
        }
        
        return l.stream().mapToInt(i -> i).toArray();
    }
}