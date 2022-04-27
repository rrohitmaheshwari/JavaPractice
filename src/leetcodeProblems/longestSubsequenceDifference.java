/*
1218. Longest Arithmetic Subsequence of Given Difference
https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/
O(N)
O(N)
*/

class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        
        int res=1;
        Map<Integer, Integer> map=new HashMap<>();
        
        for(int i=0;i<arr.length;i++) 
        { 
            if(!map.containsKey(arr[i]-difference))  // map doesnt contains past entry so make current entry as 1
                map.put(arr[i], 1);
            else 
                map.put(arr[i], map.get(arr[i]-difference)+1); // else update current entry by past+1
            
            res=Math.max(res, map.get(arr[i]));  // check if we got the max
        }
        return res;
        
    }
}