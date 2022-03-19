/*
Trapping Rain Water
https://leetcode.com/problems/trapping-rain-water/
https://leetcode.com/explore/interview/card/google/59/array-and-strings/341/
*/

class Solution {
    public int trap(int[] height) {
        int len = height.length;
        
        // can be further optimized using 2 pointers that will save space to O(1)
        int leftArr[]=new int[len];
        int result=0;
        
        int level = 0;
        for(int i=0;i<len;i++)
        {
            level=Math.max(level,height[i]);
            leftArr[i]=level;
        }
        
        level = 0;
        for(int i=len-1;i>=0;i--)
        {
            level=Math.max(level,height[i]);
            result+=Math.min(level,leftArr[i])-height[i];
        }
        
        return result;
        
    }
}